package com.javarush.task.task15.task1519;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;

/* 
Разные методы для разных типов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader (System.in));
        String value;
        Double d = null;
        ArrayList<String> arrStr = new ArrayList<>();
        while(true) {
            value = reader.readLine();

            if (value.equals("exit")) {
               //System.out.println("Введено exit");
                break;
            }
            //System.out.println("Добавляем в эррейлист значение " + value);
            arrStr.add(value);
        }

        for (String st: arrStr){

            try{
                //System.out.println("Берем из эррейлиста значение " + st);
                d=Double.parseDouble(st);
                if(st.contains(".")) {
                    print(d);
                    //System.out.println("Double");
                } else if(d>0 && d<128) {
                    short s = (short) Integer.parseInt(st);
                    print(s);
                    //System.out.println("Short");
                } else if(d<=0 || d>=128) {
                    Integer integer = new Integer (st);
                    print(integer);
                    //System.out.println("Integer");
                } /*else {
                    print(value);
                    //System.out.println("String");
                    //System.out.println("вызов метода Double.parseDouble" + d);
                }*/
            } catch (Exception e){
                print(st);
                //break;
            }
        }
        //напиште тут ваш код
    }

    public static void print(Double val) {
        System.out.println("Это тип Double, значение " + val);
    }

    public static void print(String val) {
        System.out.println("Это тип String, значение " + val);
    }

    public static void print(short val) {
        System.out.println("Это тип short, значение " + val);
    }

    public static void print(Integer val) {
        System.out.println("Это тип Integer, значение " + val);
    }
}
