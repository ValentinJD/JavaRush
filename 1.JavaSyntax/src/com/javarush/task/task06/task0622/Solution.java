package com.javarush.task.task06.task0622;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Числа по возрастанию
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());
        int c = Integer.parseInt(reader.readLine());
        int d = Integer.parseInt(reader.readLine());
        int e = Integer.parseInt(reader.readLine());

        int num=a;
        int min1=a;
        int min2=b;
        int min3=c;
        int min4=d;
        int min5=e;
        if(min1>min2) {
            num=min1;
            min1=min2;
            min2=num;
        }
        if(min2>min3) {
            num=min2;
            min2=min3;
            min3=num;
        }
        if(min3>min4) {
            num=min3;
            min3=min4;
            min4=num;
        }
        if(min4>min5) {
            num=min4;
            min4=min5;
            min5=num;
        }
        if(min1>min2) {
            num=min1;
            min1=min2;
            min2=num;
        }
        if(min2>min3) {
            num=min2;
            min2=min3;
            min3=num;
        }
        if(min3>min4) {
            num=min3;
            min3=min4;
            min4=num;
        }
        if(min4>min5) {
            num=min4;
            min4=min5;
            min5=num;
        }
        if(min1>min2) {
            num=min1;
            min1=min2;
            min2=num;
        }
        if(min2>min3) {
            num=min2;
            min2=min3;
            min3=num;
        }
        if(min3>min4) {
            num=min3;
            min3=min4;
            min4=num;
        }
        if(min4>min5) {
            num=min4;
            min4=min5;
            min5=num;
        }
        if(min1>min2) {
            num=min1;
            min1=min2;
            min2=num;
        }
        if(min2>min3) {
            num=min2;
            min2=min3;
            min3=num;
        }
        if(min3>min4) {
            num=min3;
            min3=min4;
            min4=num;
        }
        if(min4>min5) {
            num=min4;
            min4=min5;
            min5=num;
        }
        if(min1>min2) {
            num=min1;
            min1=min2;
            min2=num;
        }
        if(min2>min3) {
            num=min2;
            min2=min3;
            min3=num;
        }
        if(min3>min4) {
            num=min3;
            min3=min4;
            min4=num;
        }
        if(min4>min5) {
            num=min4;
            min4=min5;
            min5=num;
        }

        System.out.println(min1);
        System.out.println(min2);
        System.out.println(min3);
        System.out.println(min4);
        System.out.println(min5);


        //напишите тут ваш код



    }
}
