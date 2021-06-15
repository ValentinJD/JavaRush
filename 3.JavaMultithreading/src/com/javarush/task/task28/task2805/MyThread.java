package com.javarush.task.task28.task2805;

public class MyThread extends Thread {
    private static int priorytet = 0;
    private static int pr = 1;
    private ThreadGroup group = this.getThreadGroup();

    {
        if (super.getThreadGroup() != group) {
            if ((priorytet + 1) < (super.getThreadGroup().getMaxPriority() + 1)) {
                priorytet++;
            } else if ((priorytet + pr) < 11) {
                pr++;
            } else priorytet = 1;
        } else if ((priorytet + 1) < 11) {
            priorytet++;
        } else priorytet = 1;

        this.setPriority(priorytet);
    }

    public MyThread() {
    }

    public MyThread(Runnable target) {
        super(target);
    }

    public MyThread(ThreadGroup group, Runnable target) {
        super(group, target);
    }

    public MyThread(String name) {
        super(name);
    }

    public MyThread(ThreadGroup group, String name) {
        super(group, name);
    }

    public MyThread(Runnable target, String name) {
        super(target, name);
    }

    public MyThread(ThreadGroup group, Runnable target, String name) {
        super(group, target, name);
    }

    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize) {
        super(group, target, name, stackSize);
    }


}
