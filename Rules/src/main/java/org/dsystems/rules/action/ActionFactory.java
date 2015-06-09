package org.dsystems.rules.action;

import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import org.apache.log4j.Logger;

public class ActionFactory  implements Serializable{

	private static Map<String, ActionConfig> actionConfigs;
	final static Logger logger = Logger.getLogger(ActionFactory.class);
	
	public static void setActionConfigs(Map<String, ActionConfig> actionConfigs) {
		ActionFactory.actionConfigs = actionConfigs;
	}

	public static IAction getAction(String actionStr, String arguments) {
		logger.debug("getAction("+actionStr+", " + arguments + ")");
		switch(actionStr) {
		case "log": {
			return new ConsoleOutAction(arguments);
		}
		default : 
			return getActionForClass(actionStr, arguments);
		}
	}

	private static IAction getActionForClass(String actionStr, String arguments) {
		logger.debug("getActionForClass("+actionStr+", " + arguments + ")");
		if (actionConfigs == null) {
			return null;
		}
		
		ActionConfig actionConfig = actionConfigs.get(actionStr);
		if (actionConfig == null) {
			logger.error("Can not find the action: " + actionStr + " in action Confings");
			return null;
		}
		String className = actionConfig.getClassName();
		try {
			Class<?> clazz = Class.forName(className);
			Constructor<?> ctor = clazz.getConstructor();
			IAction action = (IAction)ctor.newInstance(new Object[] {  });
			action.init(actionConfig.getProperties(), arguments);
			return action;
		} catch (InstantiationException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}