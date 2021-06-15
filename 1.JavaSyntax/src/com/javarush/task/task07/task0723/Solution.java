package com.javarush.task.task07.task0723;

/* 
Обратный отсчёт
*/

import static java.lang.Thread.sleep;

public class Solution {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 30; i >= 0; i--) {
            sleep(100);
            System.out.println(i);


            //напишите тут ваш код
        }

        System.out.println("Бум!");
    }
}
