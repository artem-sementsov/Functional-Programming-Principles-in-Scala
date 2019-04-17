package funsets

object Main extends App {

  import FunSets._

  val set_1 = singletonSet(1)
  val set_1_2 = union(singletonSet(1), singletonSet(2))
  val set_1_2_3 = union(union(singletonSet(1), singletonSet(2)), singletonSet(3))

  println(contains(set_1, 1))
  printSet(set_1_2)
  printSet(intersect(set_1_2, set_1))
  printSet(diff(set_1_2, set_1))
  printSet(filter(set_1_2_3, (x: Int) => x > 1))
  println(forall(set_1_2_3, (x: Int) => x > 0))
  println(exists(set_1_2_3, (x: Int) => x < 0))
  printSet(map(set_1_2_3, (x: Int) => x * x))
}
