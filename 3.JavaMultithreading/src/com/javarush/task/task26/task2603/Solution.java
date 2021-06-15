package com.javarush.task.task26.task2603;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
Убежденному убеждать других не трудно
*/
public class Solution {

    public static void main(String[] args) {
        TestClass first = new TestClass("a","b","c");
        TestClass second = new TestClass("c","c","t");
        TestClass third = new TestClass("a","b","a");
        TestClass third2 = new TestClass("a","a","a");
        TestClass third3 = new TestClass("a","c","b");
        TestClass third4 = new TestClass("a","c","c");
        TestClass third5 = new TestClass("a","c","a");
        ArrayList<TestClass> list=new ArrayList<>();
        list.add(first);
        list.add(second);
        list.add(third);
        list.add(third2);
        list.add(third3);
        list.add(third4);
        list.add(third5);
        for (TestClass test:list) {
            test.consoleout();
        }
        System.out.println("*******************");

        Collections.sort(list,new CustomizedComparator<TestClass>(new Comparator<TestClass>() {
            @Override
            public int compare(TestClass o1, TestClass o2) {
                return o1.x.compareTo(o2.x);
            }
        }, new Comparator<TestClass>() {
            @Override
            public int compare(TestClass o1, TestClass o2) {
                return o1.y.compareTo(o2.y);
            }
        }, new Comparator<TestClass>() {
            @Override
            public int compare(TestClass o1, TestClass o2) {
                return o1.z.compareTo(o2.z);
            }
        }));

        for (TestClass test:list) {
            test.consoleout();
        }

    }

    public static class TestClass {
        public String x;
        public String y;
        public String z;
        public TestClass(String x, String y, String z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
        public void consoleout(){
            System.out.println(x+" "+y+" "+z);

        }
    }

    public static class CustomizedComparator<T> implements Comparator<T>{
        private Comparator<T>[] comparators;

        public CustomizedComparator(Comparator<T> ... comparators) {
            this.comparators = comparators;
        }

        @Override
        public int compare(T o1, T o2) {
            int result = 0;
            for (Comparator<T> c: comparators){
                 result = c.compare(o1, o2);
                 if(result !=0) break;
            }
            return result;
        }
    }
}
