package parser

import ast.Term

import java.io.InputStream

object AbstractParser :
  def analyze(in: InputStream): Term =
    val concreteTree = ConcreteParser.analyze(in)
    val visitor = new ASTVisitor
    val term  = visitor.visit(concreteTree)
    println(s"AST: $term")
    term
 
