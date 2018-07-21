package org.alchemy.pages;

import org.alchemy.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

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
		return new UserManagementPage();
		
	}
	
	public CreatNewUserRecord verifyClickOnNewUserRecord()
	{
		newUserRecord.click();
		return new CreatNewUserRecord();
	}

	
	
	
}
