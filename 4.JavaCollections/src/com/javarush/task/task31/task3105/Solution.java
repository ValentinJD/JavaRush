package com.javarush.task.task31.task3105;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;
import java.io.File;

/* 
Добавление файла в архив
*/
public class Solution {
    public static void main(String[] args) throws IOException {

        // Алгоритм
        // 1. Считываем все ентри в мапу (имя, байты)
        //2. Записываем ентри с проверкой
        // если имя текущего ентри совпадает с именем  в args[0] то заменяем его Files.copy
        // иначе продолжаем добавлять
        // если совпадения не было флаг match в false то добавляем файл из args[0] в папку new

        Map<String, ByteArrayOutputStream> allFiles = new HashMap<>();
        String sourceFile = args[0]; //args[0]; // "C:\\Users\\Валентин\\Desktop\\test.txt";

        String nameZip =  args[1]; //args[1]; //"C:\\Users\\Валентин\\Desktop\\archiv.zip";
        //String NewNameZip = nameZip; // nameZip; //"C:\\Users\\Валентин\\Desktop\\NewArchiv.zip";
        try(ZipInputStream zis = new ZipInputStream(new FileInputStream(nameZip))
        ){
            ZipEntry zipEntry;
        while ((zipEntry = zis.getNextEntry()) != null){
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            String nameFileInZip = zipEntry.getName();
            //System.out.printf("Считываем файл с именем %s из архива.\n", nameFileInZip);
            
            byte[] buffer = new byte[1024];
            int count = 0;
            while ((count = zis.read(buffer)) != -1){
                baos.write(buffer, 0, count);
            }
            allFiles.put(nameFileInZip, baos);
            //System.out.printf("Файл с именем %s добавлен в Мапу.\n", nameFileInZip);
            zis.closeEntry();
            //System.out.printf("Поток для файла с именем %s закрыт.\n", nameFileInZip);
        }
        }
        
        try(ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(nameZip));
        //System.out.printf("Создаем архив файл с именем %s из архива.\n", NewNameZip);
            ){
            
        ZipEntry zipEntry1;   
        Path adding = Paths.get(args[0]);
        boolean match = false;
        for (Map.Entry<String,ByteArrayOutputStream> pair: allFiles.entrySet()){
            String nameFileOut = pair.getKey();
            zipEntry1 = new ZipEntry(nameFileOut);

            if (!Paths.get(sourceFile).getFileName().toString().equals(Paths.get(nameFileOut).getFileName().toString())){ 
                zos.putNextEntry(zipEntry1);
                zos.write(pair.getValue().toByteArray());
                zos.closeEntry();
                //System.out.printf("Добавляем файл с именем %s в архив.\n", nameFileOut);
            } else { // если в архиве есть файл с именем файла источника то заменяем его
                match = true;
                zos.putNextEntry(zipEntry1);
                Files.copy(adding, zos);
                zos.closeEntry();
                //System.out.printf("Заменяем файл с именем %s в архиве.\n", nameFileOut);
            } 
         }
         if(!match){
            zos.putNextEntry(new ZipEntry(Paths.get("new",adding.getFileName().toString()).toString()));
            Files.copy(adding, zos);
            zos.closeEntry();
         }
        
        }
    }
}
