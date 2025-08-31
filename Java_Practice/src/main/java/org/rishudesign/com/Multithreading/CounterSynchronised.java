package org.rishudesign.com.Multithreading;

public class CounterSynchronised {
    private long count = 0;

    public long incandget(){
        synchronized (this){
            this.count++;
            return count;
        }
    }

    public long get(){
        synchronized (this){
            return this.count;
        }
    }
}
