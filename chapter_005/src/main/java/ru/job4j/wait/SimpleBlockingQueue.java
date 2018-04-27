package ru.job4j.wait;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.LinkedList;
import java.util.Queue;

@ThreadSafe
public class SimpleBlockingQueue<T> {

    @GuardedBy("this")
    private Queue<T> queue = new LinkedList<>();

    void offer(T value) throws InterruptedException {
        int size = 20;
        synchronized (this) {
            while (queue.size() == size) {
                this.wait();
            }
            queue.offer(value);
            this.notifyAll();
        }
    }

    T poll() throws InterruptedException {
        synchronized (this) {
            while (queue.isEmpty()) {
                this.wait();
            }
            this.notifyAll();
            return queue.poll();
        }
    }

    public synchronized boolean isEmp() {
        return queue.isEmpty();
    }
}
