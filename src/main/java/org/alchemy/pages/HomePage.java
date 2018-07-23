package org.alchemy.pages;

import java.util.Iterator;
import java.util.Set;

import org.alchemy.Utility.Utility;
import org.alchemy.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends TestBase{

	
	public HomePage()
	{
		PageFactory.initElements(driver, this) ;
	}
	
	
	
	@FindBy(xpath=".//*[@id='groupname']")
	WebElement companyName;
	
	@FindBy(xpath=".//*[@id='ctl00_lblUserName']")
	WebElement userNameLable;
	
	@FindBy(xpath=".//*[@id='ctl00_ASPxNavBar1_GHC2']/a/span")
	WebElement userManagement; 
	
	@FindBy(xpath=".//*[@id='ctl00_btnAddNewImg']")
	WebElement newUserRecord;
	
	@FindBy(xpath=".//*[@id='ctl00_ContentPlaceHolder1_ASPxCallbackPanel2_txtFirstName_I']")
	WebElement firstName;
	
	@FindBy(xpath=".//*[@id='ctl00_ContentPlaceHolder1_ASPxCallbackPanel2_txtLastName_I']")
	WebElement lastName;
	
	@FindBy(xpath=".//*[@id='ctl00_ContentPlaceHolder1_ASPxCallbackPanel2_txtEmail_I']")
	WebElement email;
	
	@FindBy(xpath=".//*[@id='ctl00_ContentPlaceHolder1_ASPxCallbackPanel2_dtDOB_I']")
	WebElement DOB;
	
	@FindBy(xpath=".//*[@id='ctl00_ContentPlaceHolder1_ASPxCallbackPanel2_dtDOJ_I']")
	WebElement DOJ;
	
	@FindBy(xpath=".//*[@id='ctl00_ContentPlaceHolder1_ASPxCallbackPanel2_cbGender_I']")
	WebElement Gen;
	
	@FindBy(xpath=".//*[@id='ctl00_ContentPlaceHolder1_ASPxCallbackPanel2_cbCountry_I']")
	WebElement country;
	
	@FindBy(xpath=".//*[@id='ctl00_ContentPlaceHolder1_ASPxCallbackPanel2_cbCountry_DDD_L_LBI0T0']")
	WebElement India;
	
	@FindBy(xpath=".//*[@id='ctl00_ContentPlaceHolder1_ASPxCallbackPanel2_cbState_I']")
	WebElement state;
	
	@FindBy(xpath=".//*[@id='ctl00_ContentPlaceHolder1_ASPxCallbackPanel2_cbState_DDD_L_LBI6T0']")
	WebElement Maharashtra;
	
	@FindBy(xpath=".//*[@id='ctl00_ContentPlaceHolder1_ASPxCallbackPanel2_cbCity_I']")
	WebElement city;
	
	@FindBy(xpath=".//*[@id='ctl00_ContentPlaceHolder1_ASPxCallbackPanel2_cbCity_DDD_L_LBI0T0']")
	WebElement Pune;
	
	@FindBy(xpath=".//*[@id='ctl00_ContentPlaceHolder1_ASPxCallbackPanel2_cbRole_I']")
	WebElement Role;
	
	@FindBy(xpath=".//*[@id='ctl00_ContentPlaceHolder1_ASPxCallbackPanel2_cbRole_DDD_L_LBI2T0']")
	WebElement User;
	
	@FindBy(xpath=".//*[@id='ctl00_ContentPlaceHolder1_ASPxCallbackPanel2_cbDepartment_I']")
	WebElement department;
	
	@FindBy(xpath=".//*[@id='ctl00_ContentPlaceHolder1_ASPxCallbackPanel2_cbDepartment_DDD_L_LBI2T0']")
	WebElement technical;
	
	@FindBy(xpath=".//*[@id='ctl00_ContentPlaceHolder1_btnSave']")
	WebElement submit;
	
	
	public String validateHomePageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean verifyCorrectUserName()
	{
		
		return  userNameLable.isDisplayed();
	}
	
	public UserManagementPage verifyclickOnUserManagement()
	{
		userManagement.click();
		Utility.captureScreenshot(driver, "UserManagement");
		return new UserManagementPage();
		
	}
	
	public CreatNewUserRecord verifyClickOnNewUserRecord() throws InterruptedException
	{
		userManagement.click();
		Utility.captureScreenshot(driver, "UserMangementPage");
		newUserRecord.click();
		Utility.captureScreenshot(driver, "AddNewUser");
		Thread.sleep(2000);
		
		Set <String> set1=driver.getWindowHandles();
		Iterator <String> window1=set1.iterator();
		String parent=window1.next();
		String child=window1.next();
		driver.switchTo().window(child);
		
		Thread.sleep(2000);
		 	firstName.sendKeys("Aakash");
			lastName.sendKeys("singh");
			email.sendKeys("aakash.gmail.com");
			//DOB.click();
			DOB.sendKeys("23-Jul-1990");
			Thread.sleep(1000);
			DOJ.sendKeys("23-Jul-18");
			Thread.sleep(1000);
			Gen.sendKeys("Male");
			Thread.sleep(1000);
			country.sendKeys("India");
			Thread.sleep(1000);
			India.click();
			Thread.sleep(3000);
			state.click();
			Maharashtra.click();
//			Select select = new Select(driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_ASPxCallbackPanel2_cbState_I']")));
//			select.deselectByVisibleText("Maharashtra");
			//state.sendKeys("Maharashtra");
			Thread.sleep(2000);
			city.click();
			Pune.click();
			Thread.sleep(2000);
			Role.click();
			User.click();
			//Role.sendKeys("Super Admin");
			Thread.sleep(2000);
			department.click();
			//department.sendKeys("Technical");
			technical.click();
			Thread.sleep(2000);
			Utility.captureScreenshot(driver, "CreatNewUser");
			submit.click();
		 
		// driver.switchTo().window(Parent_Window);
		
		//Actions action = new Actions(driver);
		
		//action.moveToElement(UserPopUp).b
		
	
		return new CreatNewUserRecord();
	}
}


