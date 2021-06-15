package com.javarush.task.task07.task0724;

/* 
Семейная перепись
*/

public class Solution {
    public static void main(String[] args) {
        Human human1 = new Human("Дед Петя", true, 50);
        Human human2 = new Human("Бабушка Лена", false, 50);
        Human human3 = new Human("Дед Вася", true, 50);
        Human human4 = new Human("Бабушка Аня", false, 50);
        Human father = new Human("Отец Сергей", true, 35, human1, human2);
        Human mother = new Human("Мама Юля", false, 35, human1, human2);
        Human son1 = new Human("сын Егор", true, 15, father, mother);
        Human son2 = new Human("сын Женя", true, 15, father, mother);
        Human son3 = new Human("сын Олег", true, 15, father, mother);

        System.out.println(human1);
        System.out.println(human2);
        System.out.println(human3);
        System.out.println(human4);
        System.out.println(father);
        System.out.println(mother);
        System.out.println(son1);
        System.out.println(son2);
        System.out.println(son3);


        // напишите тут ваш код
    }

    public static class Human {
        String name;
        boolean sex;
        int age;
        Human father;
        Human mother;

        public Human (String name, boolean sex, int age) {
            this.name = name;
            this.sex = sex;
            this.age = age;

        }
        public Human(String name, boolean sex, int age, Human father, Human mother){
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father= father;
            this.mother = mother;

        }
        // напишите тут ваш код

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null) {
                text += ", отец: " + this.father.name;
            }

            if (this.mother != null) {
                text += ", мать: " + this.mother.name;
            }

            return text;
        }
    }
}