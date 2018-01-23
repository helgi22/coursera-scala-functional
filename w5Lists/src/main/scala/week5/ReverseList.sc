object run {
  def reverse[T](xs: List[T]): List[T] = xs match {
    case List() => {
      println("Empty list")
      xs
    }
    case z :: zs => {
      println(s"$zs ++ $z")
      reverse(zs) ++ List(z)
    }
  }

  val lst: List[Int] = List.range(0,9)
  val rez = reverse(lst)

}