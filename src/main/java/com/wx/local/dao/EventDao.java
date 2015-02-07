package com.wx.local.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.wx.local.beans.Event;

@Repository
public interface EventDao {

	public List<Event> getEventWithLimitById(@Param("id") int id,
			@Param("direction") String direction, @Param("offset") int offset);

	public void addEvent(Event event);

	public List<Event> getEventWithLimitByDate(@Param("date") String date,
			@Param("direction") String direction, @Param("offset") int offset);

	public void incrLove(int id);

	public Event getEventById(int id);

}
