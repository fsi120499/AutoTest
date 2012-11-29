package com.anjukeinc.iata.appearance;

import com.anjukeinc.iata.init.InitConfig;
import com.anjukeinc.iata.init.Preload;
import com.anjukeinc.iata.main.ControlMain;


public class IataWindow {
	static{
		InitConfig.SetConfigPath();//预加载config配置
		Preload.perload();//预配置driver路径
	}
	
	public static void openNewWindow(String url){
		ControlMain.getInstance().initWebDriver();
		ControlMain.getInstance().currentWindow.openNewWindow(url);
	}
	
	public static void closeAllWindows(){
		ControlMain.getInstance().closeAllWindows();
	}
}
