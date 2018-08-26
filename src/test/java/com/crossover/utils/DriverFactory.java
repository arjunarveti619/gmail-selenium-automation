package com.crossover.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.crossover.constants.GlobalConstants;

public class DriverFactory {

	
	public static WebDriver getBrowser(String browsername)
	{	
		WebDriver driver;
		if(browsername!=null && browsername.contains("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", GlobalConstants.CHROME_DRIVER_PATH);
			driver = new ChromeDriver();
		}
		else if(browsername!=null && browsername.contains("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", GlobalConstants.FIREFOX_DRIVER_PATH);
			driver = new FirefoxDriver();
		
		}
		else if(browsername!=null && browsername.contains("ie"))
		{
			System.setProperty("webdriver.ie.driver", GlobalConstants.IE_DRIVER_PATH);
			driver = new InternetExplorerDriver();
		
		}
		else
		{
			throw new IllegalArgumentException("Invalid Browser specified");
		}
		return driver;
	}
}
