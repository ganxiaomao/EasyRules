package org.dsystems.rules.Utils;

import java.util.HashMap;

import org.dsystems.evaluator.AbstractVariableSet;

public class Record extends HashMap<String, Object> implements AbstractVariableSet<Object>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public Object get(String variableName) {
		return super.get(variableName);
	}

}
