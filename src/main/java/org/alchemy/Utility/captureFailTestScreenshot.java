package org.alchemy.Utility;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

public class captureFailTestScreenshot {

	public static ITestResult failTestScreenshot(ITestResult result,WebDriver driver,String failsrceenName)
	{
		if(ITestResult.FAILURE==result.getStatus())
		{
			System.out.println(result);
			Utility.captureScreenshot(driver, "fail");
		}
	
	return result;
}}