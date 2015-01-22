package com.wx.local.controller;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.WebUtils;

import com.google.common.collect.Lists;
import com.wx.local.beans.Xml;
import com.wx.local.config.WXConfig;
import com.wx.local.config.WXConfig.MessageTypeEnum;
import com.wx.local.service.MessageProcessor;
import com.wx.local.service.UserService;
import com.wx.local.utils.CommonUtils;
import com.wx.local.utils.UserUtils;

@Controller
public class WXDispatchController {
	Logger logger = Logger.getLogger(getClass());

	@Autowired
	private MessageProcessor messageProcessor;

	@Autowired
	private UserService userService;

	@ResponseBody
	@RequestMapping(value = "/wx", method = { RequestMethod.POST }, consumes = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE,
			MediaType.TEXT_XML_VALUE })
	public Xml dispatch(String signature, String timestamp, String nonce,
			@RequestBody Xml xml, HttpServletResponse respnose,
			HttpServletRequest request) throws IOException {
		logger.info(signature + "," + timestamp + "," + nonce + "," + xml);
		List<String> params = Lists.newArrayList();
		params.add(WXConfig.token);
		params.add(timestamp);
		params.add(nonce);
		Collections.sort(params);
		String paramsStr = CommonUtils.list2String(params);
		String encrytpStr = CommonUtils.encrypt(paramsStr, "SHA-1");
		if (!signature.equals(encrytpStr)) {
			logger.error("dispatch illegal request from "
					+ request.getRemoteHost());
		}
		if (null == xml) {
			logger.info("dispatch xml is null");
			return xml;
		}
		if (xml.getMsgType().equals(MessageTypeEnum.event.name())) {
			String openId = xml.getFromUserName();
			boolean exists = userService.exists(openId);
			handleEvent(xml, exists);
			if (!exists) {
				userService.addUser(UserUtils.createNormalUser(openId));
				WebUtils.setSessionAttribute(request, "login", true);
			} else {
				boolean isLogined = WebUtils.getSessionAttribute(request,
						"login") != null;
				if (!isLogined) {
					WebUtils.setSessionAttribute(request, "login", true);
				}
			}
			return null;
		} else {
			return handleMessage(xml);
		}

	}

	private Xml handleMessage(Xml xml) {
		return messageProcessor.process(xml);
	}

	private Xml handleEvent(Xml xml, boolean isLogin) {
		return messageProcessor.process(xml, isLogin);
	}
}
