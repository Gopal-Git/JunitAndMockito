package org.bitwise.mockito;

public class EmployeePaymentService {

    /**
     * @param empId employee id of Employee.
     * @return number of days the employee has worked.
     */
    public int getNoOfWorkingDays(String empId) {
        // default value
        int noOfWorkingDays = 0;
        // code for getting number of working Days. All logic for this is implemented
           //in this method itself
        noOfWorkingDays = 25;

        return noOfWorkingDays;
    }

    /**
     * @param empId employee id of Employee.
     * @return salary per day of the employee.
     */
    public int getSalaryPerDay(String empId) {
        // default value
        int salaryPerDay = 0;
        // code for getting salary per day. All logic for this is implemented
           //in this method itself.
        salaryPerDay = 1000;

        return salaryPerDay;
    }

    /**
     * This method is not calculated here but a third party method is called
     * 
     * @param empId
     * @param empWrkingDays
     * @param empSalaryPerDay
     * @return
     */
    public int processPay(String empId, int empWrkingDays, int empSalaryPerDay) {
        // code for processing is not done internally here, but a third party
           // external API call is made.

      //third party API call
        // return thirdparty.getSalaryThirdPartyCall(empId,empWrkingDays,empSalaryPerDay);

        // returning some default value
        return 20000;
    }

}