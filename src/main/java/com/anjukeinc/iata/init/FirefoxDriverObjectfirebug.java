package com.anjukeinc.iata.init;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * 加载 默认的firefox firefoxprofile 为 By default, the Firefox driver creates an
 * anonymous profile
 * 
 * @author weihuang
 */
public class FirefoxDriverObjectfirebug extends SeleniumWebDriver {
	private DesiredCapabilities capabilities;

	protected WebDriver prepare() {
		System.setProperty("webdriver.firefox.bin",
				"/Applications/Firefox.app/Contents/MacOS/firefox");
		FirefoxProfile ffPro = new FirefoxProfile();
		
		/*Running with firebug*/
		File file = new File("src/main/resources/firebug-1.10.6-fx.xpi");
		try {
			ffPro.addExtension(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ffPro.setPreference("extensions.firebug.currentVersion", "1.10.6"); 
		
		
		/*
		 * There is beta feature to make firefox not wait for the full page to
		 * load after calling .get or .click. This may cause immediate find's to
		 * break, so please be sure to use an implicit or explicit wait too.
		 * This is only available for Firefox and not other browsers.
		 */
		ffPro.setPreference("webdriver.load.strategy", "mutable");
		capabilities = DesiredCapabilities.firefox();

		capabilities.setCapability(FirefoxDriver.PROFILE, ffPro);
		capabilities.setCapability("webdriver.remote.quietExceptions", true);
		return new FirefoxDriver(capabilities);
	}
}
