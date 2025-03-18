package MobileAutomation.MobileAutomationFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;

public class MultipleTestScenario extends BaseStep {
	
	
	/*In this example we are validating multiple test case here, @BeforMethod is use coz before every 
	 method it will run the pre setup so it will not fail */ 
//	
//	@BeforeMethod
//	public void presetup()
//	{
//		
//		/*Prerequisit is the app will in home page before every test case 
//		thats why use use app package and app activity of home page of the app*/
//		
////		Activity activity = new Activity("com.androidsample.generalstore", "com.androidsample.generalstore.MainActivity");
////		driver.startActivity(activity);		
//		
//		//If above code is not working for start activity the use below
//		
//		//((JavascriptExecutor)driver).executeScript("mobile: startActivity",ImmutableMap.of("intent","com.androidsample.generalstore/com.androidsample.generalstore.MainActivity"));
//		
//	/*((JavascriptExecutor) driver).executeScript("mobile: startActivity", ImmutableMap.of(
//			    "appPackage", "com.androidsample.generalstore",
//			    "appActivity", "com.androidsample.generalstore.MainActivity"
//			));*/
//		
//		
////		((JavascriptExecutor) driver).executeScript("mobile: startActivity", 
////			    ImmutableMap.of(
////			        "appPackage", "com.androidsample.generalstore",
////			        "appActivity", "com.androidsample.generalstore.MainActivity",
////			        "intentAction", "android.intent.action.MAIN",
////			        "intentCategory", "android.intent.category.LAUNCHER"
////			    ));
//	}
//	
	@Test(priority=1)
	public void ToastErrorMessage_Validation() {

		// driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("xyzz");
		driver.hideKeyboard(); // to hide keyboard
		driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click(); // select gender
		driver.findElement(By.id("android:id/text1")).click();

		driver.findElement(
				AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));"));
		driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();

		String toastmessage = driver.findElement(By.xpath("//android.widget.Toast")).getAttribute("name");
		Assert.assertEquals(toastmessage, "Please enter your name");
		// Thread.sleep(3000);
	}

	@Test(priority=2)
	public void Positive_Flow() {

		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("xyzz");
		driver.hideKeyboard(); // to hide keyboard
		driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click(); // select gender
		driver.findElement(By.id("android:id/text1")).click();

		driver.findElement(
				AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));"));
		driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();

		Assert.assertTrue(driver.findElements(By.xpath("//android.widget.Toast")).size() < 1);

	}
}
