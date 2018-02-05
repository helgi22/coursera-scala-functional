
def sum(xs: List[Int]): Int = xs match {
  case Nil => 0
  case y :: ys => y + sum(ys)
}

//Simplify method sum
def sum1(xs: List[Int]): Int = (0 :: xs) reduceLeft ((x, y) => x + y)
def product1(xs: List[Int]): Int = (1 :: xs) reduceLeft (_ * _)

//folderLeft is like reduceLeft but takes an accumulator as an additional
// parameter, which is returned when foldLeft is called on an empty list
def sum2(xs: List[Int]): Int = (xs foldLeft (0)) (_ + _)
def product2(xs: List[Int]): Int = (xs foldLeft (1)) (+_ * _)

