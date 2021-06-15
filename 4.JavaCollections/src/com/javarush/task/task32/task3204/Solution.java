package com.javarush.task.task32.task3204;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

/* 
Генератор паролей
*/
public class Solution {
    private static List<String> listPasswords = new ArrayList<>();

    public static void main(String[] args) {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }


    public static ByteArrayOutputStream getPassword() {
        String abc = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        String r = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

        ByteArrayOutputStream password = new ByteArrayOutputStream();

        char randNum = numbers.charAt((int) (Math.random() * numbers.length())); //1 цифра
        password.write(randNum);
        char randAbc = Character.toLowerCase(abc.charAt((int) (Math.random() * abc.length())));  // 2 буква нижнего регистра
        password.write(randAbc);
        char randABC = Character.toUpperCase(abc.charAt((int) (Math.random() * abc.length()))); // 3 буква верхнего регистра
        password.write(randABC);

        for (int i = 0; i < 5; i++) {
            char random = r.charAt((int) (Math.random() * abc.length()));
            password.write(random);
        }

        String check = password.toString();

        if (!listPasswords.contains(check))
            listPasswords.add(check);
        else {
            check =  getPassword().toString();
        }

        return password;
    }
}