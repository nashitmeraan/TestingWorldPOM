package com.testingworld.qa.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.testingworld.qa.base.TestBase;

public class Home extends TestBase{

	
	//PageFactory
	@FindBy(xpath="//a[contains(text(),\"nashitmeraan\")]")
	WebElement username;
	
	@FindBy(xpath="//a[contains(text(),\"My Account\")]")
	WebElement myaccountlink;
	
	@FindBy(xpath="//li[@class=\"dropdown open\"]/child :: a / following-sibling :: ul/ child :: li/child:: a[text()=\"Manage Customer\"]")
	WebElement manageCustomer;
	
	@FindBy(xpath="//li[@class=\"dropdown open\"]/child :: a / following-sibling :: ul/ child :: li/child:: a[text()=\"Add Customer\"]")
	WebElement addCustomer;

	public Home() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomeTitle()
	{
		String title=driver.getTitle();
		return title;
	}
	public boolean verifyUsername()
	{
		return username.isDisplayed();
	}
	public void clickMyAccount()
	{
		myaccountlink.click();
	}
	
	public AddCustomer clickAddCustomer() throws IOException
	{
		clickMyAccount();
		addCustomer.click();
		return new AddCustomer();
	}
	
	public Customer clickManageCustomer() throws IOException, InterruptedException
	{
		myaccountlink.click();
		manageCustomer.click();
		return new Customer();
		
	}

}
