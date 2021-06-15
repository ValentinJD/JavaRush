package com.javarush.task.task22.task2212;



import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Проверка номера телефона
*/
public class Solution {
    public static boolean checkTelNumber(String telNumber) {
        if(telNumber == null) return false;
        Pattern pattern1 = Pattern.compile("(\\+\\d+|\\d{5})(\\(\\d{3}\\))?\\d\\-?\\d{2}\\-?\\d{2,4}$");
        Matcher match = pattern1.matcher(telNumber);
        if (match.matches()){ // проверка на ( и )
            return  true;
        } else return false;
    }

    public static void main(String[] args) {
        String telNumber = "+1(012)5012323";
        System.out.println(checkTelNumber(telNumber));

    }
}
