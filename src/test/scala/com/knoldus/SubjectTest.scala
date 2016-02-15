package com.knoldus

import org.scalatest.FunSuite
import scala.collection.mutable.ListBuffer

class SubjectTest extends FunSuite {

  val obj=new Subject
 test("Displaying contents"){

    val li=obj.displaySubject()
    assert(li==List("1", "java", "2", "scala", "3", "operating systems","4","demo","5","Software testing"))
  }

  test("Deleting contents") {

    val op=obj.deleteSubject(6)
    assert(op==0)
  }

  test("Updating contents"){

    val res=obj.updateSubject(3,"operating systems")
    assert(res==1)
  }

  test("Inserting Contents "){

    val op=obj.insertSubject(8,"discrete maths")
    assert(op==1)
  }



}
