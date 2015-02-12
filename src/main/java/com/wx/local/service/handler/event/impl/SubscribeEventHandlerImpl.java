package com.wx.local.service.handler.event.impl;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.wx.local.beans.Image;
import com.wx.local.beans.Xml;
import com.wx.local.config.WXConfig.MessageTypeEnum;
import com.wx.local.service.handler.MessageHandler;

@Component("subscribeEventHandlerImpl")
public class SubscribeEventHandlerImpl implements MessageHandler {

	@Override
	public Xml handle(Xml xml) {
		logger.info("subscribe bingo..........");
		Xml returnXml = new Xml();
		String to = xml.getFromUserName();
		String from = xml.getToUserName();
		returnXml.setCreateTime(new Date().getTime());
		returnXml.setFromUserName(from);
		returnXml.setToUserName(to);
		returnXml.setMsgType(MessageTypeEnum.image.name());
		Image image = new Image();
		image.setMediaId("203716587");
		returnXml.setImage(image);
		logger.info(returnXml);
		return returnXml;
	}
}
