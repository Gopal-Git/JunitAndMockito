package org.bitiwise.dummy;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AddtionTest {

	@Test
	public void testAdd() {
		// The first one creates an instance of the object to be tested,
		// referred to as SUT (System Under Test).
		
		Addition addition = new Addition();
		
		// it is time to invoke those methods of the SUT, which represent
		// a certain behavior the test intends to verify. Often this is just a
		// single method and the outcome is stored in local variables.
		
		int actualValue = addition.add(4, 4);

		// The last section of the test is responsible to verify whether the
		// expected outcome of a given behavior has been obtained.
		
		assertEquals("Addition of 4 and 4 is 8 ", 8, actualValue);
		
	}
}
