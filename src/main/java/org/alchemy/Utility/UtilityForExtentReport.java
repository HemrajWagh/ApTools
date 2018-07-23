package org.alchemy.Utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class UtilityForExtentReport {
	
	public static void ExtentUtil() {
	ExtentHtmlReporter reporter = new ExtentHtmlReporter("./Reports/ExtentHtml.html");
	ExtentReports extent = new ExtentReports();
	extent.attachReporter(reporter);
	ExtentTest logger = extent.createTest("Test");
		logger.log(Status.FAIL, "LoginPageTestFailed");
		logger.log(Status.PASS, "PassedTest");
	}
}
