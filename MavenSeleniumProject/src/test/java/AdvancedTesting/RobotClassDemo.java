package AdvancedTesting;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import tests.BrowserUtility;

public class RobotClassDemo {
	
	@Test
	public void FileUploadDemo() throws AWTException, InterruptedException {
		WebDriver browser = BrowserUtility.getBrowserInstance("edge");
		browser.get("https://blueimp.github.io/jQuery-File-Upload/");
		
		browser.findElement(By.cssSelector(".btn.btn-success.fileinput-button")).click();
		
		Thread.sleep(5000);
		
		StringSelection stringSelection = new StringSelection("C:\\Users\\sdalve\\Downloads\\car.jpg");
		
		//copy string to clipboard
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
		
		Robot robot = new Robot();
		
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		
		Thread.sleep(3000);
		
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		
		
		
		Thread.sleep(3000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyPress(KeyEvent.VK_ENTER);
//		robot.keyPress(KeyEvent.VK_ENTER);
		
		Thread.sleep(2000);
		
		browser.findElement(By.cssSelector(".btn.btn-primary.start")).click();
		
		WebElement delete = browser.findElement(By.cssSelector("button[data-type='DELETE']"));
		
		Assert.assertTrue(delete.isDisplayed());
		
		browser.quit();
	}
	
	@Test
	public void FileUploadDemo2() throws AWTException, InterruptedException {
		WebDriver browser = BrowserUtility.getBrowserInstance("edge");
		browser.get("http://ddta.deloitte.com/fluorescent/GetInTouch.html");
		
//		browser.findElement(By.linkText("Contact Us")).click();
//		browser.switchTo().window(browser.getWindowHandles().toArray()[1].toString());
//		
//		Thread.sleep(5000);
//		browser.findElement(By.linkText("Get In Touch")).click();
//		browser.switchTo().window(browser.getWindowHandles().toArray()[1].toString());
		
		browser.findElement(By.id("email")).sendKeys("johncena@gmail.com");
		browser.findElement(By.id("subject")).sendKeys("Hello");
		browser.findElement(By.id("description")).sendKeys("U cant see me........");
//		Thread.sleep(5000);
//		Robot robot = new Robot();
//		
//		robot.keyPress(KeyEvent.VK_TAB);
//		robot.keyPress(KeyEvent.VK_ENTER);
		
//		browser.findElement(By.cssSelector("input[id='fileInput']")).click();
		
		JavascriptExecutor jsx = (JavascriptExecutor) browser;
		
		jsx.executeScript("document.getElementById('fileInput').click();");
		
		Thread.sleep(5000);
		
		StringSelection stringSelection = new StringSelection("C:\\Users\\sdalve\\Downloads\\car.jpg");
		
		//copy string to clipboard
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
		
		Robot robot = new Robot();
		
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		
		Thread.sleep(2000);
		
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		
		
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyPress(KeyEvent.VK_ENTER);
//		robot.keyPress(KeyEvent.VK_ENTER);
		
		Thread.sleep(2000);
		
		browser.findElement(By.id("myButton")).click();
		
		Thread.sleep(1000);
		
		browser.switchTo().alert().accept();
		
		browser.findElement(By.cssSelector(".btn.btn-primary")).click();
		
		Thread.sleep(1000);
		
		browser.switchTo().alert().accept();
		
		Assert.assertTrue(browser.switchTo().alert().getText().equalsIgnoreCase("Form Submitted Successfully"));
		
		browser.switchTo().alert().accept();
		
		browser.quit();
	}
}
