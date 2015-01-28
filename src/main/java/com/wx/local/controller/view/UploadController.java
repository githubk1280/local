package com.wx.local.controller.view;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

import com.qiniu.api.io.PutRet;
import com.wx.local.config.QNConfig;
import com.wx.local.config.QNConfig.BUCKET_PICS;
import com.wx.local.constants.PageResourceConstant;
import com.wx.local.utils.JsonResponseUtils;

@Controller
@RequestMapping("/send")
public class UploadController {
	Logger logger = Logger.getLogger(getClass());

	@Autowired
	private QNConfig qnConfig;

	@RequestMapping("/show")
	public ModelAndView sendJump() {
		ModelAndView view = new ModelAndView();
		view.setViewName(PageResourceConstant.UPLOAD);
		return view;
	}

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public void send(MultipartFile file, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		PutRet result = null;
		String openId = (String) WebUtils
				.getSessionAttribute(request, "openId");
		String eventName = String.valueOf(new Date().getTime());
		String fileName = openId + "#" + eventName + "#"
				+ file.getOriginalFilename();
		try {
			result = qnConfig.uploadFile(file.getInputStream(), fileName,
					BUCKET_PICS.pics.name());
		} catch (Exception e) {
			logger.error(String.format("upload failed detail :", e.getMessage()));
			JsonResponseUtils.returnJsonResponse(response, "上传失败，请重试", false,
					500);
			return;
		}
		logger.info("Before Upload file size =" + file.getSize() / 1024 + "KB");
		JsonResponseUtils.returnJsonResponse(response, result.getKey(),
				result.ok(), result.statusCode);
	}

}
