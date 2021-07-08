package com.testingworld.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.testingworld.qa.base.TestBase;

public class Login extends TestBase{

	
	
	//PageFactory

	@FindBy(xpath="//label[text()=\"Login\"]")
	WebElement LoginTab;
	
	@FindBy(name="_txtUserName")
	WebElement username;
	
	@FindBy(name="_txtPassword")
	WebElement password;
	
	@FindBy(xpath="//input[@type=\"submit\" and @value=\"Login\"]")
	WebElement login;
	
	@FindBy(xpath="//img[@src=\"images/logo.png\"]")
	WebElement testingworldlogo;
	
	public Login() throws IOException {
		super();
		PageFactory.initElements(driver, this);
		
	}
	
	//Actions
	
	public void LoginTab()
	{
		LoginTab.click();
	}
	
	public String validateLoginPageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean validateTestingWorldImage()
	{
		return testingworldlogo.isDisplayed();
	}
	
	public Home Login(String un,String pwd) throws IOException
	{
		LoginTab();
		username.sendKeys(un);
		password.sendKeys(pwd);
		login.click();
		
		return new Home();
		
	}
	

}
