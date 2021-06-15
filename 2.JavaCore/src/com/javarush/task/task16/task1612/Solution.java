package com.javarush.task.task16.task1612;

/* 
Stopwatch (Секундомер)
*/

public class Solution {
    public static volatile boolean isStopped = false;

    public static void main(String[] args) throws InterruptedException {
        Runner ivanov = new Runner("Ivanov", 4);
        Runner petrov = new Runner("Petrov", 2);
        //на старт!
        //внимание!
        //марш!
        ivanov.start();
        //System.out.println("Иванов стартанул");
        petrov.start();
        //System.out.println("Петров стартанул");
        //System.out.println("main спит");
        Thread.sleep(2000);
        //System.out.println("main проснулся");
        isStopped = true;
        //System.out.println("Финиш");
        Thread.sleep(1000);
    }

    public static class Stopwatch extends Thread {
        private Runner owner;
        private int stepNumber;

        public Stopwatch(Runner runner) {
            this.owner = runner;
        }

        public void run() {
            try {
                while (!isStopped) {
                    doStep();
                }
            } catch (InterruptedException e) {
            }
        }

        private void doStep() throws InterruptedException {
            stepNumber++;
            long speed = owner.getSpeed();
            Thread.sleep(1000/speed);
            //add your code here - добавь код тут
            System.out.println(owner.getName() + " делает шаг №" + stepNumber + "!");
        }
    }

    public static class Runner {
        Stopwatch stopwatch;
        private String name;
        private int speed;

        public Runner(String name, int speed) {
            this.name = name;
            this.speed = speed;
            this.stopwatch = new Stopwatch(this);
        }

        public String getName() {
            return name;
        }

        public int getSpeed() {
            return speed;
        }

        public void start() {
            stopwatch.start();
        }
    }
}
