package com.testingworld.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.testingworld.qa.utilities.TestUtil;
import com.testingworld.qa.utilities.WebEventListener;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	
	public TestBase() throws IOException {
		prop=new Properties();
		FileInputStream fp=new FileInputStream("./src\\main\\java\\com\\testingworld\\qa\\config\\config.properties");
		prop.load(fp);
		
	}
	
	public static void initialization() throws IOException {
		String browsername=prop.getProperty("browser");
		if(browsername.equalsIgnoreCase("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dell\\AppData\\Local\\Google\\Chrome\\Application\\chromedriver.exe");
			driver=new ChromeDriver();
			
		}
		else if(browsername.equalsIgnoreCase("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe");
			driver=new FirefoxDriver();
		}
		else
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dell\\AppData\\Local\\Google\\Chrome\\Application\\chromedriver.exr");
			driver=new ChromeDriver();
			
		}
		
		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICITLY_WAIT_TIMEOUT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}
	

}
