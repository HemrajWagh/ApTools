package org.alchemy.testcases;

import org.alchemy.base.TestBase;
import org.alchemy.pages.Group;
import org.alchemy.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GroupTest extends TestBase {
	
	LoginPage loginPage;
	Group group= new Group();
	public GroupTest()
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
	public void verifyGroupPageTitleTest()
	{
		String grouppagetitle=group.validateGroupPageTitle();
		Assert.assertEquals(grouppagetitle, "Alchemy Tool");
		System.out.println(grouppagetitle);
	}
	
	
}
