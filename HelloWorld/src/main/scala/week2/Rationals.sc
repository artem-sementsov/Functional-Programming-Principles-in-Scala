class Rational(x: Int, y: Int) {
  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)

  val numer = x /// gcd(x, y)
  val denom = y /// gcd(x, y)

  def less(that: Rational) = numer * that.denom < that.numer * denom

  def max(that: Rational) = if (this.less(that)) that else this

  def add(that: Rational) =
    new Rational(
      numer * that.denom + that.numer * denom,
      denom * that.denom
    )

  def sub(that: Rational) = add(that.neg)

  override def toString = numer / gcd(numer, denom) + "/" + denom / gcd(numer, denom)

  def neg = new Rational(-numer, denom)
}

new Rational(1, 2)
new Rational(3, 4).neg

val x = new Rational(1, 3)
val y = new Rational(5, 7)
val z = new Rational(3, 2)

y.add(y)

x.less(y)
x.max(y)