package TestNGDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NewTest1 {

//	@Test
//	public void testGoogleHomePage() {
//		WebDriver browser = new EdgeDriver();
//		browser.manage().window().maximize();	
//		browser.get("https://www.google.com/");
//		String title = browser.getTitle();
//		Assert.assertEquals(title, "Google");
//		browser.quit();
//	}
	
//	@Test
//	public void testDemoShop() {
//		
//		String uName = "Dalve@gmail.com";
//		String pwd = "Ssd@1234";
//		
//		WebDriver browser = new EdgeDriver();
//		browser.manage().window().maximize();	
//		
//		browser.get("https://demowebshop.tricentis.com/login");
//		
//		WebElement email = browser.findElement(By.id("Email"));
//		WebElement pass = browser.findElement(By.id("Password"));
//		
//		email.sendKeys(uName);
//		pass.sendKeys(pwd);
//		
//		browser.findElement(By.cssSelector("input[value='Log in']")).click();
//		
//		String text = browser.findElement(By.cssSelector("a[class='account']")).getText();
//		
//		Assert.assertEquals(text, uName);
//		
//		browser.findElement(By.linkText("Log out")).click();
//		browser.quit();
//		
//	}
	
	@Test
	public void invalidLogin() throws InterruptedException {
		String uName = "Dalve@gmail.com";
		String pwd = "Ssd@1234";
		
		WebDriver browser = new EdgeDriver();
		browser.manage().window().maximize();	
		
		browser.get("http://ddta.deloitte.com/fluorescent/");
		
		browser.findElement(By.linkText("Login")).click();
		
		WebElement email = browser.findElement(By.id("uid"));
		WebElement pass = browser.findElement(By.id("pwd"));
		
		email.sendKeys(uName);
		pass.sendKeys(pwd);
		
		browser.findElement(By.cssSelector("button[id='submit']")).click();
		
		//static wait to handle synchronization
		Thread.sleep(4000);
		
		String res =browser.findElement(By.id("message")).getText();
//		Assert.assertEquals(res, "Invalid Credentials.");
		Assert.assertTrue(res.contains("Invalid"));
		browser.quit();
		
	}
	
	
	

}
