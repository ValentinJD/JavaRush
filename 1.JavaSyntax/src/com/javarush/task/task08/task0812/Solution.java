package com.javarush.task.task08.task0812;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* 
Cамая длинная последовательность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> list = new ArrayList<>();
        for (int i=0; i<10; i++){
            int n = Integer.parseInt(reader.readLine());
            list.add(n);
        }
        int countmax=1;
        int countCurrent=1;
        int value;
        int valueNext;


        for (int i=0; i<list.size(); i++){
            if (i==list.size()-1)break;
            value = list.get(i);
            valueNext = list.get(i+1);
            if (value==valueNext) {
               countCurrent++;
               if(countCurrent > countmax) countmax = countCurrent;
            } else  { if (countCurrent > countmax) countmax = countCurrent;
                countCurrent =1;
              }

        }

        System.out.println(countmax);
        //напишите тут ваш код

    }
}