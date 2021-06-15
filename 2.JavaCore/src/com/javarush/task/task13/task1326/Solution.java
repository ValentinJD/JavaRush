package com.javarush.task.task13.task1326;

/* 
Сортировка четных чисел из файла
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.nio.*;

public class Solution {
    public static void main(String[] args) {

        try {
            ArrayList<Integer> list = new ArrayList<>();
            //System.out.println("Введите имя файла");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            //BufferedInputStream bufferedInputStream = new BufferedInputStream (new FileInputStream(bufferedReader.readLine()));
            BufferedReader fileName = new BufferedReader(new InputStreamReader(new FileInputStream(bufferedReader.readLine())));

            while (fileName.ready()){
                String d = fileName.readLine();

                int num = Integer.parseInt(d);
                if (num%2==0) list.add(num);
            }
            fileName.close();


            Collections.sort(list);
            for (int n: list){
                System.out.println(n);
            }
        } catch (IOException e){
            e.printStackTrace();
        }

        // напишите тут ваш код
    }
}
