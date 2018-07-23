package org.alchemy.driver;


import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.ExtentTestInterruptedException;
import com.relevantcodes.extentreports.LogStatus;


public class Driver{

	public static ExtentReports extent;
	public static ExtentTest test;
	public static ExtentTestInterruptedException testexception;
	
	public Driver()
	
	{
		
	}
	
	//Messages on Dashboard Section of HTML Report
	
	@BeforeSuite(groups = { "Sanity" })
	public void beforeSuite() 
	{
		//Report Directory and Report Name
		extent = new ExtentReports("D//api_execution_report.html", true); //Provide Desired Report Directory Location and Name
		extent.loadConfig(new File("extent-config.xml")); //Supporting File for Extent Reporting
		extent.addSystemInfo("Environment","QA-Sanity"); //It will provide Execution Machine Information
	}
	
	@BeforeTest(groups = { "Sanity" })
	public void beforeTest()
	{
		System.out.println(" in Before Test ");
	}
	
	//Messages on Categories Section of HTML Report
	
	@BeforeMethod(groups = { "Sanity" })
	public  void beforeMethod(Method method) 
	{
		test = extent.startTest( (this.getClass().getSimpleName() +" :: "+  method.getName()),method.getName()); //Test Case Start Here
		test.assignAuthor("Hemraj wagh"); //Test Script Author Name
		String env = null;
		String ver = null;
		test.assignCategory("Sanity  :: " + env + " :: API VERSION - "+ ver); //Test Category Defined Here
	}
	
	//Write Your Test Script Here
	
	   //Test Case 1
	   @Test
	   public void testCase2() 
	   	{
	    		System.out.println("in test case 2");
	    		test.log(LogStatus.FAIL, "Step details");
	   	}
	   	
	   //Test Case 2
	   @Test
	   public void testCase3() 
	   	{
	    		System.out.println("in test case 2");
	    		test.log(LogStatus.FAIL, "Step details");
	   	}
	
	//Test Case Reporting Ends Here
	@AfterMethod(groups = { "Sanity" })
	public void afterMethod() 
	{
		extent.endTest(test);
		extent.flush();
	}
	   	
	@AfterTest(groups = { "Sanity" })
	public void afterTest()
	{
		System.out.println(" in After Test");
	}
		
	@AfterSuite(groups = { "Sanity" })
	public void afterSuite() 
	{
		//System.out.println("in afterSuite");
		extent.close();  // close the Test Suite
	}
	
}