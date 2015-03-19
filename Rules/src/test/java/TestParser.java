import org.dsystems.rules.parser.Parser;


public class TestParser {

	public TestParser() {
		// TODO Auto-generated constructor stub
	}
	public void parse(String rulestr) {
		System.out.println("Parsing: " + rulestr);
		Parser p = new Parser();
		p.parse(rulestr);
	}
	//@Test
	public void TestParseSimple() {
		String rulestr = "If Temperature < 10 Then Actions";
		parse(rulestr);
	}
	//@Test
	public void TestParseWithQuote() {
		String rulestr = "If ErrorCode =  \"E005\" Then Actions";
		parse(rulestr);
	}
	//@Test
	public void TestParseMulti() {
		String rulestr = "If ErrorCode =  \"E005\" AND Temperature < 14 Then Actions";
		parse(rulestr);
	}
}
