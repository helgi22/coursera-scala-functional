package worksheet3

object intsets {
  val t1 = new NonEmpty(3, new Empty, new Empty)
  val t2 = t1 incl 4
}

abstract class IntSet {
  def incl(x: Int): IntSet

  def contains(x: Int): Boolean

  def union(other: IntSet): IntSet
}

class Empty extends IntSet {
  def contains(x: Int) = false

  def incl(x: Int) = new NonEmpty(x, new Empty, new Empty)

  override def union(other: IntSet) = other

  override def toString = s"."
}

class NonEmpty(elem: Int, left: IntSet, right: IntSet) extends IntSet {
  override def contains(x: Int): Boolean =
    if (x < elem) left contains x
    else if (x < elem) right contains x
    else true

  override def incl(x: Int): IntSet =
    if (x < elem) new NonEmpty(elem, left.incl(x), right)
    else if (x > elem) new NonEmpty(elem, left, right incl x)
    else this

  override def union(other: IntSet) =
    ((left union right) union other) incl elem

  override def toString = s"{ $left $elem $right }"
}