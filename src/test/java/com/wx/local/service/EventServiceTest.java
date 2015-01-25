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
		// System.out.println(eventServcie.getEventWithLimit(0, 0, 10));
	}

	@Test
	@Ignore
	public void testAddEvent() throws UnsupportedEncodingException {
		int j = 24;
		for (int i = 99; i > 80; i--) {
			Event event = new Event();
			event.setContent("第一天当老师烟瘾犯了，然后去厕所抽了颗烟，这时德育处主任来了把我拽到了办公室，说了我一顿而且越说越过分还要请家长。。。给处分。。。这时我弱弱的说一句我是新来的，他说新来的也应该懂校规吧。。。这时我又说了老师两字。。。我和主任都沉默了 "
					+ i * 20);
			event.setId(i);
			event.setCreateTime(DateUtils.getDate(-(j++)));
			event.setFrom("测试中心");
			// event.setPics("sdafs");
			event.setRegion("dds");
			event.setStatus(0);
			event.setType("0");
			event.setUserLocalId("test1232132");
			event.setUserName("testabc");
			event.setViewCount(0);
			event.setZanCount(0);
			eventServcie.addEvent(event);
		}
	}

}
