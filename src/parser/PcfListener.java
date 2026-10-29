// Generated from C:/Users/samso/Documents/A3/compilation et interprétation/Pcf/src/parser/Pcf.g4 by ANTLR 4.13.2
package parser;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link PcfParser}.
 */
public interface PcfListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code App}
	 * labeled alternative in {@link PcfParser#term}.
	 * @param ctx the parse tree
	 */
	void enterApp(PcfParser.AppContext ctx);
	/**
	 * Exit a parse tree produced by the {@code App}
	 * labeled alternative in {@link PcfParser#term}.
	 * @param ctx the parse tree
	 */
	void exitApp(PcfParser.AppContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Number}
	 * labeled alternative in {@link PcfParser#term}.
	 * @param ctx the parse tree
	 */
	void enterNumber(PcfParser.NumberContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Number}
	 * labeled alternative in {@link PcfParser#term}.
	 * @param ctx the parse tree
	 */
	void exitNumber(PcfParser.NumberContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Var}
	 * labeled alternative in {@link PcfParser#term}.
	 * @param ctx the parse tree
	 */
	void enterVar(PcfParser.VarContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Var}
	 * labeled alternative in {@link PcfParser#term}.
	 * @param ctx the parse tree
	 */
	void exitVar(PcfParser.VarContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Let}
	 * labeled alternative in {@link PcfParser#term}.
	 * @param ctx the parse tree
	 */
	void enterLet(PcfParser.LetContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Let}
	 * labeled alternative in {@link PcfParser#term}.
	 * @param ctx the parse tree
	 */
	void exitLet(PcfParser.LetContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BinaryTerm2}
	 * labeled alternative in {@link PcfParser#term}.
	 * @param ctx the parse tree
	 */
	void enterBinaryTerm2(PcfParser.BinaryTerm2Context ctx);
	/**
	 * Exit a parse tree produced by the {@code BinaryTerm2}
	 * labeled alternative in {@link PcfParser#term}.
	 * @param ctx the parse tree
	 */
	void exitBinaryTerm2(PcfParser.BinaryTerm2Context ctx);
	/**
	 * Enter a parse tree produced by the {@code ParTerm}
	 * labeled alternative in {@link PcfParser#term}.
	 * @param ctx the parse tree
	 */
	void enterParTerm(PcfParser.ParTermContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ParTerm}
	 * labeled alternative in {@link PcfParser#term}.
	 * @param ctx the parse tree
	 */
	void exitParTerm(PcfParser.ParTermContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BinaryTerm1}
	 * labeled alternative in {@link PcfParser#term}.
	 * @param ctx the parse tree
	 */
	void enterBinaryTerm1(PcfParser.BinaryTerm1Context ctx);
	/**
	 * Exit a parse tree produced by the {@code BinaryTerm1}
	 * labeled alternative in {@link PcfParser#term}.
	 * @param ctx the parse tree
	 */
	void exitBinaryTerm1(PcfParser.BinaryTerm1Context ctx);
	/**
	 * Enter a parse tree produced by the {@code IfZero}
	 * labeled alternative in {@link PcfParser#term}.
	 * @param ctx the parse tree
	 */
	void enterIfZero(PcfParser.IfZeroContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IfZero}
	 * labeled alternative in {@link PcfParser#term}.
	 * @param ctx the parse tree
	 */
	void exitIfZero(PcfParser.IfZeroContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Fun}
	 * labeled alternative in {@link PcfParser#term}.
	 * @param ctx the parse tree
	 */
	void enterFun(PcfParser.FunContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Fun}
	 * labeled alternative in {@link PcfParser#term}.
	 * @param ctx the parse tree
	 */
	void exitFun(PcfParser.FunContext ctx);
}