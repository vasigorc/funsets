package rationals

/**
  * Created by vgorcinschi on 22/01/17.
  */
class Rational (x: Int, y: Int){
  require(y != 0, "Denominator cannot be 0")

  private val g = gcd(x.abs, y.abs)
  val numer = x / g
  val denom = y / g

  def this(x: Int) = this(x, 1)

  def + (that: Rational):Rational =
    new Rational(
      numer*that.denom + that.numer*denom,
      denom*that.denom
    )

  def < (that: Rational) = numer*that.denom < that.numer*denom

  def + (i: Int):Rational = new Rational(numer + i*denom, denom)

  def - (that: Rational):Rational = this + -that

  def - (i: Int):Rational = new Rational(numer - i*denom, denom)

  def * (that: Rational):Rational = new Rational(numer*that.numer, denom*that.denom)

  def * (i: Int): Rational = new Rational(numer * i, denom)

  def / (that: Rational): Rational = new Rational(numer*that.denom, denom*that.numer)

  def / (i: Int): Rational = new Rational(numer, denom*i)

  def unary_- : Rational = new Rational(-numer, denom)

  override def toString: String = s"$numer/$denom"

  private def gcd(a: Int, b: Int):Int = if(b == 0) a else gcd(b, a % b)
}
