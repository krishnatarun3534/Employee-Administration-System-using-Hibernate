package com.jspidersTest.config;

import com.jspiders.config.DBConfig;
import org.hibernate.Session;

public class DBConnectionTest {
    static void main(String[] args) {
        getConnectionTest();
    }
    public static void getConnectionTest(){
        System.out.println("connection to database");
        try{
            Session session = DBConfig.getConnection();
            System.out.println("Succesfully connected");
        } catch (Exception e) {
            System.err.println("Connection failed");
            throw new RuntimeException(e);
        }
    }
}
