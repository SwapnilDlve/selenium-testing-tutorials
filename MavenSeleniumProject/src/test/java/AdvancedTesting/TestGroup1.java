package AdvancedTesting;

import org.testng.annotations.Test;

public class TestGroup1 {
	@Test(groups = {"dryrun","smoke"})
	public void test1() {
		System.out.println("test method 1");
	}
	
	@Test(groups = "smoke")
	public void test2() {
		System.out.println("test method 2");
	}
	
	@Test(groups = "sanity")
	public void test3() {
		System.out.println("test method 3");
	}
}
