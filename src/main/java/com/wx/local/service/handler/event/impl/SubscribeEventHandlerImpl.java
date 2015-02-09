package com.wx.local.service.handler.event.impl;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.wx.local.beans.Image;
import com.wx.local.beans.Xml;
import com.wx.local.config.WXConfig.MessageTypeEnum;
import com.wx.local.service.handler.MessageHandler;
import com.wx.local.utils.LoggerUtils;

@Component("subscribeEventHandlerImpl")
public class SubscribeEventHandlerImpl implements MessageHandler {

	@Override
	public Xml handle(final Xml xml) {
		logger.info("subscribe bingo..........");
		logger.info(String.format(LoggerUtils.URL_COUNT_LOGGER_TEMPLATE,
				xml.getEventKey()));
		String to = xml.getFromUserName();
		String from = xml.getToUserName();
		xml.setCreateTime(new Date().getTime());
		xml.setFromUserName(from);
		xml.setToUserName(to);
		xml.setMsgType(MessageTypeEnum.image.name());
		Image image = new Image();
		image.setMediaId("203716587");
		xml.setImage(image);
		return xml;
	}
}
