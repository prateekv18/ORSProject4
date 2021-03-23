package com.rays.ors.util;

import java.math.MathContext;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Prateek
 *
 */
public class DataValidator {
	/* Check, if string is null */
	public static boolean isNull(String a) {
		if (a == null || a.trim().length() == 0) {
			return true;
		} else {
			return false;
		}
	}

	// If string is not null
	public static boolean isNotNull(String a) {
		return !isNull(a);
	}

	/* To check if value is integer */
	public static boolean isInteger(String v) {
		if (isNotNull(v)) {
			try {
				int i = Integer.parseInt(v);
				return true;
			} catch (NumberFormatException e) {
				return false;
			}
		} else {
			return false;
		}
	}

	/* To check if value is long */
	public static boolean isLong(String v) {
		if (isNotNull(v)) {
			try {
				long l = Long.parseLong(v);
				return true;
			} catch (NumberFormatException e) {
				return false;
			}
		} else {
			return false;
		}
	}

	/* Check email validation */
	public static boolean isEmail(String s) {
		String exp = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

		if (isNotNull(s)) {
			try {
				return s.matches(exp);
			} catch (NumberFormatException e) {
				return false;
			}
		} else {
			return false;
		}
	}

	/* Check whether value is null */
	public static boolean isDate(String s) {
		Date d = null;
		if (isNotNull(s)) {
			d = DataUtility.getDate(s);
		}
		return d != null;
	}

	/**
	 * Checks if value is Mobile Number.
	 *
	 * @param val the val
	 * 
	 * @return true, if is mobile no
	 */

	public static boolean isMobileNo(String val) {

		String mobreg = "^[6-9][0-9]{9}$";

		if (isNotNull(val) && val.matches(mobreg)) {

			return true;
		} else {
			return false;
		}
	}

	/**
	 * checks if value is Name.
	 *
	 * @param val the val
	 * @return true, if is name
	 */
	public static boolean isName(String val) {

		// String namereg = "^[a-zA-Z]+$";
		// String namereg = "^[a-zA-Z_-]+$";
		String namereg = "^[^-\\s][\\p{L} .']+$";

		if (DataValidator.isNotNull(val)) {
			boolean check = val.matches(namereg);

			return check;
		} else {
			return false;
		}
	}

	/**
	 * check if value is Valid Name.
	 *
	 * @param val the val
	 * @return true, if is valid name
	 */
	public static boolean isValidName(String val) {

		String namereg = "^[a-zA-Z_-]+$";

		// String namereg = "^[^-\\s][\\p{L} .']+$";

		if (DataValidator.isNotNull(val)) {
			boolean check = val.matches(namereg);

			return check;
		} else {
			return false;
		}
	}

	/**
	 * check if value is password.
	 *
	 * @param val the val
	 * @return true, if it is password
	 */
	public static boolean isPassword(String val) {

		String pass = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,15})";

		if (DataValidator.isNotNull(pass)) {
			boolean check = val.matches(pass);
			return check;
		} else {
			return false;
		}
	}

	/**
	 * check if value is Roll no.
	 *
	 * @param val the val
	 * @return true, if is roll no
	 */
	public static boolean isRollNo(String val) {

		String roll = "^[0-9]{2}[A-Z]{2}[0-9]{2}$";

		if (DataValidator.isNotNull(roll)) {
			boolean check = val.matches(roll);
			return check;
		} else {
			return false;
		}
	}

	/**
	 * check if value is validate age.
	 *
	 * @param val the val
	 * @return true, if is validate age
	 */
	public static boolean isvalidateAge(String val) {

		Date today = new Date();
		Date enterDate = DataUtility.getDate(val);
		System.out.println(today.getYear());
		int age = today.getYear() - enterDate.getYear();

		if (age > 18 && isNotNull(val)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Test above methods.
	 *
	 * @param args the arguments
	 */
	/*
	 * public static void main(String[] args) {
	 * 
	 * System.out.println("Not Null 2" + isNotNull("ABC"));
	 * System.out.println("Not Null 3" + isNotNull(null)); //
	 * System.out.println("Not Name" + isName("pankaj")); // String s =
	 * "a hajk     a mdlvkj   lkjlkgkl.    /lkjlkhklvjlk"; String a =
	 * "A           di    ty       a"; String b = "Sourabhg91@";
	 * System.out.println(isPassword(b));
	 * 
	 * System.out.println("Is Int " + isInteger(null)); System.out.println("Is Int "
	 * + isInteger("ABC1")); System.out.println("Is Int " + isInteger("123"));
	 * System.out.println("Is Int " + isNotNull("123")); } }
	 */
}
