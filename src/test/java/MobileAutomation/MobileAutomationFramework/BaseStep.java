package MobileAutomation.MobileAutomationFramework;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;

import MobileAutomation.Utils.UtilClass_CommonMethod_ForIOS_AndAndroid;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseStep extends UtilClass_CommonMethod_ForIOS_AndAndroid {
	public AndroidDriver driver;
	public AppiumDriverLocalService service;

//	@BeforeClass
//	public void configureAppium() throws IOException {
//		
//		
//		Properties pro= new Properties();
//		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\data.properties");
//		pro.load(file);
//		
//		String ipAddress=pro.getProperty("ipAddress");
//		String port=pro.getProperty("port");
//		String argument=pro.getProperty("argument");
//		
//		service=startAppiumServer(ipAddress,Integer.parseInt(port),argument);
//
//	
//		UiAutomator2Options option = new UiAutomator2Options();
//		option.setDeviceName(pro.getProperty("AndroidDeviceName"));
//		
//		// to handel webview on mobile we need below line code
//		option.setChromedriverExecutable("D:\\All Project\\Appium\\ChromeDriver\\chromedriver.exe"); // path of chrome driver
//		// option.setApp("D://All
//		// Project//Appium//AndroidAutomation//src//test//java//resources//ApiDemos-debug
//		// (1).apk"); // api app path
//		option.setApp(System.getProperty("user.dir")+"\\src\\test\\java\\MobileAutomation\\resources\\General-Store.apk"); // ecommerce app path
//		driver = new AndroidDriver(service.getUrl(), option);
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//	}

	@BeforeClass(alwaysRun = true)
	public void configureAppium() throws MalformedURLException {

		// code to start the server
		service = new AppiumServiceBuilder()
				.withAppiumJS(new File(
						"C:\\Users\\ankit.dhakulkar\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js")) // appium path in your system
				.withIPAddress("0.0.0.0").usingPort(4723).withArgument(() -> "--base-path", "/wd/hub").build();
		service.start();

		UiAutomator2Options option = new UiAutomator2Options();
		option.setDeviceName("6.7 Horizontal Fold-in API 30");

		// to handel webview on mobile we need below line code
		option.setChromedriverExecutable("D:\\All Project\\Appium\\ChromeDriver\\chromedriver.exe"); // path of chrome
																										// driver
		// option.setApp("D://All
		// Project//Appium//AndroidAutomation//src//test//java//resources//ApiDemos-debug
		// (1).apk"); // api app path
		option.setApp("D://All Project//Appium//App//General-Store.apk"); // ecommerce app path
		driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), option);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	public void LongPressElement(WebElement ele) {
		((JavascriptExecutor) driver).executeScript("mobile: longClickGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement) ele).getId(), "duration", 2000));
	}

	public void SwipeAction(WebElement ele, String direction) {
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of("elementId",
				((RemoteWebElement) ele).getId(), "direction", direction, "percent", 0.75));

		/*
		 * above we use direct on code because we have to change the direction 1. left
		 * 2. right thats why we are not giving hard coded here like that
		 * ((RemoteWebElement) ele).getId(), "direction", "left" , "percent", 0.75));
		 */

	}

	// Reusable method to remove the $ from amount
	public Double getFormatedAmount(String amount) {
		Double price = Double.parseDouble(amount.substring(1));
		return price;
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() {
		driver.quit();
		service.stop();
	}

}
