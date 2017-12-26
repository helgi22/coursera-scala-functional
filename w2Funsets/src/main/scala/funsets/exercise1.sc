object exercise1 {

  import scala.math.abs

  val tolerance = 0.0001

  def isCloseEnough(x: Double, y: Double) =
    abs((x - y) / x) / x < tolerance

  def fixedPoint(f: Double => Double)(firstGues: Double) = {
    def iterate(guess: Double): Double = {
            println("guess = " + guess)
      val next = f(guess)
      if (isCloseEnough(guess, next)) next
      else iterate(next)
    }

    iterate(firstGues)
  }

  fixedPoint(x => 1 + x / 2)(1)

  def averageDamp(f: Double => Double)(x: Double) = (x + f(x)) / 2

  def sqrt(x: Double) = fixedPoint(averageDamp(y => x / y))(1.0D)

  sqrt(2)
}

//import exercise1._

