package com.wx.local.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {
	private static final String DEFAULT_FORMAT = "yyyy-MM-dd";

	public static String formt(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat(DEFAULT_FORMAT);
		return sdf.format(date);
	}

	public static Date getDate(int delta) {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DAY_OF_MONTH, delta);
		return c.getTime();
	}
}
