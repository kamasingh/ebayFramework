package com.test.ebayAppiumFrmwk;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import com.resources.pageObjects.CustomerLoginPage;
import com.resources.pageObjects.HomePage;
import com.resources.pageObjects.LoginPage;
import com.resources.pageObjects.LoginPasswordPage;
import com.resources.pageObjects.SearchPage;
import com.resources.pageObjects.SignInpage;
import com.resources.reusableComponents.ReusableCom;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import junit.framework.Assert;

public class TestCase1 extends BaseClass {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {


		AndroidDriver<AndroidElement> driver=capabilitis("Amazon_shopping.apk");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		/**
		 * @author kamlesh
		 * customer login by using  Phone number and password
		 * 
		 */

		SignInpage sip = new SignInpage(driver);
		sip.alreadyCoustomer.click();
		Thread.sleep(2000);

		CustomerLoginPage clp = new CustomerLoginPage(driver);
		ReusableCom rc = new ReusableCom();
		clp.loginSearchBox.sendKeys("6205718115");
		clp.continuee.click();

		LoginPasswordPage lpp = new LoginPasswordPage(driver);
		lpp.amazopassword.sendKeys("kama1234");
		lpp.signInSUbmit.click();

		/**
		 * 
		 * @author kamlesh kumar
		 * customer login by clicking on skip signin Button
		 * 
		 */

		/*     
	   LoginPage lp = new LoginPage(driver);
	   lp.skipSignIn.click();

		 */

		HomePage hp = new HomePage(driver);
		hp.searchbox.click();
		Thread.sleep(3000);
		SearchPage sp = new SearchPage(driver);
		sp.search.sendKeys("Samsung 65 inch tv");
		Thread.sleep(20000);

		((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.ENTER));

		Thread.sleep(3000);

		//	  ReusableCom rc = new ReusableCom();
		//	  rc.scrollAndClick("Apple iPhone 11 (64GB) - Green");
		//	  
		//	   driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"QA65Q60RAKXXL\"));");

		driver.findElement(By.xpath("//android.widget.TextView[@text='Samsung 163 cm (65 Inches) Wondertainment Series Ultra HD LED Smart TV UA65TUE60AKXXL (Titan Gray) (2020 model)']")).click();

		Thread.sleep(2000);
		
		String productPricetext = driver.findElement(By.xpath("//android.widget.EditText[@text='rupees 94,990']")).getText();
		
		String str="";
		char[] ch = productPricetext.toCharArray();
		for (int i = 0; i < ch.length; i++) {
			if (ch[i]>=48 && ch[i]<=57) {
				str=str+(char)ch[i];
			}
			
		}
		int productPrice = Integer.parseInt(str);
		
		System.out.println(productPrice);
		

		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Add to Cart\"));");

		Thread.sleep(2000);


		driver.findElement(By.xpath("//android.widget.Button[@text='Add to Cart']")).click();

		Thread.sleep(2000);


		driver.findElement(By.id("com.amazon.mShop.android.shopping:id/action_bar_cart_image")).click();

		Thread.sleep(2000);
		driver.findElement(By.xpath("//android.widget.Button[@text='Proceed to Buy']")).click();
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//android.widget.Button[@text='Continue']")).click();
		

		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//android.widget.Button[@text='Continue']")).click();
		
		
		String checkOutproductPricetext = driver.findElement(By.xpath("//android.widget.TextView[@text='94990.00']")).getText();
		
		String str1="";
		char[] ch1 = checkOutproductPricetext.toCharArray();
		for (int i = 0; i < ch.length; i++) {
			if (ch1[i]>=48 && ch1[i]<=57) {
				str1=str1+(char)ch1[i];
			}
			
		}
		int checkOutproductPrice = Integer.parseInt(str1);
		
		System.out.println(checkOutproductPrice);
		
		Assert.assertEquals(productPrice, checkOutproductPrice);
		
		System.out.println("If Assertion is passed  is passed TEST case passed");
		


	}
}












