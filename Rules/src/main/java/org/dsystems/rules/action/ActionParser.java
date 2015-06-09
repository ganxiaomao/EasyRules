package org.dsystems.rules.action;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

public class ActionParser  implements Serializable{

	final static Logger logger = Logger.getLogger(ActionParser.class);
	public static List<IAction> parse(String actionsStr) {
	
		List<IAction> actions = new ArrayList<IAction>();
		String[] actionStrList = actionsStr.split("\n");
		logger.debug("Number of Actions are: "+ actionStrList.length);
		for (String actionStr : actionStrList) {
			actionStr = actionStr.trim();
			if (actionStr.trim().isEmpty())
				continue;
			logger.debug("Action to parse: " + actionStr);
			IAction action = parseAction(actionStr);
			if (action == null) {
				logger.error("Can not parse action : " + actionStr);
			}
			actions.add(action);
		}
		return actions;
	}

	private static IAction parseAction(String actionStr) {
		IAction action = null;
		Pattern pattern = Pattern.compile("(.*?)\\(\"(.*?)\"\\)", Pattern.DOTALL|Pattern.CASE_INSENSITIVE);
	    Matcher matcher = pattern.matcher(actionStr);
	    logger.debug("Parsing action: " + actionStr);
	    String actionName = "";
	    String arguments = "";
	    if (matcher.matches())
        {
            actionName = matcher.group(1).trim();
            arguments = matcher.group(2).trim();
    	    logger.debug("actionName : " + actionName);
    	    logger.debug("arguments: " + arguments);
        }
	    action = ActionFactory.getAction(actionName, arguments);
		return action;
	}
}
