package evaluator

import ast.Term
import Term.*
import ast.Op.{Divide, Minus, Multiply, Plus}
import ast.Par.{LPAR, RPAR}
import ast.Value
import ast.Value.{Vfun, Vint, toInt}

object Evaluator :

  type Env = Map[String, Value]

  def eval(t: Term, e: Env) : Value = t match

    case Number(value) => Vint(value)
    case IfZero(c, t1, t2) =>
      if eval(c, e) == Vint(0) then eval(t1, e) else eval(t2, e)

    case BinaryExp(op, t1, t2) =>
      val v1 = eval(t1, e)
      val v2 = eval(t2, e)
      op match
        case Plus => Vint(toInt(v1) + toInt(v2))
        case Minus => Vint(toInt(v1) - toInt(v2))
        case Multiply => Vint(toInt(v1) * toInt(v2))
        case Divide => Vint(toInt(v1) / toInt(v2))

    case Var(name) => e.getOrElse(name, throw Exception(f" ${Var(name)}%s not associated to any value"))

    case Let(name, ta1, ta2) =>
      ta2 match
        case Var(name) => eval(ta1, e)
        case BinaryExp(op, tb1, tb2)
          if tb1 != tb2 =>
            if tb1 == Var(name) then eval( BinaryExp(op, ta1, tb2), e)
            else eval(BinaryExp(op, tb1, ta1), e)
        case BinaryExp(op, tb1, tb2) => eval(BinaryExp(op, ta1, ta1), e)
        case IfZero(Var(name), tb1, tb2) => eval( IfZero(ta1, tb1, tb2), e)
        case IfZero( tb1, Var(name), tb2) => eval( IfZero(tb1, ta1, tb2), e)
        case IfZero( tb1, tb2, Var(name)) => eval( IfZero(tb1, ta2, ta1), e)

    case ParTerm(lpar, term, rpar) => eval(term, e)

    case Fun(name, ta1) => Vfun(name, ta1, e)

    case App(ta1, ta2) =>
      val v1 = eval(ta1,e)
      val v2 = eval (ta2, e)
      v1 match
        case Vfun(name, tb1, env) => eval(tb1, env + (name -> v2))
        case _ => ???
    case _ => ???

