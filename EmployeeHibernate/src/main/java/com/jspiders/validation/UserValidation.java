package com.jspiders.validation;

import com.jspiders.entity.User;

public class UserValidation {
    public static void UserNamePassword(User user){
        testUsername(user.getUserName());
        testUserPassword(user.getPassword());
    }
    public static void testUsername(String name){
        if(name.length()<5){
            throw new RuntimeException("User name length should be greater than 5 character");
        }
    }

    public static void testUserPassword(String password){
        if (password.length() < 7 ||
                !password.matches(".*[A-Z].*") ||
                !password.matches(".*[0-9].*") ||
                !password.matches(".*[!@#$%&].*")) {

            throw new RuntimeException(
                    "Password should contain at least one capital letter, one special symbol, and one numerical digit."
            );
        }

    }
}
