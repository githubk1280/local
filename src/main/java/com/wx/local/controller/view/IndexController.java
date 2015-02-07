package com.wx.local.controller.view;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

import com.wx.local.beans.Event;
import com.wx.local.constants.PageResourceConstant;
import com.wx.local.service.EventService;
import com.wx.local.service.EventService.PullDirection;
import com.wx.local.service.UserService;
import com.wx.local.utils.DateUtils;

@Controller
public class IndexController {
	Logger logger = Logger.getLogger(getClass());

	@Autowired
	private EventService eventService;

	@Autowired
	private UserService userService;

	@RequestMapping("/index")
	public ModelAndView index(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView view = new ModelAndView();
		view.addObject("title", "首页");
		List<Event> events = eventService.getEventWithLimitByDate(
				getUserPullFromDate(request), PullDirection.DOWN.name(),
				eventService.NORMAL_OFFSET);
		int upStartId = setPullId(request, "upPullStartId", events, 0);
		int downStartId = setPullId(request, "downPullStartId", events, 0);
		view.addObject("events", events);
		view.addObject("upStartId", upStartId);
		view.addObject("downStartId", downStartId + 1);
		view.setViewName(PageResourceConstant.INDEX);
		return view;
	}

	private int setPullId(HttpServletRequest request, String key,
			List<Event> events, int index) {
		Integer id = (Integer) WebUtils.getSessionAttribute(request, key);
		if (CollectionUtils.isEmpty(events)) {
			id = 0;
		} else {
			id = events.get(index).getId();
		}
		logger.info("id=" + id);
		WebUtils.setSessionAttribute(request, key, id);
		return id;
	}

	private Date getUserPullFromDate(HttpServletRequest request) {
		Date d = (Date) WebUtils.getSessionAttribute(request, "pullStartDate");
		d = DateUtils.getDateDeltaMins(0);
		WebUtils.setSessionAttribute(request, "pullStartDate", d);
		logger.info(d);
		return d;

	}
}
