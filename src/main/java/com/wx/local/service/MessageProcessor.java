package com.wx.local.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wx.local.beans.Xml;
import com.wx.local.service.handler.MessageHandlerFactory;

@Service
public class MessageProcessor {
	Logger logger = Logger.getLogger(getClass());

	@Autowired
	private MessageHandlerFactory messageHandlerFactory;

	public Xml process(Xml xml) {
		return messageHandlerFactory.get(xml.getMsgType(), xml.getEvent()).handle(xml);
	}
}
