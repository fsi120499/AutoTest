package com.anjukeinc.iata.main;

import com.anjukeinc.iata.init.InitConfig;
import com.anjukeinc.iata.init.Preload;
import com.anjukeinc.iata.init.SeleniumWebDriver;
import com.anjukeinc.iata.seleniumdriver.ChromeDriverStore;
import com.anjukeinc.iata.seleniumdriver.FirefoxDriverStore;
import com.anjukeinc.iata.seleniumdriver.IEDriverStore;
import com.anjukeinc.iata.seleniumdriver.SeleniumDriverStore;

/**
 * 单例模式 确保ControlMain只有一个
 * @author weihuang
 */
public class ControlMain {
	private volatile static ControlMain controlmain;//单例模式
	
	//读取用户配置信息
	
	public BrowserWindow currentWindow;
	
	
	/**
	 * 双重检查加锁 生成实例对象
	 * @return
	 */
	public static ControlMain getInstance() {
		if (controlmain == null) {
			synchronized (ControlMain.class) {
				if (controlmain == null) {
					controlmain = new ControlMain();
				}
			}
		}
		return controlmain;
	}
	
	public ControlMain(){
	}
	
	/**
	 * 工厂模式初始化WebDriver
	 * 
	 * @param url
	 */
	public void initWebDriver() {
		if(Preload.getOSSYSTEMNAME() ==1){
			selectWebDriver(InitConfig.getUserconfig().get("osxBrowser").toLowerCase());
		}else if(Preload.getOSSYSTEMNAME() ==2){
			selectWebDriver(InitConfig.getUserconfig().get("winBrowser").toLowerCase());//要改成ie启动模式
		}else if(Preload.getOSSYSTEMNAME() ==3){
			selectWebDriver(InitConfig.getUserconfig().get("linuxBrowser").toLowerCase());//要改成linux启动模式
		}
		
	}
	
	/**
	 * 根据传入的driver类型调用相应的driver工厂
	 * @param webDriverStoreType
	 */
	public void selectWebDriver(String webDriverStoreType) {
		if (webDriverStoreType.contains("chrome")) {
			createWebDriverChromeStore();
		}
		if (webDriverStoreType.contains("firefox")) {
			createWebDriverFirefoxDriver();
		}
		if (webDriverStoreType.contains("ie")) {
			createWebDriverIEDriver();
		}
		
	}
	
	/**
	 * 加载ChromeDriver 工厂
	 */
	public void createWebDriverChromeStore() {
		SeleniumWebDriver driver = null;
		SeleniumDriverStore driverStore = new ChromeDriverStore();
		if(Preload.getOSSYSTEMNAME()==1){
			driver = driverStore.orderWebDriver(InitConfig.getUserconfig().get("osxModel").toLowerCase());
		}
		if(Preload.getOSSYSTEMNAME()==2){
			driver = driverStore.orderWebDriver(InitConfig.getUserconfig().get("winModel").toLowerCase());
		}
		//未测试
		if(Preload.getOSSYSTEMNAME()==3){
			driver = driverStore.orderWebDriver(InitConfig.getUserconfig().get("linuxModel").toLowerCase());
		}
		driver.setDriver();
		WebDriverBrowserWindow window = new WebDriverBrowserWindow(driver.getDriver());
		this.currentWindow = window;
	}
	
	/**
	 * 加载FirefoxDriver 工厂
	 */
	public void createWebDriverFirefoxDriver() {
		SeleniumWebDriver driver = null;
		SeleniumDriverStore driverStore = new FirefoxDriverStore();
		if(Preload.getOSSYSTEMNAME()==1){
			driver = driverStore.orderWebDriver(InitConfig.getUserconfig().get("osxmodel").toLowerCase());
		}
		if(Preload.getOSSYSTEMNAME()==2){
			driver = driverStore.orderWebDriver(InitConfig.getUserconfig().get("winModel").toLowerCase());
		}	
		//未测试
		if(Preload.getOSSYSTEMNAME()==3){
			driver = driverStore.orderWebDriver(InitConfig.getUserconfig().get("linuxModel").toLowerCase());
		}
		driver.setDriver();
		WebDriverBrowserWindow window = new WebDriverBrowserWindow(driver.getDriver());
		this.currentWindow = window;
	}
	
	/**
	 * 加载IEdriver 工厂
	 */
	public void createWebDriverIEDriver() {
		SeleniumWebDriver driver = null;
		SeleniumDriverStore driverStore = new IEDriverStore();
		if(Preload.getOSSYSTEMNAME()==1){
			driver = driverStore.orderWebDriver(InitConfig.getUserconfig().get("osxmodel").toLowerCase());
		}
		if(Preload.getOSSYSTEMNAME()==2){
			driver = driverStore.orderWebDriver(InitConfig.getUserconfig().get("winModel").toLowerCase());
		}
		//未测试
		if(Preload.getOSSYSTEMNAME()==3){
			driver = driverStore.orderWebDriver(InitConfig.getUserconfig().get("linuxModel").toLowerCase());
		}
		driver.setDriver();
		WebDriverBrowserWindow window = new WebDriverBrowserWindow(driver.getDriver());
		this.currentWindow = window;
	}
	
	
	
	public void closeAllWindows(){
		this.currentWindow.quit();
	}

	
}
