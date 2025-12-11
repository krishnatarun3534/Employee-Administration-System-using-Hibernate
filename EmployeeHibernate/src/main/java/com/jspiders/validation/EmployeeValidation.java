package com.jspiders.validation;

import com.jspiders.config.DBConfig;
import com.jspiders.entity.Employee;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class EmployeeValidation {
    public static void employeevalidation(String empId){
        Session session = DBConfig.getConnection();
        Transaction transaction = session.beginTransaction();
        String hql = "from Employee e where e.empId = :empId";
        Employee employee = session.createQuery(hql,Employee.class)
                .setParameter("empId",empId).uniqueResult();
        if(employee!=null){
            throw new RuntimeException("Employee already exist!");
        }
    }
    public static void employeeValidationEmpid(String empId){
        Session session = DBConfig.getConnection();
        Transaction transaction = session.beginTransaction();
        String hql = "from Employee e where e.empId = :empId";
        Employee employee = session.createQuery(hql,Employee.class)
                .setParameter("empId",empId).uniqueResult();
        if(employee==null){
            throw new RuntimeException("Employee doesn't exist!");
        }
    }
    public static Integer employeeValidationEmpId(String empId){
        Session session = DBConfig.getConnection();
        Transaction transaction = session.beginTransaction();
        String hql = "from Employee e where e.empId = :empId";
        Employee employee = session.createQuery(hql,Employee.class)
                .setParameter("empId",empId).uniqueResult();
        if(employee==null){
            throw new RuntimeException("Employee doesn't exist!");
        }
        return employee.getId();
    }
}
