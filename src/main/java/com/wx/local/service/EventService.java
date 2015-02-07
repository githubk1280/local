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

	public enum PullDirection {
		UP, DOWN;
	}

	@Autowired
	private EventDao eventDao;

	public Event getEventById(int id) {
		return eventDao.getEventById(id);
	}

	public List<Event> getEventWithLimitById(int id, String direction, int offset) {
		List<Event> events = eventDao.getEventWithLimitById(id, direction, offset);
		if (CollectionUtils.isEmpty(events))
			return Collections.emptyList();
		return events;
	}

	public void addEvent(Event event) {
		eventDao.addEvent(event);
	}

	public List<Event> getEventWithLimitByDate(Date now, String direction, int offset) {
		List<Event> events = eventDao.getEventWithLimitByDate(DateUtils.formt(now), direction,
				offset);
		if (CollectionUtils.isEmpty(events))
			return Collections.emptyList();
		logger.info(String.format("get events size=%s", events.size()));
		return events;
	}

	public void incrLove(int id) {
		eventDao.incrLove(id);

	}

}
