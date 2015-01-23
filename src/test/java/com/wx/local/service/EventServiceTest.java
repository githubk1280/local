package com.wx.local.service;

import java.io.UnsupportedEncodingException;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.wx.local.base.AbstractBaseTestConfig;
import com.wx.local.beans.Event;
import com.wx.local.utils.DateUtils;

public class EventServiceTest extends AbstractBaseTestConfig {
	@Autowired
	private EventService eventServcie;

	@Test
	public void testGetEventWithLimit() {
		System.out.println(eventServcie.getEventWithLimit(0, 0, 10));
	}

	@Test
	@Ignore
	public void testAddEvent() throws UnsupportedEncodingException {
		for (int i = 0; i < 20; i++) {
			Event event = new Event();
			event.setContent("测试文字测试文字测试文字测试文字测试文字测试文字测试文字测试文字测试文字测试文字测试文字测试文字测试文字测试文字测试文字测试文字测试文字测试文字测试文字测试文字测试文字测试文字测试文字测试文字测试文字测试文字测试文字测试文字测试文字"
					+ i * 20);
			event.setCreateTime(DateUtils.getDate(i));
			event.setFrom("测试中心");
			event.setPics("sdafs");
			event.setRegion("dds");
			event.setStatus(0);
			event.setType("0");
			event.setUserLocalId("test1232132");
			event.setUserName("testabc");
			event.setViewCount(0);
			event.setZanCount(0);
			// System.out.println(event);
			eventServcie.addEvent(event);
		}
	}

}
