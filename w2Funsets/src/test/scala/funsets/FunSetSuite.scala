package funsets

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

/**
  * This class is a test suite for the methods in object FunSets. To run
  * the test suite, you can either:
  *  - run the "test" command in the SBT console
  *  - right-click the file in eclipse and chose "Run As" - "JUnit Test"
  */
@RunWith(classOf[JUnitRunner])
class FunSetSuite extends FunSuite {

  /**
    * Link to the scaladoc - very clear and detailed tutorial of FunSuite
    *
    * http://doc.scalatest.org/1.9.1/index.html#org.scalatest.FunSuite
    *
    * Operators
    *  - test
    *  - ignore
    *  - pending
    */

  /**
    * Tests are written using the "test" operator and the "assert" method.
    */
  test("string take") {
    val message = "hello, world"
    assert(message.take(5) == "hello")
  }

  /**
    * For ScalaTest tests, there exists a special equality operator "===" that
    * can be used inside "assert". If the assertion fails, the two values will
    * be printed in the error message. Otherwise, when using "==", the test
    * error message will only say "assertion failed", without showing the values.
    *
    * Try it out! Change the values so that the assertion fails, and look at the
    * error message.
    */
  test("adding ints") {
    assert(1 + 2 === 3)
  }


  import FunSets._

  test("contains is implemented") {
    assert(contains(x => true, 100))
  }

  /**
    * When writing tests, one would often like to re-use certain values for multiple
    * tests. For instance, we would like to create an Int-set and have multiple test
    * about it.
    *
    * Instead of copy-pasting the code for creating the set into every test, we can
    * store it in the test class using a val:
    *
    * val s1 = singletonSet(1)
    *
    * However, what happens if the method "singletonSet" has a bug and crashes? Then
    * the test methods are not even executed, because creating an instance of the
    * test class fails!
    *
    * Therefore, we put the shared values into a separate trait (traits are like
    * abstract classes), and create an instance inside each test method.
    *
    */

  trait TestSets {
    val s1: Set = singletonSet(1)
    val s2: Set = singletonSet(2)
    val s3: Set = singletonSet(3)
    val s4: Set = singletonSet(1)
    val s1001: Set = singletonSet(1001)
  }

  /**
    * This test is currently disabled (by using "ignore") because the method
    * "singletonSet" is not yet implemented and the test would fail.
    *
    * Once you finish your implementation of "singletonSet", exchange the
    * function "ignore" by "test".
    */

  test("singletonSet(1) contains 1") {

    /**
      * We create a new instance of the "TestSets" trait, this gives us access
      * to the values "s1" to "s3".
      */
    new TestSets {
      /**
        * The string argument of "assert" is a message that is printed in case
        * the test fails. This helps identifying which assertion failed.
        */
      assert(contains(s1, 1), "Singleton")
    }
  }

  test("union contains all elements of each set") {
    new TestSets {
      val s = union(s1, s2)
      assert(contains(s, 1), "Union 1")
      assert(contains(s, 2), "Union 2")
      assert(!contains(s, 3), "Union 3")
    }
  }

  test("intersection contains common elements only") {
    new TestSets {
      val i = intersect(s1, s4)
      assert(contains(i, 1), "intersect 1")
      assert(!contains(i, 2), "not intersect 2")
      assert(!contains(i, 3), "not intersect 3")
    }
  }

  test("diff a set which contains all the elements of the set S that are not in the set T") {
    new TestSets {
      val d = diff(s2, s3)
      assert(!contains(d, 1), "diff 1")
      assert(contains(d, 2), "diff 2")
      assert(!contains(d, 3), "diff 3")
    }
  }

  test("filter works like intersection") {
    new TestSets {
      val fl1 = filter(s1, _ == 1)
      val fl2 = filter(s2, _ < 0)
      val fl3 = filter(s3, _ > 2)
      val fl4 = filter(s3, _ >= 3)
      assert(fl1(1), "filter 1 == 1")
      assert(!fl2(2), "filter 2 < 0")
      assert(fl3(3), "filter 3 > 2")
      assert(fl3(3), "filter 3 >= 3")
    }
  }

  test("forall works in range -1000 <= x <= 1000") {
    new TestSets {
      val s: Set = union(union(s1, s2), union(s3, s1001))
//      println(s(1) + " " + s(2) + " " + s(3) + " " + s(1000) + " " + s(1001))
      assert(forall(s, _ < 4))
      assert(!forall(s, _ < 2))
    }
  }

  test("exists works in range -1000 <= x <= 1000") {
    new TestSets {
      assert(exists(s1, _ == 1), "")
      assert(exists(s2, _ >= 2), "")
      assert(exists(s3, _ > 2), "")
      assert(!exists(s4, _ < 0), "")
      assert(!exists(s1001, _ == 1001), "")
      assert(!exists(s1001, _ == -1001), "")
    }
  }

  test("map transformed a set by applying `f` to each element of `s`") {
    new TestSets {
      val s = union(union(s1, s2), s3)
      val mapped = map(s, _ * 3)
      assert(contains(mapped, 3), "map 3")
      assert(contains(mapped, 6), "map 6")
      assert(contains(mapped, 9), "map 9")
      assert(!contains(mapped, 2), "not map 2")
    }
  }
}
