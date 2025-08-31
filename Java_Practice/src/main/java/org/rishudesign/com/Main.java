package org.rishudesign.com;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");

        System.out.println("current thread: " + Thread.currentThread().getName());

        Runnable run = () ->{
            System.out.println("current thread: " + Thread.currentThread().getName());
        };

        Thread thread = new Thread(run);
        thread.start();
    }
}