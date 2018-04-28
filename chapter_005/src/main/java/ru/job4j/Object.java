package ru.job4j;

public class Object {
    String string = "";

    public void convert(int number) {
        Integer num = new Integer(number);
        string += num.toString();
    }

    public String getString() {
        return string;
    }

    public static void main(String[] args) throws InterruptedException {
        Object object = new Object();
        boolean flag = true;
        Thread first = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    for (int i = 0; i < 10; i++) {
                        object.convert(1);
                        System.out.println("Add 1");
                    }
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread second = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    for (int i = 0; i < 10; i++) {
                        object.string += "2";
                        System.out.println("Add 2");
                    }
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        });
        first.start();
        second.start();
    }
}
