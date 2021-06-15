package com.javarush.task.task16.task1630;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.*;

public class Solution {
    public static String firstFileName;
    public static String secondFileName;

    static {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            firstFileName = reader.readLine();
            secondFileName = reader.readLine();
            reader.close();
        } catch (IOException e) {
        }


    }
    //add your code here - добавьте код тут

    public static void main(String[] args) throws InterruptedException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        f.join();
        //add your code here - добавьте код тут
        System.out.println(f.getFileContent());
    }

    public interface ReadFileInterface {

        void setFileName(String fullFileName);

        String getFileContent();

        void join() throws InterruptedException;

        void start();
    }

    public static class ReadFileThread extends Thread implements ReadFileInterface {
        private static File file;
        private static Thread thread;
        private ReadFileThread readFileThread;
        private String fullFileName;
        private boolean startRun = false;
        private String content = null;


        public void setFileName(String fullFileName) {
            this.fullFileName = fullFileName;
        }

        public String getFileContent() {
            if (!startRun) return "";
            else return content;
        }

        @Override
        public void run() {
            startRun = true;

            StringBuffer strResult = null;
            file = new File(fullFileName);

            try {
                BufferedReader fileReader = new BufferedReader(new FileReader(file));
                strResult = new StringBuffer();

                while (fileReader.ready()) {
                    String str = (fileReader.readLine() + " ");
                    strResult.append(str);
                }
                fileReader.close();

            } catch (Exception e) {
            }

            content = strResult.toString();
        }
    }

//add your code here - добавьте код тут
}