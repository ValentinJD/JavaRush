package com.javarush.task.task08.task0828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* 
Номер месяца
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String month = reader.readLine();
        ArrayList<String> monthes = new ArrayList<>();
        monthes.add("January");
        monthes.add("February");
        monthes.add("March");
        monthes.add("April");
        monthes.add("May");
        monthes.add("June");
        monthes.add("July");
        monthes.add("August");
        monthes.add("September");
        monthes.add("October");
        monthes.add("November");
        monthes.add("December");
        int number=-1;
        for (int i=0; i<monthes.size(); i++){
           if (month.equals(monthes.get(i)))
               number = i+1;

        }
        System.out.println(month + " is the " + number + " month");

        //напишите тут ваш код
    }
}
