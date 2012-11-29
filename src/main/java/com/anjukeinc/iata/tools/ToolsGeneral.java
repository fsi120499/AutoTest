package com.anjukeinc.iata.tools;

import java.util.Properties;

public class ToolsGeneral {
	/**
	 * 获取操作系统信息
	 * @return
	 */
	public static String getSystemOS(){
		//Properties props=new Properties(); 
		Properties props=System.getProperties(); 
		return props.getProperty("os.name");
	}
}
