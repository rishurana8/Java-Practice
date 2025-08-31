package org.rishudesign.com.Multithreading.CustomThreadPoolExecutor;

import java.util.concurrent.BlockingQueue;

public class PoolThreadRunnable implements Runnable{

    private Thread thread = null;
    private BlockingQueue taskQueue = null;
    private boolean isStopped = false;

    public PoolThreadRunnable(BlockingQueue queue){
        taskQueue = queue;
    }

    @Override
    public void run() {
       this.thread = Thread.currentThread();
        while(!isStopped()){
             try{
                 Runnable runnable = (Runnable) taskQueue.take();
             }catch (Exception e){

             }
        }
    }

    public synchronized void doStop(){
                isStopped = true;
                this.thread.interrupt();
    }

    public boolean isStopped(){
        return isStopped;
    }
}
