package TestNGDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DataProviderTest {
//	@Test(dataProvider = "credentials",dataProviderClass = DataProviderDemo.class)
//	public void testLogin(String user, String pass) {
//		System.out.println(user+"--->"+pass);
//	}
	
	WebDriver browser;
	
	@BeforeClass
	public void setupEdge() {
		browser = new EdgeDriver();
		
		browser.manage().window().maximize();
	}
	
	@AfterClass
	public void closeEdge() {
		browser.quit();
	}
	
	@Test(dataProvider = "credentials",dataProviderClass = DataProviderDemo.class)
	public void testValidLogin(String uName, String pwd) throws InterruptedException {
		
		browser.get("http://ddta.deloitte.com/fluorescent/");
		Thread.sleep(4000);
		browser.findElement(By.linkText("Login")).click();
		
		WebElement email = browser.findElement(By.id("uid"));
		WebElement pass = browser.findElement(By.id("pwd"));
		
		email.sendKeys(uName);
		pass.sendKeys(pwd);
		
		browser.findElement(By.cssSelector("button[id='submit']")).click();
		
		Thread.sleep(5000);
		
		Assert.assertEquals(browser.findElement(By.cssSelector("a[href='logout.jsp']")).getText(), "Logout");
		
		browser.findElement(By.cssSelector("a[href='logout.jsp']")).click();
		
		Thread.sleep(5000);
	}
}
