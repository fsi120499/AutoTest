package com.anjukeinc.iata.init;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * IEdriver的实现
 * @author weihuang
 */
public class IEDriverObject extends SeleniumWebDriver {
	private DesiredCapabilities capabilities;
	
	protected WebDriver prepare() {
		System.setProperty("webdriver.ie.driver","src/main/resources/IEDriverServer.exe");
		
		capabilities = DesiredCapabilities.internetExplorer();
		capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		//capabilities.setCapability("useLegacyInternalServer", true);
		
		return new InternetExplorerDriver(capabilities);
	}
}
