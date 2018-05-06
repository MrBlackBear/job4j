package ru.job4j.wait;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.concurrent.*;

@ThreadSafe
public class ThreadPool {
    /**
     * Queue of tasks.
     */
    private final BlockingQueue<Work> queue = new LinkedBlockingQueue<>();

    /**
     * Threads to run tasks.
     */
    private Thread[] threads;

    private volatile boolean finish = false;
    /**
     * Lock.
     */
    @GuardedBy("queue")
    private final Object lock = new Object();

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
    private ThreadPool(int cores) {
        threads = new Thread[cores];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new Work());
        }
    }

    /**
     * Add task to Thread Pool.
     *
     * @param work work
     */
    public void add(Work work) {
        if (finish) {
            queue.add(work);
            finish = false;
            queue.notifyAll();
        }
    }

    /**
     * Shut Down Thread Pool.
     */
    public void shutdown() {
        for (Thread thread : threads) {
            thread.interrupt();
        }
        finish = true;
    }

    public void start() {
        for (Thread t : threads) {
            t.start();
        }
    }

    /**
     * Pool Runnable to run in threads.
     */
    private class Work implements Runnable {
        @Override
        public void run() {
            if (queue.isEmpty()) {
                finish = true;
            }
            while (finish) {
                try {
                    queue.wait();
                } catch (InterruptedException e) {
                    break;
                }
            }
            finish = false;
            while (!finish) {
                try {
                    Runnable task = queue.poll(200, TimeUnit.MILLISECONDS);
                    if (task != null) {
                        task.run();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
