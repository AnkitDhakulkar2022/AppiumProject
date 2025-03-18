package MobileAutomation.Utils;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class UtilClass_CommonMethod_ForIOS_AndAndroid {
	public AppiumDriverLocalService service;
	
//	AppiumDriver driver; 
//	
//	/*AppiumDriver is parent for both ios and android thats why we use Appium driver in this class 
//	coz this class is same for foth android and ios*/
//	
//	public UtilClass_CommonMethod_ForIOS_AndAndroid(AppiumDriver driver)
//	{
//		
//		this.driver=driver;
//	}
	
	//Reusable method to remove the $ from amount
		public Double getFormatedAmount(String amount) {
			Double price=Double.parseDouble(amount.substring(1));
			return price;
		}

		
		public void waitForElementToAppear(WebElement ele,AppiumDriver driver)
		{
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.attributeContains((ele), "text", "Cart"));
		}
		
//		public AppiumDriverLocalService startAppiumServer(String ipAddress, int port,String argument)
//		{
//			
//			
//			service = new AppiumServiceBuilder()
//					.withAppiumJS(new File(
//							"C:\\Users\\ankit.dhakulkar\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
//					.withIPAddress(ipAddress).usingPort(port).withArgument(() -> argument).build();
//			service.start();
//			return service;
//			
//		}
		
		
		public String getScreenShot(String testcasename, AppiumDriver driver) throws IOException
		{
			File source=driver.getScreenshotAs(OutputType.FILE);
			String destination= System.getProperty("user.dir") + "\\reports"+testcasename +".png";
			//FileUtils.copyFile(source, destination);
			FileUtils.copyFile(source, new File(destination));
			return destination;
		}
}
