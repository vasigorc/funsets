object  FunSetsTests{
  import funsets.FunSets._



  contains(x=> x > 10, 11)

  singletonSet(5)(5)

  val toFilter: Set =_ < 10

  union((_ < 10), (_ % 2 == 0))(11)

  intersect((_ < 0),  (_ % 2 == 0))(-5)

  filter(toFilter, x => x * x < 1000)(97)

  filter(toFilter, _ == 101)(101)

  val iool = forall((_ < 1001), x => x != -1001)

  exists((_ < 1001), x => x != -1001)

  forall(x=> x< bound && x> -bound, singletonSet(5))

  exists(x => x > 2000, x => x >3000)
}