package com.javarush.task.task14.task1419;

import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 
Нашествие исключений
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //the first exception
        try {
            float i = 1 / 0;

        } catch (Exception e) {
            exceptions.add(e);
        }

        try { // 2
            int[] arr = new int[]{0,1};
            int a = arr[20];

        } catch (Exception e) {
            exceptions.add(e);
        }

        try { // 3
            int[] arr = null;
            int a = arr[20];

        } catch (Exception e) {
            exceptions.add(e);
        }

        try { // 4
            File file = new File("jfjf.txt");
            FileInputStream fileInputStream = new FileInputStream(file);

        } catch (Exception e) {
            exceptions.add(e);
        }

        try { // 5
            String s = "p";
            int p = Integer.parseInt(s);

        } catch (Exception e) {
            exceptions.add(e);
        }

        try { // 6
            ArrayList<Integer> list = new ArrayList<>();
            int k = list.get(2);

        } catch (Exception e) {
            exceptions.add(e);
        }

        try { // 7
            int[] intAr = new int[-1];

        } catch (Exception e) {
            exceptions.add(e);
        }

        try { // 8
            List<Integer> ll = new ArrayList<>(-2);

        } catch (Exception e) {
            exceptions.add(e);
        }

        try { // 9
            throw new IOException();

        } catch (Exception e) {
            exceptions.add(e);
        }

        try { // 10
            throw new SQLException();

        } catch (Exception e) {
            exceptions.add(e);
        }

        //напишите тут ваш код

    }
}
