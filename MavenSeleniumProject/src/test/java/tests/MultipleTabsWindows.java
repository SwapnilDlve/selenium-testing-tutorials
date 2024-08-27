package tests;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MultipleTabsWindows {
	
	@Test
	public void testMultipleTabs() throws InterruptedException {
		WebDriver browser = BrowserUtility.getBrowserInstance("edge");
		browser.get("https://www.hdfcbank.com/");
		
		WebElement loginbtn = browser.findElement(By.xpath("//button[contains(text(),'Login')]"));
		
		Actions actions = new Actions(browser);
		actions.moveToElement(loginbtn).perform();
		
		browser.findElement(By.linkText("NetBanking")).click();
		
		String home = browser.getWindowHandle();
		Set<String> tabs = browser.getWindowHandles();
		tabs.forEach((t)->System.out.println(t));
		
		browser.switchTo().window(tabs.toArray()[1].toString());
		
		Assert.assertEquals(browser.getTitle().trim(),"Welcome to HDFC Bank NetBanking".trim());
		
		Thread.sleep(2000);
		
		browser.switchTo().window(home);
		
		Thread.sleep(2000);
		
		browser.quit();
		
	}
	
	@Test
	public void switchFrameTest() throws InterruptedException {
		WebDriver browser = BrowserUtility.getBrowserInstance("edge");
		browser.get("https://www.hdfcbank.com/");
		
		WebElement loginbtn = browser.findElement(By.xpath("//button[contains(text(),'Login')]"));
		
		Actions actions = new Actions(browser);
		actions.moveToElement(loginbtn).perform();
		
		browser.findElement(By.linkText("NetBanking")).click();
		

		Set<String> tabs = browser.getWindowHandles();
		browser.switchTo().window(tabs.toArray()[1].toString());
		
		browser.switchTo().frame("login_page");
		
		String text = browser.findElement(By.xpath("//div[@id='hdfcwelcmetxtId']")).getText();
		
		Assert.assertTrue(text.equalsIgnoreCase("Welcome to HDFC Bank NetBanking"));
		
		browser.findElement(By.name("fldLoginUserId")).sendKeys("1234567");
		
		Thread.sleep(2000);
		
		browser.quit();
	}
	
	@Test
	public void handlingAlert() throws InterruptedException {
		WebDriver browser = BrowserUtility.getBrowserInstance("edge");
		browser.get("https://www.hdfcbank.com/");
		
		WebElement loginbtn = browser.findElement(By.xpath("//button[contains(text(),'Login')]"));
		
		Actions actions = new Actions(browser);
		actions.moveToElement(loginbtn).perform();
		
		browser.findElement(By.linkText("NetBanking")).click();
		

		Set<String> tabs = browser.getWindowHandles();
		browser.switchTo().window(tabs.toArray()[1].toString());
		
		browser.switchTo().frame("login_page");
		
		browser.findElement(By.linkText("CONTINUE")).click();
		
		Alert alert = browser.switchTo().alert();
		
		Assert.assertEquals(alert.getText(), "Customer ID  cannot be left blank.");
		alert.accept();
		
		Thread.sleep(2000);
		
		browser.quit();
	}
	
	@Test
	public void contactUsAlert() throws InterruptedException {
		WebDriver browser = BrowserUtility.getBrowserInstance("edge");
		browser.get("http://ddta.deloitte.com/fluorescent/GetInTouch.html");
		
		browser.findElement(By.id("email")).sendKeys("dalve@gmail.com");
		browser.findElement(By.id("subject")).sendKeys("details");
		browser.findElement(By.id("description")).sendKeys("Swapnil Dalve \n 12345678");
		
		browser.findElement(By.xpath("//button[@type='submit']")).click();
		
		Alert alert = browser.switchTo().alert();
		Thread.sleep(2000);
		alert.accept();
		
		browser.quit();
	}
	
	@Test
	public void testMap() throws InterruptedException {
		WebDriver browser = BrowserUtility.getBrowserInstance("edge");
		browser.get("http://ddta.deloitte.com/fluorescent/");

		Actions actions = new Actions(browser);
		
		actions.scrollToElement(browser.findElement(By.xpath("//*[@id=\"footers\"]/div[1]/div[2]"))).perform();
		
		//using xpath of map element
//		browser.switchTo().frame(browser.findElement(By.xpath("//*[@id=\"footers\"]/div[1]/div[1]/div[2]/div/div/iframe")));
		
		//using frame index
		browser.switchTo().frame(0);
		
		browser.findElement(By.linkText("View larger map")).click();
		
		Thread.sleep(5000);
		
		Set<String> tabs = browser.getWindowHandles();
		browser.switchTo().window(tabs.toArray()[1].toString());
		
		Assert.assertEquals(browser.getTitle().trim(), "Deloitte Towers - Google Maps");
		
		Thread.sleep(1000);
		
		browser.quit();
		
	}
	
	@Test
	public void testWebTables() throws InterruptedException {
		WebDriver browser = BrowserUtility.getBrowserInstance("edge");
		browser.get("http://demowebshop.tricentis.com/");
		browser.findElement(By.linkText("Log in")).click();
		
		browser.findElement(By.id("Email")).sendKeys("cena123@gmail.com");
		browser.findElement(By.id("Password")).sendKeys("Cena@1234");
		browser.findElement(By.xpath("//input[@value='Log in']")).click();
		
		browser.findElement(By.partialLinkText("Shopping cart")).click();
		
		WebElement tbody = browser.findElement(By.cssSelector(".cart tbody"));
		List<WebElement> trList = tbody.findElements(By.tagName("tr"));
		
		if(trList.size()>0) {
			Assert.assertEquals(trList.size(), 5);
			for(WebElement tr : trList) {
				List<WebElement> tds = tr.findElements(By.tagName("td"));
				Assert.assertEquals(tds.size(), 6);
				Thread.sleep(1000);
				tds.get(0).click();
			}
			
			browser.findElement(By.name("updatecart")).click();
		}
		
		Assert.assertEquals(browser.findElement(By.cssSelector("span[class='cart-qty']")).getText().trim(), "(0)");
		
		browser.quit();
		
	}
	
	
	@Test
	public void testTables2() {
		WebDriver browser = BrowserUtility.getBrowserInstance("edge");
		browser.get("http://ddta.deloitte.com/fluorescent/offers.html");
		
		
		WebElement thead = browser.findElement(By.cssSelector(".offer-table tr"));
		WebElement tbody = browser.findElement(By.xpath("/html/body/div[2]/div[1]/div/table/tbody"));
		
		
		
		for(WebElement th: thead.findElements(By.tagName("th"))) {
			System.out.print(th.getText()+"\t");
		}
		System.out.println("");
		
		List<WebElement> trs = tbody.findElements(By.tagName("tr"));
		
		for(WebElement tr : trs) {
			for(WebElement td: tr.findElements(By.tagName("td"))) {
				System.out.print(td.getText()+"\t");
			}
			System.out.println("");
		}
		
		browser.quit();
		
	}
	
	
}
