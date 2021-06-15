package com.javarush.task.task22.task2210;

/* 
StringTokenizer
*/
import java.util.StringTokenizer;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        String[] array = getTokens("level22.lesson13.task01", ".");
        for(String s: array){
            System.out.println(s);
        }
        

    }
    public static String [] getTokens(String query, String delimiter) {
        StringTokenizer tokenizer = new StringTokenizer(query, delimiter);
        List<String> list = new ArrayList();
        while(tokenizer.hasMoreTokens()){
            list.add(tokenizer.nextToken());
        }
        return list.toArray(new String[0]);
        
         
    }
    
    
}
