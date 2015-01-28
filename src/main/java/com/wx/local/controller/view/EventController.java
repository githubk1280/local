package com.wx.local.controller.view;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

import com.alibaba.fastjson.JSON;
import com.wx.local.beans.Event;
import com.wx.local.constants.PageResourceConstant;
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
		String eventName = getEventName(picPath);
		Event event = EventUtils.createNormalEvent(openId);
		event.setEventName(eventName);
		event.setContent(text);
		event.setUserLocalId(openId);
		eventService.addEvent(event);
		// view.addObject("", "");
		view.setViewName(PageResourceConstant.USER);
		return view;
	}

	private String getEventName(String picPath) {
		return picPath
				.substring(picPath.indexOf("#"), picPath.lastIndexOf("#"));
	}
}
