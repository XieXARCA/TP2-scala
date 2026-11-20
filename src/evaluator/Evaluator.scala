package evaluator

import ast.Term
import Term.*
import ast.Op.{Divide, Minus, Multiply, Plus}
import ast.Par.{LPAR, RPAR}
import ast.Value
import ast.Value.{Vfun, Vice, Vint, toInt}

object Evaluator :

  type Env = Map[String, Value]
  val e1:Env = Map.empty[String, Value]

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
        case Divide =>
          if toInt(v2) == 0 then throw Exception("division by zero")
          else Vint(toInt(v1) / toInt(v2))

    case Var(name) => e.getOrElse(name, throw Exception(f" ${Var(name)}%s not associated to any value"))

    case Let(name, ta1, ta2) =>
      val v1 = eval(ta1, e)
      eval(ta2, e + (name -> v1))

    case ParTerm(lpar, term, rpar) => eval(term, e )

    case Fix(name, t) => Vice(name, t, e)

    case Fun(name, t) =>  Vfun(name,t , e )

    case App(ta1, ta2) =>
      val v1 = eval(ta1,e)
      val v2 = eval (ta2, e)
      v1 match
        case Vfun(name, tb1, env) => eval(tb1, env + (name -> v2))
        case Vice(name, tb1, env) =>
          val fun = eval(tb1, env + (name -> Vice(name, tb1, env)))
          fun match
            case Vfun(name2, tc1, envFun) =>
              eval(tc1, envFun +(name2 -> v2))
            case _ => ???
        case _ => ???
    case _ => ???


