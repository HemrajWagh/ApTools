package org.alchemy.pages;

import org.alchemy.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends TestBase{

	
	public HomePage()
	{
		PageFactory.initElements(driver, this) ;
	}
	
	
	
	@FindBy(xpath=".//*[@id='groupname']")
	WebElement companyName;
	
	@FindBy(xpath=".//*[@id='ctl00_lblUserName']")
	WebElement userNameLable;
	
	
	public String validateHomePageTitle(){
		return driver.getTitle();
	}
	
	public boolean verifyCorrectUserName()
	{
		return  userNameLable.isDisplayed();
	}
	
	public UserManagementPage verifyclickOnUserManagement()
	{
		
		
		return new UserManagementPage();
	}

	
}
