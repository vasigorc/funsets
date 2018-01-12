package funsets

object Main extends App {
  import FunSets._
  println(contains(singletonSet(1), 1))
  println(intersect(singletonSet(-4), (_ % 2 == 1))( -4))
}
