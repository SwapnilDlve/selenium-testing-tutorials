package noui.stepdefs;

import org.junit.Assert;

import features.Person;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ShoutStepDefs {
	private Person sean;

	@Given("Sean is {int} meters away from Lucia")
	public void sean_is_meters_away_from_lucia(Integer distance) {
	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
		sean = new Person();
		sean.setDistance(distance);
	}

	@When("Sean shouts {string}")
	public void sean_shouts(String msg) {
	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
		sean.setMessage(msg);
	}

	@Then("Lucia listens to the message")
	public void lucia_listens_to_the_message() {
	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
		String msg = sean.getMessage();
		Assert.assertTrue(msg.equalsIgnoreCase("Free Coffee"));
	}
	
	@Then("Lucia cannot listen to the message")
	public void lucia_cannot_listen_to_the_message() {
	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
		String msg = sean.getMessage();
		Assert.assertNull(msg);
	}
}
