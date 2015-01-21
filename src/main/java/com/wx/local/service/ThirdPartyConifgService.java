package com.wx.local.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wx.local.dao.ThirdPartyConfigInfoDao;

@Service
public class ThirdPartyConifgService {

	@Autowired
	private ThirdPartyConfigInfoDao dao;

	public String getValue(String key) {
		return dao.getValue(key);

	}
}
