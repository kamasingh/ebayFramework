package com.resources.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LoginPasswordPage {

	public LoginPasswordPage(AppiumDriver driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(xpath="//android.widget.EditText[@text='Amazon password']")
	public	WebElement amazopassword;
	
	@AndroidFindBy(xpath="//android.widget.Button[@text='Login']")
	public	WebElement signInSUbmit;

}
