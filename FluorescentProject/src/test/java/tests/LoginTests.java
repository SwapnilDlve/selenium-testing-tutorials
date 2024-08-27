package tests;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
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
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import browser.util.BrowserUtility;
import pages.FluorescentHomePage;
import pages.FluorescentLoginPage;
import pages.FluorescentRegisterPage;


public class LoginTests {

	WebDriver browser;
	FluorescentHomePage homePage;
	FluorescentLoginPage loginPage;
	FluorescentRegisterPage registerPage;
	
	ExtentSparkReporter sparkReporter;
	ExtentReports report;
	ExtentTest test;
	
	@BeforeClass
	public void beforeClass() {
		SimpleDateFormat sdf = new SimpleDateFormat("hh_mm_ss_ms_yyyy_MM_dd");
		
		String filepath = System.getProperty("user.dir") + "/extent-reports/"+sdf.format(new Date())+".html";
		sparkReporter = new ExtentSparkReporter(filepath);
		sparkReporter.config().setDocumentTitle("Automation-Report");
		sparkReporter.config().setReportName("Fluorescent Website ");
		sparkReporter.config().setTheme(Theme.DARK);
		
		report = new ExtentReports();
		report.setSystemInfo("UserName", "Swapnil");
		report.setSystemInfo("Enviroment", "Test-Env");
		report.attachReporter(sparkReporter);
		
		browser = BrowserUtility.getBrowserInstance("edge");
		browser.get("http://ddta.deloitte.com/fluorescent/");
		
		homePage = PageFactory.initElements(browser, FluorescentHomePage.class);
		loginPage = PageFactory.initElements(browser, FluorescentLoginPage.class);
		registerPage = PageFactory.initElements(browser, FluorescentRegisterPage.class);

	}
	
	@AfterClass
	public void afterClass() {
		report.flush();
		browser.quit();
	}
	
	@BeforeMethod
	public void beforeMethod(ITestResult result)
	{
		browser.get("http://ddta.deloitte.com/fluorescent/");
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
	public void testInvalidLogin() throws InterruptedException {
		homePage.Login_link.click();
		Assert.assertTrue(browser.getTitle().equalsIgnoreCase("Login"));
		loginPage.Username.sendKeys("swapnil12");
		loginPage.Password.sendKeys("ssd@121321");
		loginPage.Login.click();
		Thread.sleep(5000);
		Assert.assertTrue(browser.findElement(By.id("message")).getText().equalsIgnoreCase("Invalid Credentials."));	
	}
	
	@Test(priority = 1, alwaysRun = true)
	public void testValidLogin() {
		homePage.Login_link.click();
		Assert.assertTrue(browser.getTitle().equalsIgnoreCase("Login"));
		loginPage.Username.sendKeys("sdalve");
		loginPage.Password.sendKeys("Dalve@1234");
		loginPage.Login.click();
		Assert.assertTrue(browser.findElement(By.xpath("//*[@id=\"headers\"]/div/div/header/div[1]/div/div/div/div[3]/div[2]/div[4]/div/ul/li/span")).getText().contains("Hi!!"));	
		browser.findElement(By.linkText("Logout")).click();
	}
	
}
