package com.anjukeinc.iata.init;

import com.anjukeinc.iata.tools.ToolsGeneral;

public class Preload {

	private static String OSTYPE = ToolsGeneral.getSystemOS();//获取系统名称
	private static int OSSYSTEMNAME;//表示系统类型1为mac  2为window 3为linux 
	
	public static int getOSSYSTEMNAME() {
		return OSSYSTEMNAME;
	}

	public static void setOSSYSTEMNAME(int ossystemName) {
		OSSYSTEMNAME = ossystemName;
	}
	
	
	/**
	 * OSSYSTEMNAME 1代表MAC 
	 * OSSYSTEMNAME 2代表Windows
	 * OSSYSTEMNAME 3代表linux
	 */
	public static void perload(){
		try {
			if(OSTYPE.contains("Mac")){
				setOSSYSTEMNAME(1);
				EnvironmentSet.initMacDriver();
			}else if(OSTYPE.contains("Windows")){
				setOSSYSTEMNAME(2);
				EnvironmentSet.initWinDriver();
			}else if(OSTYPE.contains("Linux")){
				setOSSYSTEMNAME(3);
				//待配置
			}
		} catch (NullPointerException e) {
			System.out.println("OSTYPE is null");
			e.printStackTrace();
		}
	}
}
