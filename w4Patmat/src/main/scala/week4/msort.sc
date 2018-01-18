object sort {

  def msort[T](less: (T, T) => Boolean)(xs: List[T]): List[T] = {
    def merge(xs: List[T], ys: List[T]): List[T] =
      (xs, ys) match {
        case (Nil, _) => ys
        case (_, Nil) => xs
        case (x :: xs1, y :: ys1) => if (less(x, y)) x :: merge(xs1, ys)
        else y :: merge(xs, ys1)
      }

    val n = xs.length / 2
    if (n == 0) xs
    else {
      val (ys, zs) = xs splitAt (n)
      merge(msort(less)(ys), msort(less)(zs))
    }
  }

  msort((x: Int, y: Int) => x < y)(List(1, 2, 3, 4, 5, 6, 7))
  val intSort = msort((x:Int, y:Int) => x > y) _
  val reverseSort = msort((x:Int, y:Int) => x < y) _
  val mixedIns = List(4,7,2,9,5,6,0,3)
  intSort(mixedIns)
  reverseSort(mixedIns)
}
