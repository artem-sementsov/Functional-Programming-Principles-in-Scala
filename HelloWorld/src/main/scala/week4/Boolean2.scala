package week4

abstract class Boolean2 {

  def ifThenElse[T](t: => T, e: => T): T

  def < (x: Boolean): Boolean = ifThenElse[Boolean](false, x)
}


