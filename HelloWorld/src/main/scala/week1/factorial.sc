
def factorial(n: Double): Double = {
  def factorial(c: Double, n: Double): Double = {
    if (n == 0) c else factorial(c * n, n - 1)
  }
  factorial(1, n)
}

factorial(5)