package com.crossover.test;

import java.awt.AWTException;

import org.junit.Test;

import com.crossover.constants.GlobalConstants;
import com.crossover.page.LoginPage;
import com.crossover.page.SendMailPage;


public class TestSendMail extends BaseClass{

	@Test
	public void SendMail() throws AWTException, InterruptedException
	{
		LoginPage login=new LoginPage(driver);
		login.Login(GlobalConstants.USERNAME,GlobalConstants.PASSWORD);
		
		SendMailPage send=new SendMailPage(driver);
		
		send.sendEmail(driver,GlobalConstants.FILE_PATH);	

	}
}
