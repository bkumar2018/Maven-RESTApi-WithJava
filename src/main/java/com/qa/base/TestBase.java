package com.qa.base;

import java.io.FileInputStream;
import java.util.Properties;

public class TestBase {

	public Properties prop = null;
	
	public TestBase(){
		
		try{
			prop = new Properties();
			FileInputStream fin = new FileInputStream("D://java_tut//Eclipse_wrk//MavenRESTAPItest//src//main//java//com//qa//config1//config.properties");
			prop.load(fin);	
			
		}catch(Exception e){
			System.out.println(e);
		}
		
		
	}
}
