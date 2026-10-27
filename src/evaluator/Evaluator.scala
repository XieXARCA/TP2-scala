package evaluator

import ast.Term
import Term.*
import ast.Op
import ast.Op.{Divide, Minus, Multiply, Plus}

object Evaluator :

  type Env = Map[String, Int]

  def eval(t: Term, e: Env): Int = t match

    case Number(value) => value
    case IfZero(c, t1, t2) =>
      if eval(c, e) == 0 then eval(t1, e) else eval(t2, e)

    case BinaryExp(op, t1, t2) =>
      val v1 = eval(t1, e)
      val v2 = eval(t2, e)
      op match
        case Plus => v1 + v2
        case Minus => v1 - v2
        case Multiply => v1 * v2
        case Divide => v1 / v2
    case Var(name) => e.getOrElse(name, throw Exception(f" ${Var(name)}%s not associated to any value"))

    case Let(name, tA1, tA2) =>
      tA2 match
        case Var(name) => eval(tA1, e)
        case BinaryExp(op, tB1, tB2)
          if tB1 != tB2 =>
            if tB1 == Var(name) then eval( BinaryExp(op, tA1, tB2), e)
            else eval(BinaryExp(op, tB1, tA1), e)
        case BinaryExp(op, tB1, tB2) => eval(BinaryExp(op, tA1, tA1), e)
        case IfZero(Var(name), tB1, tB2) => eval( IfZero(tA1, tB1, tB2), e)
        case IfZero( tB1, Var(name), tB2) => eval( IfZero(tB1, tA1, tB2), e)
        case IfZero( tB1, tB2, Var(name)) => eval( IfZero(tB1, tB2, tA1), e)

    case ParTerm(lpar, term, rpar) => eval(term, e)

    case _ => ???

