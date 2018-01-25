def squraList(xs: List[Int]): List[Int] = xs match {
  case Nil => Nil
  case y :: ys => y * y :: squraList(ys)
}

squraList(List.range(1, 7))


def squareListr(xs: List[Int]): List[Int] = xs map (x => x * x)

squareListr(List.range(1, 7))

val nums = List(2, 4, -5, 7, 9)

nums filter (x => x > 0)
nums filterNot (x => x > 0)
nums partition (x => x < 0) //create two lists with true and false conditions

nums takeWhile (x => x > 0) //take while condition true
nums dropWhile (x => x > 0) //drop while condition true
nums span (x => x > 0) // return two lists with takeWhile and dropWhile

def pack[T](list: List[T]): List[List[T]] = list match {
  case Nil => Nil
  case y :: yx =>
    val (first, rest) = list span (x => x == y)
    first :: pack(rest)
}

val data = List(List("a", "a", "a"), List("b"), List("c", "c"), List("a")).flatten
pack(data)

def encode[T](list: List[T]): List[(T, Int)] = pack(list) map (ys => (ys.head, ys.length))
encode(data)

data foreach  println

List()