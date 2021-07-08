package com.testingworld.qa.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.testingworld.qa.base.TestBase;

public class Customer extends TestBase {
	

	public Customer() throws IOException {
		super();
		
	}
	
	public String verifyCustomerTitle()
	{
		String title= driver.getTitle();
		return title;
	}
	public String moveToActionsEdit(String name) throws InterruptedException
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("scrollBy(0, 250)", "");
		Actions a=new Actions(driver);
		WebElement customerName=driver.findElement(By.xpath("//td[text()=\""+name+"\"]/following-sibling :: td[@class=\"menu-action\"] /a[text()=\" Edit \"]"));
		a.moveToElement(customerName);
		Thread.sleep(10000);
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", customerName);
		return customerName.getText();
		
	}

}
