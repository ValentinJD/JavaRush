package com.javarush.task.task18.task1812;

import java.io.*;

/* 
Расширяем AmigoOutputStream
*/

public class QuestionFileOutputStream implements AmigoOutputStream {
    AmigoOutputStream outputStream;

    public QuestionFileOutputStream(AmigoOutputStream outputStream){
        this.outputStream = outputStream;
    }

    public void flush() throws IOException{
        outputStream.flush();
    }

    public void write(int b) throws IOException{
        outputStream.write(b);
    }

    public void write(byte[] b) throws IOException{
        outputStream.write(b);
    }

    public void write(byte[] b, int off, int len) throws IOException{
        outputStream.write(b, off, len);
    }

    @Override
    public void close() throws IOException{
        System.out.println("Вы действительно хотите закрыть поток? Д/Н");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();
        if (str.equals("Д")) outputStream.close();
        else return;
    }


}

