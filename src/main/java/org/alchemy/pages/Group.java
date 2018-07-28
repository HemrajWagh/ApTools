package org.alchemy.pages;

import org.alchemy.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Group extends TestBase{
	
	public Group()
	{
		PageFactory.initElements(driver, this) ;
	}
	
	@FindBy(xpath="//span[@class='dxnb-ghtext' and contains(text(),'GroupDetails')]")
	WebElement GroupDetails;
	
	
	public String validateGroupPageTitle()
	{
		return driver.getTitle();
	}
	
	
	public void clickOnGroupDetails() 
	{
		GroupDetails.click();
	}
	
	
	

}
