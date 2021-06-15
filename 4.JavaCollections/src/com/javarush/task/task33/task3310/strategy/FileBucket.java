package com.javarush.task.task33.task3310.strategy;

import com.javarush.task.task33.task3310.Helper;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileBucket {
    Path path;


    public FileBucket() {
        try {
            this.path = Files.createTempFile(null, null);
            Files.deleteIfExists(path);
            Files.createFile(path);
            path.toFile().deleteOnExit();
        } catch (Exception e) {
            System.err.println(e);
        }

    }

    public long getFileSize() {
        try {
            return Files.size(path);
        } catch (Exception e) {

        }
        return 0l;
    }

    public void putEntry(Entry entry) {
        try {
            OutputStream outputStream = Files.newOutputStream(path);
            ObjectOutputStream out = new ObjectOutputStream(outputStream);
            out.writeObject(entry);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    } // - должен сериализовывать переданный entry в файл. Учти, каждый entry может содержать еще один entry.

    public Entry getEntry() {
        if (getFileSize() > 0){
            try {
                InputStream in = Files.newInputStream(path);
                ObjectInputStream input = new ObjectInputStream(in);
                Entry entry = (Entry) input.readObject();
                input.close();
                in.close();
                return entry;
            }catch (IOException | ClassNotFoundException e){
                e.printStackTrace();
            }            
        }
        return null;
    } //- должен забирать entry из файла. Если файл имеет нулевой размер, вернуть null.


    public void remove() {
        try {
            Files.delete(path);
        } catch (IOException e) {
            e.printStackTrace();
        }

    } //- удалять файл на который указывает path.

}
