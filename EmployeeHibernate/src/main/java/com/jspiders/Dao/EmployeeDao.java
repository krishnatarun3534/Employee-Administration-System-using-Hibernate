package com.jspiders.Dao;

import com.jspiders.config.DBConfig;
import com.jspiders.entity.Employee;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class EmployeeDao {
    public void addEmployeeDao(Employee employee){
        Session session= DBConfig.getConnection();
        Transaction transaction = session.beginTransaction();
        try{
            session.persist(employee);
            transaction.commit();
            System.out.println("Added employee succesfully.");
        } catch (Exception e) {
            transaction.rollback();
            System.err.println("Add employee failed");
        }
        session.close();
    }
    public Employee getEmployee(String empId){
        Session session= DBConfig.getConnection();
        Transaction transaction = session.beginTransaction();
        String hql = "from Employee e where e.empId=:empId";
        Employee employee = session.createQuery(hql,Employee.class).setParameter("empId",empId).uniqueResult();
        return employee;
    }
    public void updateEmployeeSalDao(Integer id,Long sal){
        Session session= DBConfig.getConnection();
        Transaction transaction = session.beginTransaction();
        Employee employee = session.find(Employee.class,id);
        employee.setSalary(sal);
        try {
            session.merge(employee);
            transaction.commit();
            System.out.println("Succesfully employee salary updated");
        } catch (Exception e) {
            transaction.rollback();
            System.err.println("Failed to updated salary");
        }
    }
    public void deleteEmployeeDao(Integer id){
        Session session= DBConfig.getConnection();
        Transaction transaction = session.beginTransaction();
        Employee employee = session.find(Employee.class,id);
        try{
            session.remove(employee);
            transaction.commit();
            System.out.println("employee removed uccefully");
        } catch (Exception e) {
            transaction.rollback();
            System.err.println("employee deleted failed");
        }
    }
    public List<Employee> getAllEmployee(){
        Session session = DBConfig.getConnection();
        Transaction transaction=session.beginTransaction();
        return session.createQuery("from Employee",Employee.class).getResultList();
    }
}
