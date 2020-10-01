package com.test.ebayAppiumFrmwk;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.google.common.annotations.VisibleForTesting;
import com.resources.pageObjects.CustomerLoginPage;
import com.resources.pageObjects.HomePage;
import com.resources.pageObjects.LoginPage;
import com.resources.pageObjects.LoginPasswordPage;
import com.resources.pageObjects.SearchPage;
import com.resources.pageObjects.SignInpage;
import com.resources.reusableComponents.Iautoconstant;
import com.resources.reusableComponents.ReusableComponents;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;import io.appium.java_client.functions.ExpectedCondition;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import junit.framework.Assert;

public class TestCase1 extends BaseClass implements Iautoconstant{

	@Test
	public void endToendTestCase() throws Throwable {

		ReusableComponents rc = new ReusableComponents();
		AndroidDriver<AndroidElement> driver=capabilitis(rc.getKeyPropValue(PROP_PATH, "apkFileName"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver,30);

		/**
		 * @author kamlesh
		 * customer login by using  Phone number and password
		 * 
		 * if there is security issue while login then we have to use skip
		 * signin button
		 * 
		 */
		

/*
		SignInpage sip = new SignInpage(driver);
		sip.alreadyCoustomer.click();


		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.EditText[@index='1']")));


		CustomerLoginPage clp = new CustomerLoginPage(driver);
		clp.loginSearchBox.sendKeys(rc.getKeyPropValue(PROP_PATH, "phoneNumber"));

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.Button[@text='Continue']")));


		clp.continuee.click();


		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.EditText[@text='Amazon password']")));
		LoginPasswordPage lpp = new LoginPasswordPage(driver);
		lpp.amazopassword.sendKeys(rc.getKeyPropValue(PROP_PATH, "password"));
		lpp.signInSUbmit.click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.EditText[@text='Search']")));
*/

		/**
		 * 
		 * @author kamlesh kumar
		 * customer login by clicking on skip signin Button
		 * 
		 * if there is security issue while login then we have to use skip
		 * signin button
		 * 
		 */

		     
	   LoginPage lp = new LoginPage(driver);
	   lp.skipSignIn.click();

		 

		HomePage hp = new HomePage(driver);
		hp.searchbox.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.EditText[@text='Search']")));
		SearchPage sp = new SearchPage(driver);
		sp.search.sendKeys(rc.getKeyPropValue(PROP_PATH, "applnSEARCH"));

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.ENTER));

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Samsung 163 cm (65 Inches) Wondertainment Series Ultra HD LED Smart TV UA65TUE60AKXXL (Titan Gray) (2020 model)']")));

		driver.findElement(By.xpath("//android.widget.TextView[@text='Samsung 163 cm (65 Inches) Wondertainment Series Ultra HD LED Smart TV UA65TUE60AKXXL (Titan Gray) (2020 model)']")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.EditText[@text='rupees 94,990']")));

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

		/**
		 * 
		 * @author kamlesh
		 * sometimes add to cart button doesn't work
		 * then you need to manually scroll to add to cart 
		 * button.
		 * 
		 */


		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Add to Cart\"));");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.Button[@text='Add to Cart']")));


		driver.findElement(By.xpath("//android.widget.Button[@text='Add to Cart']")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.amazon.mShop.android.shopping:id/action_bar_cart_image")));


		driver.findElement(By.id("com.amazon.mShop.android.shopping:id/action_bar_cart_image")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.Button[@text='Proceed to Buy']")));
		driver.findElement(By.xpath("//android.widget.Button[@text='Proceed to Buy']")).click();
		/**
		 * @author kamlesh
		 * you have to change the xpath of  address
		 * of the user  while using
		 * 
		 */

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.Button[@text='Deliver to this address C-3']")));
		driver.findElement(By.xpath("//android.widget.Button[@text='Deliver to this address C-3 , central colony']")).click();



		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='94990.00']")));

		/**
		 * 
		 * if UI of the application doesnt take you to the Checkout page
		 * then you need change the xpath of  checkOutproductPricetext from buy now page  
		 * and do the assertion accordingly.
		 * 
		 */

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

		System.out.println("If productPrice is equal to checkOutproductPrice test case is passed  ");



	}
}












