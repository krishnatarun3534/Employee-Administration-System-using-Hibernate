package com.jspiders.service;

import com.jspiders.Dao.EmployeeDao;
import com.jspiders.entity.Address;
import com.jspiders.entity.Employee;
import com.jspiders.validation.EmployeeValidation;

import java.util.List;
import java.util.Scanner;

public class EmployeeService {
    Scanner sc = new Scanner(System.in);
    public void addemployee(){
        Employee employee = new Employee();

        System.out.println("Enter employee id : ");
        String empId = sc.next().toUpperCase();
        employee.setEmpId(empId);

        EmployeeValidation.employeevalidation(empId);

        System.out.println("Enter employee name : ");
        employee.setName(sc.next().toUpperCase());

        System.out.println("Enter employee role : ");
        employee.setRole(sc.next().toUpperCase());

        System.out.println("Enter employee phone number : ");
        employee.setPhoneNumber(sc.next());

        System.out.println("Enter employee Sal");
        employee.setSalary(sc.nextLong());

        Address address = new Address();

        System.out.println("Enter employee state : ");
        address.setState(sc.next().toUpperCase());

        System.out.println("Enter employee country : ");
        address.setCountry(sc.next().toUpperCase());

        System.out.println("Enter employee country code : ");
        address.setCountryCode(sc.nextInt());

        employee.setAddress(address);

        EmployeeDao employeeDao = new EmployeeDao();
        employeeDao.addEmployeeDao(employee);
    }
    public void getEmployee(){
        System.out.println("Enter employee id : ");
        String empId = sc.next().toUpperCase();
        EmployeeValidation.employeeValidationEmpid(empId);

        EmployeeDao employeeDao = new EmployeeDao();
        System.out.println(employeeDao.getEmployee(empId));
    }
    public void updatateEmployeeSal(){

        System.out.println("Enter employee id : ");
        String empId = sc.next().toUpperCase();
        Integer id = EmployeeValidation.employeeValidationEmpId(empId);

        System.out.println("Enter employee salary : ");
        Long sal = sc.nextLong();

        EmployeeDao employeeDao = new EmployeeDao();
        employeeDao.updateEmployeeSalDao(id,sal);


    }
    public void deleteEmployee(){
        System.out.println("Enter employee id : ");
        String empId = sc.next().toUpperCase();
        Integer id = EmployeeValidation.employeeValidationEmpId(empId);

        EmployeeDao employeeDao = new EmployeeDao();
        employeeDao.deleteEmployeeDao(id);
    }
    public void getAllEmpoyee(){
        EmployeeDao employeeDao = new EmployeeDao();
        List<Employee> employeeList = employeeDao.getAllEmployee();
        for(Employee e : employeeList){
            System.out.println(e);
        }
    }

}
