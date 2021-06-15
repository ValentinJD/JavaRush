package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        Map<String, Double> map = new TreeMap<>();

        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        while (reader.ready()){
            String line = reader.readLine();
            String[] array = line.split(" ");
            String name = array[0].replace("\uFEFF", ""); // Убираем долбаный BOM который на поднасрал
            Double solaries = Double.parseDouble(array[1]);
            boolean cnt = map.containsKey(name);

            //System.out.println("cnt=" + cnt);
            //System.out.println("solaries=" + solaries);
            //System.out.println("name=" + name);
            if (!cnt){
                //System.out.println("Добавляем в список" + name);
                map.put(name,solaries);
            } else {
                Double sol = map.get(name);
                //System.out.println("У " + name + " sol=" + sol);
                Double sum = sol + solaries;
                //System.out.println("Теперь У " + name + " sol=" + sum);
                map.replace(name, sol, sum);
            }
        }
        reader.close();

        //System.out.println("печатаем наш список");
        for (Map.Entry<String, Double> pair: map.entrySet()){
            System.out.println(pair.getKey() + " " + pair.getValue());
        }
    }
}
