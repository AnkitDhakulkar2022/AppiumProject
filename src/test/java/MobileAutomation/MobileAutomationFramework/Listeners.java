package MobileAutomation.MobileAutomationFramework;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import MobileAutomation.Utils.UtilClass_CommonMethod_ForIOS_AndAndroid;
import io.appium.java_client.AppiumDriver;

public class Listeners extends UtilClass_CommonMethod_ForIOS_AndAndroid implements ITestListener {
	AppiumDriver driver;
	ExtentTest test;
	ExtentReports ex = ExtentReport.getReporterObject();

	@Override
	public void onTestStart(ITestResult result) {

		test = ex.createTest(result.getMethod().getMethodName()); // ExtentTest test
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "Test Pass");

		// It will execute only when the method is successfully run
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Test failed: " + result.getName());
		// Capture screenshot or log the failure reason
		// Example: ScreenshotUtil.captureScreenshot(result.getName());
		// It will execute only when the method is failed

		// test.log(Status.FAIL,"Test Fail");
		test.fail(result.getThrowable());

		try {
			driver = (AppiumDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		try {
			test.addScreenCaptureFromPath(getScreenShot(result.getMethod().getMethodName(), driver),
					result.getMethod().getMethodName());
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("Test skipped: " + result.getName());
		// It will execute only when the method is skipped
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("Test failed but within success percentage: " + result.getName());
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("Test suite started: " + context.getName());
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("Test suite finished: " + context.getName());
		ex.flush();
	}

}
