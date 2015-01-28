package com.wx.local.utils;

import org.apache.log4j.Logger;

import com.wx.local.beans.Event;

public class EventUtils {
	Logger logger = Logger.getLogger(getClass());

	public static Event createNormalEvent(String openId) {
		Event event = new Event();
		event.setStatus(-1);
		event.setType(1);
		return event;
	}

}