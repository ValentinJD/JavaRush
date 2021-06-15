package com.javarush.task.task08.task0820;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* 
Множество всех животных
*/

public class Solution {
    public static void main(String[] args) {
        Set<Cat> cats = createCats();
        Set<Dog> dogs = createDogs();

        Set<Object> pets = join(cats, dogs);
        printPets(pets);


        removeCats(pets, cats);
        printPets(pets);

    }

    public static Set<Cat> createCats() {
        Set<Cat> result = new HashSet<Cat>();
        result.add(new Cat());
        result.add(new Cat());
        result.add(new Cat());
        result.add(new Cat());
        //напишите тут ваш код

        return result;
    }

    public static Set<Dog> createDogs() {
        Set<Dog> dogSet = new HashSet<Dog>();
        dogSet.add(new Dog());
        dogSet.add(new Dog());
        dogSet.add(new Dog());
        //напишите тут ваш код
        return dogSet;
    }

    public static Set<Object> join(Set<Cat> cats, Set<Dog> dogs) {
        Set<Object> objCatandDog = new HashSet<>();
        objCatandDog.addAll(cats);
        objCatandDog.addAll(dogs);
        //напишите тут ваш код
        return objCatandDog;
    }

    public static void removeCats(Set<Object> pets, Set<Cat> cats) {
        Iterator<Object> iterator = pets.iterator();
        pets.removeAll(cats);
        /*while (iterator.hasNext()){
            Object cat = iterator.next();
            if(cat instanceof Cat) iterator.remove();
        }*/

        //напишите тут ваш код
    }

    public static void printPets(Set<Object> pets) {
        for (Object dog : pets){
            System.out.println(dog);
        }
        //напишите тут ваш код
    }

    public static class Cat {

    }

    public static class Dog {

    }

    //напишите тут ваш код
}
