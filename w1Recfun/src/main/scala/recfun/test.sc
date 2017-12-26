print(" " * 3)

object test {

  //  @tailrec
  def countChange(money: Int, coins: List[Int]): Int = (money, coins) match {
    case (0, _) => 1
    case (mn, _) if mn < 0 => {
      println("mn<0 | cn.isEmpty")
      0
    }
    case (_, cn) if cn.isEmpty => {
      println("cn.isEmpty")
      0
    }
    case (mn, cn) => {
      printf("%1$d(mn) - %2$s(cn.head) = %3$d   and  %4$s\n", mn, cn.head, mn - cn.head, cn.tail)
      countChange(mn - cn.head, cn) + countChange(mn, cn.tail)
    }
  }

}

import test._

countChange(10, List(1, 2, 5))
