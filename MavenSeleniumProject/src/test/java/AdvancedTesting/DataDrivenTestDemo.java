package AdvancedTesting;

import java.io.IOException;
import java.util.Base64;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import tests.BrowserUtility;

public class DataDrivenTestDemo {
	
	WebDriver browser;
	
	@BeforeClass
	public void beforeClass() {
		browser = BrowserUtility.getBrowserInstance("edge");
		browser.get("http://demowebshop.tricentis.com/");
	}
	
	@AfterClass
	public void afterClass() {
		browser.quit();
	}
	
	@DataProvider(name = "xldata")
	public Object[][] getLoginData() throws IOException{
		return XLSUtility.readXLS("logindata.xlsx", "Sheet2");
	}
	
	@Test(dataProvider = "xldata")
	public void loginTestDDT(String email, String password) {
		browser.findElement(By.linkText("Log in")).click();
		browser.findElement(By.id("Email")).sendKeys(email);
		password = new String(Base64.getDecoder().decode(password));
		System.out.println(password);
		browser.findElement(By.id("Password")).sendKeys(password);
		browser.findElement(By.cssSelector("input[value='Log in']")).click();
		
		boolean displayed = browser.findElement(By.linkText("Log out")).isDisplayed();
		
		Assert.assertTrue(displayed);
		
		browser.findElement(By.linkText("Log out")).click();
		
	}
}
