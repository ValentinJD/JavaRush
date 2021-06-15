package com.javarush.task.task06.task0611;

/* 
Класс StringHelper
*/

public class StringHelper {
    public static String multiply(String s) {
        String result = "";
        for (int i=0; i<5; i++){
            result = result + s;
        }
        //напишите тут ваш код
        return result;
    }

    public static String multiply(String s, int count) {
        String result = "";
        for (int i=0; i<count; i++){
            result = result + s;
        }
        //напишите тут ваш код
        return result;
    }

    public static void main(String[] args) {
        String s1 = StringHelper.multiply("Амиго");
        System.out.println(s1);
        String s2 = StringHelper.multiply("Амиго", 2);
        System.out.println(s2);

    }
}
