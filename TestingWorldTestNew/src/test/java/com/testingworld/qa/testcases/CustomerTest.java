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

public class CustomerTest extends TestBase{
	Login login;
	Home home;
	Customer customer;

	public CustomerTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException
	{
		initialization();
		login=new Login();
		customer=new Customer();
		home = login.Login(prop.getProperty("username"), prop.getProperty("password"));
		customer=home.clickManageCustomer();
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
	@Test(enabled=true,priority=1)
	public void verifyCustomerTitleTest()
	{
		String title=customer.verifyCustomerTitle();
		Assert.assertEquals(title, "Manage Customer : Performance Application Testing Online");
	}
	@Test(priority=2)
	public void moveToActionsEditTest() throws InterruptedException
	{
		String value=customer.moveToActionsEdit("Jaweria");
		Assert.assertEquals(value, "Edit");
	}

}
