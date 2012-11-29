package com.anjukeinc.iata.init;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class RemoteWebDriverObject extends SeleniumWebDriver {

	protected WebDriver prepare() {
		System.setProperty("webdriver.chrome.driver",
				"/Users/weihuang/Documents/IDETEST/workspace/iata/src/main/resources/chromedriver");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		return new ChromeDriver(options);
	}
}
