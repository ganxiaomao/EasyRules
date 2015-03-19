package org.dsystems.rules.action;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.dsystems.rules.Utils.Record;

public class FileLogAction extends IAction {
	final static Logger logger = Logger.getLogger(FileLogAction.class);
	
	protected String fileName;
	protected String message;
	
	public FileLogAction() {
		this.properties = new Properties();
	}

/*	public FileLogAction(String message) {
		this.properties = new Properties();
		this.properties.setProperty("message", message);
		//System.out.println("Creating ConsoleOutAction with Message: " + message);
	}
*/	
	@Override
	public boolean init(Properties properties, String arguments) {
		logger.debug("init("+properties.toString()+", " + arguments + ")");
		if (properties.getProperty("filename") == null) {
			logger.error("Reuired property filename is not set in config");
			return false; 
		}
		fileName = properties.getProperty("filename");
		message = arguments;
		this.properties = properties;
		return true;
	}

	@Override
	public void perform(Record record) {
		//String message="";
		//if (properties.contains("message")) {
		//	message = properties.getProperty("message");
		//}
		//System.out.println("Message: " +message);
		try {
			//FileUtils.writeStringToFile(new File(fileName), "Performing File Log Action " + getMessage(message, record));
			FileWriter fileWriter = new FileWriter(new File(fileName), true);
		    fileWriter.append("Performing File Log Action " + getMessage(message, record) + "\n");
		    fileWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println("Performing ConsoleOutAction " + getMessage(message, record));
	}


}
