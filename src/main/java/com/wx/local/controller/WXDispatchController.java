package com.wx.local.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.common.collect.Lists;
import com.wx.local.beans.Xml;
import com.wx.local.config.WXConfig;
import com.wx.local.service.MessageProcessor;
import com.wx.local.utils.CommonUtils;

@RequestMapping("/wx")
@Controller
public class WXDispatchController {
	Logger logger = Logger.getLogger(getClass());

	@Autowired
	private MessageProcessor messageProcessor;
	
	public void connect(String signature, String timestamp, String nonce,
			String echostr, HttpServletResponse respnose) throws IOException {
		logger.info(signature + "," + timestamp + "," + nonce + "," + echostr);
		List<String> params = Lists.newArrayList();
		params.add(WXConfig.token);
		params.add(timestamp);
		params.add(nonce);
		logger.info(params);
		Collections.sort(params);
		logger.info(params);
		String paramsStr = CommonUtils.list2String(params);
		String encrytpStr = CommonUtils.encrypt(paramsStr, "SHA-1");
		logger.info(signature + " SHA1 match ? " + signature.equals(encrytpStr)
				+ " " + encrytpStr);
		PrintWriter writer = respnose.getWriter();
		writer.write(echostr);
	}

//	@ResponseBody
//	@RequestMapping(value = "/wx", consumes = {
//			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE,
//			MediaType.TEXT_XML_VALUE })
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
			// return null;
		}
		if (null == xml) {
			logger.warn("dispatch xml is null");
			return xml;
		}
		return handle(xml);

	}

	private Xml handle(Xml xml) {
		return messageProcessor.process(xml);
	}
}
