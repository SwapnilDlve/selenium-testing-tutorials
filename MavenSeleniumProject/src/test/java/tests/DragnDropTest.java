package tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v118.browser.Browser;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DragnDropTest {
		
	@Test
	public static void testDnD() {
		WebDriver browser = BrowserUtility.getBrowserInstance("edge");
		browser.get("https://demos.telerik.com/aspnet-ajax/treeview/examples/overview/defaultcs.aspx");
		
		WebElement dragFrom = browser.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceholder1_RadTreeView1\"]/ul/li/ul/li[3]/ul/li[1]/div/div"));
		WebElement dragTo = browser.findElement(By.id("ctl00_ContentPlaceholder1_priceChecker"));
		
		Actions action = new Actions(browser);
		
//		action.clickAndHold(dragFrom).pause(Duration.ofSeconds(3)).release(dragTo).perform();
		
		action.dragAndDrop(dragFrom, dragTo).perform();
		
		WebDriverWait wait = new WebDriverWait(browser, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.invisibilityOfElementWithText(By.id("ctl00_ContentPlaceholder1_Label1"), "Drop a package here to check price"));
		
		String text = browser.findElement(By.id("ctl00_ContentPlaceholder1_Label1")).getText();
		
		Assert.assertTrue(text.contains("$3999"));
		System.out.println(text);
		
		browser.quit();
	}
	
	
	@Test
	public void testDnd2() throws InterruptedException {
		WebDriver browser = BrowserUtility.getBrowserInstance("edge");
		browser.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
		
		WebDriverWait wait = new WebDriverWait(browser, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfAllElements(browser.findElement(By.id("draggable")),browser.findElement(By.id("droptarget"))));
		
		WebElement dragFrom = browser.findElement(By.id("draggable"));
		WebElement dragTo = browser.findElement(By.id("droptarget"));
		
		Actions actions = new Actions(browser);
		
		actions.dragAndDrop(dragFrom, dragTo).perform();
		
		wait.until(ExpectedConditions.invisibilityOfElementWithText(By.id("droptarget"), "Drag the small circle here."));
		
		Assert.assertTrue(browser.findElement(By.id("droptarget")).getText().contains("You did great!"));
		
		browser.quit();
	}
	
}
