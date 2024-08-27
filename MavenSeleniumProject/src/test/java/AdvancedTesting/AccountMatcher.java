package AdvancedTesting;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

public class AccountMatcher extends TypeSafeMatcher<String> {

	@Override
	public void describeTo(Description description) {
		// TODO Auto-generated method stub
		description.appendText("The Account no is not in valid format \n");
		description.appendText("Valid Account format is DEL-xxxx-xx-778");
	}

	@Override
	protected boolean matchesSafely(String acntNo) {
		// TODO Auto-generated method stub
		
		return (acntNo.startsWith("DEL") && acntNo.endsWith("778"));
	}
	
	public static Matcher<String> isAValidAccount() {
		return new AccountMatcher();
	}

}
