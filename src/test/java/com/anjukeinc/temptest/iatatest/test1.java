package com.anjukeinc.temptest.iatatest;

import java.io.UnsupportedEncodingException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.anjukeinc.iata.appearance.IataWindow;

public class test1 {
	@BeforeMethod
	public void setUp() {
		//bs = FactoryBrowser.factoryBrowser();
	}

	@AfterMethod
	public void tearDown() {
		//bs.quit();
		//bs=null;
	}

	//(timeOut=600000)
	@Test()
	public void testSart() throws InterruptedException,
			UnsupportedEncodingException {
		IataWindow.openNewWindow("http://www.baidu.com");
		Thread.sleep(5000);
		IataWindow.closeAllWindows();
	}
}
