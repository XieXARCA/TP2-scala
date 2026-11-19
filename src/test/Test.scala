package test

import pcf.Pcf

@main
def test(): Unit =
  val examples = List(
    "test/square.pcf",
    "test/if.pcf",
    "test/let.pcf",
    "test/fun-let.pcf",
    "test/curry.pcf",
    "test/higher-order.pcf",
    "test/free-var.pcf",
    "test/twice.pcf",
    "test/factorial.pcf",
    "test/fibonacci.pcf",
    "test/sum-rec.pcf",
    "test/curry-rec.pcf",
    "test/error-not-a-function.pcf"
  )
  for file <- examples do
    println(s"--- $file ---")
    test(file)
    println()

def test(file: String): Unit =
  Pcf.main(Array(file))
