package com.javarush.task.task25.task2514;

/* 
Первый закон Финэйгла: если эксперимент удался, что-то здесь не так...
*/
public class Solution {
    public static class YieldRunnable implements Runnable {
        private int index;

        public YieldRunnable(int index) {
            this.index = index;
        }

        public  void run() {

            System.out.println("begin-" + index);
            Thread.yield();
            System.out.println("end-" + index);
        }
    }

    public static void main(String[] args) {
        Solution.YieldRunnable task = new Solution.YieldRunnable(0);
        //Solution.YieldRunnable task2 = new Solution.YieldRunnable(1);
        //Solution.YieldRunnable task3 = new Solution.YieldRunnable(2);

        Thread test = new Thread(task);
        test.start();
        Thread test1 = new Thread(task);
        test1.start();
        Thread test3 = new Thread(task);
        test3.start();


    }
}
