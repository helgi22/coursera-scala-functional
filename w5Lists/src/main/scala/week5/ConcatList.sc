object run {
  def concat[T](xs: List[T], ys: List[T]): List[T] = xs match {
    case List() => ys
    case z :: zs => z :: concat(zs, ys)
  }

  val lst: List[Int] = List(2, 3, 4, 5, 6)
  concat(List(),lst)
  concat(lst,List())
  concat(List(0, 1), lst)

}