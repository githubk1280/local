package com.wx.local.dao;

import org.springframework.stereotype.Repository;

import com.wx.local.beans.User;

@Repository
public interface UserDao {

	public User getUserByOpenId(String userOpenId);

	public void addUser(User user);

	public void updateLoginTime(String openId);

}
