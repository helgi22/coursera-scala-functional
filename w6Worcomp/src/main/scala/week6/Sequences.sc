/*Array and String are sequences*/

object test {
  val xs = Array(1, 2, 3, 44)
  xs map (_ * 2)

  val s = "Hello World"
  // filter
  s filter (_.isUpper)
  // exists
  s exists (c => c.isUpper)
  // forall
  s forall (c => c.isUpper)
  // zip
  val pairs = List(1, 2, 3) zip s
  // unzip
  pairs.unzip
  // flatMap
  s.flatMap(List('.', _))
  //  sum
  xs.sum
  // max
  xs.max

  val r: Range = 1 until 5
  r foreach println
  val ss: Range = 1 to 5
  ss foreach println
  val t: Range = 1 to 10 by 3
  t foreach println
  val v: Range = 6 to 1 by -2
  v foreach println
}

object test1 {
  def scalarProduct(xs: Vector[Double], ys: Vector[Double]): Double =
    (xs zip ys).map(xy => xy._1 * xy._2).sum

  //  Alternative way with pattern matching function
  def scalarProductPatternMatching(xs: Vector[Double], ys: Vector[Double]): Double =
  //  {case p1 => e1 ... case pn => en}
  //  is equivalent to
  //  x => x  match {case p1 => e1 ... case pn => en}
    (xs zip ys).map { case (x, y) => y * y }.sum

  def isPrime(n: Int): Boolean = (2 until n) forall (d => n % d != 0)
}




