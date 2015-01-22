package com.wx.local.service.handler.event.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Component;

import com.wx.local.beans.Xml;
import com.wx.local.service.UserService;
import com.wx.local.service.handler.MessageHandler;
import com.wx.local.utils.LoggerUtils;
import com.wx.local.utils.UserUtils;

@Component("viewEventHandlerImpl")
public class ViewEventHandlerImpl implements MessageHandler {

	@Autowired
	private UserService userService;

	@Autowired
	private TaskExecutor taskExecutor;

	@Override
	public Xml handle(final Xml xml) {
		logger.info(String.format(LoggerUtils.URL_COUNT_LOGGER_TEMPLATE, xml.getEventKey()));
		taskExecutor.execute(new Runnable() {

			@Override
			public void run() {
				String openId = xml.getFromUserName();
				boolean exists = userService.getUserByOpenId(openId) != null;
				if (!exists) {
					userService.addUser(UserUtils.createNormalUser(openId));
				} else {
					userService.updateLoginTime(openId);
				}

			}

		});
		return null;
	}

}
