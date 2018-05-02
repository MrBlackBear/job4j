package ru.job4j.wait;

import java.util.LinkedList;
import java.util.Queue;

public class ThreadPool {
    /**
     * Queue of tasks.
     */
    private final Queue<Work> queue = new LinkedList<>();

    /**
     * Threads to run tasks.
     */
    private Thread[] threads;

    /**
     * Lock.
     */
    private final Object lock = new Object();

    /**
     * Close-flag.
     */
    private boolean closed = false;

    /**
     * Constructor with processors cores.
     */
    public ThreadPool() {
        this(Runtime.getRuntime().availableProcessors());
    }

    /**
     * Constructor with custom amount of threads.
     *
     * @param cores int.
     */
    public ThreadPool(int cores) {
        threads = new Thread[cores];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new Work());
            threads[i].start();
        }
    }

    /**
     * Add task to Thread Pool.
     *
     * @param work work
     */
    public void add(Work work) {
        synchronized (lock) {
            if (!closed) {
                queue.add(work);
                lock.notifyAll();
            }
        }
    }

    /**
     * Shut Down Thread Pool.
     */
    public void shutdown() {
        closed = true;
        for (Thread thread : threads) {
            thread.interrupt();
        }
    }

    /**
     * Pool Runnable to run in threads.
     */
    private class Work implements Runnable {
        @Override
        public void run() {
            while (!closed) {
                synchronized (lock) {
                    while (queue.isEmpty() && !closed) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            break;
                        }
                    }
                }
                if (!closed) {
                    Runnable task;
                    synchronized (queue) {
                        task = queue.poll();
                    }
                    if (task != null) {
                        task.run();
                    }
                }
            }
        }
    }
}
