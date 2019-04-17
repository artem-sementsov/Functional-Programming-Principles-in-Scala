"HelloWorld"

def abs(x: Double) = if (x < 0) -x else x

def sqrt(x: Double): Double = {
  def sqrtIter(guess: Double, x: Double): Double = {
    def improve(guess: Double, x: Double) = (guess + x / guess) / 2

    def isGoodEnough(guess: Double, x: Double) =
      abs(x / (guess * guess) - 1) < 0.01

    if (isGoodEnough(guess, x)) guess
    else sqrtIter(improve(guess, x), x)
  }
  sqrtIter(1.0, x)
}

sqrt(5)


def power(x: Double) =
  x * x

power(0.031642015868650786)
