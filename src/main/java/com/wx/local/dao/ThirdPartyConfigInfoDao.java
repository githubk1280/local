package com.wx.local.dao;

import org.springframework.stereotype.Repository;

@Repository
public interface ThirdPartyConfigInfoDao {
	public String getValue(String key);
}
