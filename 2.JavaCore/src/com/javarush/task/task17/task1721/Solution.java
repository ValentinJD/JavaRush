package com.javarush.task.task17.task1721;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String fileName1 = reader.readLine();
            String fileName2 = reader.readLine();
            reader.close();
            BufferedReader fileReader = new BufferedReader(new FileReader(fileName1));
            while (fileReader.ready()){
                allLines.add(fileReader.readLine());
            }
            fileReader.close();
            BufferedReader fileReader1 = new BufferedReader(new FileReader(fileName2));
            while (fileReader1.ready()){
                forRemoveLines.add(fileReader1.readLine());
            }
            fileReader1.close();

        } catch (Exception e){}
        Solution solution = new Solution();
        try {
            solution.joinData();
        } catch (CorruptedDataException e ){}


    }

    public void joinData() throws CorruptedDataException {

            if (allLines.containsAll(forRemoveLines)) {
                allLines.removeAll(forRemoveLines);
            } else {
                allLines.clear();
                throw new CorruptedDataException();
            }





    }
}
