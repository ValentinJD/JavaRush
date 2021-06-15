package com.javarush.task.task22.task2207;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* 
Обращенные слова
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();
  // C:\Users\Валентин\Desktop\test.txt
    public static void main(String[] args) throws IOException {
        List<String> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        File file = new File(reader.readLine());
        reader.close();
        BufferedReader fileReader = new BufferedReader(new FileReader(file));
        while (fileReader.ready()){
            String string = fileReader.readLine();
            String[] array = string.split(" ");
            for (String s:array){
                String str1 = s.replaceAll("\\uFEFF", "");
                String str2 = str1.trim();
                list.add(str2);
            }
        }
        fileReader.close();
        StringBuilder sb = null;
        int i = 0;
        while ( i < list.size()){
            if ((i+1)==list.size()){ break;
            }
            String one = list.get(i);
            String two = list.get(i+1);
            sb = new StringBuilder(list.get(i+1));
            String srav = sb.reverse().toString();
            if(one.equals(srav)) {
                Pair pair = new Pair();
                pair.first = one;
                pair.second = two;
                if (!result.contains(pair))
                result.add(pair);
                if ((i + 2) < list.size()){
                    i = i + 2;
                } else break;
            } else i++;
            //System.out.println(i);
        }
        /*for (Pair pair: result) {
            System.out.println(pair.first + " " + pair.second);
        }*/

    }

    public static class Pair {
        String first;
        String second;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return  first == null && second == null ? "" :
                        first == null ? second :
                            second == null ? first :
                                first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
