package com.javarush.task.task09.task0927;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* 
Десять котов
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, Cat> map = createMap();
        Set<Cat> set = convertMapToSet(map);
        printCatSet(set);
    }

    public static Map<String, Cat> createMap() {
        Map<String, Cat> map = new HashMap<String, Cat>();
        map.put("Кот1", new Cat("1"));
        map.put("Кот2", new Cat("1"));
        map.put("Кот3", new Cat("1"));
        map.put("Кот4", new Cat("1"));
        map.put("Кот5", new Cat("1"));
        map.put("Кот6", new Cat("1"));
        map.put("Кот7", new Cat("1"));
        map.put("Кот8", new Cat("1"));
        map.put("Кот9", new Cat("1"));
        map.put("Кот10", new Cat("1"));
        return map;

        //напишите тут ваш код
    }

    public static Set<Cat> convertMapToSet(Map<String, Cat> map) {
        Set<Cat> set = new HashSet<>();
        for (Map.Entry<String, Cat> c: map.entrySet()){
            Cat value = c.getValue();
            set.add(value);
        }
        return set;
        //напишите тут ваш код
    }

    public static void printCatSet(Set<Cat> set) {
        for (Cat cat : set) {
            System.out.println(cat);
        }
    }

    public static class Cat {
        private String name;

        public Cat(String name) {
            this.name = name;
        }

        public String toString() {
            return "Cat " + this.name;
        }
    }


}
