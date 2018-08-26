package com.crossover.e2e;

import java.awt.AWTException;

import org.junit.Test;

import com.crossover.Page.LoginPage;
import com.crossover.Page.SendMailPage;
import com.crossover.constants.GlobalConstants;


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
