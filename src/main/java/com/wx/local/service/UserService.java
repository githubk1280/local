package com.wx.local.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wx.local.beans.User;
import com.wx.local.dao.UserDao;

@Service
public class UserService {
	@Autowired
	private UserDao userDao;

	public boolean exists(String userOpenId) {
		return userDao.getUserByOpenId(userDao);

	}

	public void addUser(User user) {
		// TODO Auto-generated method stub
		
	}

}
