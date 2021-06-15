package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> listFile1 = new ArrayList<>();
        ArrayList<Integer> listFile2 = new ArrayList<>();

        try {
            String nameFile1 = reader.readLine();
            String nameFile2 = reader.readLine();

            FileInputStream inputStream1 = new FileInputStream(nameFile1);
            while (inputStream1.available()>0){ // считываем данные первого файла
                int input =  inputStream1.read();
                listFile1.add(input);
            }
            inputStream1.close();

            FileInputStream inputStream2 = new FileInputStream(nameFile2);
            while (inputStream2.available()>0){ // считываем данные второго файла
                int input =  inputStream2.read();
                listFile2.add(input);
            }
            inputStream2.close();

            FileOutputStream outputStream1 = new FileOutputStream(nameFile1);
            for (int i=0; i<listFile2.size(); i++){
                outputStream1.write(listFile2.get(i));
            }
            int label = ',';
            outputStream1.write(label);
            outputStream1.close();

            FileOutputStream outputStream2 = new FileOutputStream(nameFile1, true);
            outputStream2.write(listFile1.get(0));
            outputStream2.write(listFile1.get(0));

            for (int i=0; i<listFile1.size(); i++){
                outputStream2.write(listFile1.get(i));
            }
            outputStream2.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
