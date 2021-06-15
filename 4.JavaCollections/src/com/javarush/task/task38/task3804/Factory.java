package com.javarush.task.task38.task3804;

public class Factory  {
    public static Throwable createException(Enum e ){
        if (e == null) return new IllegalArgumentException();

        String message = e.name().charAt(0) + e.name().substring(1).toLowerCase().replace("_", " ");
        System.out.println(message);
        if (e instanceof ApplicationExceptionMessage){
            return new Exception(message);
        }else if (e instanceof DatabaseExceptionMessage){
            return new RuntimeException(message);
        }else if (e instanceof UserExceptionMessage){
            return new Error(message);
        }else return new IllegalArgumentException();

    }
}
