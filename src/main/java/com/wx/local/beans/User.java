package com.wx.local.beans;

import java.util.Date;

import lombok.Data;

@Data
public class User {
	private int id;
	private String openId;
	/**
	 * 商户，普通用户
	 */
	private int type;
	/**
	 * 等级
	 */
	private int level;
	private String name;
	/**
	 * 用户修改的网站显示名
	 */
	private String alias;
	private int gender;
	/**
	 * 家乡
	 */
	private String homeTown;
	private String password;
	/**
	 * 头像地址
	 */
	private String headPic;
	private Date registerTime;
	private Date lastLoginTime;

}
