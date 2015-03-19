package org.dsystems.rules.action;

import java.util.Properties;

import org.dsystems.rules.Utils.Record;

public class ConsoleOutAction extends IAction {

	public ConsoleOutAction() {
		this.properties = new Properties();
		
	}

	public ConsoleOutAction(String message) {
		this.properties = new Properties();
		this.properties.setProperty("message", message);
		//System.out.println("Creating ConsoleOutAction with Message: " + message);
	}
	
	@Override
	public void perform(Record record) {
		String message="";
		//if (properties.contains("message")) {
			message = properties.getProperty("message");
		//}
		//System.out.println("Message: " +message);
		System.out.println("Performing ConsoleOutAction " + getMessage(message, record));
	}

	@Override
	public boolean init(Properties properties, String arguments) {
		return true;
	}

}
