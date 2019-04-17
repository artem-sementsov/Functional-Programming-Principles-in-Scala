import week3._

object nth extends App {
  def nth[T](n: Int, xs: List[T]): T = {
    if (xs.isEmpty) throw new IndexOutOfBoundsException
    else if (n == 0) xs.head
    else nth[T](n - 1, xs.tail)
  }

  val list = new Cons(1, new Cons(2, new Nil))
  println(nth(1, list))

  //println(nth(-1, list))
}
