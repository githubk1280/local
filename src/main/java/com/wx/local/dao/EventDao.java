package com.wx.local.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.wx.local.beans.Event;

@Repository
public interface EventDao {

	public List<Event> getEventWithLimit(@Param("id") int id,
			@Param("start") int start, @Param("offset") int offset);

	public List<Event> getEventWithLimitDate(@Param("date") String date,
			@Param("offset") int offset);

	public void addEvent(Event event);

}
