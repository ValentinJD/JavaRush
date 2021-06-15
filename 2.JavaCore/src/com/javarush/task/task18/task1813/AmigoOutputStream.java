package com.javarush.task.task18.task1813;

import java.io.*;

/* 
AmigoOutputStream
*/

public class AmigoOutputStream extends FileOutputStream {

    public static String fileName = "C:/tmp/result.txt";

    FileOutputStream fileOutputStream;

    public AmigoOutputStream(FileOutputStream fileOutputStream) throws FileNotFoundException {
        super(fileName);
        this.fileOutputStream = fileOutputStream;
    }


    public void write(int b) throws IOException {
        fileOutputStream.write(b);
    }

    public void write(byte[] b) throws IOException {
        fileOutputStream.write(b);
    }

    public void write(byte[] b, int n, int m) throws IOException{
        fileOutputStream.write(b, n, m);
    }

    public void flush() throws IOException {
        fileOutputStream.flush();
    }

    public void close() throws IOException {
        fileOutputStream.flush();
        String str = "JavaRush © All rights reserved.";
        byte[] bb = str.getBytes();
        fileOutputStream.write(bb);
        fileOutputStream.close();
    }

    public static void main(String[] args) throws FileNotFoundException {
        new AmigoOutputStream(new FileOutputStream(fileName));
    }

}
