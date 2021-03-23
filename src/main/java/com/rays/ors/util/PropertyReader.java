package com.rays.ors.util;

import java.util.ResourceBundle;

/**
 * Read the property values from application properties file using Resource
 * Bundle
 *
 * @author Prateek
 *
 */

public class PropertyReader {

	private static ResourceBundle rb = ResourceBundle.getBundle("com.rays.ors.bundle.system");

	/**
	 * Return value of key
	 *
	 * @param key the string used
	 * @return the string variable
	 */

	public static String getValue(String key) {

		String val = null;

		try {
			val = rb.getString(key);
		} catch (Exception e) {
			val = key;
		}

		return val;

	}

	/**
	 * Gets String after placing param values
	 *
	 * @param key the string parameter
	 * @param param the string parameter
	 * @return String
	 */
	public static String getValue(String key, String param) {
		String msg = getValue(key);
		msg = msg.replace("{0}", param);
		return msg;
	}

	/**
	 * Gets String after placing params values
	 *
	 * @param key the string
	 * @param params the string array
	 * @return the message
	 */
	public static String getValue(String key, String[] params) {
		String msg = getValue(key);
		for (int i = 0; i < params.length; i++) {
			msg = msg.replace("{" + i + "}", params[i]);
		}
		return msg;
	}

	/**
	 * Test method
	 *
	 * @param args the string array
	 */

	public static void main(String[] args) {
		String[] params = { "Roll No" };
		System.out.println(PropertyReader.getValue("error.require", params));
	}

}
