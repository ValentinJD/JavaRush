package com.javarush.task.task31.task3101;

import java.io.*;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
Проход по дереву файлов
*/
public class Solution {

    public static void main(String[] args) {

        List<Path> fileList = new ArrayList<>(); // лист для хранения файлов
        File path = new File(args[0]);
        File resultFileAbsolutePath = new File(args[1]);
        File newFile = new File(resultFileAbsolutePath.getParent()+"/allFilesContent.txt");
        FileUtils.renameFile(resultFileAbsolutePath, newFile);

        class Tree {
            List<Path> fileList;
            public Tree(List<Path> fileList) {
                this.fileList = fileList;
            }
            public List<Path> getFileList() {
                return fileList;
            }
            public void collectFileList(Path path) {
                try {
                    // Добавляем только файлы
                    if (Files.isRegularFile(path)) {
                        //Path relativePath = path.getFileName();
                        if (Files.size(path) <= 50)
                            fileList.add(path);
                    }
                    // Добавляем содержимое директории
                    if (Files.isDirectory(path)) {
                        // Рекурсивно проходимся по всему содержмому директории
                        // Чтобы не писать код по вызову close для DirectoryStream, обернем вызов newDirectoryStream в try-with-resources
                        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(path)) {
                            for (Path file : directoryStream) {
                                collectFileList(file);
                            }
                        }
                    }
                } catch (IOException e) { }
            }
        }

        Tree tree = new Tree(fileList);

        tree.collectFileList(path.toPath()); // проходим по дереву и добавляем файлы в список

        fileList = tree.getFileList(); //

        Collections.sort(fileList);

        try {
            FileOutputStream fos = new FileOutputStream(newFile, true);

            for (Path path1 : fileList) {
                try (FileInputStream fis = new FileInputStream(path1.toFile())) { // читаем каждый файл из списка
                    while (fis.available() > 0)
                        fos.write(fis.read());
                    fos.write(10);   // после тела файла записываем \n
                }
            }
            fos.close();
        } catch (IOException e) {
        }
    }
}
