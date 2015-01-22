package com.wx.local.service.handler.event.impl;

import org.springframework.stereotype.Component;

import com.wx.local.beans.Xml;
import com.wx.local.service.handler.MessageHandler;
import com.wx.local.utils.LoggerUtils;

@Component("viewEventHandlerImpl")
public class ViewEventHandlerImpl implements MessageHandler {

	@Override
	public Xml handle(Xml xml) {
		logger.info(String.format(LoggerUtils.URL_COUNT_LOGGER_TEMPLATE, xml.getEventKey()));
		return null;
	}

}
