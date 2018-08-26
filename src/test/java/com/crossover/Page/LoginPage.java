package com.crossover.page;

import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);

	}

	public static String LOGIN_USERNAME = "id=identifierId";
	public static String LOGIN_USERNAME_NEXT="id=identifierNext";
	public static String LOGIN_PASSWORD = "name=password";
	public static String LOGIN_PASSWORD_NEXT="id=passwordNext";
	
	
	
	public void Login(String username, String password) throws InterruptedException {

		WaitForElementToAppear(LOGIN_USERNAME).click();
		getElement(LOGIN_USERNAME).sendKeys(username);
		getElement(LOGIN_USERNAME_NEXT).click();
		
		WaitForElementToAppear(LOGIN_PASSWORD).click();
		getElement(LOGIN_PASSWORD).sendKeys(password);
		getElement(LOGIN_PASSWORD_NEXT).click();
	}
	
	
	

}
