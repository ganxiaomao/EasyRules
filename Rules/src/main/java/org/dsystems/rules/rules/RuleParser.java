package org.dsystems.rules.rules;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;
import org.dsystems.rules.action.ActionParser;
import org.dsystems.rules.action.IAction;
import org.dsystems.rules.engine.RulesEngine;

public class RuleParser {
	final static Logger logger = Logger.getLogger(RuleParser.class);
	
	public static Rule parse(String rulestr) {
		//rulestr = rulestr.replaceAll("(\\t|\\r?\\n)+", " ");
		rulestr = rulestr.trim();
		String expression = "";
		String actionsStr = "";
		String name = "";
		//Pattern pattern = Pattern.compile("rule \"(.*?)\".*if (.*?) then (.*?)end", Pattern.DOTALL|Pattern.CASE_INSENSITIVE);
		Pattern pattern = Pattern.compile("rule \"(.*?)\".*if (.*?)then(.*?)end", Pattern.DOTALL|Pattern.CASE_INSENSITIVE);
	    Matcher matcher = pattern.matcher(rulestr);
	    logger.debug("Parsing rule: " + rulestr);
	    if (matcher.matches())
        {
	    	name = matcher.group(1);
            expression = matcher.group(2);
            actionsStr = matcher.group(3);
    	    logger.debug("Expression : " + expression.trim());
    	    logger.debug("Actions: " + actionsStr.trim());
    		Rule rule = new Rule(name);
    	    rule.setExpression(expression.trim());
    	    List<IAction> actions = ActionParser.parse(actionsStr.trim());
    	    rule.setActions(actions);
    		return rule;
        } else {
        	return null;
        }
	}
}
