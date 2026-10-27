package test
import pcf.Pcf.main

@main
def test(): Unit =
  test("test/if.calc")

def test(file: String): Unit =
  val args = Array(file)
  main(args)


