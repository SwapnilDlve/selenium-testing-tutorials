package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.DemoWebShopHomePage;
import pages.DemoWebShopLogin;
import pages.DemoWebShopRegisterPage;

public class testPagesDemo {
	
	Logger log = LogManager.getLogger(testPagesDemo.class);
	WebDriver browser;
	DemoWebShopHomePage homePage;
	DemoWebShopLogin loginPage;
	DemoWebShopRegisterPage registerPage;
	
	@BeforeClass
	public void beforeClass() {
		log.info("Before class - browser launch once");
		browser = BrowserUtility.getBrowserInstance("edge");
		browser.get("https://demowebshop.tricentis.com/");
		
		homePage = PageFactory.initElements(browser, DemoWebShopHomePage.class);
		loginPage = PageFactory.initElements(browser, DemoWebShopLogin.class);
		registerPage = PageFactory.initElements(browser, DemoWebShopRegisterPage.class);
	}
	
	@AfterClass
	public void afterClass() {
		log.info("after class - browser close once");
		browser.quit();
	}
	
	@Test(priority = 1)
	public void testLoginLink() {
		log.info("before test - testLoginLink");
		homePage.login_link.click();
		String title = browser.getTitle();
		Assert.assertTrue(title.contains("Login"));
		log.info("after test - testLoginLink");
	}
	
	@Test(priority = 2, enabled = false)
	public void testRegisterLink() {
		
	}
	
	@Test(priority = 4, enabled = false)
	public void testLoginWithValidUsers() {
		
	}
	
	@Test(priority = 3, enabled = false)
	public void testRegisterWithValidUsers() {
		
	}
}
