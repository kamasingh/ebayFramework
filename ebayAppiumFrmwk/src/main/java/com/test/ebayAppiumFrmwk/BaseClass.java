package com.test.ebayAppiumFrmwk;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import com.resources.reusableComponents.Iautoconstant;
import com.resources.reusableComponents.ReusableComponents;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseClass implements Iautoconstant {

	
	public static  AndroidDriver<AndroidElement> capabilitis(String appName) throws Throwable 
	{
		

	AndroidDriver<AndroidElement>  driver;

		// TODO Auto-generated method stub
	 File appDir = new File("src");

	ReusableComponents rc = new ReusableComponents();
     File app = new File(appDir, rc.getKeyPropValue(PROP_PATH, "apkFileName"));
     DesiredCapabilities cap = new DesiredCapabilities();
     
     cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android");
   //  cap.setCapability(MobileCapabilityType.VERSION, 9);

     cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
    driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
	    
	    return driver;
	}
}
