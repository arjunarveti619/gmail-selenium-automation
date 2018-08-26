package com.crossover.Page;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crossover.constants.GlobalConstants;

public class BasePage {
	WebDriver driver;
	
	public BasePage(WebDriver driver)
	{
		this.driver=driver;
		
	}
	
	public String getTitle()
	{
		return driver.getTitle();
	}
	
	public WebElement getElement(String locator)
	{
		WebElement element=driver.findElement(getLocator(locator));
		return element;
	}
	
	public String getText(String locator)
	{
		WebElement element=driver.findElement(getLocator(locator));
		return element.getText();
		
	}
	public WebElement WaitForElementToAppear(String locator)
	{
		return WaitForElementToAppear(locator,20);
		
	}
	
	public WebElement WaitForElementToAppear(String locator,int TimeInSeconds)
	{
		//driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);

		WebDriverWait wait=new WebDriverWait(driver, TimeInSeconds);
		WebElement element=wait.until(ExpectedConditions.elementToBeClickable(getLocator(locator)));
		
	//	driver.manage().timeouts().implicitlyWait(Integer.parseInt(GlobalConstants.DRIVER_IMPLICIT_WAIT_TIME_DEFAULT),TimeUnit.SECONDS);
		
		return element;
	}

	public By getLocator(String locator) {
		// TODO Auto-generated method stub
		By by= null;
		
		String newlocator=locator.substring(locator.indexOf("=")+1);
		
		if (locator.startsWith("id"))
		{
		by= By.id(newlocator);
		}
		else if (locator.startsWith("css"))
		{
		by= By.cssSelector(newlocator);
		}
		else if (locator.startsWith("name"))
		{
		by= By.name(newlocator);
		}
		else if (locator.startsWith("xpath"))
		{
		by= By.xpath(newlocator);
		}
		else if (locator.startsWith("link"))
		{
		by= By.linkText(newlocator);
		}
		else if (locator.startsWith("partial"))
		{
		by= By.partialLinkText(newlocator);
		}
		else
		{
			throw new IllegalArgumentException("Locator not recognised "+locator);
		}
		return by;
	}
}
