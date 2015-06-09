import org.dsystems.utils.Record;
import org.dsystems.rules.engine.RulesEngine;


public class appRule {

	public static void main(String[] args) {
		//Initialize RuleEngine.
		String rulesFile="C:\\Dhaval\\Work\\EasyRules\\Rules\\src\\test\\java\\App1.rls";
		String actionsFile="C:\\Dhaval\\Work\\EasyRules\\Rules\\src\\test\\java\\Actions.json";
		RulesEngine ruleEngine = RulesEngine.init(rulesFile, actionsFile);
		Record record = new Record();
		record.put("Temperature", 8);
		ruleEngine.run(record);
		record.put("Temperature", 20);
		ruleEngine.run(record);
		record.put("Temperature", 3);
		ruleEngine.run(record);
		record.put("Temperature", 36);
		record.put("Time", "Morning");
		ruleEngine.run(record);
	}
}
