package pcf

import parser.AbstractParser.analyze
import parser.SyntaxError
import evaluator.{EvalError, Evaluator}
import Evaluator.eval

import java.io.{FileInputStream, InputStream}

object Pcf:
  def main(args: Array[String]): Unit =
    val in: InputStream =
      if args.isEmpty then
        System.in
      else
        FileInputStream(args(0))

    try
      val term = analyze(in)
      println(s"==> ${eval(term, Map())}")
    catch
      case e: SyntaxError => println(s"Erreur de syntaxe : ${e.getMessage}")
      case e: EvalError   => println(s"Erreur d'evaluation : ${e.getMessage}")
