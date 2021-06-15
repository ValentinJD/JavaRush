package com.javarush.task.task08.task0814;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* 
Больше 10? Вы нам не подходите
*/

public class Solution {
    public static Set<Integer> createSet() {
        Set<Integer> set = new HashSet<>();
        set.add(2);
        set.add(1);
        set.add(3);
        set.add(5);
        set.add(7);
        set.add(29);
        set.add(8);
        set.add(9);
        set.add(11);
        set.add(12);
        set.add(15);
        set.add(16);
        set.add(17);
        set.add(20);
        set.add(25);
        set.add(30);
        set.add(32);
        set.add(52);
        set.add(62);
        set.add(72);
        return set;
        // напишите тут ваш код
    }

    public static Set<Integer> removeAllNumbersGreaterThan10(Set<Integer> set) {
        Iterator<Integer> iterator = set.iterator();
        while ( iterator.hasNext())
        {
            int number = iterator.next();
            if (number > 10)
                iterator.remove();
        }
        return set;
        // напишите тут ваш код
    }

    public static void main(String[] args) {
       //System.out.println(removeAllNumbersGreaterThan10(createSet()));

    }
}
