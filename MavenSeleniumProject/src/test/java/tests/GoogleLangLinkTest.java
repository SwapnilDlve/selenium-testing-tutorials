package tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GoogleLangLinkTest {
	
	@Test
	public void testNoOfLangs() {
		WebDriver browser = new FirefoxDriver();
		
		browser.get("http://www.google.co.in/");
		
		browser.manage().window().maximize();
		
		WebElement div = browser.findElement(By.cssSelector("div[id='SIvCob']")).;
		
		List<WebElement> atags = div.findElements(By.tagName("a"));
		
		Assert.assertEquals(atags.size(), 9);
		
		browser.quit();
		
	}
	
}
