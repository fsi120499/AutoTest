package com.anjukeinc.iata.seleniumdriver;

import com.anjukeinc.iata.init.ChromeDriverObject;
import com.anjukeinc.iata.init.SeleniumWebDriver;

public class ChromeDriverStore extends SeleniumDriverStore {
	public SeleniumWebDriver driver = null;

	public SeleniumWebDriver createWebdriver(String type) {
		if (type.equals("default")) {
			driver = new ChromeDriverObject();
		}else{
			driver = new ChromeDriverObject();
		}
		return driver;
	}
}
