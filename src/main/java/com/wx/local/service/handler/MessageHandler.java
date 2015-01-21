package com.wx.local.service.handler;

import org.apache.log4j.Logger;

import com.wx.local.beans.Xml;

public interface MessageHandler {
	Logger logger = Logger.getLogger(MessageHandler.class);

	public Xml handle(Xml xml);
}
