package com.wx.local.controller.view;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.WebUtils;

import com.alibaba.fastjson.JSON;
import com.wx.local.beans.Event;
import com.wx.local.service.EventService;
import com.wx.local.service.EventService.PullDirection;
import com.wx.local.utils.JsonResponseUtils;

@Controller
@RequestMapping("/event")
public class EventController {
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
}
