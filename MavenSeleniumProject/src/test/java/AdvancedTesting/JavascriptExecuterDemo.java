package AdvancedTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import tests.BrowserUtility;

public class JavascriptExecuterDemo {
	@Test
	public void JSExecuterDemo1() throws InterruptedException {
		WebDriver browser = BrowserUtility.getBrowserInstance("edge");
		browser.get("https://www.hdfcbank.com/");
		
		WebElement loans = browser.findElement(By.xpath("//li[contains(text(),'Loans')]"));
		WebElement payz = browser.findElement(By.xpath("//li[contains(text(),'Payzapp')]"));
		JavascriptExecutor js = (JavascriptExecutor) browser;
		
//		js.executeScript("alert('welcome to js executor');");
		
//		Thread.sleep(3000);
		
		js.executeScript("arguments[0].click();arguments[1].click();", new Object[] {loans,payz});
		Thread.sleep(3000);
		
		js.executeScript("window.scrollBy(0,350);");
		
		String title = (String) js.executeScript("return document.title;");
		System.out.println(title);
		browser.quit();
	}	
	
	@Test
	public void testFastTagWithJS() {
		WebDriver browser = BrowserUtility.getBrowserInstance("edge");
		browser.get("https://www.hdfcbank.com/");
		
		WebElement fastag = browser.findElement(By.linkText("Fastag"));
		JavascriptExecutor js = (JavascriptExecutor) browser;
		
		js.executeScript("arguments[0].click();", new Object[] {fastag});
		
		browser.quit();
		
	}
}
