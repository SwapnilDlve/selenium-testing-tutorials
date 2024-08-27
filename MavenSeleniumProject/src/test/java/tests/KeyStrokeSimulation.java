package tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class KeyStrokeSimulation {
	
	@Test
	public void testSearchBox() throws InterruptedException {
		WebDriver browser = BrowserUtility.getBrowserInstance("edge");
		WebDriverWait wait = new WebDriverWait(browser, Duration.ofSeconds(10));
		Actions actions = new Actions(browser);
		
		browser.get("https://www.makemytrip.com/");
		
//		wait.until(ExpectedConditions.visibilityOf(browser.findElement(By.cssSelector("img[id='second-img']"))));
//		browser.findElement(By.id("webklipper-publisher-widget-container-notification-close-div")).click();
		
		Thread.sleep(10000);
		
		WebElement fromCity = browser.findElement(By.id("fromCity"));
		WebElement toCity = browser.findElement(By.id("toCity"));
		
		
		
		actions.doubleClick(fromCity).sendKeys("b").pause(Duration.ofSeconds(3)).sendKeys("a").pause(Duration.ofSeconds(3)).sendKeys("n")
				.pause(Duration.ofSeconds(3)).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
		
		actions.doubleClick(toCity).sendKeys("p").pause(Duration.ofSeconds(3)).sendKeys("u").pause(Duration.ofSeconds(3)).sendKeys("n")
		.pause(Duration.ofSeconds(3)).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
		
		browser.quit();
		
		
	}
	
	
	@Test
	public void listCities() throws InterruptedException {
		WebDriver browser = BrowserUtility.getBrowserInstance("edge");
		browser.get("https://www.makemytrip.com/");
		
		Thread.sleep(10000);
		browser.switchTo().frame("webklipper-publisher-widget-container-notification-frame");
		browser.findElement(By.id("webklipper-publisher-widget-container-notification-close-div")).click();
		
		WebElement fromCity = browser.findElement(By.id("fromCity"));
		
		Actions actions = new Actions(browser);
		
		actions.doubleClick(fromCity).sendKeys("d").pause(Duration.ofSeconds(3)).sendKeys("e").pause(Duration.ofSeconds(3)).sendKeys("l")
		.pause(Duration.ofSeconds(3)).sendKeys(Keys.ARROW_DOWN).perform();
		
		Thread.sleep(4000);
		WebElement listbox = browser.findElement(By.xpath("//ul[@role='listbox']"));
		
		List<WebElement> listCity = listbox.findElements(By.tagName("li"));
		for(WebElement city: listCity) {
			if(city.getText().contains("DRT")) {
				System.out.println(city.getText());
			}
			
		}
		
		browser.quit();
	}
	
}
