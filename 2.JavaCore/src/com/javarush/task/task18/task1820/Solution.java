package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String nameFile1;
        String nameFile2;

        try {
            nameFile1 = reader.readLine(); //"C:\\Users\\Валентин\\Desktop\\test.txt"; //
            nameFile2 = reader.readLine(); //"C:\\Users\\Валентин\\Desktop\\test2.txt"; //
            reader.close();
            Scanner scanner = new Scanner(new FileInputStream(nameFile1));
            long numberRound;
            List<Integer> list = new ArrayList<>();
            scanner.useDelimiter(" ");
            while (scanner.hasNextLine()){
                float number = Float.parseFloat(scanner.next());

                //System.out.println("считываем число из файла " + number);
                if(number>=0){
                    numberRound = Math.round(number);
                   // System.out.println("метод Math.round " + number);
                } else {
                    numberRound = (long) Math.ceil(number);
                    //System.out.println("метод Math.ceil " + number);
                }
                //System.out.println("добавляем в массив число " + numberRound);
                list.add((int) numberRound);
            }
            list.forEach(s -> System.out.println(s+ " "));

        } catch (IOException e){
            System.out.println("Ошибка ввода вывода!");
        }




    }
}
