package org.alchemy.testcases;

import org.alchemy.base.TestBase;
import org.alchemy.pages.HomePage;
import org.alchemy.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	public HomePageTest()	
	{
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("companyName"), prop.getProperty("emailId"), prop.getProperty("password"));
	}
	
	
	
	
	
	@Test(priority=1)
	public void verifyHomePageTitleTest()
	{
		String homepagetitle=homePage.validateHomePageTitle();
		Assert.assertEquals(homepagetitle, "CONTROLS MANAGER");
	}
	
	@Test(priority=2)
	public void verifyCorrectUserNameTest()
	{
		boolean flag = homePage.verifyCorrectUserName();
		Assert.assertTrue(flag);
	}
	

	@Test(priority=3)
	public void verifyclickOnMastersLinkTest() throws InterruptedException
	{
		//mastersPage=homePage.verifyclickOnMastersLink();
	}
	
	

}