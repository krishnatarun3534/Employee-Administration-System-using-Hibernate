package com.jspiders.userMin;

import com.jspiders.service.EmployeeService;
import com.jspiders.service.UserService;

import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    static void main() {
        user();
    }
    public static void user() {
        UserService userService = new UserService();

        System.out.println("Choose your option ");
        System.out.println("1.Register");
        System.out.println("2.User Login");
        int choice = sc.nextInt();
        switch (choice){
            case 1:
                userService.register();
                break;
            case 2:
                int  count = userService.userLogin();
                if(count==1){
                    System.out.println("user exists");
                    userLoginSuccess();
                }else {
                    System.err.println("User has not exist!");
                    Main.user();
                }
                break;
        }
    }
    public static void userLoginSuccess(){
        EmployeeService employeeService = new EmployeeService();
        System.out.println("Enter what do you user want  : ");
        System.out.println("1.add employee");
        System.out.println("2.get employee");
        System.out.println("3.update employee sal");
        System.out.println("4.delete employee");
        System.out.println("5.get All Employees");
        int choice = sc.nextInt();
        switch (choice){
            case 1:
                employeeService.addemployee();
                userLoginSuccess();
                break;
            case 2:
                employeeService.getEmployee();
                userLoginSuccess();
                break;
            case 3:
                employeeService.updatateEmployeeSal();
                userLoginSuccess();
                break;
            case 4:
                employeeService.deleteEmployee();
                userLoginSuccess();
                break;
            case 5:
                employeeService.getAllEmpoyee();
                userLoginSuccess();
                break;
            default:
                System.exit(0);
        }
    }

}
