package com.javarush.task.task28.task2806;

import java.util.concurrent.*;

/* 
Знакомство с Executors
*/
public class Solution {
    public static void main(String[] args) throws InterruptedException {
        final int[] local = {1};
        ExecutorService threadPoolExecutor = Executors.newFixedThreadPool(5);
        for (int i =0; i < 10; i++){
            threadPoolExecutor.submit(new Runnable() {
                @Override
                public void run() {
                    doExpensiveOperation(local[0]++);
                }
            });
        }
        threadPoolExecutor.shutdown();
        threadPoolExecutor.awaitTermination(5, TimeUnit.SECONDS);
        //Add your code here

        /* output example
pool-1-thread-2, localId=2
pool-1-thread-1, localId=1
pool-1-thread-3, localId=3
pool-1-thread-1, localId=7
pool-1-thread-1, localId=9
pool-1-thread-4, localId=4
pool-1-thread-5, localId=5
pool-1-thread-2, localId=6
pool-1-thread-1, localId=10
pool-1-thread-3, localId=8
         */
    }

    private static void doExpensiveOperation(int localId) {
        System.out.println(Thread.currentThread().getName() + ", localId="+localId);
    }
}
