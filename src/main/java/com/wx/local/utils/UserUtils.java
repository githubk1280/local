package com.wx.local.utils;

import java.util.Date;

import org.apache.log4j.Logger;

import com.wx.local.beans.User;

public class UserUtils {
	Logger logger = Logger.getLogger(getClass());

	public static User createNormalUser(String openId) {
		User user = new User();
		Date d = new Date();
		user.setGender(GenderEnum.male.getValue());
		user.setHeadPic("");
		user.setHomeTown("");
		user.setLastLoginTime(d);
		user.setLevel(LevelEnum.normal.getValue());
		user.setName("wxuser" + d.getTime());
		user.setOpenId(openId);
		user.setPassword("");
		user.setRegisterTime(d);
		user.setType(UserTypeEnum.normal.getValue());
		return user;
	}

	public enum GenderEnum {
		male(1), female(2);
		private int value;

		private GenderEnum(int value) {
			this.value = value;
		}

		public int getValue() {
			return value;
		}

	}

	public enum LevelEnum {
		normal(1);
		private int value;

		private LevelEnum(int value) {
			this.value = value;
		}

		public int getValue() {
			return value;
		}

	}

	public enum UserTypeEnum {
		normal(1), merchant(2);
		private int value;

		private UserTypeEnum(int value) {
			this.value = value;
		}

		public int getValue() {
			return value;
		}

	}

}