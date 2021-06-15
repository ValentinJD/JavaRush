package com.javarush.task.task31.task3113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/* 
Что внутри папки?
*/
public class Solution extends SimpleFileVisitor<Path> {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Path path = Paths.get(reader.readLine());
        if (!Files.isDirectory(path)){
            System.out.println(path.toAbsolutePath() + " - не папка");
        } else {

            Solution solution = new Solution();
            Files.walkFileTree(path, new Solution());
            System.out.println("Всего папок - " + (solution.allDirectories - 1));
            System.out.println("Всего файлов - " + (solution.allFiles));
            System.out.println("Общий размер - " + solution.allByte);

        }
    }

    private static  int allFiles = 0;
    private static int allDirectories = 0;
    private static int allByte;

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException{
        if (Files.isRegularFile(file)){
            this.allFiles++;
            byte[] bytes = Files.readAllBytes(file);
            this.allByte = this.allByte + bytes.length;
        }
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult preVisitDirectory (Path file, BasicFileAttributes attrs) throws IOException{
        this.allDirectories++;
        return FileVisitResult.CONTINUE;
    }
}
