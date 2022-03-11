package com.pms.management.utils;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * The Class EraUtil.
 */
public class PmsManagementUtil {


	private PmsManagementUtil() {
		super();
	}

	public static Long convertObjectIntoLong(Object obj) {
		return Long.valueOf(String.valueOf(obj));
	}

	public static String convertObjectIntoString(Object obj) {
		return String.valueOf(obj);
	}

	
	public static String formatDate(Date date, String dateFormat) {
		SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);
		return (null != date) ? formatter.format(date) :"";
	}

	
	public static Date parseDate(String date, String dateFormat) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);
		return (null != date) ? formatter.parse(date) : null;
	}

	public static BigDecimal convertObjectIntoBigDecimal(Object obj) {
		return BigDecimal.valueOf(Double.parseDouble(String.valueOf(obj)));
	}

	public static Double convertObjectIntoDouble(Object obj) {
		return Double.parseDouble(String.valueOf(obj));
	}

	public static Integer convertObjectIntoInteger(Object obj) {
		return Integer.valueOf(Integer.parseInt(String.valueOf(obj)));
	}

}