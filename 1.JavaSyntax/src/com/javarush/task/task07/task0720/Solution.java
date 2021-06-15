package com.javarush.task.task07.task0720;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;

/* 
Перестановочка подоспела
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int m = Integer.parseInt(reader.readLine());
        ArrayList<String> list = new ArrayList<>();
        for (int i=n; i>0; i--){
            list.add(reader.readLine());
        }
        Iterator<String> listIterator = list.iterator();
        for (int i=0; i<m; i++){
            String str = list.get(0);
            list.remove(0);
            list.add(str);
        }
        for (int i=0; i<list.size(); i++){
            System.out.println(list.get(i));
        }

        //напишите тут ваш код
    }
}
