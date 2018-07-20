package org.alchemy.testcases;

import org.alchemy.base.TestBase;
import org.alchemy.pages.HomePage;
import org.alchemy.pages.LoginPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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
	}
	
	@Test(priority=2)
	public void validateDigiSystemImageTest(){
		boolean flag = loginPage.validateDigiSystemImage();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void loginTest() throws InterruptedException
	{
		homePage = loginPage.login(prop.getProperty("companyName"), prop.getProperty("emailId"), prop.getProperty("password"));
	}
	
	
	
	
//	@AfterMethod
//	public void tearDown()
//	{
//		driver.quit();
//	}
	
}