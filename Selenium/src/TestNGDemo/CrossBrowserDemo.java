package TestNGDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowserDemo {
	WebDriver browser;
	/*
	 * public void beforeMethod() {
	 * browser.get("https://demowebshop.tricentis.com/login");
	 * browser.manage().window().maximize();
	 * 
	 * }
	 */
	@BeforeClass
	@Parameters("browser")
	public void beforeClass(String browserValue)
	{
		if(browserValue.equals("edge"))
		{
			browser=new EdgeDriver();
		}
		else if(browserValue.equals("firefox"))
		{
			browser=new FirefoxDriver();
		}
		browser.get("https://demowebshop.tricentis.com/login");
	    browser.manage().window().maximize();
 
	}
 
	@AfterClass
	public void afterMethod()
	{
		browser.quit();
	}
	@Test(dataProvider="credentials2", dataProviderClass=DataProviderDemo.class)
 
	public void testLoginDemoWebShop(String username, String password)
	{
		browser.findElement(By.linkText("Log in")).click();
		WebElement emailtextbox= browser.findElement(By.id("Email"));
		emailtextbox.sendKeys(username);
		WebElement passwordtextbox=browser.findElement(By.id("Password"));
		passwordtextbox.sendKeys(password);
		browser.findElement(By.cssSelector("input[value= 'Log in']")).click();
		boolean logoutStatus= browser.findElement(By.linkText("Log out")).isDisplayed();
		Assert.assertTrue(logoutStatus);
		browser.findElement(By.linkText("Log out")).click();
	}
}
