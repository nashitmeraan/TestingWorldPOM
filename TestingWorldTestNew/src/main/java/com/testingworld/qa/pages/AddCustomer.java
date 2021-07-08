package com.testingworld.qa.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.testingworld.qa.base.TestBase;

public class AddCustomer extends TestBase {
	
	@FindBy(xpath="//input[@name=\"first_name\"]")
	WebElement firstname;
	
	@FindBy(xpath="//input[@name=\"last_name\"]")
	WebElement lastname;
	
	@FindBy(xpath="//input[@name=\"email\"]")
	WebElement email;
	
	@FindBy(xpath="//input[@name=\"age\"]")
	WebElement age;
	
	@FindBy(xpath="//input[@name=\"contact\"]")
	WebElement contact;
	
	@FindBy(xpath="//span[@class=\"select2-selection select2-selection--single\"]")
	WebElement country;
	
	@FindBy(xpath="//select[@name=\"state\"]")
	WebElement statevalue;
	
	@FindBy(xpath="//input[@name=\"city\"]")
	WebElement city;
	
	@FindBy(xpath="//button[@type=\"submit\"]")
	WebElement addcustomerbutton;
	
	
	public AddCustomer() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}
	
	public String verifyAddCustomerTitle()
	{
		String title;
		title=driver.getTitle();
		return title;
	}
	
	public void addFirstname(String fname)
	{
		firstname.sendKeys(fname);
	}
	public void addLastname(String lname)
	{
		lastname.sendKeys(lname);
	}
	public void addEmail(String emailid)
	{
		email.sendKeys(emailid);
	}
	public void addAge(String Age)
	{
		age.sendKeys(Age);
	}
	public void addContact(String con)
	{
		contact.sendKeys(con);
	}
	public void clickandselectCountry(String countryval)
	{
		country.click();
		WebElement countryvalue=  driver.findElement(By.xpath("//li[text()=\""+countryval+"\"]"));
		countryvalue.click();
		
	}
	public void selectState(String state)
	{
		Select states=new Select(statevalue);
		states.selectByVisibleText(state);
	}
	public void addCity(String cityvalue)
	{
		city.sendKeys(cityvalue);
	}
	public void clickAddCustomer()
	{
		addcustomerbutton.click();
	}
	public void AddCustomerAllDetails(String fname,String lname,String emailid,String age,String con,String countryval,String state,String cityvalue)
	{
		addFirstname(fname);
		addLastname(lname);
		addEmail(emailid);
		addAge(age);
		addContact(con);
		clickandselectCountry(countryval);
		selectState(state);
		addCity(cityvalue);
		clickAddCustomer();
	}
	
	
	

}
