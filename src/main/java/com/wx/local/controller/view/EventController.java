package com.wx.local.controller.view;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

import com.alibaba.fastjson.JSON;
import com.qiniu.api.auth.AuthException;
import com.qiniu.api.io.PutRet;
import com.wx.local.beans.Event;
import com.wx.local.config.QNConfig;
import com.wx.local.config.QNConfig.BUCKET_PICS;
import com.wx.local.service.EventService;
import com.wx.local.service.EventService.PullDirection;
import com.wx.local.utils.EventUtils;
import com.wx.local.utils.JsonResponseUtils;

@Controller
@RequestMapping("/event")
public class EventController {
	Logger logger = Logger.getLogger(getClass());

	@Autowired
	private EventService eventService;

	@Autowired
	private QNConfig qnConfig;

	@RequestMapping("/ajax/down/{id}")
	public void ajaxDownLoad(@PathVariable int id, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		List<Event> events = eventService.getEventWithLimitById(id,
				PullDirection.DOWN.name(), eventService.NORMAL_OFFSET);
		WebUtils.setSessionAttribute(request, "pullId",
				eventService.NORMAL_OFFSET);
		JsonResponseUtils.returnJsonResponse(response,
				JSON.toJSONString(events), true, 200);
	}

	@RequestMapping("/ajax/up/{id}")
	public void ajaxUpLoad(@PathVariable int id, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		List<Event> events = eventService.getEventWithLimitById(id,
				PullDirection.UP.name(), eventService.NORMAL_OFFSET);
		WebUtils.setSessionAttribute(request, "pullId",
				eventService.NORMAL_OFFSET);
		JsonResponseUtils.returnJsonResponse(response,
				JSON.toJSONString(events), true, 200);
	}

	@RequestMapping("/add")
	public ModelAndView addEvent(String text, String picPath,
			HttpServletRequest request) {
		ModelAndView view = new ModelAndView();
		logger.info(text + "--" + picPath);
		String openId = (String) WebUtils
				.getSessionAttribute(request, "openId");
		String eventName = "";
		Event event = EventUtils.createNormalEvent(openId);
		event.setPics(picPath);
		event.setEventName(eventName);
		event.setContent(text);
		event.setUserLocalId(StringUtils.isEmpty(openId) ? "游客"
				+ new Date().getTime() : openId);
		event.setFrom("website");
		eventService.addEvent(event);
		// view.addObject("", "");
		view.setViewName("redirect:/index");
		return view;
	}

	@RequestMapping("/addForm")
	public ModelAndView addEventByForm(MultipartFile file, String text,
			HttpServletRequest request) throws AuthException, JSONException,
			IOException {
		ModelAndView view = new ModelAndView();
		String picPath ="";
		if (!file.isEmpty()) {
			PutRet result = null;
			String fileName = "file-pics-" + file.getOriginalFilename()
					+ new Date().getTime();
			result = qnConfig.uploadFile(file.getInputStream(), fileName,
					BUCKET_PICS.pics.name());
			logger.info(result.getKey());
			picPath = result.getKey();
		}
		String openId = (String) WebUtils
				.getSessionAttribute(request, "openId");
		String eventName = "";
		Event event = EventUtils.createNormalEvent(openId);
		event.setPics(picPath);
		event.setEventName(eventName);
		event.setContent(text);
		event.setUserLocalId(StringUtils.isEmpty(openId) ? "游客"
				+ new Date().getTime() : openId);
		event.setFrom("website");
		eventService.addEvent(event);

		view.setViewName("redirect:/index");
		return view;
	}
}
