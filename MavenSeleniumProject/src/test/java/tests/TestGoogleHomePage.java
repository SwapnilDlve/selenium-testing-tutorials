package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TestGoogleHomePage {
		
	@Test
	public void TestPage() {
		WebDriver browser = BrowserUtility.getBrowserInstance("edge");
		browser.get("https://www.google.co.in/");
		
		WebElement logo = browser.findElement(By.cssSelector("img[alt='Google']"));
		
		Dimension size = logo.getSize();
		System.out.println(size.height +"X"+ size.width);
		
		System.out.println(logo.getAttribute("src"));
		System.out.println(logo.getCssValue("font-family"));
		
		browser.quit();
	}
	
	
}
