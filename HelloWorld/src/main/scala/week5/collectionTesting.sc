
object test {
  val xs = Array(0, 2, 3, 44)
  val ys = 1 to 4

  (xs zip ys).map(xy => xy._1 * xy._2).sum
  (xs zip ys).map { case (x, y) => x * y }.sum
  (xs zip ys).map { x =>
    x match {
      case (a, 0) => a
      case (0, b) => b
      case (a, b) => a * b
    }
  }.sum

  def isPrime(n: Int): Boolean = {
    (2 to n / 2).forall(d => n % d != 0)
  }

  isPrime(2)
  isPrime(17)
  isPrime(4)

  for (x <- xs if x % 2 == 0) yield x

  def scalarProduct(xs: List[Double], ys: List[Double]): Double = {
    (for ((x, y) <- xs zip ys) yield x * y).sum
  }



  scalarProduct(List(1.0, 2.0), List(1.0, 2.0))

}