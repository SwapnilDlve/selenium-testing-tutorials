package features;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDefs {
	
	private static EdgeDriver browser;

	@BeforeAll
	public static void beforeAll(){
		browser = new EdgeDriver();
		browser.manage().window().maximize();
		browser.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	@AfterAll
	public static void afterAll() {
		browser.quit();
	}
	
	
	@Given("{string} Page is Visible to Sean")
	public void page_is_visible_to_sean(String msg) {
	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
		browser.get("http://ddta.deloitte.com/fluorescent/login.jsp");
		Assert.assertTrue(browser.getTitle().equalsIgnoreCase(msg));
	}

	@When("Sean Logins to page using {string} and {string}")
	public void sean_logins_to_page_using_and(String uid, String pwd) {
	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
		browser.findElement(By.id("uid")).sendKeys(uid);
		browser.findElement(By.id("pwd")).sendKeys(pwd);
		browser.findElement(By.id("submit")).click();
	}

	@Then("Sean sees Message {string}")
	public void sean_sees_message(String msg) {
	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
		WebElement loginMessage = browser.findElement(By.xpath("//*[@id=\"headers\"]/div/div/header/div[1]/div/div/div/div[3]/div[2]/div[4]/div/ul/li/span"));
		Assert.assertTrue(loginMessage.getText().contains(msg));
		browser.findElement(By.linkText("Logout")).click();
	}
}
