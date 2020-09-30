package com.resources.reusableComponents;

import java.io.FileInputStream;
import java.util.Properties;

public class ReusableComponents {

	public String getKeyPropValue(String path, String key) throws Throwable
	{
		FileInputStream fis=new FileInputStream(path);
		Properties prop=new Properties();
		prop.load(fis);
		String propValue = prop.getProperty(key);
		return propValue;
		
	}
	
	
}
