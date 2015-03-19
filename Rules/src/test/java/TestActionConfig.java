import org.dsystems.rules.action.ActionConfig;
import org.junit.Test;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;



public class TestActionConfig {

	@Test
	public void testActionConfig1() {
		ActionConfig action1 = new ActionConfig();
		action1.setName("filelog");
		action1.setClassName("org.dsystems.rules.actoin.FileLogAction");
		Properties props = new Properties();
		props.setProperty("filename", "Alerts.log");
		action1.setProperties(props);
		List<ActionConfig> actions = new ArrayList<ActionConfig>();
		actions.add(action1);
		Gson gson = new Gson();
		System.out.println("ActionConfig JSON: "+ gson.toJson(actions));
	}
}
