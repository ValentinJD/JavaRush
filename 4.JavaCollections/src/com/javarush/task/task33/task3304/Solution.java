package com.javarush.task.task33.task3304;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.StringWriter;

/* 
Конвертация из одного класса в другой используя JSON
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        Second s = (Second) convertOneToAnother(new First(), Second.class);
        First f = (First) convertOneToAnother(new Second(), First.class);
    }

    public static Object convertOneToAnother(Object one, Class resultClassObject) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        StringWriter writer = new StringWriter();
        objectMapper.writeValue(writer, one); // сериализуем первый объект
        System.out.println(writer);
        String replaceOne = one.getClass().getSimpleName().toLowerCase();
        String replaceTwo = resultClassObject.getSimpleName().toLowerCase();
        String strJson = writer.toString().replaceFirst(replaceOne,replaceTwo); // заменяем first на second
        System.out.println(strJson);
        return objectMapper.readValue(strJson, resultClassObject);
    }

    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "className")
    @JsonSubTypes(
            @JsonSubTypes.Type(value = First.class, name = "first")
    )
    public static class First {
        public int i;
        public String name;
    }

    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "className")
    @JsonSubTypes(
            @JsonSubTypes.Type(value = Second.class, name = "second")
    )
    public static class Second {
        public int i;
        public String name;
    }
}
