import org.dsystems.rules.Utils.Record;
import org.dsystems.rules.action.IAction;
import org.dsystems.rules.action.ConsoleOutAction;
import org.dsystems.rules.rules.Rule;
import org.junit.Test;


public class TestRule {

	private void applyRule(Rule rule, Record record) {
		rule.run(record);
	}

	@Test
	public void testRuleSimple() {
		Rule rule = new Rule("Rule1");
		IAction outAction = new ConsoleOutAction("Test Message !!");
		rule.addAction(outAction);
		rule.setExpression("Temperature<10");
		Record record = new Record();
		record.put("Temperature", 4);
		record.put("Perssure", 10);
		applyRule(rule, record);
		rule.setExpression("False");
		applyRule(rule, record);
		rule.setExpression("Perssure>9");
		applyRule(rule, record);
	}

}
