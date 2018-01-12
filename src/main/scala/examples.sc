import scala.annotation.tailrec

def sum(f: Int => Int)(a: Int, b: Int):Int = {
  if(a > b) 0 else f(a) + sum(f)(a+1, b)
}

sum(x=>x) (1, 10)

def sum2(f: Int=>Int)(a: Int, b: Int):Int ={
  @tailrec
  def loop(a: Int, acc: Int):Int = {
    if(a > b) acc
    else loop(a+1, f(a)+acc)
  }
  loop(a, 0)
}

sum2(x=>x)(1, 10)

def product(f: Int => Int)(a: Int, b: Int):Int = {
  if(a > b) 1 else f(a) * product(f)(a+1, b)
}

product(x=>x)(1,5)

def fact(x: Int):Int = product(x=>x)(1,x)

fact(5)

def combine(f: Int=>Int)(a: Int, b: Int)(unit:Int)
           (oper:(Int, Int)=>Int):Int={
  if(a > b) unit else oper(f(a), combine(f)(a+1, b)(unit)(oper))
}

combine(x=>x)(1, 5)(1)((a,b) => a*b)