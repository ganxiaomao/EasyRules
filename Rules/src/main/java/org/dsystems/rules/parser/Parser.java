package org.dsystems.rules.parser;

import java.util.ArrayList;
import java.util.List;


public class Parser {

	public Parser() {
		
	}
	public List<Token> parse(String rulestr) {
		Tokenizer tokenizer = new Tokenizer(rulestr);
		List<Token> tokenList = new ArrayList<Token>();
		Token token = tokenizer.getNextToken();
		if (token != null)
			tokenList.add(token);
		while(token != null) {
			System.out.println("Next Token : " + token);
			token = tokenizer.getNextToken();
			if (token != null)
				tokenList.add(token);
		}
		return tokenList;
	}
}
