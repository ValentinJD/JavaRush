package com.javarush.task.task08.task0818;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* 
Только для богачей
*/

public class Solution {
    public static Map<String, Integer> createMap() {
        Map<String, Integer> map = new HashMap<>();
        map.put("Иванов", 100);
        map.put("Петров", 200);
        map.put("Сидоров", 300);
        map.put("нов", 400);
        map.put("И", 500);
        map.put("В", 600);
        map.put("П", 700);
        map.put("К", 800);
        map.put("О", 900);
        map.put("У", 1000);

        return map;
        //напишите тут ваш код
    }

    public static void removeItemFromMap(Map<String, Integer> map) {
        Iterator<Map.Entry<String,Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String, Integer> pair = iterator.next();
            int value = pair.getValue();
            if (value<500) iterator.remove();
        }
        //напишите тут ваш код
    }

    public static void main(String[] args) {

    }
}