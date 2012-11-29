package com.anjukeinc.temptest.iatatest;

import java.io.UnsupportedEncodingException;
import java.util.Properties;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class testInit {
	 // 静态变量  
    public static String staticField = "静态变量";  
    // 变量  
    public String field = "变量";  
  
    // 静态初始化块  
    static {  
        System.out.println(staticField);  
        System.out.println("静态初始化块");  
    }  
  
    // 初始化块  
    {  
        System.out.println(field);  
        System.out.println("初始化块");  
    }  
  
    // 构造器  
    public testInit() {  
        System.out.println("构造器");  
    }  
  
    public static void main(String[] args) {  
        new testInit();  
    }  
}
