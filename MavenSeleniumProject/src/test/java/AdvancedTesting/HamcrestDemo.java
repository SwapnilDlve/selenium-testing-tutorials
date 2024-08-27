package AdvancedTesting;

import java.util.Arrays;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import org.testng.Assert;
import org.testng.annotations.Test;
import static AdvancedTesting.TempretureMature.*;
import static AdvancedTesting.AccountMatcher.*;
public class HamcrestDemo {
	@Test
	public void testdemo1() {
		String[] cities = {"banglore", "hyderabad", "chennai"};
		
		Assert.assertTrue(Arrays.asList(cities).contains("hyderabad"));
		
		assertThat(cities, hasItemInArray("hyderabad"));
		
		String msg = "hello";
		assertThat(msg, is(equalTo("hello")));
		
//		Assert.assertEquals(5, cars.size());
//		assertThat(cars, hasSize(5));
		
//		Assert.assertEquals(10, "10");
//		assertThat("10", is(10));
		
//		Assert.assertEquals("abc", 123);
//		assertThat("abc", is(123));
		
		String email = "askmail@email.com";
		assertThat(email, anyOf(endsWith(".in"),endsWith(".com"),endsWith(".co.in")));
		assertThat(email, allOf(startsWith("ask"),containsString("@"),endsWith(".com")));
		
//		assertThat(100.00, isAFever());
		
		assertThat("DEL-1232-34-788", isAValidAccount());
	}
}
