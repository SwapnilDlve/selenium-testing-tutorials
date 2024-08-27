package TestNGDemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestDemo1 {
	
	WebDriver browser;
	
	@BeforeClass
	public void beforeMethod() {
		browser = new EdgeDriver();
		browser.manage().window().maximize();
	}
	
	@AfterClass
	public void afterMethod() {
		browser.quit();
	}
	
	@Test
	public void testGoogle() {
		
		browser.get("http://www.google.com/");
		Assert.assertEquals(browser.getTitle(), "Google");
	}
	
	@Test
	public void testDemoShop() {
		// TODO Auto-generated method stub
		
		browser.get("http://demowebshop.tricentis.com/");
	}
	
}
