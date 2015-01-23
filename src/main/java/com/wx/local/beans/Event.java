package com.wx.local.beans;

import java.util.Date;

import lombok.Data;

@Data
public class Event {

	private int id;
	private String pics;
	private String content;
	private int zanCount;
	private int viewCount;
	/**
	 * 广告? 实事
	 */
	private String type;
	private String userLocalId;
	private String userName;
	private String from;
	/**
	 * 审核
	 */
	private int status;
	private String region;
	private Date createTime;
}
