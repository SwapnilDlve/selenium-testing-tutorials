package tests;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import pages.DemoWebShopHomePage;
import pages.DemoWebShopLogin;
import pages.DemoWebShopRegisterPage;

public class TestExtentReports {
	
	WebDriver browser;
	DemoWebShopHomePage homePage;
	DemoWebShopLogin loginPage;
	DemoWebShopRegisterPage registerPage;
	
	ExtentSparkReporter sparkReporter;
	ExtentReports report;
	ExtentTest test;
	
	@BeforeClass
	public void beforeClass() {
		SimpleDateFormat sdf = new SimpleDateFormat("hh_mm_ss_ms_yyyy_MM_dd");
		
		String filepath = System.getProperty("user.dir") + "/extent-reports/"+sdf.format(new Date())+".html";
		sparkReporter = new ExtentSparkReporter(filepath);
		sparkReporter.config().setDocumentTitle("Automation-Report");
		sparkReporter.config().setReportName("Demo web report ");
		sparkReporter.config().setTheme(Theme.DARK);
		
		report = new ExtentReports();
		report.setSystemInfo("UserName", "Swapnil");
		report.setSystemInfo("Enviroment", "Test-Env");
		report.attachReporter(sparkReporter);
		
		browser = BrowserUtility.getBrowserInstance("edge");
		browser.get("https://demowebshop.tricentis.com/");
		
		homePage = PageFactory.initElements(browser, DemoWebShopHomePage.class);
		loginPage = PageFactory.initElements(browser, DemoWebShopLogin.class);
		registerPage = PageFactory.initElements(browser, DemoWebShopRegisterPage.class);

	}
	
	@AfterClass
	public void afterClass() {
		report.flush();
		browser.quit();
	}
	
	@BeforeMethod
	public void beforeMethod(ITestResult result)
	{
		test=report.createTest(result.getMethod().getMethodName());
	}
	
	@AfterMethod
	public void afterMethod(ITestResult result) throws IOException {
		
		if(result.getStatus() == ITestResult.FAILURE) {
			TakesScreenshot sshot = (TakesScreenshot) browser;
			File srcfile = sshot.getScreenshotAs(OutputType.FILE);
			String destination = System.getProperty("user.dir")+ "/images/"+result.getMethod().getMethodName()+".jpg";
			
			FileUtils.copyFile(srcfile, new File(destination));
			
			test.log(Status.FAIL,"The test method is failed");
			test.addScreenCaptureFromPath(destination);
			test.log(Status.FAIL,result.getThrowable().getMessage());
					
		}
		else if(result.getStatus() == ITestResult.SUCCESS) {
			
		}
		
	}
	
	@Test(priority = 2)
	public void testLogin()
	{
		//Assert.assertTrue(true);
		//test.log(Status.PASS, "This test method is passed");
	}
	@Test(priority = 1)
	public void testRegister()
	{
		homePage.register_link.click();
		Assert.assertTrue(browser.getTitle().contains("Register"));
		registerPage.gender_radio.click();
		registerPage.first_name_text.sendKeys("aswani");
		registerPage.last_name_text.sendKeys("kumar");
		registerPage.email_text.sendKeys("abcteztxyz@test.com");
		registerPage.password_text.sendKeys("abc123");
		registerPage.confirm_password_text.sendKeys("abc123");
		registerPage.register_button.click();

		//test.log(Status.FAIL, "This test method is failed");
		//Assert.assertFalse(true);
	}
	
	@Test
	public void testMethodPass() {
		test =report.createTest("test method always pass");
		Assert.assertTrue(true);
		test.log(Status.PASS, "This test method is passed");
	}
	
	@Test
	public void testMethodFail() {
		test =report.createTest("test method always fail");
		test.log(Status.FAIL, "This test method is failed");
		Assert.assertTrue(false);
	}
}
