package com.wx.local.service.handler.event.impl;

import org.springframework.stereotype.Component;

import com.wx.local.beans.Xml;
import com.wx.local.service.handler.event.EventMessageHandler;
import com.wx.local.utils.LoggerUtils;

@Component("viewEventHandlerImpl")
public class ViewEventHandlerImpl implements EventMessageHandler {

	@Override
	public Xml handle(Xml xml, boolean isLogin) {
		logger.info(String.format(LoggerUtils.URL_COUNT_LOGGER_TEMPLATE,
				xml.getEventKey()));
		return null;
	}

}
