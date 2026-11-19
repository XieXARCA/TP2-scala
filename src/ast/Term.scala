package ast

enum Term:
  case Number(value: Int)
  case BinaryExp(op: Op, term1: Term, term2: Term)
  case IfZero(test: Term, term1: Term, term2: Term)
  case Var(name: String)
  case Let(name: String, term1: Term, term2: Term)
  case Fun(param: String, body: Term)
  case App(term1: Term, term2: Term)
  case Fix(name: String, body: Term)

enum Op:
  case Plus, Minus, Multiply, Divide

object Op:
  def parse(op: String): Op = op match
    case "+" => Plus
    case "-" => Minus
    case "*" => Multiply
    case "/" => Divide
    case _   => throw IllegalArgumentException(s"operateur inconnu : $op")
