package com.wx.local.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wx.local.beans.User;
import com.wx.local.dao.UserDao;

@Service
public class UserService {
	@Autowired
	private UserDao userDao;

	public User getUserByOpenId(String userOpenId) {
		return userDao.getUserByOpenId(userOpenId);

	}

	public void addUser(User user) {
		userDao.addUser(user);
	}

	public void updateLoginTime(String openId) {
		userDao.updateLoginTime(openId);

	}

}
