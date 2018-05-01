package ru.job4j.wait;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.LinkedList;
import java.util.Queue;

@ThreadSafe
class SimpleBlockingQueue<T> {
    @GuardedBy("queue")
    private final Queue<T> queue = new LinkedList<>();

    void offer(T value) throws InterruptedException {
        int size = 5;
        synchronized (queue) {
            while (queue.size() == size) {
                queue.wait();
            }
            queue.notifyAll();
            queue.offer(value);
        }
    }

    T poll() throws InterruptedException {
        int size = 5;
        synchronized (queue) {
            while (queue.isEmpty()) {
                this.wait();
            }
            queue.notifyAll();
            return queue.poll();
        }
    }

    boolean isEmp() {
        synchronized (queue) {
            return queue.isEmpty();
        }
    }
}
