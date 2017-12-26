package worksheet3
object scratch {
  def error(msg: String): Nothing = throw new Error(msg)

  val x = null
  val y: String = x
//  val z: Int = null
  if (true) 1 else false
}

//error("Error message")
