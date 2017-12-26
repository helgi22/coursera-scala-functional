object rationals {

  val x = new Rational(1, 3)
  val y = new Rational(5, 7)
  val z = new Rational(3, 2)
  //  val strange = new Rational(1,0)
  x - y - z
  y + y
  x < y //infix operation
  x max y //infix operation
  new Rational(2)
}

class Rational(x: Int, y: Int) {
  require(y != 0, "denominator must by nonzero")

  def this(x: Int) = this(x, 1)

  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)

  val numer = x

  val denom = y

  def <(that: Rational): Boolean = numer * that.denom < that.numer * denom

  def max(that: Rational): Rational = if (this < that) that else this

  def +(that: Rational) = new Rational(
    numer * that.denom + that.numer * denom, denom * that.denom
  )
//prefix operation
  def unary_- : Rational = new Rational(-numer, denom)

  def -(that: Rational) = this + -that

  override def toString = {
    val g = gcd(x, y)
    s"Rational(${numer / g} / ${denom / g})"
  }
}
