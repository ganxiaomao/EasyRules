package org.dsystems.rules.expression;
import java.util.List;

import org.dsystems.expression.*;
import org.dsystems.rules.parser.Parser;
import org.dsystems.rules.parser.Token;

public class Evaluator {

	private Evaluator() 
	{}
	public static Expression  getExpression(String expr) {
		Parser p = new Parser();
		List<Token> tokenList = p.parse(expr);
		return generateExpression(tokenList);
	}
	private static Expression generateExpression(List<Token> tokenList) {
		Expression expr = null; 
		return expr;
	}
}
