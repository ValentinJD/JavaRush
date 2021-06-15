package com.javarush.task.task08.task0808;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* 
10 тысяч удалений и вставок
*/

public class Solution {
    public static void main(String[] args) {
        // ArrayList
        ArrayList arrayList = new ArrayList();
        insert10000(arrayList);
        get10000(arrayList);
        set10000(arrayList);
        //System.out.println(arrayList.size());
        remove10000(arrayList);

        // LinkedList
        LinkedList linkedList = new LinkedList();
        insert10000(linkedList);
        get10000(linkedList);
        set10000(linkedList);
        remove10000(linkedList);
    }

    public static void insert10000(List list) {

        for (int i =0; i<10000; i++)
        {
            Object o = new Object();
            list.add(o);
                        //напишите тут ваш код
        }
    }

    public static void get10000(List list) {
        for (int i =0; i<10000; i++)
        {
            list.get(i);
            //напишите тут ваш код
        }
        //напишите тут ваш код

    }

    public static void set10000(List list) {
        for (int i =0; i<10000; i++)
        {
            Object o = new Object();
            list.set(i,o);
            //напишите тут ваш код
        }
        //напишите тут ваш код

    }

    public static void remove10000(List list) {


        for (int i = 10000-1; i >=0; i--) {
            list.remove(i);


        }

        //напишите тут ваш код

    }
}
