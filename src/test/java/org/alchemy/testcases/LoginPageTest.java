package org.alchemy.testcases;

import org.alchemy.Utility.Utility;
import org.alchemy.Utility.UtilityForExtentReport;
import org.alchemy.base.TestBase;
import org.alchemy.driver.Driver;
import org.alchemy.pages.HomePage;
import org.alchemy.pages.LoginPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.relevantcodes.extentreports.LogStatus;

public class LoginPageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage = new HomePage();
	
	public LoginPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		loginPage = new LoginPage();
	}
	

	@Test(priority=1)
	public void loginPageTitleTest(){
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title,"Alchemy Tool");
		ExReport();
//		ExtentHtmlReporter reporter = new ExtentHtmlReporter("./Reports/ExtentHtml1.html");
//		ExtentReports extent = new ExtentReports();
//		extent.attachReporter(reporter);
//		ExtentTest logger = extent.createTest("Test1");
//		logger.log(Status.PASS, "TitleTestPasseed");
	}
	
	@Test(priority=2)
	public void loginTest() throws InterruptedException
	{
		homePage = loginPage.login(prop.getProperty("companyName"), prop.getProperty("emailId"), prop.getProperty("password"));
		Utility.captureScreenshot(driver, "LoginPage1");
		ExReport();
		
	}
	
	@Test(priority=3)
	public void validateDigiSystemImageTest(){
		boolean flag = loginPage.validateDigiSystemImage();
		//UtilityForExtentReport.ExtentUtil();
		ExReport();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=4)
	public void validateAPLableTest()
	{
		boolean flag = loginPage.validateAPLable();
//		ExReport();
//		Driver.test.log(LogStatus.PASS, "Newtest1");
//		Driver.test.log(LogStatus.FAIL, "Failed Tests");
//		Driver.test.addScreenCapture("./Screenshot/"+1+".png");
		Utility.captureScreenshot(driver, "LableTest");
		Assert.assertTrue(flag);
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
}