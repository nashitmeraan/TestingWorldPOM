package com.testingworld.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.testingworld.qa.base.TestBase;
import com.testingworld.qa.pages.Home;
import com.testingworld.qa.pages.Login;

public class LoginTest extends TestBase {
	
	Login login;
	Home home;

	public LoginTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@BeforeMethod
	public void setUp() throws IOException
	{
		initialization();
		login=new Login();
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	
	@Test(priority=1)
	public void LoginTabTest()
	{
		login.LoginTab();
	}
	
	@Test(priority=2)
	public void LoginTitleTest()
	{
		login.LoginTab();
		String title=login.validateLoginPageTitle();
		Assert.assertEquals(title, "Login & Sign Up Forms");
		
	}
	@Test(priority=3)
	public void TestingWorldImageTest()
	{
		login.LoginTab();
		boolean image=login.validateTestingWorldImage();
		Assert.assertTrue(image);
	}
	@Test(priority=4)
	public void LoginTest() throws IOException
	{
		home = login.Login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
}
