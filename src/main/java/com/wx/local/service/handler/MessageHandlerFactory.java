package com.wx.local.service.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.wx.local.config.WXConfig.EventTypeEnum;
import com.wx.local.config.WXConfig.MessageTypeEnum;

@Component
public class MessageHandlerFactory {
	@Autowired
	@Qualifier("textHandlerImpl")
	private MessageHandler textHandlerImpl;

	@Autowired
	@Qualifier("viewEventHandlerImpl")
	private MessageHandler viewEventHandlerImpl;

	public MessageHandler get(String type, String eventType) {
		if (type.equals(MessageTypeEnum.event.name())) {
			if (eventType.equals(EventTypeEnum.VIEW.name())) {
				return viewEventHandlerImpl;
			}
		} else if (type.equals(MessageTypeEnum.text.name())) {
			return textHandlerImpl;
		}
		return null;

	}
}
