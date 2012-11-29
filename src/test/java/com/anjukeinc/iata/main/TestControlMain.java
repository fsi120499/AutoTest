package com.anjukeinc.iata.main;

import java.io.UnsupportedEncodingException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.anjukeinc.iata.init.Preload;
import com.anjukeinc.iata.tools.ToolsGeneral;

public class TestControlMain {
	public ControlMain cl = null;
	@BeforeMethod
	public void setUp() {
		cl = ControlMain.getInstance();
	}

	@AfterMethod
	public void tearDown() {
	}

	/**
	 * 测试 MAC系统下是否正确付值
	 * @throws InterruptedException
	 * @throws UnsupportedEncodingException
	 */
	@Test()
	public void testb() throws InterruptedException,
			UnsupportedEncodingException {
		Assert.assertEquals(Preload.getOSSYSTEMNAME(), 1,"判断系统验证 1是mac 2是window");
	}
	
	@Test()
	public void testa() throws InterruptedException,
	UnsupportedEncodingException {
		//cl.OSTYPE=null;
		ToolsGeneral tg = new ToolsGeneral();
		//Assert.assertEquals(cl.OSSYSTEMNAME, 1,"判断系统验证 1是mac 2是window");
	}
	
	
}
