package AdvancedTesting;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

public class TempretureMature extends TypeSafeMatcher<Double> {

	@Override
	public void describeTo(Description description) {
		// TODO Auto-generated method stub
		description.appendText("The tempreture must be greater than 102.00");
	}

	@Override
	protected boolean matchesSafely(Double temp) {
		// TODO Auto-generated method stub
		
		return temp>102.00?true:false;
	}
	
	public static Matcher<Double> isAFever() {
		return new TempretureMature();
	}

}
