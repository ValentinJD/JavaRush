package com.javarush.task.task08.task0821;

import java.util.HashMap;
import java.util.Map;

/* 
Однофамильцы и тёзки
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = createPeopleList();
        printPeopleList(map);
    }

    public static Map<String, String> createPeopleList() {
        Map<String, String> mapa = new HashMap<>();
        mapa.put("1", "22");
        mapa.put("1", "33");
        mapa.put("2", "44");
        mapa.put("3", "55");
        mapa.put("4", "55");
        mapa.put("5", "66");
        mapa.put("6", "77");
        mapa.put("7", "88");
        mapa.put("8", "99");
        mapa.put("9", "01");
        //напишите тут ваш код

        return mapa;
    }

    public static void printPeopleList(Map<String, String> map) {
        for (Map.Entry<String, String> s : map.entrySet()) {
            System.out.println(s.getKey() + " " + s.getValue());
        }
    }
}
