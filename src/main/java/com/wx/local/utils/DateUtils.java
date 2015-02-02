package com.wx.local.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.log4j.Logger;

public class DateUtils {
	static Logger logger = Logger.getLogger("DateUtils");
	private static final String DEFAULT_FORMAT = "yyyy-MM-dd HH:mm:ss";

	public static String formt(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat(DEFAULT_FORMAT);
		logger.info(sdf.format(date));
		return sdf.format(date);
	}

	public static Date getDate(int delta) {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DAY_OF_MONTH, delta);
		logger.info(c.getTime());
		return c.getTime();
	}

	public static Date getDateDeltaMins(int delta) {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.MINUTE, delta);
		return c.getTime();
	}
}
