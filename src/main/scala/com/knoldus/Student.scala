package com.knoldus

import java.sql.{Connection, DriverManager, ResultSet}
import org.slf4j.LoggerFactory

import scala.collection.mutable.ListBuffer


class Student {

  val logger=LoggerFactory.getLogger(this.getClass())

  val conn=new StudentManagement().connectDB()


  def displayStudent():List[String]= {

    val li:ListBuffer[String]=ListBuffer()
    val statement = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY)

    // Execute Query
    val rs = statement.executeQuery("SELECT * FROM student")

    // Iterate Over ResultSet
    while (rs.next) {
      logger.debug("Reecords are successfully displayed.")
      li+=rs.getString("s_id")
      li+=rs.getString("s_name")
      li+=rs.getString("s_email")

    }
    li.toList
  }

    def insertStudent(id:Int,name:String,email:String)={

      val statement = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY)
      val prep = conn.prepareStatement("INSERT INTO student VALUES ('"+id+"','"+name+"','"+email+"') ")
      prep.executeUpdate
    }

  def deleteStudent(id:Int)={

    val prep=conn.prepareStatement("DELETE from student where s_id='"+id+"'")
    prep.executeUpdate

    val res=conn.prepareStatement("DELETE from student_subject where s_id='"+id+"'")
    res.executeUpdate
  }

  def updateStudent(id:Int,email:String):Int={
    val prep=conn.prepareStatement("update student set s_email='"+email+"' where s_id='"+id+"'")
    val res=prep.executeUpdate()
    res
  }


}
