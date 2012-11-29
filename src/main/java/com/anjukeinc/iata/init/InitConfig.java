package com.anjukeinc.iata.init;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public class InitConfig {
	// 设置config路径到环境变量
	private static String CONFIG = ClassLoader.getSystemResource("config.ini").getPath();
	
	private static Map<String, String> USERCONFIG = null;
	
	public static void setUserconfig(Map<String, String> uSERCONFIG) {
		USERCONFIG = uSERCONFIG;
	}
	
	public static Map<String, String> getUserconfig() {
		return USERCONFIG;
	}
	
	public static void SetConfigPath() {
		try {
			CONFIG = java.net.URLDecoder.decode(CONFIG, "utf8");
			System.setProperty("iata.default.config", CONFIG);
			USERCONFIG = readConfig();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
	
	/**
     * 从项目根目录读取config.ini配置文件存入map中,等号前面的内容是key,等号后面的内容是value. 注释以#开头的行.
     *
     * @return 返回Map<String, String>形式的config文件
     */
    final public static Map<String, String> readConfig() {
    		//EnvironmentSet.SetConfigPath(); 自己设置config.ini的配置路径
        BufferedReader input = null;// 读文件用
        Map<String, String> map = new HashMap<String, String>();// 存文件内容的map,等号前面是key,等号后面的是value
        String text = null;// 存放读出每行的变量
        FileInputStream file = null;

        try {
            String configPath = System.getProperties().getProperty("iata.path");//预读环境变量路径 
            System.out.println("configpath is "+configPath);
            if(!(configPath==null||configPath.equals(""))){
                file = new FileInputStream(configPath);
            }else{
            		try {
            			System.out.println("环境变量iata.path 是空 开始查看iata.default.config ="+System.getProperties().getProperty("iata.default.config"));
            			file = new FileInputStream(System.getProperties().getProperty("iata.default.config"));
            			//file = new FileInputStream("src/main/resources/config.ini");
					} catch (Exception e) {
						System.out.println("请将config.ini文件放到项目根目录下src/main/resources/下");
						e.printStackTrace();
					}
            }
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
