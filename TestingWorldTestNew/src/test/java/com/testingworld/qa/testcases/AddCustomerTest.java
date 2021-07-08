package com.testingworld.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.testingworld.qa.base.TestBase;
import com.testingworld.qa.pages.AddCustomer;
import com.testingworld.qa.pages.Customer;
import com.testingworld.qa.pages.Home;
import com.testingworld.qa.pages.Login;
import com.testingworld.qa.utilities.TestUtil;

public class AddCustomerTest extends TestBase{
	Login login;
	Home home;
	AddCustomer addcustomer; 
	String sheetname="Customer";
	public AddCustomerTest() throws IOException {
		super();
		
	}
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException
	{
		initialization();
		login=new Login();
		addcustomer=new AddCustomer();
		home = login.Login(prop.getProperty("username"), prop.getProperty("password"));
		addcustomer=home.clickAddCustomer();
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
	@Test(enabled=true,priority=1)
	public void verifyAddCustomerTitleTest()
	{
		String title=addcustomer.verifyAddCustomerTitle();
		Assert.assertEquals(title,"Add Customer : Performance Application Testing Online");
	}
	@Test(priority=2,dataProvider="getTestingWorldTestData")
	public void enterDetailsTest(String fname,String lname,String emailid,String age,String con,String countryval,String state,String cityvalue)
	{
		/*addcustomer.addFirstname("Fayez");
		addcustomer.addLastname("Bashar");
		addcustomer.addEmail("fayezbashar@gmail.com");
		addcustomer.addAge("23");
		addcustomer.addContact("9898787777");
		addcustomer.clickandselectCountry("India");
		addcustomer.selectState("Kansas");
		addcustomer.addCity("Kolkata");
		addcustomer.clickAddCustomer();*/
		addcustomer.AddCustomerAllDetails(fname,lname,emailid,age,con,countryval,state,cityvalue);
	}
	@DataProvider
	public Object[][] getTestingWorldTestData()
	{
		Object data[][]=TestUtil.getTestData(sheetname);
		return data;
	}
	
}
