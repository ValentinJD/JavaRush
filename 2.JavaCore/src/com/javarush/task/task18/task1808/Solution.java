package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        try{
            FileInputStream fileInputStream = new FileInputStream(reader.readLine());
            FileOutputStream fileOutputStream1 = new FileOutputStream(reader.readLine());
            FileOutputStream fileOutputStream2 = new FileOutputStream(reader.readLine());
            reader.close();
            int countBytes=fileInputStream.available();
            
            while(fileInputStream.available()> countBytes/2){
                fileOutputStream1.write(fileInputStream.read());
            }
            
            while(fileInputStream.available()> 0){
                fileOutputStream2.write(fileInputStream.read());
            }
            
            fileInputStream.close();
            fileOutputStream1.close();
            fileOutputStream2.close();
            
        } catch(Exception e){
            e.printStackTrace();
        }

    }
}
