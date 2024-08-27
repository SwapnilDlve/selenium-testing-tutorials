package TestNGDemo;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class PriorityDemo {
	
	@BeforeMethod
	public void BeforeClass() {
		Reporter.log("Testing Started");
	}
	
	@AfterClass
	public void AfterClass() {
		Reporter.log("Testing ended");
	}
	
	@Test(dependsOnMethods = {"Demo4","Demo2"})
	public void Demo1() {
		System.out.println("Demo1");
	}

	@Test
	public void Demo2() {
		System.out.println("Demo2");
	}
	
	@Test(priority = 2)
	public void Demo3() {
		System.out.println("Demo3");
	}
	
	@Test(priority = 1)
	public void Demo4() {
		System.out.println("Demo4");
	}
	
	@Test(dependsOnMethods =  {"Demo4"})
	public void Demo5() {
		System.out.println("Demo5");
	}
	
	
	@Test
	public void Demo0() {
		System.out.println("Demo0");
	}
	
	@Test
	public void Demo7() {
		System.out.println("Demo7");
	}
	
	@Test
	@Parameters({"uid","pwd"})
	public void Demo8(String uid,String pwd) {
		System.out.println(uid+"->"+pwd);
	}
}
