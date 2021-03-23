package com.rays.ors.util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * Data Utility class to format data from one format to another.
 *
 * @author Prateek
*/
public class DataUtility {
	// Application date and time format
	public static final String APP_DATE_FORMAT = "dd-MM-yyyy";
	/* Date format */

	public static final String APP_TIME_FORMAT = "dd/MM/yyyy HH:mm:ss";
	/* Time format */

	/* Date and Time formatter */

	private static final SimpleDateFormat fmt = new SimpleDateFormat(APP_DATE_FORMAT);
	// Date formatter

	private static final SimpleDateFormat tFmt = new SimpleDateFormat(APP_TIME_FORMAT);
	// Time formatter

	/* Trim, trailing & leading space in string */
	public static String getString(String a) {
		if (DataValidator.isNotNull(a)) {
			return a.trim();
		} else {
			return a;
		}
	}

	/**
	 * Converts an Object to String.
	 *
	 * @param val the val
	 * @return the string data
	 */
	public static String getStringData(Object val) {
		if (val != null) {
			return val.toString();
		} else {
			return "";
		}
	}

	/* Convert String into integer */
	public static int getInt(String b) {
		if (DataValidator.isInteger(b)) {
			return Integer.parseInt(b);
		} else {
			return 0;
		}
	}

	/* Convert String into long */
	public static long getLong(String v) {
		if (DataValidator.isLong(v)) {
			return Long.parseLong(v);
		} else {
			return 0;
		}
	}

	/* Convert String into Date */
	public static Date getDate(String s) {
		Date d = null;
		try {
			d = fmt.parse(s);
		} catch (Exception e) {
		}
		return d;
	}

	/* Convert Date into String */
	public static String getDateString(Date d) {
		try {
			return fmt.format(d);
		} catch (Exception e) {
		}
		return "";
	}

	/* Get Date after number of days */
	public static Date getDate(Date d, int day) {
		return null;
	}

	/* Convert string into time */
	public static Timestamp getTimeStamp(String v) {
		Timestamp t = null;
		try {
			t = new Timestamp(tFmt.parse(v).getTime());
		} catch (Exception e) {
			return null;
		}
		return t;
	}

	public static Timestamp getTimestamp(long l) {
		Timestamp t = null;
		try {
			t = new Timestamp(l);
		} catch (Exception e) {
			return null;
		}
		return t;
	}

	public static Timestamp getCurrentTimestamp() {
		Timestamp t = null;
		try {
			t = new Timestamp(new Date().getTime());
		} catch (Exception e) {
			return null;
		}
		return t;
	}

	public static long getTimestamp(Timestamp t) {
		try {
			return t.getTime();
		} catch (Exception e) {
			return 0;
		}
	}

	public static void main(String[] args) {
		System.out.println(getInt("124"));
	}

}
