package com.anjukeinc.temptest.iatatest;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.anjukeinc.iata.appearance.IataWindow;

public class TestChromeDriver {
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
	
	
	final public static Map<String, String> readConfig() {
        BufferedReader input = null;// 读文件用
        Map<String, String> map = new HashMap<String, String>();// 存文件内容的map,等号前面是key,等号后面的是value
        String text = null;// 存放读出每行的变量
        FileInputStream file = null;

        try {
            //String configPath = Sysprob.getSysPro().getProperty("IATA");
            /*if(!(configPath==null||configPath.equals(""))){
                file = new FileInputStream(configPath);
            }else{*/
                file = new FileInputStream("src/main/resources/config.ini");
            //}
            input = new BufferedReader(new InputStreamReader(file, "UTF-8"));
            while ((text = input.readLine()) != null) {
                if (text.length() >= 1 && text.substring(0, 1).equals("#")) {
                    continue;
                }
                int number = text.indexOf("=");
                if (number != -1) {
                    map.put(text.substring(0, number), text.substring(number + 1, text.length()));
                }
            }
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException ioException) {
            System.err.println("File Error!");
            ioException.printStackTrace();
        }  catch (Exception xception) {
            xception.printStackTrace();
        } finally {
            try {
                input.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return map;
    }
}
