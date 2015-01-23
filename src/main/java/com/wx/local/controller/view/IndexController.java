package com.wx.local.controller.view;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

import com.wx.local.constants.PageResourceConstant;
import com.wx.local.service.EventService;
import com.wx.local.service.UserService;

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
		Date d = (Date) WebUtils.getSessionAttribute(request, "pullStartDate");
		if (null == d) {
			d = new Date();
		}
		view.addObject("events",
				eventService.getEventWithLimit(d, eventService.NORMAL_OFFSET));
		view.setViewName(PageResourceConstant.INDEX);
		return view;
	}
}
