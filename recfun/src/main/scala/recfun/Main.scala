package recfun

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }

    println(balance("(if (zero? x) max (/ 1 x))".toList))
    println(balance("I told him (that it’s not (yet) done). (But he wasn’t listening)".toList))
    println(balance(":-)".toList))
    println(balance("())(".toList))

    println(countChange(4, 1 :: 2 :: Nil))
  }

  /**
    * Exercise 1
    */
  def pascal(c: Int, r: Int): Int = {
    if (c == 0 || r == 0 || c == r) 1 else pascal(c - 1, r - 1) + pascal(c, r - 1)
  }

  /**
    * Exercise 2
    */
  def balance(chars: List[Char]): Boolean = {
    def chars2: List[Char] = chars.filter(c => c == '(' || c == ')')

    def balance(cache: List[Char], chars: List[Char]): Boolean = {
      if (chars.isEmpty)
        cache.isEmpty
      else {
        def cache2: List[Char] = if (cache.isEmpty) {
          chars.head :: cache
        }
        else {
          if (cache.last == '(' && chars.head == ')') cache.init else chars.head :: cache
        }
        balance(cache2, chars.tail)
      }
    }
    balance("".toList, chars2)
  }

  /**
    * Exercise 3
    */
  def countChange(money: Int, coins: List[Int]): Int = {
    if (money == 0)
      1
    else if (money > 0 && !coins.isEmpty)
      countChange(money, coins.tail) + countChange(money - coins.head, coins)
    else
      0
  }
}
