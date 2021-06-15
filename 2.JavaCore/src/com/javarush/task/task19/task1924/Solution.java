package com.javarush.task.task19.task1924;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.*;

/* 
Замена чисел
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();
    
    static{
        map.put(0, "ноль");
        map.put(1, "один");
        map.put(2, "два");
        map.put(3, "три");
        map.put(4, "четыре");
        map.put(5, "пять");
        map.put(6, "шесть");
        map.put(7, "семь");
        map.put(8, "восемь");
        map.put(9, "девять");
        map.put(10, "десять");
        map.put(11, "одиннадцать");
        map.put(12, "двенадцать");
        
    }

    public static void main(String[] args) throws IOException {
        BufferedReader readerConsole = new BufferedReader(new InputStreamReader(System.in));
        String fileName = readerConsole.readLine();
        readerConsole.close();
        
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        
        while (reader.ready()){
            String line = reader.readLine();
            String[] array = line.split(" ");
            
            for(int i=0; i<array.length; i++){
                String strArray = array[i].replace("\uFEFF", "");
                for(Map.Entry<Integer, String> pair: map.entrySet()){
                    Integer num = pair.getKey();
                    String numToString = "" + num;
                    if(strArray.equals(numToString)){
                        array[i] = map.get(num);
                    }
                }
            }
            for(String s:array){
                System.out.print(s + " ");
               
            }
            System.out.println();
        }
        reader.close();
        
    }
}
