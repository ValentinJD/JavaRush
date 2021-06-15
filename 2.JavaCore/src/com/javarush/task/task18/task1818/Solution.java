package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            String nameFile1 = reader.readLine();
            String nameFile2 = reader.readLine();
            String nameFile3 = reader.readLine();

            BufferedOutputStream outputStream1 = new BufferedOutputStream(new FileOutputStream(nameFile1));
            BufferedInputStream inputStream2 = new BufferedInputStream(new FileInputStream(nameFile2));
            BufferedInputStream inputStream3 = new BufferedInputStream(new FileInputStream(nameFile3));

            while (inputStream2.available()>0){
               int input =  inputStream2.read();
               outputStream1.write(input);
            }
            inputStream2.close();

            while (inputStream3.available()>0){
                int input =  inputStream3.read();
                outputStream1.write(input);
            }
            inputStream3.close();
            outputStream1.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
