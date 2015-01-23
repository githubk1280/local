package com.wx.local.service;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.wx.local.base.AbstractBaseTestConfig;
import com.wx.local.beans.User;
import com.wx.local.utils.UserUtils;

public class UserServiceTest extends AbstractBaseTestConfig {
	@Autowired
	private UserService service;

	@Test
	@Ignore
	public void testExists() {
		System.out.println(service
				.getUserByOpenId("ozFLysooe-M0lxA_ZAygXLepJSS4"));
	}

	@Test
	@Ignore
	public void testAddUser() {
		User user = UserUtils.createNormalUser("ozFLysooe-M0lxA_ZAygXLepJSS4");
		user.setAlias("中文件");
		service.addUser(user);
	}

	@Test
	@Ignore
	public void updateLoginTime() {
		service.updateLoginTime("ozFLysooe-M0lxA_ZAygXLepJSS4");
	}
}
