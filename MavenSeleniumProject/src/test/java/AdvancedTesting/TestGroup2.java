package AdvancedTesting;

import org.testng.annotations.Test;

public class TestGroup2 {
	@Test(groups = {"sanity","smoke"})
	public void test4() {
		System.out.println("test method 4");
	}
	
	@Test(groups = "smoke")
	public void test5() {
		System.out.println("test method 5");
	}
}
