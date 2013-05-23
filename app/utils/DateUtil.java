package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	private static final String PATTERN = "yy/MM/dd HH:mm:ss";
	
	private static final SimpleDateFormat SDF = new SimpleDateFormat(PATTERN);
	
	/**
	 * Convert date to formatted String value .
	 * @param date
	 */
	public static String toString(Date date) {
		return SDF.format(date);
	}
}
