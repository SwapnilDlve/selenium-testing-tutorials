package tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MercuryToursRegistration {
	
	@Test
	public void testFlightBooking() throws InterruptedException {
		//Initialize browser
		WebDriver browser = BrowserUtility.getBrowserInstance("edge");
		browser.get("https://demo.guru99.com/test/newtours/reservation.php");
		
		
		
		browser.findElement(By.cssSelector("input[value='roundtrip']")).click();
		
		browser.findElement(By.name("passCount")).sendKeys("3");
		
//		WebElement passCount = browser.findElement(By.name("passCount"));
		
		
		WebElement fromPort = browser.findElement(By.name("fromPort"));
		WebElement toPort = browser.findElement(By.name("toPort"));
		
		browser.findElement(By.name("fromMonth")).sendKeys("October");
		browser.findElement(By.name("fromDay")).sendKeys("29");
		
		browser.findElement(By.name("toMonth")).sendKeys("October");
		browser.findElement(By.name("toDay")).sendKeys("31");
		
		browser.findElement(By.cssSelector("input[value='First']")).click();
		
		browser.findElement(By.name("airline")).sendKeys("Pangea Airlines");
		
		Select fromCity = new Select(fromPort);
		List<WebElement> options1 = fromCity.getOptions();
		
		Select toCity = new Select(toPort);
		List<WebElement> options2 = toCity.getOptions();
		
		Assert.assertEquals(options1.size(), 10);
		Assert.assertEquals(options2.size(), 10);
		
		for(WebElement op1:options1) {
			fromCity.selectByValue(op1.getText());
			for(WebElement op2: options2) {
				if(op1.getText().equalsIgnoreCase(op2.getText())) {
					continue;
				}
				toCity.selectByValue(op2.getText());
				Thread.sleep(1000);
			}
		}
		
		browser.quit();		
	}
	
}
