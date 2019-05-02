package week4

trait Expr {
//
//  def parse(): Expr =  {
//
//  }

  def eval(): Int = this match {
    case Number(n) => n
    case Sum(e1, e2) => e1.eval() + e2.eval()
    case Prod(l, r) => l.eval() * r.eval()
    case Var(x) => {
      if (x == "x") return 1
      if (x == "y") return 2
      if (x == "z") return 3
      else return 0
    }
  }

  def show(): String = this match {
    case Number(n) => n.toString
    case Var(x) => x
    case Sum(e1, e2) => e1.show() + " + " + e2.show()
    case Prod(Sum(l, r), Sum(l2, r2)) => "(" + Sum(l, r).show() + ") * " + Sum(l2, r2).show()
    case Prod(Sum(l, r), rp) => "(" + Sum(l, r).show() + ") * " + rp.show()
    case Prod(lp, Sum(l, r)) => lp.show() + " * (" + Sum(l, r).show()
    case Prod(e1, e2) => e1.show() + " * " + e2.show()
  }
}

case class Number(n: Int) extends Expr
case class Sum(e1: Expr, e2: Expr) extends Expr
case class Prod(e1: Expr, e2: Expr) extends Expr
case class Var(name: String) extends Expr

object Exprs extends App{

  val e = Prod(Sum(Number(2), Var("x")), Var("y"))
  println(e.show())
  println(e.eval())
}
