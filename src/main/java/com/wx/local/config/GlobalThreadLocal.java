//package com.wx.local.config;
//
//import java.util.concurrent.ConcurrentHashMap;
//import java.util.concurrent.TimeUnit;
//
//import org.springframework.stereotype.Component;
//
//@Component
//public class GlobalThreadLocal {
//
//	public final static String QN_UPLOAD_COUNT = "qn-upload-count";
//
//	private ThreadLocal<ConcurrentHashMap<String, Integer>> countThreadLocal = new ThreadLocal<ConcurrentHashMap<String, Integer>>() {
//
//		@Override
//		protected ConcurrentHashMap<String, Integer> initialValue() {
//			return new ConcurrentHashMap<String, Integer>();
//		}
//
//	};
//
//	public Integer getCount(String key) {
//		Integer current = countThreadLocal.get().get(key);
//		if (null == current) {
//			countThreadLocal.get().put(key, 0);
//			current = 0;
//		}
//		addCount(key);
//		return current;
//	}
//
//	private void addCount(String key) {
//		Integer current = countThreadLocal.get().get(key);
//		if (null == current) {
//			countThreadLocal.get().put(key, 0);
//		}
//		countThreadLocal.get().put(key, countThreadLocal.get().get(key).intValue() + 1);
//	}
//
//	public static void main(String args[]) throws InterruptedException {
//		// GlobalThreadLocal gl = new GlobalThreadLocal();
//		// for (int i = 0; i < 2; i++) {
//		// Thread t = new Thread(new Task(gl));
//		// t.start();
//		// }
//		long start = System.currentTimeMillis();
//		TimeUnit.SECONDS.sleep(2);
//		long balance = System.currentTimeMillis() - start;
//		System.out.println(balance);
//	}
//
//	static class Task implements Runnable {
//		private GlobalThreadLocal gl;
//
//		public Task(GlobalThreadLocal gl) {
//			this.gl = gl;
//		}
//
//		@Override
//		public void run() {
//			System.out.println(Thread.currentThread().getName() + "--" + gl.getCount("test"));
//			System.out.println(Thread.currentThread().getName() + "--" + gl.getCount("test"));
//			System.out.println(Thread.currentThread().getName() + "--" + gl.getCount("test"));
//		}
//
//	}
//}
