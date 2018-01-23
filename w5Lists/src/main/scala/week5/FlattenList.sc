
object run {
  def flatten(xs: List[Any]): List[Any] = xs match {
    case Nil => Nil
    case (head: List[Any]) :: tail => flatten(head) ::: flatten(tail)
    case head :: tail => head :: flatten(tail)
  }

  flatten(List(List(1, 1, 3), 2, List(3, List(5, 8))))

}