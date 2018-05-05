package ru.job4j.wait;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

@ThreadSafe
public class Lock {
    @GuardedBy("lock")
    private final Object lock = new Object();
    @GuardedBy("lock")
    private boolean flag = false;
    @GuardedBy("lock")
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
        synchronized (lock) {
            if (t.equals(Thread.currentThread())) {
                flag = false;
                lock.notifyAll();
            }
        }
    }
}
