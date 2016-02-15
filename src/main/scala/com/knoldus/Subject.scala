package com.knoldus

import java.sql.ResultSet
import scala.collection.mutable.ListBuffer


class Subject {
  val conn=new StudentManagement().connectDB()


  def displaySubject():List[String]= {

    val li:ListBuffer[String]=ListBuffer()

    val statement = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY)

    // Execute Query
    val rs = statement.executeQuery("SELECT * FROM subject")

    // Iterate Over ResultSet
    while (rs.next) {

      li+=rs.getString("sub_id")
      li+=rs.getString("sub_name")

    }
    li.toList
  }

  def insertSubject(id:Int,name:String):Int={

    val statement = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY)
    val prep = conn.prepareStatement("INSERT INTO subject VALUES ('"+id+"','"+name+"') ")
    val op=prep.executeUpdate
    op
  }

  def deleteSubject(id:Int):Int={
    val prep=conn.prepareStatement("DELETE from subject where sub_name='"+id+"'")
    prep.executeUpdate

    val res=conn.prepareStatement("DELETE from student_subject where sub_id='"+id+"'")
    val op=res.executeUpdate
    op
  }

  def updateSubject(id:Int,name:String):Int={
    val prep=conn.prepareStatement("update subject set sub_name='"+name+"' where sub_id='"+id+"'")
    val res=prep.executeUpdate()
    res
  }

}
