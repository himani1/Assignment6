package com.knoldus

import org.scalatest.FunSuite
import org.scalatest.BeforeAndAfterEach

class StudentTest extends FunSuite with BeforeAndAfterEach{

  val obj=new Student
  test("Displaying contents of student table"){

    val li=obj.displayStudent()
    assert(li==List("1", "himani", "himani@knoldus.in", "3", "sahil", "sahil@al.com"))
  }


  test("Deleting contents of student table") {

    obj.insertStudent(7,"knol","knol@gmail.com")
    val op=obj.deleteStudent(7)
    assert(op==0)
  }

  test("Inserting Contents in student table"){

    val op=obj.insertStudent(7,"knol","knol@gmail.com")
    obj.deleteStudent(7)
    assert(op==1)
  }

  test("Updating contents of the student table"){

    val res=obj.updateStudent(3,"sahil@knoldus.in")
    assert(res==1)
  }

}
