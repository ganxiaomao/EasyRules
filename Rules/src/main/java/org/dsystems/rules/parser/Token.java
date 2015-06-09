package org.dsystems.rules.parser;

import java.io.Serializable;

public class Token  implements Serializable{
	private TokenType type;
	private String value;
	public Token(TokenType type, String value) {
		super();
		this.type = type;
		this.value = value;
	}
	public Token() {
		// TODO Auto-generated constructor stub
	}
	public TokenType getType() {
		return type;
	}
	public void setType(TokenType type) {
		this.type = type;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	@Override
	public String toString() {
		return "Token [type=" + type + ", value=" + value + "]";
	}
	
}
