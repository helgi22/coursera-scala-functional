val oneTwo: List[Int] = 0 :: 1 :: Nil
println(oneTwo)

def dec(x: List[Int]): Any = x match {
  case Nil => "List empty"
  case t :: Nil => s"List consists $t"
  case x => s"List consists first element ${x.head} and rest elements ${x.tail}"
}

def append[T](xs: List[T], ys: List[T]): List[T] = xs match {
  case List() => ys
  case x :: xs1 => append(x :: Nil, ys)
//  case x :: _*  => xs ::: ys
}

dec(Nil)
dec(0 :: 1 :: 2 :: Nil)

//append(0 :: 1 :: Nil, 1 :: 2 :: Nil)

val list = 0::1::2::Nil
list.apply(1)
list.indices
list.last
list.init
list.head
list.tail
list.isEmpty
list.length
list.mkString("my-list(",";",")")
list.drop(2)
list.take(2)
val (x:List[Int],y:List[Int]) = list.splitAt(1)
val iter: Iterator[Int] = list.iterator
iter.next
iter.next

val chlist= (List('a','b')::List('c','d')::List('e','f')::Nil).flatten

val zipl = chlist.zipWithIndex
zipl.unzip
zipl.toString
