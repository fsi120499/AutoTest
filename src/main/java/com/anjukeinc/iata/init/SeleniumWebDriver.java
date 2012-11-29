package com.anjukeinc.iata.init;

public abstract class SeleniumWebDriver {
	Object driver;
	
	/*void SeleniumWebDriver(){
		this.driver = this.prepare();
	}*/
	/*private void getWebDriver(){
		SeleniumDriverStore sds = new ChromeDriverStore();
		driver = sds.createWebdriver("Chrome");//读入配置文件
	}*/
	abstract Object prepare();
	
	public void setDriver(){
		this.driver = this.prepare();
	}
	
	public Object getDriver(){
		return this.driver;
	}
}
