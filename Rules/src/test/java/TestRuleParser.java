import org.dsystems.rules.rules.Rule;
import org.dsystems.rules.rules.RuleParser;
import org.junit.Test;


public class TestRuleParser {

	public Rule parseRule(String rulestr) {
		System.out.println("--------------------------------------------------------------------------");
		System.out.println("Rule String: " + rulestr);
		return RuleParser.parse(rulestr);
	}
	@Test
	public void testRule1()  {
		String rulestr = "IF Temperature < 10 Then consolelog(\"Message for Temperature\")";
		@SuppressWarnings("unused")
		Rule rule = parseRule(rulestr);
	}
	@Test
	public void testRuleMultiAction()  {
		String rulestr = "If Temperature < 10 Then consolelog(\"Message for Temperature\")\nfilelog(Message for ${Temperature})";
		@SuppressWarnings("unused")
		Rule rule = parseRule(rulestr);
	}
}
