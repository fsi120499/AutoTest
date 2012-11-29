package com.anjukeinc.iata.seleniumdriver;

import com.anjukeinc.iata.init.FirefoxDriverObjectDefault;
import com.anjukeinc.iata.init.FirefoxDriverObjectfirebug;
import com.anjukeinc.iata.init.SeleniumWebDriver;

public class FirefoxDriverStore extends SeleniumDriverStore {
	public SeleniumWebDriver driver = null;

	public SeleniumWebDriver createWebdriver(String type) {
		if (type.equals("default")) {
			driver = new FirefoxDriverObjectDefault();
		}else if(type.equals("firebug")){
			driver = new FirefoxDriverObjectfirebug();
		}else{
			driver = new FirefoxDriverObjectDefault();
		}
		return driver;
	}
}
