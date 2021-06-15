package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.HashMap;
import java.util.*;

/* 
Самые частые байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList<Integer> list = new ArrayList();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String nameFile = reader.readLine();
        reader.close();
        FileInputStream fileInputStream = new FileInputStream(nameFile);

        while (fileInputStream.available()>0){
           list.add(fileInputStream.read());
        }
        fileInputStream.close();
        
        Map<Integer, Integer> fakeMap = new HashMap<>(list.size());
        for(Integer ourByte: list){
            Integer cnt = fakeMap.get(ourByte);
            fakeMap.put(ourByte, cnt==null? 1: cnt+1);
        }
        int maxValue = Collections.max(fakeMap.values());
        for (Map.Entry<Integer, Integer> entry: fakeMap.entrySet()){
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            if (value==maxValue){
                int intKey = key;
                System.out.print((byte) intKey + " ");
                
            }

        }

    }
}
