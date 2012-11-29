package com.anjukeinc.iata.init;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
/**
 * 加载 默认的firefox firefoxprofile 为
 * By default, the Firefox driver creates an anonymous profile
 * @author weihuang
 */
public class FirefoxDriverObjectDefault extends SeleniumWebDriver {
	
	protected WebDriver prepare() {
		//System.setProperty("webdriver.firefox.bin", "/Applications/Firefox.app/Contents/MacOS/firefox");
		return new FirefoxDriver();
	}
}
