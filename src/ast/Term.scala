package ast

enum Term:
  case Number(value: Int)
  case BinaryExp(op: Op, term1: Term, term2: Term)
  case IfZero(test: Term, term1: Term, term2: Term)
  case Var(name: String)
  case Let(name: String, term1: Term, term2: Term)
  case ParTerm(lpar: Par, term: Term, rpar: Par)
  case Fun(name: String , term: Term)
  case App(term1: Term, term2: Term)

enum Op:
  case Plus, Minus, Multiply, Divide

enum Value:
  case Vint(i: Int)
  case Vfun(name: String, body: Term, env: Map[String , Value])

object Value:
  def toInt(value: Value): Int = value match
    case Vint(x) => x
    case _ => ???



enum Par:
  case LPAR, RPAR

object Op:
  def parse(op: String): Op = op match
    case "+" => Plus
    case "-" => Minus
    case "*" => Multiply
    case "/" => Divide
    case _ => ???

    