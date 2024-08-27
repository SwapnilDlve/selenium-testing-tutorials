package tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ScrollDemo {
	
	@Test
	public void scrollDemo() {
		WebDriver browser = BrowserUtility.getBrowserInstance("edge");
		Actions actions = new Actions(browser);
		
		browser.get("https://www.hdfcbank.com/");
		
		WebElement connect = browser.findElement(By.linkText("Connect"));
		actions.scrollByAmount(0,750).pause(Duration.ofSeconds(2))
		.scrollToElement(connect).pause(Duration.ofSeconds(2))
		.sendKeys(Keys.PAGE_UP).pause(Duration.ofSeconds(5)).perform();
		
		
		browser.quit();
	}
	
	@Test
	public void navigateTest() throws InterruptedException {
		WebDriver browser = new EdgeDriver();
		browser.manage().window().maximize();
		browser.navigate().to("https://www.google.co.in/");
		browser.navigate().to("http://demowebshop.tricentis.com/");
		Thread.sleep(2000);
		browser.navigate().back();
		Thread.sleep(2000);
		browser.navigate().forward();
		browser.close();
	}
	
}
