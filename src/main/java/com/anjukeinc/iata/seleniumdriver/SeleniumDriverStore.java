package com.anjukeinc.iata.seleniumdriver;

import com.anjukeinc.iata.init.SeleniumWebDriver;

public abstract class SeleniumDriverStore {
	SeleniumWebDriver driver;
	public abstract SeleniumWebDriver createWebdriver(String type);
	 
	public SeleniumWebDriver orderWebDriver(String type) {
		driver = createWebdriver(type);
		//driver.setDriver();
		return driver;
		//return driver.getDriver();
	}
}
