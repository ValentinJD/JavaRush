package com.javarush.task.task18.task1807;

/* 
Подсчет запятых
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class Solution {
    public static void main(String[] args) {
       
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String nameFile="";
        try{
            nameFile = reader.readLine();
            reader.close();
        } catch(Exception e){
            e.printStackTrace();
        }
        
        try{
            FileInputStream fileInputStream = new FileInputStream(nameFile);
            int count=0;
            while (fileInputStream.available()>0){
                int ch = fileInputStream.read();
                if (ch==44) count++;
            }
            fileInputStream.close();
            
            System.out.println(count);
            
        } catch(Exception e){
            e.printStackTrace();
        }
        
    }
}
