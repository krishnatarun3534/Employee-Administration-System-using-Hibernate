package com.jspiders.extra;

import java.util.Random;

public class Otp {
    public static String otp(){
        Random random = new Random();
        Long otp = 1000+random.nextLong(9000);
        return String.valueOf(otp);
    }
    public static boolean otpCheck(String autoOtp,String  enteredOtp){
        if(autoOtp.equals(enteredOtp)){
            return true;
        }
        return false;
    }
}
