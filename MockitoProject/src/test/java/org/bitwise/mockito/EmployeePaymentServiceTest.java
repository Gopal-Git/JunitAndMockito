package org.bitwise.mockito;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

public class EmployeePaymentServiceTest {
	private int testWrkingDays = 25;
	private int testSalaryPerDay = 1000;
	private int testSalary = 25000;
	private String empId = "emp100";

	// Mock class instance using Spy
	@Spy
	private EmployeePaymentService employeePaymentService;

	/**
	 * Setup before test.
	 */
	@Before
	public void beforeMethod() {
		employeePaymentService = new EmployeePaymentService();
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testGetSalary() {
		// Tell mockito to mock only the processPay Method
		when(employeePaymentService.processPay(anyString(), anyInt(), anyInt())).thenReturn(testSalary);
		
		// Actual call made
		int returnedWrkingDays = employeePaymentService.getNoOfWorkingDays(empId);
		Assert.assertEquals(returnedWrkingDays, testWrkingDays);

		// Actual call made
		int returnedSalaryPerDay = employeePaymentService.getSalaryPerDay(empId);
		Assert.assertEquals(returnedSalaryPerDay, testSalaryPerDay);
		
		// Mock call
		int returnedSalary = employeePaymentService.processPay(empId, testWrkingDays, testSalaryPerDay);
		Assert.assertEquals(testSalary, returnedSalary);

	}
}
