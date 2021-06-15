package com.javarush.task.task38.task3812;

/* 
Обработка аннотаций
*/

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        printFullyQualifiedNames(Solution.class);
        printFullyQualifiedNames(SomeTest.class);

        printValues(Solution.class);
        printValues(SomeTest.class);
    }

    public static boolean printFullyQualifiedNames(Class c)  {
        if (c.isAnnotationPresent(PrepareMyTest.class)){
            PrepareMyTest prepareMyTest = (PrepareMyTest) c.getAnnotation(PrepareMyTest.class);
            String[] s = prepareMyTest.fullyQualifiedNames();
            System.out.println(Arrays.toString(s));
            return true;
        }else {
            return false;
        }

    }

    public static boolean printValues(Class c) {
        Annotation annotation = c.getAnnotation(PrepareMyTest.class);

        if (c.isAnnotationPresent(PrepareMyTest.class)){
            PrepareMyTest prepareMyTest = (PrepareMyTest) c.getAnnotation(PrepareMyTest.class);
            Class<?>[] result = prepareMyTest.value();
            for (Class<?> clazz: result) {
                System.out.println(clazz);
            }


            return true;
        }else {
            return false;
        }
    }
}
