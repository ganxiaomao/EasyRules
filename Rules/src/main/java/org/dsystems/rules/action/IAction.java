package org.dsystems.rules.action;

import java.io.Serializable;
import java.util.Properties;

import org.apache.commons.lang3.text.StrSubstitutor;
import org.dsystems.utils.Record;

public abstract class IAction  implements Serializable{


	private static final long serialVersionUID = 1L;
	protected String name;
	protected Properties properties;
	
	
	public Properties getProperties() {
		return properties;
	}

	public void setProperties(Properties properties) {
		this.properties = properties;
	}

	public abstract void perform(Record record);
	public abstract boolean init(Properties properties, String arguments);
	
	public String getMessage(String message, Record record) {
		StrSubstitutor sub = new StrSubstitutor(record, "${", "}");
		return sub.replace(message);
	}

}
