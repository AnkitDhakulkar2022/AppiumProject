package MobileAutomation.MobileAutomationFramework;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import MobileAutomation.PageObject.Android.CartPage;
import MobileAutomation.PageObject.Android.FormPage;
import MobileAutomation.PageObject.Android.ProductCatalog;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class E_CommerceTestCase_4_Hybrid_WebView extends BaseStep {
	
	// In this TC we add 2 product in cart and calculate the amount of both product
	// and match with final amount whether its match or not

	// Method Without data provider
//	@Test
//	public void fillform() throws InterruptedException {
//
//		FormPage frompage = new FormPage(driver);
//		frompage.setNameField("xyzz");
//		frompage.setGender("female");
//		frompage.setCountrySelection("Argentina");
//		frompage.submitbutton();
//
//		ProductCatalog PC = new ProductCatalog(driver);
//		PC.addItemtoCardByIndex(0);
//		PC.addItemtoCardByIndex(0);
//
//		PC.goToCartPage();
//
//		CartPage CP = new CartPage(driver);
//
//		double totalSum = CP.getProductSum();
//		double displayformatedsun = CP.getTotalAmountDisplayed();
//		Assert.assertEquals(totalSum, displayformatedsun);
//
//		CP.acceptTermsAndCondition();
//		CP.SubmitOrder();
//		Thread.sleep(2000);
//
//	}

	// Method with data provider

	@Test(dataProvider = "getData", groups= {"Smoke"})
	public void fillform(String name, String gender, String country) throws InterruptedException {

		
		FormPage frompage = new FormPage(driver);
		frompage.setNameField(name);
		frompage.setGender(gender);
		frompage.setCountrySelection(country);
		frompage.submitbutton();

		ProductCatalog PC = new ProductCatalog(driver);
		PC.addItemtoCardByIndex(0);
		PC.addItemtoCardByIndex(0);

		PC.goToCartPage();

		CartPage CP = new CartPage(driver);

		double totalSum = CP.getProductSum();
		double displayformatedsun = CP.getTotalAmountDisplayed();
		Assert.assertEquals(totalSum, displayformatedsun);

		CP.acceptTermsAndCondition();
		CP.SubmitOrder();
		Thread.sleep(2000);

	}

	// By using data provider you can send multiple data for same test cases
	//Data provider by using single data
	
	@DataProvider
	public Object[][] getData() {

		// We use object because data type is not fix either its string int so we use
		// parent data type object
		return new Object[][] { { "xyzz", "female", "Argentina" } };
	
	
//	@BeforeMethod
//	public void presetup()
//	{
//		/*Prerequisit is the app will in home page before every test case 
//		thats why use use app package and app activity of home page of the app*/
//				Activity activity = new Activity("com.androidsample.generalstore", "com.androidsample.generalstore.MainActivity");
//		driver.startActivity(activity);	
//	}
//	
//	//Data provider by using multiple data
//	@DataProvider
//	public Object[][] getData() {
//
//		// We use object because data type is not fix either its string int so we use
//		// parent data type object
//		return new Object[][] { { "xyzz", "female", "Argentina" },{ "Ankit", "male", "Argentina" } };
//	}

}
}
