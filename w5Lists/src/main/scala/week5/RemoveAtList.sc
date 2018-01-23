
object run {
  def removeAt[T](n: Int, xs: List[T]) = (xs take n) ::: (xs drop n+1)

  val lst: List[Int] = List.range(0, 9)
  val rez = removeAt(2, lst)

}