package ru.job4j.wait;

public class SimpleBlockingQueueTest {
    public static void main(String[] args) throws InterruptedException {
        SimpleBlockingQueue<Integer> sbq = new SimpleBlockingQueue<>();
        Thread newCostumer = new Thread(new Customer(sbq));
        Thread newProducer = new Thread(new Producer(sbq));
        newProducer.start();
        newProducer.join();
        newCostumer.start();
        newCostumer.join();
    }
}

class Producer implements Runnable {
    private final SimpleBlockingQueue<Integer> sbq;

    public Producer(final SimpleBlockingQueue<Integer> simpleBlockingQueue) {
        sbq = simpleBlockingQueue;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            try {
                System.out.printf("\n%s %s %s", Thread.currentThread().getName(), "добавил", i);
                sbq.offer(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Customer implements Runnable {
    private final SimpleBlockingQueue<Integer> sbq;

    public Customer(final SimpleBlockingQueue<Integer> simpleBlockingQueue) {
        sbq = simpleBlockingQueue;
    }

    @Override
    public void run() {
        while (!sbq.isEmp()) {
            try {
                System.out.printf("\n%s %s %s", Thread.currentThread().getName(), "забрал", sbq.poll());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
