package com.javarush.task.task08.task0815;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* 
Перепись населения
*/

public class Solution {
    public static Map<String, String> createMap() {
        Map<String, String> map = new HashMap<>();
        map.put("Ивано", "Иван");
        map.put("Петро", "Петр");
        map.put("Лыско", "Женя");
        map.put("Братко", "Ден");
        map.put("Жижко", "Дима");
        map.put("Ковытко", "Петя");
        map.put("Пычко", "Коля");
        map.put("Шматко", "Киря");
        map.put("Дрыжко", "Ванес");
        map.put("Брумко", "Вася");
        return map;

        //напишите тут ваш код

    }

    public static int getCountTheSameFirstName(Map<String, String> map, String name) {
        int count=0;
        Iterator<Map.Entry<String, String >> iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String, String > pair = iterator.next();
            String value = pair.getValue();
            if (value.equals(name)) count++;
        }
        return count;
        //напишите тут ваш код

    }

    public static int getCountTheSameLastName(Map<String, String> map, String lastName) {
        int count=0;
        Iterator<Map.Entry<String, String >> iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String, String > pair = iterator.next();
            String key = pair.getKey();
            if (key.equals(lastName)) count++;
        }
        return count;        //напишите тут ваш код

    }

    public static void main(String[] args) {

    }
}
