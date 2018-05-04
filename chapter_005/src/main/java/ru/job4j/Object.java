package ru.job4j;

public class Object {
    StringBuffer string = new StringBuffer();

    public void convert(int number) {
        string.append(number);
    }

    public StringBuffer getString() {
        return string;
    }

    public static void main(String[] args) throws InterruptedException {
        Object object = new Object();
        Thread first = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (object) {
                    while (true) {
                        for (int i = 0; i < 10; i++) {
                            object.convert(1);
                            System.out.println("Add 1");
                        }
                        try {
                            object.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        object.notify();
                    }
                }
            }
        });

        Thread second = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (object) {
                    while (true) {
                        for (int i = 0; i < 10; i++) {
                            object.convert(2);
                            System.out.println("Add 2");
                        }
                        object.notify();
                        try {
                            object.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }

            }
        });
        first.start();
        second.start();
    }
}
