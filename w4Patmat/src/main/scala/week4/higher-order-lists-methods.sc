List(1, 2, 3) map (_ + 1)
val words = "the" :: "quick" :: "brown" :: "fox" :: Nil
words map (_.length)
words map (_.toList.reverse.mkString)

words flatMap (_.toList)

List range(1, 5) flatMap (
  i => List.range(1, i) map (j => (i, j))
  )


words filter (_.length == 3)
words partition (_.length == 3)
List range(0, 10) filter (_ % 2 != 0)
List range(0, 10) partition (_ % 2 == 0)

words find (_.length == 3)
List range(1, 10) find (_ < 1)