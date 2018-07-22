package org.bitiwise.dummy;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class PrimeNumberCheckerTest {
   private Integer inputNumber;
   private Boolean expectedResult;
   private static PrimeNumberChecker primeNumberChecker;

//   @BeforeClass
//   public static void beforeClass(){
//	   System.out.println("BeforeClass annotation");
//   }
   
   @Before
   public void initialize() {
	   System.out.println("Before annotation");
      primeNumberChecker = new PrimeNumberChecker();
   }

   // Each parameter should be placed as an argument here
   // Every time runner triggers, it will pass the arguments
   // from parameters we defined in primeNumbers() method
	
   public PrimeNumberCheckerTest(Integer inputNumber, Boolean expectedResult) {
      this.inputNumber = inputNumber;
      this.expectedResult = expectedResult;
   }

   @Parameterized.Parameters
   public static Collection primeNumbers() {
      return Arrays.asList(new Object[][] {
         { 2, true },
         { 6, false },
         { 19, true },
         { 22, false },
         { 23, true }
      });
   }

   // This test will run 5 times since we have 5 parameters defined
   @Test
   public void testPrimeNumberChecker() {
      System.out.println("Parameterized Number is : " + inputNumber);
      assertEquals(expectedResult, 
      primeNumberChecker.validate(inputNumber));
   }
   
   
   @After
   public void afterAnnotation(){
	   System.out.println("After annotation");
   }
   
//   @AfterClass
//   public static void afterClassAnnotation(){
//	   System.out.println("AfterClass annotation");
//   }
}