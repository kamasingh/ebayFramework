package com.resources.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CustomerLoginPage {

	public CustomerLoginPage(AppiumDriver driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(xpath="//android.widget.EditText[@index='1']")
	public	WebElement loginSearchBox;
	
	@AndroidFindBy(xpath="//android.widget.Button[@text='Continue']")
	public	WebElement continuee;
	
}
