package week4

trait List[+T] {
  def isEmpty: Boolean

  def head: T

  def tail: T
}

class Cons[T](val head: T, val tail: List[T]) extends List[T] {
  override def isEmpty: Boolean = false
}

object Nil extends List[Nothing] {
  override def isEmpty: Boolean = true

  override def head: Nothing = throw new NoSuchElementException("Nil.head")

  override def tail: Nothing = throw new NoSuchElementException("Nil.tail")
}

object List {

  def apply[T](x1: T, x2: T): List[T] = new Cons(x1, new Cons[T](x2, Nil))

  def apply[T]() = Nil
}

object test {
  val x: List[String] = Nil
}