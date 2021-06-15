package com.javarush.task.task38.task3803;

/* 
Runtime исключения (unchecked exception)
*/

public class VeryComplexClass {
    public void methodThrowsClassCastException() {
        Object o = new Object();
        String str = (String) o;

    }

    public void methodThrowsNullPointerException() {
        String s = null;
        s.contains("dd");

    }

    public static void main(String[] args) {

    }


}
