package com.javarush.task.task33.task3303;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

/* 
Десериализация JSON объекта
*/
public class Solution {
    public static <T> T convertFromJsonToNormal(String fileName, Class<T> clazz) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(new File(fileName), clazz);

    }

    public static void main(String[] args) {
       /* Cat cat = new Cat();
        Cat cat2 = null;
        try {
           cat2 = convertFromJsonToNormal("C:\\Users\\Валентин\\Desktop\\tt.txt", cat.getClass());
        }catch (Exception e){
            e.printStackTrace();
        }

        System.out.println(cat2.id);*/
    }
}

 class Cat{
    public int id;

    public Cat() {
    }
}
