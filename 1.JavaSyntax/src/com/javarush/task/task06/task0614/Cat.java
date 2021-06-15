package com.javarush.task.task06.task0614;

import java.util.ArrayList;

/* 
Статические коты
*/

public class Cat {
    public static ArrayList<Cat> cats = new ArrayList<Cat>();
    //напишите тут ваш код

    public Cat() {

    }

    public static void main(String[] args) {
        for (int i=0; i<10; i++){
            cats.add(new Cat());
        }
        //напишите тут ваш код
        printCats();
    }

    public static void printCats() {
        for (int i=0; i<Cat.cats.size(); i++){
            System.out.println(Cat.cats.get(i));
        }
        //напишите тут ваш код
    }
}
