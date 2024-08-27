package noui.stepdefs;

import io.cucumber.java.en.Given;

public class CucumberStepDefs

{
	@Given("Sarah/She has {double} cucumber(s) in her bag")
	public void sarah_has_cucumbers_in_her_bag(Double cucumbersdata)
	{
	    System.out.println("No.of cucumbers: " +cucumbersdata);
	}
}
