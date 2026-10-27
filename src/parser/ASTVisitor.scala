package parser

import ast.Term
import ast.Term.*
import ast.Op
import ast.Par.{LPAR, RPAR}

import scala.jdk.CollectionConverters.*

class ASTVisitor extends PcfBaseVisitor[Term] :

  override def visitNumber(ctx: PcfParser.NumberContext): Term =
    Number(ctx.getText.toInt)

  override def visitBinaryExp1(ctx: PcfParser.BinaryExp1Context): Term =
    val s = ctx.OP1().getText
    val op = Op.parse(s)
    val concreteExps = ctx.term.asScala.toList
    val List(term1, term2) =
      for (concreteTerm <- concreteExps) yield
        visit(concreteTerm)
    BinaryExp(op, term1, term2)

  override def visitBinaryExp2(ctx: PcfParser.BinaryExp2Context): Term =
    val s = ctx.OP2().getText
    val op = Op.parse(s)
    val concreteTerms = ctx.term.asScala.toList
    val List(term1, term2) =
      for (concreteTerm <- concreteTerms) yield
        visit(concreteTerm)
    BinaryExp(op, term1, term2)

  override def visitIfZero(ctx: PcfParser.IfZeroContext): Term =
    val concreteTerms = ctx.term.asScala.toList
    val List(term1, term2, term3) =
      for (concreteTerm <- concreteTerms) yield
        visit(concreteTerm)
    IfZero(term1, term2, term3)

  override def visitVar(ctx: PcfParser.VarContext): Term =
    Var(ctx.ID().getText)
    
  override def visitLet(ctx: PcfParser.LetContext): Term =
    val concreteTerms = ctx.term.asScala.toList
    val name = ctx.ID().getText
    val List(term1, term2) =
      for (concreteTerm <- concreteTerms) yield
        visit(concreteTerm)
    Let (name, term1, term2)

  override def visitParExp(ctx: PcfParser.ParExpContext): Term =
    val term = visit(ctx.term)
    ParTerm(LPAR, term, RPAR )

