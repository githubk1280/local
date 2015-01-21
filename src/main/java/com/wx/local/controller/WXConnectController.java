package com.wx.local.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.common.collect.Lists;
import com.wx.local.config.WXConfig;
import com.wx.local.utils.CommonUtils;

@Controller
public class WXConnectController {
	Logger logger = Logger.getLogger(getClass());

	@RequestMapping("/wx/connect")
	public void testConnect(String signature, String timestamp, String nonce,
			String echostr, HttpServletResponse respnose) throws IOException {
		logger.info(signature + "," + timestamp + "," + nonce + "," + echostr);
		List<String> params = Lists.newArrayList();
		params.add(WXConfig.token);
		params.add(timestamp);
		params.add(nonce);
		logger.info(params);
		Collections.sort(params);
		logger.info(params);
		String paramsStr = list2String(params);
		String encrytpStr = CommonUtils.encrypt(paramsStr, "SHA-1");
		logger.info(signature + " SHA1 match ? " + signature.equals(encrytpStr)
				+ " " + encrytpStr);
		PrintWriter writer = respnose.getWriter();
		writer.write(echostr);
	}

	private String list2String(List<String> source) {
		StringBuilder sb = new StringBuilder();
		for (String s : source) {
			sb.append(s);
		}
		return sb.toString();
	}

}
