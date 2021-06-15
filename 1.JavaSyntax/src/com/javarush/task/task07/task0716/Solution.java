package com.javarush.task.task07.task0716;

import java.util.ArrayList;
import java.util.Collections;

/* 
Р или Л
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<String>();
       // strings.add("роза");
        //strings.add("лира");
       // strings.add("лоза");
        Collections.addAll(strings, "роза", "мера", "лоза", "лира", "вода", "упор");
        strings = fix(strings);

        for (String string : strings) {
            System.out.println(string);
        }
    }

    public static ArrayList<String> fix(ArrayList<String> strings) {
        for (int i=0; i<strings.size();i++){
            if (strings.get(i).indexOf("р")!=-1 && strings.get(i).indexOf("л")!=-1);
            else if (strings.get(i).indexOf("р")!=-1) {
                strings.remove(i);
                i--;
            } else if (strings.get(i).indexOf("л")!=-1){
                String str = strings.get(i);
                strings.add((i+1), str);
                i++;

            } else ;
        }

        //напишите тут ваш код
        return strings;
    }
}