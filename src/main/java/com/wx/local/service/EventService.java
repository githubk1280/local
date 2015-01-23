package com.wx.local.service;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.wx.local.beans.Event;
import com.wx.local.dao.EventDao;
import com.wx.local.utils.DateUtils;

@Service
public class EventService {
	Logger logger = Logger.getLogger(getClass());
	public final int NORMAL_OFFSET = 10;
	public final int ADMIN_OFFSET = 20;

	@Autowired
	private EventDao eventDao;

	public List<Event> getEventWithLimit(int id, int start, int offset) {
		List<Event> events = eventDao.getEventWithLimit(id, start, offset);
		if (CollectionUtils.isEmpty(events))
			return Collections.emptyList();
		return events;
	}

	public List<Event> getEventWithLimit(Date now, int offset) {
		List<Event> events = eventDao.getEventWithLimitDate(
				DateUtils.formt(now), offset);
		if (CollectionUtils.isEmpty(events))
			return Collections.emptyList();
		logger.info(String.format("get events size=%s", events.size()));
		return events;
	}

	public void addEvent(Event event) {
		eventDao.addEvent(event);
	}

}
