package com.jspidersTest.employeeService;

import com.jspiders.service.EmployeeService;

public class employeeServiceTest {
    static void main() {
        testGetAllEmployee();
    }
    static EmployeeService employeeService = new EmployeeService();
    private static void testEmployee() {
        employeeService.addemployee();
    }
    public static void testEmployeeGet(){
        employeeService.getEmployee();
    }
    private static void testUpdateSal(){
        employeeService.updatateEmployeeSal();
    }
    private static void testDeleteEmployee(){
        employeeService.deleteEmployee();
    }
    private static void testGetAllEmployee(){
        employeeService.getAllEmpoyee();
    }

}
