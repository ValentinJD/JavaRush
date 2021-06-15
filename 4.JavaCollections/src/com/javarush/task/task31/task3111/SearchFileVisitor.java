package com.javarush.task.task31.task3111;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class SearchFileVisitor extends SimpleFileVisitor<Path> {

    private String partOfName;
    private String partOfContent;
    private int minSize;
    private int maxSize;
    private List<Path> foundFiles = new ArrayList<>();

    private boolean searchPartOfName = false;
    private boolean searchPartOfContent = false;
    private boolean searchMinSize = false;
    private boolean searchMaxSize = false;


    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        byte[] content = Files.readAllBytes(file); // размер файла: content.length

        boolean one = true;
        if (searchPartOfName && !file.getFileName().toString().contains(partOfName))
            one = false;

        boolean two = true;
        String contents = new String(Files.readAllBytes(file));
        if (searchPartOfContent && !contents.contains(partOfContent))
            two = false;

        boolean three = true;
        if (searchMinSize && !(minSize < content.length))
            three = false;

        boolean four = true;
        if (searchMaxSize && !(maxSize > content.length))
            four = false;

        if (searchPartOfName || searchPartOfContent || searchMinSize || searchMaxSize){
            if (one && two && three && four)
                foundFiles.add(file);
        }



        return super.visitFile(file, attrs);
    }

    public void setPartOfName(String partOfName) {
        searchPartOfName = true;
        this.partOfName = partOfName;
    }

    public void setPartOfContent(String partOfContent) {
        searchPartOfContent = true;
        this.partOfContent = partOfContent;
    }

    public void setMinSize(int minSize) {
        searchMinSize = true;
        this.minSize = minSize;
    }

    public void setMaxSize(int maxSize) {
        searchMaxSize = true;
        this.maxSize = maxSize;
    }

    public List<Path> getFoundFiles() {

        return foundFiles;
    }
}
