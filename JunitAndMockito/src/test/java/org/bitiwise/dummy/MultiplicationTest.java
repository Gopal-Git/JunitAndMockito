package org.bitiwise.dummy;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MultiplicationTest {

	 @Test(expected = IllegalArgumentException.class)
	  public void testExceptionIsThrown() {
		 Multiplication multiplication = new Multiplication();
		 multiplication.multiply(1000, 5);
	  }
	
	@Test
	public void testMultiply() {
		Multiplication multiplication = new Multiplication();
		assertEquals("Muiltiplication of 4* 2 is 8", 8, multiplication.multiply(4, 2)); 
	}
}
