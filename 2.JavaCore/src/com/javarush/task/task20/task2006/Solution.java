package com.javarush.task.task20.task2006;                                                  
                                                  
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;                                                  
import java.util.List;

/*                                                   
Как сериализовать?                                                  
*/                                                  
public class Solution {                                                  
    public static class Human implements Serializable{                                                  
        public String name;                                                  
        public List<String> assets = new ArrayList<>();                                                  
                                                  
        public Human() {                                                  
        }                                                  
                                                  
        public Human(String name, String... assets) {                                                  
            this.name = name;                                                  
            if (assets != null) {                                                  
                this.assets.addAll(Arrays.asList(assets));                                                  
            }                                                  
        }                                                  
    }                                                  
                                                  
    public static void main(String[] args) throws Exception {
        //Human human = new Human("Вася");
       // FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\Валентин\\Desktop\\test.txt");
        //ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutputStream);
        //objectOutput.writeObject(human);
        //fileOutputStream.close();
        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\Валентин\\Desktop\\test.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        Human human = (Human) objectInputStream.readObject();
        System.out.println(human.name);
    }                                                  
}