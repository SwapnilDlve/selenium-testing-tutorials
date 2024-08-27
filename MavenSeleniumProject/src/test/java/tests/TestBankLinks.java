package tests;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestBankLinks {
	
	@Test
	public void testFastagOption() {
		WebDriver browser = BrowserUtility.getBrowserInstance("edge");
		browser.get("https://www.hdfcbank.com/");
		
		WebElement loginbtn = browser.findElement(By.xpath("//button[contains(text(),'Login')]"));
		
		Actions actions = new Actions(browser);
		actions.moveToElement(loginbtn).pause(Duration.ofSeconds(2)).click(browser.findElement(By.xpath("//a[@href='https://fastag.hdfcbank.com/CustomerPortal/Login']"))).perform();
		
		Assert.assertTrue(browser.getCurrentUrl().contains("fastag"));
		
		browser.quit();
	}
	
	
	@Test
	public void testHoverMouse() {
		WebDriver browser = BrowserUtility.getBrowserInstance("edge");
		Actions actions = new Actions(browser);
		
		browser.get("https://www.hdfcbank.com/");
		
		WebElement navbar = browser.findElement(By.xpath("//*[@id=\"main\"]/div[2]/div[13]/div[3]/div[3]/div/div/div/div/div/div/div/div[1]/div[2]/ul"));
		List<WebElement> options = navbar.findElements(By.cssSelector("li[id^='web']"));
		
		assertEquals(options.size(), 7);
		
		for(WebElement elm: options) {
			actions.moveToElement(elm).pause(Duration.ofSeconds(2)).perform();
		}
		
		browser.quit();
	}
	
}
