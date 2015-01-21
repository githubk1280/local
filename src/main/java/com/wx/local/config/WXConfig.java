package com.wx.local.config;

public class WXConfig {
	public final static String accessToken = "access_token";

	public final static String token = "123token321";

	public enum MessageTypeEnum {
		text, image, voice, video, location, link;
	}

	public enum EventTypeEnum {
		subscribe, unsubscribe, SCAN, LOCATION, CLICK, VIEW;
	}
}
