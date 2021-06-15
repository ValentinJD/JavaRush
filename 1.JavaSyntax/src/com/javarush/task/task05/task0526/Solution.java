package com.javarush.task.task05.task0526;

/* 
Мужчина и женщина
*/

public class Solution {
    public static void main(String[] args) {
        Man man1 = new Man("Вася", 15, "Самара");
        Man man2 = new Man("Вася", 19, "Самара");
        Woman woman1 = new Woman("Марина", 19, "Самара");
        Woman woman2 = new Woman("Марина", 21, "Самара");
        System.out.println(man1);
        System.out.println(man2);
        System.out.println(woman1);
        System.out.println(woman2);


        //напишите тут ваш код
    }
    public static class Man{
        public String name;
        public int age;
        public String address;

        public String toString(){
            return name + " " + age + " " + address;
        }

        public Man(){
            this.name = "б";
            this.age = 12;
            this.address = "kinel";
        }

        public Man(String name){
            this.name = name;
            this.age = 12;
            this.address = "kinel";
        }

        public Man(String name, int age){
            this.name = name;
            this.age = age;
            this.address = "kinel";
        }

        public Man(String name, int age, String address){
            this.name = name;
            this.age = age;
            this.address = address;
        }

    }

    public static class Woman{
        public String name;
        public int age;
        public String address;

        public String toString(){
            return name + " " + age + " " + address;
        }

        public Woman(){
            this.name = "m";
            this.age = 19;
            this.address = "kinel";
        }

        public Woman(String name){
            this.name = name;
            this.age = 12;
            this.address = "kinel";
        }

        public Woman(String name, int age){
            this.name = name;
            this.age = age;
            this.address = "kinel";
        }

        public Woman(String name, int age, String address){
            this.name = name;
            this.age = age;
            this.address = address;
        }

    }

    //напишите тут ваш код
}
