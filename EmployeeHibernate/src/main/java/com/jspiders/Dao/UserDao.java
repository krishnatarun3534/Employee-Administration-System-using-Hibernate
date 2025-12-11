package com.jspiders.Dao;

import com.jspiders.config.DBConfig;
import com.jspiders.entity.User;
import com.jspiders.validation.UserValidation;
import com.jspiders.validation.UserValidationData;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UserDao {
    public void AddNewUser(User user){
        Session session = DBConfig.getConnection();
        Transaction transaction = session.beginTransaction();

        int count = UserValidationData.userNamePasswordCheck(user.getUserName(),user.getPassword());
        if(count==0){
            session.persist(user);
            transaction.commit();
            System.out.println("😊 user registered succesfully");
        }else {
            System.err.println("😟 user registered already.");
            transaction.rollback();
        }
        session.close();
    }
}
