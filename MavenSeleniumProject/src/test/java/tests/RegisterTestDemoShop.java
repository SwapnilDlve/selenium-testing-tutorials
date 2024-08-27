package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterTestDemoShop {

	@Test
	public void testRegistration() {
		WebDriver browser = BrowserUtility.getBrowserInstance("edge");
		browser.get("https://demowebshop.tricentis.com/register");
		
		browser.findElement(By.id("gender-male")).click();
		WebElement firstname = browser.findElement(By.cssSelector("input[id='FirstName']"));
		firstname.sendKeys("Swapnil");
		WebElement lastname = browser.findElement(RelativeLocator.with(By.tagName("input")).below(firstname));
		lastname.sendKeys("Dalve");
		
	
		
		browser.findElement(RelativeLocator.with(By.tagName("input")).below(lastname)).sendKeys("sdalve2@gmail.com");
		
		browser.findElements(By.cssSelector("input[id*='Password']")).forEach((pass)->pass.sendKeys("Ssd@123456"));
		
		browser.findElement(By.id("register-button")).click();
		
		String text = browser.findElement(By.className("result")).getText();
		
		Assert.assertEquals(text, "Your registration completed");
		
		browser.findElement(By.linkText("Log out")).click();
		
		browser.quit();
		
		
		
		
		
	}
	
}
