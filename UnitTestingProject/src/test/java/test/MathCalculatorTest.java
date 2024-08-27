package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class MathCalculatorTest {

	static MathCalculator mcalc;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		mcalc = new MathCalculator();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		mcalc =null;
	}
	
	@DisplayName("Add Test")
	@Order(1)
	@Test
	void testAddition() {
		double actual = mcalc.addition(5, 5);
		double expected =10.00;
		
		assertEquals(expected, actual);
	}

	@Order(2)
	@Test
	void testSubstraction() {
		double actual = mcalc.substraction(5, 5);
		double expected =0.00;
		
		assertEquals(expected, actual);
	}

	@Order(3)
	@Test
	void testMultiplication() {
		double actual = mcalc.multiplication(5, 5);
		double expected =25.00;
		
		assertEquals(expected, actual);
	}

	@Order(4)
	@Test
	void testDivision() {
		double actual = mcalc.division(5, 5);
		double expected =1.00;
		
		assertEquals(expected, actual);
	}

}
