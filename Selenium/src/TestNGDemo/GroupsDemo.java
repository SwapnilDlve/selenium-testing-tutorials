package TestNGDemo;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class GroupsDemo {
	@Test(groups = {"smoke"})
	public void Demo1() {
		System.out.println("Demo1");
	}

	@Test
	public void Demo2() {
		System.out.println("Demo2");
	}
	
	@Test(groups = {"smoke"})
	public void Demo3() {
		System.out.println("Demo3");
	}
	
	@Test
	@Parameters({"uid","pwd"})
	public void Demo3(String uid,String pwd) {
		System.out.println(uid+"->"+pwd);
	}
	
}
