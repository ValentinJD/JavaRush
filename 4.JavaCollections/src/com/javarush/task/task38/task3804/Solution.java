package com.javarush.task.task38.task3804;

/* 
Фабрика исключений
*/

public class Solution {
    public static Class getFactoryClass() {
        return new Factory().getClass();
    }

    public static void main(String[] args) {
        Factory.createException(ApplicationExceptionMessage.SOCKET_IS_CLOSED);
        //System.out.println(ApplicationExceptionMessage.SOCKET_IS_CLOSED.name());


    }
}