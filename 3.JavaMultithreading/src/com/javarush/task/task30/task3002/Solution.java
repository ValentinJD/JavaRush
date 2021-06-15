package com.javarush.task.task30.task3002;

/* 
Осваиваем методы класса Integer
*/
public class Solution {

    public static void main(String[] args) {
        System.out.println(convertToDecimalSystem("0x16")); //22
        System.out.println(convertToDecimalSystem("012"));  //10
        System.out.println(convertToDecimalSystem("0b10")); //2
        System.out.println(convertToDecimalSystem("62"));   //62
    }

    public static String convertToDecimalSystem(String s) {
        if(s.startsWith("0x")){//16
            String s1 = s.substring(2, s.length());
          return Integer.parseInt(s1, 16)+ "";
        }else if(s.startsWith("0b")){//2
          String s1 = s.substring(2, s.length());
          return Integer.parseInt(s1, 2)+ "";
        }else if(s.startsWith("0")){//8
          String s1 = s.substring(1, s.length());
          return Integer.parseInt(s1, 8)+ "";
        }else return Integer.parseInt(s, 10)+ "";
        
        //напишите тут ваш код
       
    }
}
