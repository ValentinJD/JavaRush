package com.javarush.task.task33.task3310;

import java.math.BigInteger;
import java.security.SecureRandom;

public class Helper {
    public static String generateRandomString() {
        SecureRandom random = new SecureRandom();
        return new BigInteger(130, random).toString(36);
    }// который будет генерировать случайную строку. Воспользуйся для этого классами SecureRandom и BigInteger.
    public static void printMessage(String message){
        System.out.println(message);
    }
}
