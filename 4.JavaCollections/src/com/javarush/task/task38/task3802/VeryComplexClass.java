package com.javarush.task.task38.task3802;

/* 
Проверяемые исключения (checked exception)
*/

import java.io.File;
import java.nio.file.Files;

public class VeryComplexClass {
    public void veryComplexMethod() throws Exception {
        File file = new File("sdf");
        Files.createFile(file.toPath());
        //напишите тут ваш код
    }

    public static void main(String[] args)  {
       // new VeryComplexClass().veryComplexMethod();

    }
}
