package com.jspiders.service;

import com.jspiders.Dao.UserDao;
import com.jspiders.entity.User;
import com.jspiders.enums.UserGender;
import com.jspiders.extra.Otp;
import com.jspiders.validation.UserValidation;
import com.jspiders.validation.UserValidationData;

import java.util.Scanner;

public class UserService {
    Scanner sc = new Scanner(System.in);
    public void register(){
        User user = new User();
        System.out.println("Enter user name : ");
        user.setUserName(sc.next());

        System.out.println("Enter user gender : ");
        user.setGender(UserGender.valueOf(sc.next().toUpperCase()));

        System.out.println("enter phone number : ");
        user.setPhoneNo(sc.next());

        System.out.println("Enter user password : ");
        user.setPassword(sc.next());

        UserValidation.UserNamePassword(user);

        UserDao userDao = new UserDao();
        userDao.AddNewUser(user);
    }
    public Integer userLogin(){
        User user = new User();

        System.out.println("Enter user name : ");
        String userName = sc.next();
        System.out.println("Enter user password : ");
        String password = sc.next();

        String otp1 = Otp.otp();
        System.out.println("Enter otp : "+otp1);
        String otp2 = sc.next();

        Integer count=0;
        if( Otp.otpCheck(otp1,otp2)) {
            count = UserValidationData.userNamePasswordCheck(userName, password);
        }else {
            throw new RuntimeException("you entered wrong otp");
        }
        return count;
    }
}
