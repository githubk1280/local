package com.wx.local.dao;

import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {

	public boolean getUserByOpenId(UserDao userDao);

}
