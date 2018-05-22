package ru.job4j;

public class DeadLock {
    public static void main(String[] args) {
        Object first = new Object();
        Object second = new Object();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (first) {
                    System.out.println(Thread.currentThread().getName() + "get first monitor");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "trying to get second monitor");
                    synchronized (second) {
                        System.out.println(Thread.currentThread().getName() + "get second monitor");
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (second) {
                    System.out.println(Thread.currentThread().getName() + "get second monitor");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "trying to get first monitor");
                    synchronized (first) {
                        System.out.println(Thread.currentThread().getName() + "get first monitor");
                    }
                }
            }
        }).start();
    }
}
