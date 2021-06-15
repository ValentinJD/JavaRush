package com.javarush.task.task31.task3112;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.*;
import java.nio.file.StandardCopyOption;

/* 
Загрузчик файлов
*/
public class Solution {

    public static void main(String[] args) throws IOException {
        Path passwords = downloadFile("https://javarush.ru/testdata/secretPasswords.txt", Paths.get("D:/MyDownloads"));

        for (String line : Files.readAllLines(passwords)) {
            System.out.println(line);
        }
    }

    public static Path downloadFile(String urlString, Path downloadDirectory) throws IOException {
        //String[] strings = "https://javarush.ru/testdata/secretPasswords.txt".split("/");
        //String nameFile = strings[strings.length-1];
        String nameFile = urlString.substring(urlString.lastIndexOf("/")+1);
        URL url = new URL(urlString);
        InputStream inputStream = url.openStream();
        Path tempFile = Files.createTempFile("temp-", ".tmp");
        Files.copy(inputStream, tempFile);
        Path downloadFile = downloadDirectory.resolve(nameFile);
        Files.move(tempFile, downloadFile);
        return downloadFile;
        // implement this method
    }
}
