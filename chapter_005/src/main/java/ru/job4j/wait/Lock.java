package ru.job4j.wait;

public class Lock {
    private Object lock = new Object();
    boolean flag = false;

    public void lock() {
        synchronized (lock) {
            while (flag) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            flag = true;
        }
    }

    public void unlock() {
        synchronized (lock) {
            flag = false;
            lock.notifyAll();
        }
    }
}
