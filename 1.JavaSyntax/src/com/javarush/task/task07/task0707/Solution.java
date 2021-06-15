package com.javarush.task.task07.task0707;

import java.util.ArrayList;

/* 
Что за список такой?
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();
        list.add("n1");
        list.add("n2");
        list.add("n3");
        list.add("n4");
        list.add("n5");
        System.out.println(list.size());
        for (int i=0; i<list.size();i++){
            System.out.println(list.get(i));
        }
        //напишите тут ваш код
    }
}
