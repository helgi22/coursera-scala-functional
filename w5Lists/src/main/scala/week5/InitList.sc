object run {

  def init[T](list: List[T]): List[T] = list match {
    case List() => throw new Error("init  of empty list")
    case List(x) => List()
    case y :: ys => y::init[T](ys)
  }

  val t: List[Int] = List[Int](1, 2, 3, 4, 5)
  val el: List[Int] = List()

  t.init
  init[Int](t)

  init[Int](el)
  //  el.init
}

