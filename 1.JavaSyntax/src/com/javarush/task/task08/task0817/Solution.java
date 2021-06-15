package com.javarush.task.task08.task0817;

import java.util.*;

/* 
Нам повторы не нужны
*/

public class Solution {
    public static Map<String, String> createMap() {
        Map<String, String> map = new HashMap<>();
        map.put("1", "Иван");
        map.put("2", "Петр");
        map.put("3", "Иван");
        map.put("4", "Федор");
        map.put("5", "Коля");
        map.put("6", "Вася");
        map.put("7", "Коля");
        map.put("8", "Федот");
        map.put("9", "Артем");
        map.put("10", "Женя");
        return map;
        //напишите тут ваш код

    }

    public static  void removeTheFirstNameDuplicates(Map<String, String> map) {

        Iterator<Map.Entry<String, String >> iterator = map.entrySet().iterator();
        Map<String, String> copy1 = new HashMap<>();

        while (iterator.hasNext()){ // Создаем копию без дубликатов
            Map.Entry<String, String> pair = iterator.next();
            String value = pair.getValue();
            String key = pair.getKey();
            if (copy1.containsValue(value)){
                continue;
            } else {
                copy1.put(key, value);
            }
        }

        int n=0;
        Set<String> set = new HashSet<>(); // для хранения дубликатов
        Iterator<Map.Entry<String, String >> iterator1 = copy1.entrySet().iterator();

        while (iterator1.hasNext()){ // создаем лист только дубликатов
            Map.Entry<String, String> pair1 = iterator1.next();
            String value1 = pair1.getValue();

            for (Map.Entry<String, String> pair: map.entrySet()){
                Map.Entry<String, String> pair9 = pair;
                String value = pair9.getValue();

                if (value1.equals(value)) {
                    n++;
                }
                if (n>1) {
                    set.add(value1);
                    n=0;
                }
            }
            n=0;
        }

        Iterator<String> setIterator = set.iterator();

        while (setIterator.hasNext()){
            String value = setIterator.next();
            removeItemFromMapByValue(copy1, value);
        }
        Iterator<String> iteratorP = set.iterator();
        while (iteratorP.hasNext()){ //удаляем все из map по шаблону
            String value = iteratorP.next();
            if (map.containsValue(value)) removeItemFromMapByValue(map, value);
        }


        //return map;
        //напишите тут ваш код
    }

    public static void removeItemFromMapByValue(Map<String, String> map, String value) {
        Map<String, String> copy = new HashMap<>(map);
        for (Map.Entry<String, String> pair : copy.entrySet()) {
            if (pair.getValue().equals(value)) {
                map.remove(pair.getKey());
            }
        }
    }

    public static void main(String[] args) {

       // System.out.println(removeTheFirstNameDuplicates(createMap()));

    }
}
