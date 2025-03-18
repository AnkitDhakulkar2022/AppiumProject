package MobileAutomation.MobileAutomationFramework;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport {
	static ExtentReports ex;

	public static ExtentReports getReporterObject() {
		String path = System.getProperty("user.dir") + "\\reports\\index.html"; // path where report should be created
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("WebAutomationResult"); // Report name
		reporter.config().setDocumentTitle("Test Result");// Report title name

		ex = new ExtentReports();
		ex.attachReporter(reporter);
		ex.setSystemInfo("Tester", "Ankit");
		return ex;
	}

}
