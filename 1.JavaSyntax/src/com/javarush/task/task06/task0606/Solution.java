package com.javarush.task.task06.task0606;

import java.io.*;

/* 
Чётные и нечётные циферки
*/

public class Solution {

    public static int even;
    public static int odd;

    public static void main(String[] args) throws IOException {
       BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
       String s = buffer.readLine();
       int length = s.length();
       int number = Integer.parseInt(s);
       //System.out.println("number перед циклом =" + number);
       int n = number;
       for (int i =0; i<length; i++){
           //System.out.println("number в цикле перед делением" + number);
              n = number/10;
              number = number%10;


           //System.out.println("number в цикле после деления = " + number + "проход № " + i);

           if (number%2==0) {
               even++;
           } else odd++;
           number = n;
        }
       System.out.println( "Even: " + even + " Odd: " + odd);


        //напишите тут ваш код
    }
}
