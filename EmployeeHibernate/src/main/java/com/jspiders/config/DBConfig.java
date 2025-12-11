package com.jspiders.config;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DBConfig {
    static Session session=null;
    static {
        System.out.println("load configuration");
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        System.out.println("create session factory");
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        System.out.println("create session");
        session=sessionFactory.openSession();
    }
    public static Session getConnection(){
        return session;
    }
}
