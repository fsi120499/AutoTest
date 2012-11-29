package com.anjukeinc.temptest.iatatest;

import java.io.UnsupportedEncodingException;
import java.util.Properties;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class testGetOScontent {
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


		Properties props=System.getProperties(); //获得系统属性集
		String osName = props.getProperty("os.name"); //操作系统名称
		String osArch = props.getProperty("os.arch"); //操作系统构架
		String osVersion = props.getProperty("os.version"); //操作系统版本
		System.out.println(osName+"|||"+osArch+"|||"+osVersion);

	}
	
	@Test()
	public void testSarta(){
		
	}
}
