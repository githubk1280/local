package com.wx.local.utils;

import java.io.File;

public class SystemUtils {

	public final static String LOG4JDIR = File.separator + "datas"
			+ File.separator + "applogs";
	public final static String LOG4JDIR_WIN = "D:" + LOG4JDIR;

	public enum SystemEnum {
		windows, linux;
	}

	public static String getSystem() {
		String sysSymbol = System.getProperty("os.name", "Windows");
		if (sysSymbol.toLowerCase().contains("windows")) {
			return SystemEnum.windows.name();
		}
		return SystemEnum.linux.name();
	}

	public static String getSystemLogDir() {
		if (isWindows()) {
			return LOG4JDIR_WIN;
		}
		return LOG4JDIR;
	}

	public static boolean isWindows() {
		return SystemEnum.windows.name().equals(getSystem());
	}
}
