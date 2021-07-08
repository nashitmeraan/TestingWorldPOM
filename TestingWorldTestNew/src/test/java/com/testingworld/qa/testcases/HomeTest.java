package com.testingworld.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.testingworld.qa.base.TestBase;
import com.testingworld.qa.pages.Customer;
import com.testingworld.qa.pages.Home;
import com.testingworld.qa.pages.Login;

public class HomeTest extends TestBase{
	
	Login login;
	Home home;
	Customer customer;

	public HomeTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@BeforeMethod
	public void setUp() throws IOException
	{
		initialization();
		login=new Login();
		customer=new Customer();
		home = login.Login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
	@Test(enabled=true,priority=1)
	public void verifyHomeTitleTest()
	{
		String title=home.verifyHomeTitle();
		Assert.assertEquals(title,"My Account : Application Testing Online","Home title not matched");
	}
	@Test(enabled=true,priority=2)
	public void verifyUsernameTest()
	{
		Assert.assertTrue(home.verifyUsername());
	}
	@Test(enabled=true,priority=3)
	public void clickMyAccountTest()
	{
		home.clickMyAccount();
	}
	@Test(priority=4)
	public void clickManageCustomerTest() throws IOException, InterruptedException
	{
		customer=home.clickManageCustomer();
	}

}
