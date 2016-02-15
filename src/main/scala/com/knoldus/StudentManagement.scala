package com.knoldus

import java.sql._

class StudentManagement {

  val driver:String = "com.mysql.jdbc.Driver"
  val path:String = "jdbc:mysql://localhost/STUDENTDB"
  val username:String = "root"
  val password:String = "knoldus"

  def connectDB()={


      Class.forName(driver)
      val connection:Connection = DriverManager.getConnection(path,username,password)

    connection
  }
}
