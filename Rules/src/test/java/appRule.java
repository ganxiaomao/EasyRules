import org.dsystems.rules.Utils.Record;
import org.dsystems.rules.engine.RulesEngine;


public class appRule {

	public static void main(String[] args) {
		//Initialize RuleEngine.
		String rulesFile="C:\\Users\\Dhaval\\workspace\\Rules\\src\\test\\java\\App1.rls";
		String actionsFile="C:\\Users\\Dhaval\\workspace\\Rules\\src\\test\\java\\Actions.json";
		RulesEngine ruleEngine = RulesEngine.init(rulesFile, actionsFile);
		Record record = new Record();
		record.put("Temperature", 9);
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
