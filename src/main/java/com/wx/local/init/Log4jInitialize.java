package com.wx.local.init;

import java.net.URL;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.wx.local.utils.SystemUtils;

@Component
public class Log4jInitialize implements ApplicationListener<ContextRefreshedEvent> {
	Logger logger = Logger.getLogger(getClass());

	public final String LOG_LOCATIONS = "/log4j.xml";

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		// logger.info("Initialize reload log4j onApplicationEvent !");
		// reloadLog4j();
		// logger.info("Initialize reload log4j finished !");
		// prinitProperties();
	}

	private void prinitProperties() {
		Properties pros = System.getProperties();
		Set<Object> keys = pros.keySet();
		Iterator<Object> elems = keys.iterator();
		while (elems.hasNext()) {
			String key = (String) elems.next();
			System.out.println(key + "=" + pros.getProperty(key));
		}
	}

	private void reloadLog4j() {

		System.setProperty("local_log_dir", SystemUtils.getSystemLogDir());
		logger.info(System.getProperty("local_log_dir"));
		URL url = this.getClass().getResource(LOG_LOCATIONS);
		if (url == null) {
			logger.error("No log4j.xml found for " + LOG_LOCATIONS);
			return;
		}
		String path = url.toString();
		if (!StringUtils.isEmpty(path)) {
			path = path.substring(path.indexOf(":") + 1, path.length());
			logger.info("Initialize reload log4j path=" + path);
			DOMConfigurator.configure(path);
		}
	}
}
