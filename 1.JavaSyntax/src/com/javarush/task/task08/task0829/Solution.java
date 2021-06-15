package com.javarush.task.task08.task0829;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* 
Модернизация ПО
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, String> map = new HashMap<>();
        while (true) {
            String town = reader.readLine();
            if (town.isEmpty()) {
                break;
            }
            String family = reader.readLine();
            if (family.isEmpty()) {
                break;
            }

            map.put(town, family);
        }

        // Read the house number
        String townKey = (reader.readLine());
        String familyValue = null;
        for (Map.Entry<String, String> m: map.entrySet()){
            String key = m.getKey();
            String value = m.getValue();
            if (townKey.equals(key)) familyValue = value;
            System.out.println(familyValue);
            break;
        }


    }
}
