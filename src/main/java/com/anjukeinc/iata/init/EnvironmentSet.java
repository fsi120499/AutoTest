package com.anjukeinc.iata.init;

import java.io.UnsupportedEncodingException;

public class EnvironmentSet {
	//ChromeDriver
	private static String MAC_CHROMEDRIVER_PATH = InitConfig.getUserconfig().get("osxPath");
	private static String WIN_CHROMEDRIVER_PATH = InitConfig.getUserconfig().get("winPath");
	
	//Firefox
	private static String MAC_FIREFOXDRIVER_PATH = InitConfig.getUserconfig().get("osxPath"); 
	private static String WIN_FIREFOXDRIVER_PATH = InitConfig.getUserconfig().get("winPath");
	
	//Ie
	private static String WIN_IEDRIVER_PATH = InitConfig.getUserconfig().get("winPath");
	
	/**
	 * 设置mic下Driver的路径
	 */
	public static void SetMacOSDriverPath() {
		try {
			System.out.println("chromedriver path is "+MAC_CHROMEDRIVER_PATH);
			MAC_CHROMEDRIVER_PATH = java.net.URLDecoder.decode(MAC_CHROMEDRIVER_PATH, "utf8");
			MAC_FIREFOXDRIVER_PATH =  java.net.URLDecoder.decode(MAC_FIREFOXDRIVER_PATH, "utf8");
			System.setProperty("webdriver.chrome.driver", MAC_CHROMEDRIVER_PATH);
			System.setProperty("webdriver.firefox.bin", MAC_FIREFOXDRIVER_PATH);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 设置WIN下 DRIVER 的路径
	 */
	public static void SetWinOSDriverPath() {
		try {
			System.out.println("chromedriver path is "+WIN_CHROMEDRIVER_PATH);
			WIN_CHROMEDRIVER_PATH = java.net.URLDecoder.decode(WIN_CHROMEDRIVER_PATH, "utf8");
			WIN_FIREFOXDRIVER_PATH =  java.net.URLDecoder.decode(WIN_FIREFOXDRIVER_PATH, "utf8");
			WIN_IEDRIVER_PATH = java.net.URLDecoder.decode(WIN_IEDRIVER_PATH, "utf8");
			System.setProperty("webdriver.ie.driver", WIN_IEDRIVER_PATH);
			System.setProperty("webdriver.chrome.driver", WIN_CHROMEDRIVER_PATH);
			System.setProperty("webdriver.firefox.bin", WIN_FIREFOXDRIVER_PATH);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
	
	public static void initMacDriver(){
		SetMacOSDriverPath();
	}
	
	public static void initWinDriver(){
		SetWinOSDriverPath();
	}

}
