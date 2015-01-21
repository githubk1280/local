package com.wx.local.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wx.local.beans.Xml;
import com.wx.local.service.handler.MessageHandler;

@Service
public class MessageProcessor {
	Logger logger = Logger.getLogger(getClass());

	@Autowired
	private MessageHandlerFactory messageHandlerFactory;

	public Xml process(Xml xml) {
		MessageHandler handler = messageHandlerFactory.get(xml.getMsgType(), xml.getEvent());
		return handler.handle(xml);
	}
}
