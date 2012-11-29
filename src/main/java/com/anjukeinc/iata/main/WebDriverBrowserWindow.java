package com.anjukeinc.iata.main;

import org.openqa.selenium.WebDriver;

public class WebDriverBrowserWindow implements BrowserWindow{
	Object driver;
	
	public WebDriverBrowserWindow(Object driver){
		this.driver = driver;
	}
	
	@Override
	public void openNewWindow(String url){
		open(url);
	}
	
	public void open(String url){
		((WebDriver)driver).get(url);
	}
	
	@Override
	public void quit() {
		((WebDriver)driver).quit();
	}
}
