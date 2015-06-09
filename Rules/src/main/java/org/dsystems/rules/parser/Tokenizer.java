package org.dsystems.rules.parser;

import java.io.Serializable;

import org.dsystems.rules.Utils.Utils;

public class Tokenizer  implements Serializable{

	private String input;
	private int current;

	public Tokenizer(String input) {
		this.input = input;
		current = 0;
	}
	public Token getNextToken() {
		Token token = readNextToken();
		//String str = 
		//System.out.println("getNextToken: token str: " + str);
		return token;
	}
	public Token readNextToken() {
		String str = "";
//		System.out.println("Input: " + input);
//		System.out.println("current: " + current);
		if (current >= input.length()) {
			return null;
		}
		while (true) {
			if (input.charAt(current) == '"') {
				// Read till next "
				//System.out.println("In Double quotes section");
				current++;
				while (input.charAt(current) != '"') {
					str += input.charAt(current);
					current++;
				}
				current++;
				return new Token(TokenType.CONSTANT_STRING, str);
//				return str;
			} else if (input.charAt(current) == '\'') {
				// Read till next '
				current++;
				while (input.charAt(current) == '\'') {
					str += input.charAt(current);
					current++;
				}
				current++;
				return new Token(TokenType.CONSTANT_STRING, str);
			} else if (input.charAt(current) == ' ') {
				// Read till next whilespace and skip
				current++;
				while (input.charAt(current) == ' ' || current >= input.length()) {
					current++;
				}
				continue;
			} else {
				// Read till next space
				//current++;
				while (current < input.length() && input.charAt(current) != ' ' ) {
					str += input.charAt(current);
					current++;
				}
				return getToken(str);
//				return str;
			}
		}
	}

	private Token getToken(String str) {
		if (Utils.isArithMeticOperator(str))
			return new Token(TokenType.ARITHMETICOPERATOR, str);
		if (Utils.isComparisionOperator(str))
			return new Token(TokenType.COMPARISIONOPERATOR, str);
		if (Utils.isLogicalOperator(str))
			return new Token(TokenType.LOGICALOPERATOR, str);
		if (Utils.isKeyword(str))
			return new Token(TokenType.KEYWORD, str);
		if (Utils.isNumeric(str)) 
			return new Token(TokenType.CONSTANT_DECIMAL, str);
		return new Token(TokenType.VARIABLE, str);
//		return null;
	}

}
