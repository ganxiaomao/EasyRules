package org.dsystems.rules.parser;

import java.io.Serializable;

public enum TokenType  implements Serializable{
	VARIABLE, 
	CONSTANT_DECIMAL,
	CONSTANT_STRING,
	KEYWORD,
	BINARYOPERATOR,
	UNARYOPERATOR,
	BRACKETS,
	ARITHMETICOPERATOR,
	COMPARISIONOPERATOR,
	FUNCTION, LOGICALOPERATOR;
}
