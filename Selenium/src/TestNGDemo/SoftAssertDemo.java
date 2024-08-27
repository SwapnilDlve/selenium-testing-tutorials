package TestNGDemo;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertDemo {
	@Test
	public void testTypesofAsserts() {
		
		SoftAssert sAssert = new SoftAssert();
		sAssert.assertEquals(10, 10);
		System.out.println("after assert 1");
		sAssert.assertEquals(10, 10.0);
		System.out.println("after assert 2");
		sAssert.assertEquals(10, "10");
		System.out.println("after assert 3");
		sAssert.assertAll();                       //without this statement it give test passed even if it is failed
		System.out.println("after assert all");
	}
}
