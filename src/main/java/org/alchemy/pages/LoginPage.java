package org.alchemy.pages;

import org.alchemy.Utility.UtilityForExtentReport;
import org.alchemy.base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class LoginPage extends TestBase{
	
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this) ;
	}
	
	@FindBy(xpath=".//*[@id='groupname']")
	WebElement companyName;
	
	@FindBy(xpath=".//*[@id='emailid']")
	WebElement emailId;
	
	@FindBy(xpath=".//*[@id='pass']")
	WebElement password;
	
	@FindBy(xpath=".//*[@id='divLogin']/form/input")
	WebElement loginBtn;
	
	@FindBy(xpath=".//*[@id='logo']/div/div")
	WebElement APLable;
	
	@FindBy(xpath=".//*[@id='logo']/img")
	WebElement DigiImage;
	
	
	public HomePage login(String compName, String email, String pwd ) throws InterruptedException
	{
		companyName.sendKeys(compName);
		emailId.sendKeys(email);
		password.sendKeys(pwd);
		loginBtn.click();
//			ExtentHtmlReporter reporter = new ExtentHtmlReporter("./Reports/ExtentHtml1.html");
//			ExtentReports extent = new ExtentReports();
//			extent.attachReporter(reporter);
//			ExtentTest logger = extent.createTest("Test1");
//			logger.log(Status.PASS, "LoginTestPassed");
//			extent.flush();

		
		return new HomePage();
	}
	
	public String validateLoginPageTitle()
	{
//		ExtentHtmlReporter reporter = new ExtentHtmlReporter("./Reports/ExtentHtml1.html");
//		ExtentReports extent = new ExtentReports();
//		extent.attachReporter(reporter);
//		ExtentTest logger = extent.createTest("Test2");
//		logger.log(Status.PASS, "LoginTestPasseed");
		
		return driver.getTitle();
	}
	
	public boolean validateDigiSystemImage()
	{
		//UtilityForExtentReport.ExtentUtil();
		return  DigiImage.isDisplayed();
	}
	
	public boolean validateAPLable()
	{
		return  APLable.isDisplayed();
	}
	

}
