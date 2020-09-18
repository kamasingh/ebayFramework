package com.resources.reusableComponents;

import java.io.File;
import java.io.FileInputStream;
import java.net.MalformedURLException;
import java.util.Properties;

import com.test.ebayAppiumFrmwk.BaseClass;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class ReusableCom {


	public void scrollAndClick(String visibleText) throws MalformedURLException {
		BaseClass bc = new BaseClass();
		AndroidDriver<AndroidElement> driver = bc.capabilitis(null);
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+visibleText+"\").instance(0))").click();
	}


	public void readProperty() {


		File file = new File(System.getProperty("user.dir")+"//Config//config.properties");

		FileInputStream fileInput = null;
		try {
			fileInput = new FileInputStream(file);
			//Create properties Class object 
			Properties prop = new Properties();
			prop.load(fileInput);
		}

		catch (Exception e)
		{
			e.printStackTrace();
		}
	}


}

