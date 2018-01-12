package funsets

import org.scalatest.PropSpec
import org.scalatest.prop.Checkers
import org.scalacheck.{Gen, Prop}
import org.scalatest.Matchers

/**
  * Created by vgorcinschi on 09/01/18.
  */
class FunSetsCheck extends PropSpec with Checkers with Matchers{

  import FunSets._

  private val gen = Gen.oneOf(singletonSet(1001), (x:Int) => x != -1,
    (x:Int) => x > 10)

  property("forAll") {
    val gt1000:Set =  _ > 1000
    check(Prop.forAll(gen){(a) => FunSets.forall(gt1000, a)})
  }

  property("map"){
    val validRange = Gen.choose(-1000, 1000)
    check(Prop.forAll(validRange){(anInt) => contains(map(singletonSet(anInt), _ / 2), anInt / 2)})
  }
}
