package org.dsystems.rules.rules;

import java.util.ArrayList;
import java.util.List;

import org.dsystems.rules.Utils.Record;
import org.dsystems.rules.action.IAction;
import org.dsystems.evaluator.ObjectEvaluator;

public class Rule {

	private String name;
	private String expression;
	private List<IAction> actions;

	public Rule(String name) {
		this.name=name;
		actions = new ArrayList<IAction>();
	}

	public Rule(String name, String expression) {
		this.name = name;
		this.expression = expression;
	}

	public Rule() {
		actions = new ArrayList<IAction>();
	}

	public String getExpression() {
		return expression;
	}

	public void setExpression(String expression) {
		this.expression = expression;
	}

	public List<IAction> getActions() {
		return actions;
	}

	public void setActions(List<IAction> actions) {
		this.actions = actions;
	}

	public void addAction(IAction action) {
		if (actions == null)
			actions = new ArrayList<IAction>();
		actions.add(action);
	}

	public void run(Record record) {
		ObjectEvaluator evaluator = new ObjectEvaluator();
		// System.out.println("Expression evaluates to : " +
		// evaluator.evaluate(expression,record));
		try {
			if ("false".equalsIgnoreCase(expression)) {
				System.out.println("Inactive Rule: " + name);
				return;
			}
			Object result = evaluator.evaluate(expression, record);
/*			if (("false".equalsIgnoreCase(result.toString()))) {
				return;
			}
*/			if (("true".equalsIgnoreCase(result.toString())) || (boolean) result == true) {
				//System.out.println("Performing actions...");
				for (IAction action : actions) {
					action.perform(record);
				}
			}
		} catch (Exception e) {
			System.out
					.println("Rule runner throws excetion for Rule: " + name + " : Message: " + e.getMessage());
		}
	}
}
