package features;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BookStepDef {
	
	@Before
	public void beforeScenario() {
		System.out.println("Before Scenario");
	}
	
	@After
	public void afterScenario() {
		System.out.println("After Scenario");
	}
	
	@BeforeStep
	public void beforeStep() {
		System.out.println("Before Scenario");
	}
	
	@AfterStep
	public void afterStep() {
		System.out.println("After Step");
	}
	
	@BeforeAll              //before all features and scenarios
	public static void beforeAll() {
		System.out.println("Before All");
	}
	
	@AfterStep          //after all features and scenarios
	public static void afterAll() {
		System.out.println("After All");
	}
	
	
	@Given("the following are the books in the store")
	public void the_following_are_the_books_in_the_store(List<Map<String, String>> datatable) {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
	    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
	    // Double, Byte, Short, Long, BigInteger or BigDecimal.
	    //
	    // For other transformations you can register a DataTableType.
//	    throw new io.cucumber.java.PendingException();
//		List<List<String>> asList = dataTable.asLists();
//		
//		for(int i=1;i<asList.size();i++) {
//			System.out.println(asList.get(i));
//		}
		
		for(int i =1; i<datatable.size();i++) {
			Set<String> keySet = datatable.get(i).keySet();
			for(String key:keySet) {
				System.out.print(datatable.get(i).get(key)+"\t");
			}
			System.out.println("");
		}
	}

	@When("the user search for book by name")
	public void the_user_search_for_book_by_name() {
	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
	}

	@Then("user will get the book info")
	public void user_will_get_the_book_info(List<String> cities) {
	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
		for(String city:cities) {
			System.out.println(city);
		}
	}

}
