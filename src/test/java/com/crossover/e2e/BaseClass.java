package com.crossover.e2e;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;


import com.crossover.constants.GlobalConstants;
import com.crossover.utils.DriverFactory;



public class BaseClass {
	WebDriver driver;
	
	@Before
	public void setUp() {
		
		driver=DriverFactory.getBrowser(GlobalConstants.BROWSER_NAME);
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(GlobalConstants.DRIVER_IMPLICIT_WAIT_TIME_DEFAULT), 
				TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(GlobalConstants.SERVER_URL);
	}
	
	@After
	public void teardown()
	{
		
		driver.close();
	}
	
	
}
