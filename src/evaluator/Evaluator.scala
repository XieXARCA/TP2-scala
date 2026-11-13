package evaluator

import ast.Term
import Term.*
import ast.Op
import ast.Op.{Divide, Minus, Multiply, Plus}

class EvalError(msg: String) extends RuntimeException(msg)

object Evaluator:

  enum Value:
    case VInt(n: Int)
    case VFun(param: String, body: Term, defEnv: Map[String, Value])

    override def toString: String = this match
      case VInt(n)       => n.toString
      case VFun(p, _, _) => s"<fonction $p -> ...>"

  import Value.*

  type Env = Map[String, Value]

  def eval(t: Term, e: Env): Value = t match

    case Number(value) => VInt(value)

    case Var(name) =>
      e.getOrElse(name, throw EvalError(s"variable libre : $name n'est associee a aucune valeur"))

    case BinaryExp(op, t1, t2) =>
      val v1 = asInt(eval(t1, e), op)
      val v2 = asInt(eval(t2, e), op)
      op match
        case Plus     => VInt(v1 + v2)
        case Minus    => VInt(v1 - v2)
        case Multiply => VInt(v1 * v2)
        case Divide   =>
          if v2 == 0 then throw EvalError("division par zero")
          else VInt(v1 / v2)

    case IfZero(c, t1, t2) =>
      if asIntTest(eval(c, e)) == 0 then eval(t1, e) else eval(t2, e)

    case Let(name, t1, t2) =>
      val v1 = eval(t1, e)
      eval(t2, e + (name -> v1))

    case Fun(param, body) => VFun(param, body, e)

    case App(t1, t2) =>
      val arg = eval(t2, e)
      eval(t1, e) match
        case VFun(param, body, defEnv) =>
          eval(body, defEnv + (param -> arg))
        case VInt(n) =>
          throw EvalError(s"$n n'est pas une fonction : impossible de lui appliquer $arg")

  private def asInt(v: Value, op: Op): Int = v match
    case VInt(n) => n
    case VFun(_, _, _) =>
      throw EvalError(s"operande invalide pour ${symbol(op)} : $v n'est pas un entier")

  private def asIntTest(v: Value): Int = v match
    case VInt(n) => n
    case VFun(_, _, _) =>
      throw EvalError(s"le test de ifz doit etre un entier, et non $v")

  private def symbol(op: Op): String = op match
    case Plus => "+" ; case Minus => "-" ; case Multiply => "*" ; case Divide => "/"
