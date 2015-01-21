package com.wx.local.service.handler.impl;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.stereotype.Component;

import com.wx.local.beans.Xml;
import com.wx.local.service.handler.MessageHandler;

@Component("viewEventHandlerImpl")
public class ViewEventHandlerImpl implements MessageHandler {

	@Override
	public Xml handle(Xml xml) {
		String to = xml.getFromUserName();
		String from = xml.getToUserName();
		xml.setCreateTime(new Date().getTime());
		xml.setFromUserName(from);
		xml.setToUserName(to);
		xml.setMsgId(xml.getMsgId().add(new BigDecimal(1)));
		xml.setContent("感谢发话，我们会尽快完成此功能！");
		return null;
	}

}
