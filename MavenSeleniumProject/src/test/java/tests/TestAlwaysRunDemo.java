package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestAlwaysRunDemo {
	
	@Test(dependsOnMethods = "testMethod2")
	public void testMethod1() {
		System.out.println("Test method 1");
	}
	
	@Test(dependsOnMethods = "testMethod3", alwaysRun = true)
	public void testMethod2() {
		System.out.println("Test method 2");
	}
	
	@Test
	public void testMethod3() {
		Assert.assertTrue(false);
		System.out.println("Test method 3");
	}
}
