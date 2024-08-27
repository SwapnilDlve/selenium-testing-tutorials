package test;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.internal.verification.VerificationModeFactory;

public class MockitoDemo {
	@Test
	public void testMethod() {
		@SuppressWarnings("unchecked")
		List<String> mockedList = Mockito.mock(List.class);
		
		mockedList.add("first-element");
		mockedList.add("second-element");
		mockedList.add("third-element");
		mockedList.add("third-element");
		mockedList.clear();

		verify(mockedList).add("first-element");
		verify(mockedList).add("second-element");
		verify(mockedList, VerificationModeFactory.times(2)).add("third-element");

		verify(mockedList).clear();
	}

	@Test
	void testCalc() {
		System.out.println("**--- Test testCalc executed ---**");

		AddService addService = Mockito.mock(AddService.class);


		int num1 = 11;
		int num2 = 12;
		int expected = 23;

		when(addService.add(num1, num2)).thenReturn(expected);


	}

}

