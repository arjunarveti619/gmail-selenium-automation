package com.crossover.Page;

import static org.junit.Assert.assertEquals;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import com.crossover.constants.GlobalConstants;

public class SendMailPage extends BasePage {
	WebDriver driver;

	public SendMailPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public static String COMPOSE_EMAIL = "xpath=//*[@role='button' and (.)='Compose']";
	public static String TO = "name=to";
	public static String SUBJECT = "name=subjectbox";
	public static String ATTACH_FILE = "css=div.bAK > div";
	public static String SEND_EMAIL = "css=table.IZ td div:nth-child(2)";
	public static String OPEN_FIRST_EMAIL = "css=div.UI > div> div:nth-child(1) > div:nth-child(2)  table tbody>tr:nth-child(1) >td:nth-child(6) span";
	public static String GET_SUBJECT = "css=div.nH.if >div.nH >div.nH >div.ha >h2";
	public static String GET_BODY = "css=div.ii.gt >div >div:nth-child(1)";
	public static String GET_ATTACHMENT_TEXT = "css=div.aSH >div:nth-child(3) span";
	public static String SEARCH_BOX="css=#aso_search_form_anchor > div > input";

	public void sendEmail(WebDriver driver,String file) throws AWTException, InterruptedException {

		WaitForElementToAppear(COMPOSE_EMAIL).click();
		getElement(TO).clear();
		getElement(TO).sendKeys(String.format("%s@gmail.com", GlobalConstants.USERNAME));
		getElement(TO).sendKeys(Keys.ENTER);
		getElement(SUBJECT).clear();
		getElement(SUBJECT).sendKeys(GlobalConstants.SUBJECT);

		Actions body = new Actions(driver);
		body.sendKeys(Keys.TAB).sendKeys(GlobalConstants.BODY).build().perform();
		// click on attachment icon
		getElement(ATTACH_FILE).click();
		// upload your file using RobotClass
		// attach your path where file is located.
		StringSelection ss = new StringSelection(file);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		Robot robot = new Robot();
		Thread.sleep(3000);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		Thread.sleep(3000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(5000);

		WaitForElementToAppear(SEND_EMAIL).click();
		Thread.sleep(5000);
		WaitForElementToAppear(SEARCH_BOX).sendKeys("subject: "+GlobalConstants.SUBJECT);
		WaitForElementToAppear(OPEN_FIRST_EMAIL).click();
		Thread.sleep(5000);
		String ExtractSubjectName = getText(GET_SUBJECT);
		String ExtractBody = getText(GET_BODY);
		String ExtractAttachmentText = getText(GET_ATTACHMENT_TEXT);
		System.out.println("FileName "+GlobalConstants.FILE_NAME);
		assertEquals(ExtractSubjectName, GlobalConstants.SUBJECT);
		assertEquals(ExtractBody, GlobalConstants.BODY);
		assertEquals(ExtractAttachmentText, GlobalConstants.FILE_NAME);
	}

}
