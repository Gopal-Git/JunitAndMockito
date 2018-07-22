package org.bitwise.mockito;

import static org.mockito.Mockito.when;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

// @RunWith attaches a runner with the test class to initialize the test data
@RunWith(MockitoJUnitRunner.class)
public class MathApplicationTest {
	//@Mock annotation is used to create the mock object to be injected
	@Mock
	CalculatorService calcService;
	
   //@InjectMocks annotation is used to create and inject the mock object
   @InjectMocks 
   MathApplication mathApplication = new MathApplication();


   @Test
   public void testAdd(){
      //add the behavior of calc service to add two numbers
      when(calcService.add(11.0,20.0)).thenReturn(31.00);
      when(calcService.add(10.0,20.0)).thenReturn(30.00);
      //test the add functionality
      Assert.assertEquals(mathApplication.add(10.0, 20.0),30.0,0);
      Assert.assertEquals(mathApplication.add(11.0, 20.0),31.0,0);
   }
}