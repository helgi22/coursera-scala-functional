package recfun

import scala.annotation.tailrec

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    val rows = 10
    for (row <- 0 to rows) {
      print("%s".format(" " * (rows - row)))
      for (col <- 0 to row) {
        val psc = pascal(col, row)
        print(s"%${psc.toString.length}d ".format(psc))
      }
      println()
    }
  }

  /**
    * Exercise 1
    */
  def pascal(c: Int, r: Int): Int = (c, r) match {
    case (0, `r`) => 1
    case (`c`, `r`) if c == r => 1
    case _ => pascal(c - 1, r - 1) + pascal(c, r - 1)
  }

  /**
    * Exercise 2
    */
  def balance(chars: List[Char]): Boolean = {
    @tailrec
    def loop(chars: List[Char], count: Int = 0): Boolean = (chars, count) match {
      case (cs, 0) if cs.isEmpty => true
      case (cs, _) if cs.isEmpty => false
      case (cs, c) => cs.head match {
        case '(' => loop(cs.tail, c + 1)
        case ')' if c > 0 => loop(cs.tail, c - 1)
        case ')' => false
        case _ => loop(cs.tail, c)
      }
    }

    loop(chars)
  }

  /**
    * Exercise 3
    */
  def countChange(money: Int, coins: List[Int]): Int = (money, coins) match {
    case (0, _) => 1
    case (mn, _) if mn < 0 => 0
    case (_, cn) if cn.isEmpty => 0
    case (mn, cn) => countChange(mn - cn.head, cn) + countChange(mn, cn.tail)
  }
}