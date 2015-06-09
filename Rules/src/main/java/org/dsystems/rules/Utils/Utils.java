package org.dsystems.rules.Utils;

import java.io.Serializable;

public class Utils  implements Serializable{

	public static boolean isNumeric(String str)  
	{  
	  try  
	  {  
	    Double.parseDouble(str);  
	  }  
	  catch(NumberFormatException nfe)  
	  {  
	    return false;  
	  }  
	  return true;  
	}
	public static boolean isArithMeticOperator(String str) {
		if (str.equals("+") || str.equals("-") || str.equals("*") || str.equals("%") || str.equals("/") || str.equals("^"))
			return true;
		else
			return false;
	}

	public static boolean isComparisionOperator(String str) {
		if (str.equals(">") || str.equals("<") || str.equals(">=") || str.equals("<=") || str.equals("=") || str.equals("!="))
			return true;
		else
			return false;
	}

	public static boolean isKeyword(String str) {
		if (str.equalsIgnoreCase("If") || str.equalsIgnoreCase("Then") )
			return true;
		else
			return false;
	}
	public static boolean isLogicalOperator(String str) {
		if (str.equals("AND") || str.equals("OR") )
			return true;
		else
			return false;
	}

	
}
