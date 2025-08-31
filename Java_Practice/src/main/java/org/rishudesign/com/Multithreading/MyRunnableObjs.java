package org.rishudesign.com.Multithreading;

public class MyRunnableObjs implements Runnable{

    private int count = 0;
    private MyObject myObject = null;

    public MyRunnableObjs(MyObject myObject){
        this.myObject = myObject;
    }
    @Override
    public void run() {
        System.out.println(myObject);

        for(int i=0;i<100000;i++){
            this.count++;
        }

        System.out.println(Thread.currentThread().getName() + ": " + this.count);
    }
}
