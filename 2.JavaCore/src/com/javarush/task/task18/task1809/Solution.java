package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;


public class Solution {
     public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        try{
            FileInputStream fileInputStream = new FileInputStream(reader.readLine());
            FileOutputStream fileOutputStream1 = new FileOutputStream(reader.readLine());
            reader.close();
            int countBytes=fileInputStream.available();
            List<Integer> list = new ArrayList<>(countBytes);
            
            while(fileInputStream.available()> 0){
                list.add(new Integer(fileInputStream.read()));
            }
            Collections.reverse(list);
            
            for(Integer b:list){
                int bb = b;
                fileOutputStream1.write((byte)bb);
            }
            
            fileInputStream.close();
            fileOutputStream1.close();
            
            
        } catch(Exception e){
            e.printStackTrace();
        }

    }
}
