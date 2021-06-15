package com.javarush.task.task19.task1920;

/* 
Самый богатый
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        Map<String, Double> map = new TreeMap<>();

        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        while (reader.ready()){
            String line = reader.readLine();
            String[] array = line.split(" ");
            String name = array[0].replace("\uFEFF", ""); // Убираем долбаный BOM который нам поднасрал
            Double solaries = Double.parseDouble(array[1]);
            boolean cnt = map.containsKey(name);

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

        Double d = Collections.max(map.values());

        //System.out.println("печатаем наш список");
        for (Map.Entry<String, Double> pair: map.entrySet()){
            Double max = pair.getValue();
            if (d.equals(max)){
                System.out.println(pair.getKey());
            }

        }
    }
}
