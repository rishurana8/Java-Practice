package org.rishudesign.com.Multithreading;

public class Threadlocal {
    ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public void startThreads() {
        Thread thread1 = new Thread(() -> {
            threadLocal.set("Thread1");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            String value = threadLocal.get();
            System.out.println(value);
        });

        Thread thread2 = new Thread(() -> {
            threadLocal.set("Thread2");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            String value = threadLocal.get();
            System.out.println(value);
        });

        thread1.start();
        thread2.start();
    }
}
