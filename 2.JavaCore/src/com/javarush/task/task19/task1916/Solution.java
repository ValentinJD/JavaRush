package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.*;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileNmae1 = reader.readLine();
        String fileNmae2 = reader.readLine();
        reader.close();
        BufferedReader readerFile1 = new BufferedReader(new FileReader(fileNmae1));
        Stack<String> linesFile1 = new Stack<String>();
        while (readerFile1.ready()){
            String str = readerFile1.readLine();
            linesFile1.push(str);
        }
        readerFile1.close();
        BufferedReader readerFile2 = new BufferedReader(new FileReader(fileNmae2));
        Stack<String> linesFile2 = new Stack<String>();
        while (readerFile2.ready()){
            String str = readerFile2.readLine();
            linesFile2.push(str);
        }
        readerFile2.close();
        Collections.reverse(linesFile1);
        Collections.reverse(linesFile2);

        while (true) {
            if(linesFile1.empty()&&linesFile2.empty()){
                System.out.println("end");
                break;
            } 
            if(linesFile1.empty()){
                String lineCurrentToFile2 = linesFile2.peek();
                lines.add(new LineItem(Type.ADDED, lineCurrentToFile2));
                System.out.println("удаляем строку из второго файла");
                linesFile2.pop();
                System.out.println("ADDED " + lineCurrentToFile2);
                break;
            }
            if (linesFile2.empty()){
                String lineCurrentToFile1 = linesFile1.peek();
                lines.add(new LineItem(Type.REMOVED, lineCurrentToFile1));
                System.out.println("удаляем строку из первого файла");
                linesFile1.pop();
                System.out.println("REMOVED " + lineCurrentToFile1);
                break;
            }
            String lineCurrentToFile1 = linesFile1.peek();
            String lineCurrentToFile2 = linesFile2.peek();
            

            if(lineCurrentToFile1.equals(lineCurrentToFile2)){
                System.out.println("SRAVNIVAEM " + lineCurrentToFile1 + " and " + lineCurrentToFile2);
                lines.add(new LineItem(Type.SAME, lineCurrentToFile1));
                System.out.println("удаляем строку из первого файла");
                linesFile1.pop();
                System.out.println("удаляем строку из второго файла");
                linesFile2.pop();
                System.out.println("SAME " + lineCurrentToFile1);
                continue;

            }
            System.out.println("строка из первого файла не равна строке из второго");
            System.out.println("удаляем строку из первого файла");
            linesFile1.pop();
            String lineNextToFile1 = linesFile1.peek();

            if(lineNextToFile1.equals(lineCurrentToFile2)){
                System.out.println("SRAVNIVAEM " + lineNextToFile1 + " and " + lineCurrentToFile2);
                lines.add(new LineItem(Type.REMOVED, lineCurrentToFile1));
                System.out.println("удаляем строку из первого файла");
                linesFile1.pop();
                System.out.println("удаляем строку из второго файла");
                linesFile2.pop();
                System.out.println("REMOVED " + lineCurrentToFile1);
                continue;
            }
            System.out.println("строка из первого файла не равна строке из второго999999");
            System.out.println("удаляем строку из второго файла");
            linesFile2.pop();
            String lineNextToFile2 = linesFile2.peek();
            if(lineCurrentToFile1.equals(lineNextToFile2)){
                System.out.println("SRAVNIVAEM " + lineCurrentToFile1 + " and " + lineNextToFile2);
                lines.add(new LineItem(Type.ADDED, lineCurrentToFile2));
                //linesFile2.pop();
                System.out.println("ADDED " + lineCurrentToFile2);
            }
        }
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
