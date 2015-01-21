package com.wx.local.config;

import java.io.File;
import java.io.InputStream;
import java.util.Date;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.qiniu.api.auth.AuthException;
import com.qiniu.api.auth.digest.Mac;
import com.qiniu.api.io.IoApi;
import com.qiniu.api.io.PutExtra;
import com.qiniu.api.io.PutRet;
import com.qiniu.api.rs.PutPolicy;
import com.wx.local.service.ThirdPartyConifgService;

/**
 * @author James
 * 
 */
@Component
public class QNConfig {
	Logger logger = Logger.getLogger(getClass());

	private static String APPID_VALUE = "";
	private static String SECRET_KEY_VALUE = "";
	private final static String APPID = "qn-appid";
	private final static String SECRET_KEY = "qn-secretid";

	private final static int MAX_TRY = 3;
	/**
	 * timeout milliseconds
	 */
	private final static int MAX_TRY_MILLSCENDS = 3000;

	public enum BUCKET_PICS {
		pics;
	}

	public static String upToken = "";

	@Autowired
	private ThirdPartyConifgService thirdPartyConifgService;

	@PostConstruct
	public void init() {
		loadKeys();
	}

	private void loadKeys() {
		APPID_VALUE = thirdPartyConifgService.getValue(APPID);
		SECRET_KEY_VALUE = thirdPartyConifgService.getValue(SECRET_KEY);
		logger.info(String.format("qiniu load keys,APPID_VALUE=%s,SECRET_KEY_VALUE=%s",
				APPID_VALUE, SECRET_KEY_VALUE));
	}

	private String getUploadKey(String bucketName) throws AuthException, JSONException {
		Mac mac = new Mac(APPID_VALUE, SECRET_KEY_VALUE);
		// 请确保该bucket已经存在
		PutPolicy putPolicy = new PutPolicy(bucketName);
		upToken = putPolicy.token(mac);
		logger.info("Get qiniu upload key @" + new Date() + " " + upToken);
		return upToken;
	}

	public PutRet uploadFile(File f, String serverPath, String bucketName) throws AuthException,
			JSONException {
		if (StringUtils.isEmpty(upToken)) {
			getUploadKey(bucketName);
		}
		PutExtra extra = new PutExtra();
		PutRet ret = null;
		long start = System.currentTimeMillis();
		int count = 1;
		do {
			ret = IoApi.putFile(upToken, serverPath, f, extra);
		} while (retry(ret, start, count++));
		return ret;
	}

	private boolean retry(PutRet ret, long start, int count) {
		int statusCode = ret.getStatusCode();
		if (statusCode != 200) {
			long current = System.currentTimeMillis();
			if ((current - start) > MAX_TRY_MILLSCENDS) {
				logger.error(String.format("qiniu upload failed after tried %s millseconds",
						MAX_TRY_MILLSCENDS));
				return false;
			}
			if (count > MAX_TRY) {
				logger.error(String.format("qiniu upload failed after tried %s times", MAX_TRY));
				return false;
			}
			logger.warn(String.format("Qiniu upload failed statusCode=%s,message=%s,re-try ing !",
					statusCode, ret.getResponse()));
			if (statusCode == 401) {
				upToken = "";
			}
		}
		return true;
	}

	public PutRet uploadFile(InputStream in, String serverPath, String bucketName)
			throws AuthException, JSONException {
		if (StringUtils.isEmpty(upToken)) {
			getUploadKey(bucketName);
		}
		PutExtra extra = new PutExtra();
		PutRet ret = null;
		long start = System.currentTimeMillis();
		int count = 1;
		do {
			ret = IoApi.Put(upToken, serverPath, in, extra);
		} while (retry(ret, start, count));
		return ret;
	}

}
