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

import com.google.common.collect.Lists;
import com.wx.local.beans.Xml;
import com.wx.local.config.WXConfig;
import com.wx.local.service.MessageProcessor;
import com.wx.local.utils.CommonUtils;

@Controller
public class WXDispatchController {
	Logger logger = Logger.getLogger(getClass());

	@Autowired
	private MessageProcessor messageProcessor;

	@ResponseBody
	@RequestMapping(value = "/wx", method = { RequestMethod.POST }, consumes = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE,
			MediaType.TEXT_XML_VALUE })
	public Xml dispatch(String signature, String timestamp, String nonce, @RequestBody Xml xml,
			HttpServletResponse respnose, HttpServletRequest request) throws IOException {
		logger.info(signature + "," + timestamp + "," + nonce + "," + xml);
		List<String> params = Lists.newArrayList();
		params.add(WXConfig.token);
		params.add(timestamp);
		params.add(nonce);
		Collections.sort(params);
		String paramsStr = CommonUtils.list2String(params);
		String encrytpStr = CommonUtils.encrypt(paramsStr, "SHA-1");
		if (!signature.equals(encrytpStr)) {
			logger.error("dispatch illegal request from " + request.getRemoteHost());
		}
		if (null == xml) {
			logger.info("dispatch xml is null");
			return xml;
		}
		// // if (xml.getMsgType().equals(MessageTypeEnum.event.name())) {
		// handleEvent(xml);
		// } else {
		// handleMessage(xml);
		// }

		return handle(xml);
	}

	private Xml handle(Xml xml) {
		return messageProcessor.process(xml);
	}
}
