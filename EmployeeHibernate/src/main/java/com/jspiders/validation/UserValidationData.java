package com.jspiders.validation;

import com.jspiders.config.DBConfig;
import com.jspiders.entity.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UserValidationData {
    public static int userNamePasswordCheck(String userName,String password){
        Session session = DBConfig.getConnection();
        Transaction transaction = session.beginTransaction();


        String hql = "FROM User u WHERE u.userName = :userName AND u.password = :password";
        User user = (User) session.createQuery(hql)
                .setParameter("userName", userName)
                .setParameter("password", password)
                .uniqueResult();

        if (user != null) {
            return 1;
        }
        return 0;
    }
}
