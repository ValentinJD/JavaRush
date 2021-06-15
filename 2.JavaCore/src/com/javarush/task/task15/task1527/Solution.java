package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) {
        String url=null;
        //BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        /*try {
            url = reader.readLine();
        } catch (Exception e){}
        while (true){
        }*/
        url = "http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo";
        int numQuestion = url.indexOf('?');
        String subUrl = url.substring(numQuestion+1, url.length());
        ArrayList<String> array = new ArrayList();
        int startIndex=0;
        int endIndex=0;
        while (true){
            if (startIndex!=0){

                startIndex = subUrl.indexOf('&', endIndex);

            }
            endIndex = subUrl.indexOf('=', endIndex);
            String param1 = url.substring(startIndex+1, endIndex);
            System.out.println(param1);
            array.add(param1);
        }





        //add your code here
    }

    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}
