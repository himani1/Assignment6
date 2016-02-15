package com.knoldus

import java.sql.ResultSet


class StudentSubject {

  val conn=new StudentManagement().connectDB()

def addStudentSubject(sSubId:Int,sId:Int,subId:Int)={

  val statement = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY)

    val pr = conn.prepareStatement("INSERT INTO student_subject VALUES ('"+sSubId+"','" + sId + "','" + subId + "') ")
    pr.executeUpdate

}
  def deleteStudentSubject(sId:Int)={
    val prep=conn.prepareStatement("DELETE from student_subject where s_id='"+sId+"'")
    prep.executeUpdate
  }


}
