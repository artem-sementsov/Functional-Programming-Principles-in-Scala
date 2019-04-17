
abstract class Base {
  def foo = 1
  def bar: Int
}

class Sub extends Base {
  override val foo = 2
  def bar = 3
}