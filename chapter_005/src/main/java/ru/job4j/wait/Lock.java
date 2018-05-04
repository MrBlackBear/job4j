package ru.job4j.wait;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

@ThreadSafe
public class Lock {
    @GuardedBy("lock")
    private final Object lock = new Object();
    private boolean flag = false;
    private Thread t;

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
            t = Thread.currentThread();
        }
    }

    public void unlock() {
        if (t.equals(Thread.currentThread())) {
            synchronized (lock) {
                flag = false;
                lock.notifyAll();
            }
        }
    }
}
