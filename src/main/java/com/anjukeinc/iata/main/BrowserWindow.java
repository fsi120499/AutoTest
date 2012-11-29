package com.anjukeinc.iata.main;

/**
 * 操作浏览器函数接口
 * @author weihuang
 */
public interface BrowserWindow {
	
	/**
	 * 打开新浏览器 同时初始化Driver
	 * @param url
	 */
	public void openNewWindow(String url);
	
	/**
	 * 退出Driver
	 */
	public void quit();
}
