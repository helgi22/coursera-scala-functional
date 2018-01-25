//package week5

object mergesort {

  def msort[T](xs: List[T])(lt: (T, T) => Boolean): List[T] = {
    val n = xs.length / 2
    if (n == 0) xs
    else {
      def merge(xs: List[T], ys: List[T]): List[T] = (xs, ys) match {
        case (Nil, `ys`) => ys
        case (`xs`, Nil) => xs
        case (x :: xs1, y :: ys1) => if (lt(x, y)) x :: merge(xs1, ys)
        else y :: merge(xs, ys1)
      }

      val (fst, snd) = xs splitAt n
      merge(msort(fst)(lt), msort(snd)(lt))
    }
  }

  def msortodr[T](xs: List[T])(implicit ord: Ordering[T]): List[T] = {
    val n = xs.length / 2
    if (n == 0) xs
    else {
      def merge(xs: List[T], ys: List[T]): List[T] = (xs, ys) match {
        case (Nil, `ys`) => ys
        case (`xs`, Nil) => xs
        case (x :: xs1, y :: ys1) => if (ord.lt(x, y)) x :: merge(xs1, ys)
        else y :: merge(xs, ys1)
      }

      val (fst, snd) = xs splitAt n
      merge(msortodr(fst), msortodr(snd))
    }
  }


  val nums = List(2, -4, 5, 7, 1)
  val frutis = List("bananas", "apple", "pineapple", "orange")
  msort(nums)((x: Int, y: Int) => x < y)
  msort(frutis)((x: String, y: String) => x.compareTo(y) < 0)

  msortodr(nums)(Ordering.Int)
  msortodr(frutis)(Ordering.String)
  msortodr(nums)
  msortodr(frutis)

}