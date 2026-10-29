// Generated from C:/Users/samso/Documents/A3/compilation et interprétation/Pcf/src/parser/Pcf.g4 by ANTLR 4.13.2
package parser;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link PcfParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface PcfVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by the {@code App}
	 * labeled alternative in {@link PcfParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitApp(PcfParser.AppContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Number}
	 * labeled alternative in {@link PcfParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumber(PcfParser.NumberContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Var}
	 * labeled alternative in {@link PcfParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVar(PcfParser.VarContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Let}
	 * labeled alternative in {@link PcfParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLet(PcfParser.LetContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BinaryTerm2}
	 * labeled alternative in {@link PcfParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryTerm2(PcfParser.BinaryTerm2Context ctx);
	/**
	 * Visit a parse tree produced by the {@code ParTerm}
	 * labeled alternative in {@link PcfParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParTerm(PcfParser.ParTermContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BinaryTerm1}
	 * labeled alternative in {@link PcfParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryTerm1(PcfParser.BinaryTerm1Context ctx);
	/**
	 * Visit a parse tree produced by the {@code IfZero}
	 * labeled alternative in {@link PcfParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfZero(PcfParser.IfZeroContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Fun}
	 * labeled alternative in {@link PcfParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFun(PcfParser.FunContext ctx);
}