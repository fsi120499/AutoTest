package com.anjukeinc.iata.seleniumdriver;

import com.anjukeinc.iata.init.IEDriverObject;
import com.anjukeinc.iata.init.SeleniumWebDriver;

public class IEDriverStore extends SeleniumDriverStore {
	public SeleniumWebDriver driver = null;

	public SeleniumWebDriver createWebdriver(String type) {
		if (type.equals("default")) {
			driver = new IEDriverObject();
		}else{
			driver = new IEDriverObject();
		}
		return driver;
	}
}
