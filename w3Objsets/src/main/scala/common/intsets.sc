object intsets {
  println("Welcome to the Scala ")
}

abstract class IntSet {
  def incl(x: Int): IntSet

  def contains(x: Int): Boolean
}
