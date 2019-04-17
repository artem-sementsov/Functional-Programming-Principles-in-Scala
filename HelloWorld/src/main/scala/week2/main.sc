
def sum(f: Int => Int)(a: Int, b: Int): Int = {
  if (a > b) 0
  else f(a) + sum(f)(a + 1, b)
}

sum(x => x)(1, 2)

def product(f: Int => Int)(a: Int, b: Int): Int =
  if (a > b) 1
  else f(a) * product(f)(a + 1, b)

product(x => x)(1, 3)

def fact(a: Int): Int =
  if (a > 0)
    product(x => x)(1, a)
  else 0

fact(4)

def mapReduce(f: Int => Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b: Int): Int =
  if (a > b) zero
  else combine(f(a), mapReduce(f, combine, zero)(a + 1, b))

mapReduce(x => x, (x, y) => x + y, 0)(1, 2)

def product2(f: Int => Int)(a: Int, b: Int): Int =
  mapReduce(f, (x, y) => x * y, 1)(a: Int, b: Int)

product2(x => x)(1, 3)