package org.dsystems.rules.engine;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dsystems.utils.Record;
import org.dsystems.rules.action.ActionConfig;
import org.dsystems.rules.action.ActionFactory;
import org.dsystems.rules.rules.Rule;
import org.dsystems.rules.rules.RuleParser;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;

import com.google.gson.Gson;

public class RulesEngine implements Serializable{

	protected List<Rule> rules;
	protected Map<String, ActionConfig> actionConfigs;
	final static Logger logger = Logger.getLogger(RulesEngine.class);
	
	public static RulesEngine init(String rulesFile, String actionFile) {
		Map<String, ActionConfig> actions = readActionConfigs(actionFile);
		ActionFactory.setActionConfigs(actions);
		RulesEngine rulesEngine = init(rulesFile);
		rulesEngine.actionConfigs = actions;
		return rulesEngine;
	}
	
	public static RulesEngine init(String rulesFile) {
		RulesEngine rulesEngine = new RulesEngine();
		rulesEngine.rules = readRules(rulesFile); 
		return rulesEngine;
	}
	
	public boolean registerActionConfig(String actionName, ActionConfig actionConfig) {
		if (actionConfigs == null) 
			actionConfigs = new HashMap<String, ActionConfig>();
		if (actionConfigs.containsKey(actionName)) {
			logger.error("Action Configs already contains key: " + actionName);
			return false;
		}
		actionConfigs.put(actionName, actionConfig);
		logger.info("Action Config added for key: " + actionName);
		return true;
	}
	
	@SuppressWarnings("unchecked")
	private static Map<String, ActionConfig> readActionConfigs(String actionFile) {
		Map<String, ActionConfig> actions = new HashMap<String, ActionConfig>();
		try {
 			String content = FileUtils.readFileToString(new File(actionFile));
			Gson gson = new Gson();
			ActionConfig[] actionConfigs = gson.fromJson(content, ActionConfig[].class);
			for (ActionConfig action: actionConfigs) {
				actions.put(action.getName(), action);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return actions;
	}
	
	private static List<Rule> readRules(String rulesFile) {
		List<Rule> rules = new ArrayList<Rule>();
		try {
			String content = FileUtils.readFileToString(new File(rulesFile));
			String[] rulesStr = content.split("end");
			for (String ruleStr: rulesStr) {
				Rule rule = RuleParser.parse(ruleStr+"end");
				if (rule != null)
					rules.add(rule);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rules;
	}



	public void run(Record record) {
		for(Rule rule: rules) {
			rule.run(record);
		}
	}
}
