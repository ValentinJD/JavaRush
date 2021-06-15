package com.javarush.task.task10.task1019;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* 
Функциональности маловато!
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));



        String name;
        String number;
        int id;
        HashMap<String, Integer> map = new HashMap<>();

        while (true){

            number = reader.readLine();
            try {
                id = Integer.parseInt(number);

            } catch (NumberFormatException e){
                    break;
            }

            name = reader.readLine();

            if (name.isEmpty()){
                map.put(name,id);
                break;
            }
            map.put(name,id);
        }
        for (Map.Entry<String, Integer> pair : map.entrySet()){
            System.out.println(pair.getValue() + " " + pair.getKey());
        }
    }
}
