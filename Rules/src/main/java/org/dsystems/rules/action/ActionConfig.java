package org.dsystems.rules.action;

import java.io.Serializable;
import java.util.Properties;

public class ActionConfig  implements Serializable{


	private static final long serialVersionUID = 1L;
	protected String name;
	protected String className;
	protected Properties properties;
	
	public ActionConfig() {
	}

	public ActionConfig(String name, String className, Properties properties) {
		super();
		this.name = name;
		this.className = className;
		this.properties = properties;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public Properties getProperties() {
		return properties;
	}

	public void setProperties(Properties properties) {
		this.properties = properties;
	}
	
}
