package com.javarush.task.task12.task1212;

/* 
«Исправь код», часть 1
*/

public abstract class Solution {
    public static void main(String[] args) {

    }

    public abstract static class Pet {
        public String getName() {
            return "Я - котенок";
        }

        public abstract Pet getChild();
    }
}
