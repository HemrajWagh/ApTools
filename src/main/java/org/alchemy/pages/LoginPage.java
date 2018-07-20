package org.alchemy.pages;

import org.alchemy.base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
	
	@FindBy(xpath=".//*[@id='aspnetForm']/div[3]/div[1]/div[1]/img")
	WebElement DigiImage;
	
	
	public HomePage login(String compName, String email, String pwd ) throws InterruptedException
	{
		Thread.sleep(2000);
		companyName.sendKeys(compName);
		Thread.sleep(2000);
		emailId.sendKeys(email);
		Thread.sleep(2000);
		password.sendKeys(pwd);
		Thread.sleep(2000);
		loginBtn.click();
		return new HomePage();
	}
	
	
	
	public String validateLoginPageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean validateDigiSystemImage()
	{
		return  DigiImage.isDisplayed();
	}
	

}
