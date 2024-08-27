package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import LoggingDemo.LogListener;
import pages.DemoWebShopHomePage;
import pages.DemoWebShopLogin;
import pages.DemoWebShopRegisterPage;
 
@Listeners(LogListener.class)
public class testPagesDemo2 {
 
	Logger log=LogManager.getLogger(testPagesDemo2.class);
	WebDriver browser;
	DemoWebShopHomePage homePage;
	DemoWebShopLogin loginPage;
	DemoWebShopRegisterPage registerPage;
	@BeforeClass
	public void beforeClass()
	{
		log.info("before class - browser launch once");
		browser=BrowserUtility.getBrowserInstance("edge");
		browser.get("https://demowebshop.tricentis.com/");
		homePage=PageFactory.initElements(browser,DemoWebShopHomePage.class);
		loginPage=PageFactory.initElements(browser, DemoWebShopLogin.class);
		registerPage=PageFactory.initElements(browser,DemoWebShopRegisterPage.class);
	}
	@AfterClass
	public void afterClass()
	{
		log.info("after class - browser close once");
		browser.quit();
	}
	@Test(priority = 1)
	public void testLoginLink()
	{
		homePage.login_link.click();
		String title = browser.getTitle();
		Assert.assertTrue(title.contains("Login"));
	}
	@Test(priority = 2)
	public void testRegisterLink()
	{
		homePage.register_link.click();
		String title = browser.getTitle();
		Assert.assertTrue(title.contains("Register"));
	}
	@Test(priority = 4)
	public void testLoginWithValidUsers()
	{
		throw new SkipException("This method is Skipped");
	}
	
	
	@Test(priority = 3, retryAnalyzer = RetryForAll.class)    //enabled=false  to disable this method
	public void testRegisterWithValidUsers()
	{
		Assert.assertTrue(false);
	}
}
