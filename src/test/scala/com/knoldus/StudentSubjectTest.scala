package com.knoldus

import org.scalatest.FunSuite

class StudentSubjectTest extends FunSuite{

  val obj=new StudentSubject
  test("Insertion of values when student id exists")
  {
    obj.addStudentSubject(4,1,3)
  }

  test("Insertion of values when student id or subject id does not exist"){

    intercept[com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException]{
      obj.addStudentSubject(4,17,2)
    }
  }


}
