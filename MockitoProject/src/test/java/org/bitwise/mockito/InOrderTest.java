package org.bitwise.mockito;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class InOrderTest {
		//@Mock annotation is used to create the mock object to be injected
		@Mock
		CalculatorService calcService;
		
	   //@InjectMocks annotation is used to create and inject the mock object
	   @InjectMocks 
	   MathApplication mathApplication = new MathApplication();
	   
	   @Test
		public void testAddAndSubtract() {

			// add the behavior to add numbers
			when(calcService.add(20.0, 10.0)).thenReturn(30.0);

			// subtract the behavior to subtract numbers
			when(calcService.subtract(20.0, 10.0)).thenReturn(10.0);

			// test the add functionality
			Assert.assertEquals(mathApplication.add(20.0, 10.0), 30.0, 0);

			// test the subtract functionality
			Assert.assertEquals(mathApplication.subtract(20.0, 10.0), 10.0, 0);

			// create an inOrder verifier for a single mock
			InOrder inOrder = inOrder(calcService);

			// following will make sure that add is first called then subtract
			// is called.
			inOrder.verify(calcService).add(20.0, 10.0);
			inOrder.verify(calcService).subtract(20.0, 10.0);
		}
}
