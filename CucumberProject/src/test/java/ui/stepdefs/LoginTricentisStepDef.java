package ui.stepdefs;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.PageFactory;

import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPages;
import util.SharedDriver;

public class LoginTricentisStepDef {
	
	WebDriver browser;
	
	public LoginTricentisStepDef(SharedDriver browser) {
		// TODO Auto-generated constructor stub
		this.browser = browser;
		PageFactory.initElements(browser, LoginPages.class);
	}
	
//	@BeforeAll
//	public static void beforeAll(){
//		browser = new EdgeDriver();
//		browser.manage().window().maximize();
//		browser.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//	}
//	
//	@AfterAll
//	public static void afterAll() {
//		browser.quit();
//	}
	
	
	@Given("The url of the demo web shop {string}")
	public void the_url_of_the_demo_web_shop(String url) {
	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//		init();
		browser.get(url);
		Assert.assertEquals("Demo Web Shop. Login", browser.getTitle());
		
	}

	@When("The user enters valid email {string}")
	public void the_user_enters_valid_email(String email) {
	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
		LoginPages.Email.sendKeys(email);
	}

	@When("The user enters valid password {string}")
	public void the_user_enters_valid_password(String pwd) {
	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
		LoginPages.Password.sendKeys(pwd);
	}

	@When("The user clicks on login button")
	public void the_user_clicks_on_login_button() {
	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
		LoginPages.Login.click();
	}

	@Then("The user is in the shopping page")
	public void the_user_is_in_the_shopping_page() {
	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
		Assert.assertEquals("Demo Web Shop", browser.getTitle());
	}

	@Then("Not on the login page")
	public void not_on_the_login_page() {
	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
	    Assert.assertFalse("Demo Web Shop. Login".equalsIgnoreCase(browser.getTitle()));
	    LoginPages.Logout.click();
//	    end();
	}
	
	//Invalid Steps
	
	@When("The user enters Invalid email {string}")
	public void the_user_enters_invalid_email(String email) {
	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
		LoginPages.Email.sendKeys(email);
	}

	@When("The user enters Invalid password {string}")
	public void the_user_enters_invalid_password(String pwd) {
	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
		LoginPages.Password.sendKeys(pwd);
	}

	@Then("The user is in the login page")
	public void the_user_is_in_the_login_page() {
	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
		 Assert.assertTrue("Demo Web Shop. Login".equalsIgnoreCase(browser.getTitle()));
	}

	@Then("Not on the shopping page")
	public void not_on_the_shopping_page() {
	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
		 Assert.assertFalse("Demo Web Shop".equalsIgnoreCase(browser.getTitle()));
//		 end();
	}

}
