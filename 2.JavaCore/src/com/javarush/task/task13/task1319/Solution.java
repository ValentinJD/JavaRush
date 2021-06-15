package com.javarush.task.task13.task1319;

import javax.imageio.IIOException;
import java.io.*;
import java.util.ArrayList;

/* 
Писатель в файл с консоли
*/

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            //System.out.println("Введите имя файла");
            String fileName = reader.readLine();
            File file = new File(fileName);
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            ArrayList<String> list = new ArrayList<>();
            String text;
            while (true){
                //System.out.println("Введите строку для записи в файл либо exit для окончания записи строк в файл");
                text = reader.readLine();
                list.add(text);
                if (text.equals("exit")) break;
            }
            //System.out.println("Запись строк окончена");
            for (String s: list){
                bufferedWriter.write(s + "\n");
            }
            reader.close();
            bufferedWriter.close();

        } catch (IOException e) {
            //System.out.println("Ошибка ввода");
            e.printStackTrace();
        }

        // напишите тут ваш код
    }
}
