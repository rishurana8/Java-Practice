package org.rishudesign.com.Multithreading.CustomThreadPoolExecutor;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ThreadPool {
    private BlockingQueue<Runnable> taskQueue  = null;
    private List<PoolThreadRunnable> runnables = new ArrayList<>();
    private boolean isStopped = false;

    public ThreadPool(int noOfThreads, int maxNoOfTasks){
        taskQueue  = new ArrayBlockingQueue(maxNoOfTasks);

        for(int i=0;i<noOfThreads;i++){
            // this is required because jitni threads hongi utne runnable toh lgenge hi threads ko run krne k liye
            PoolThreadRunnable poolThreadRunnable = new PoolThreadRunnable(taskQueue);

            runnables.add(poolThreadRunnable);
        }

        for(PoolThreadRunnable runnable: runnables){
            new Thread(runnable).start();
        }

    }

    public synchronized void execute(Runnable task) throws Exception{
        if(this.isStopped)
             throw new IllegalStateException("Thread Pool is Stopped");
        this.taskQueue.offer(task);
    }

    public synchronized  void stop(){
        this.isStopped = true;
        for(PoolThreadRunnable runnable: runnables){
            runnable.doStop();
        }
    }

    public synchronized void waitUntillAllTasksFinished(){
        while(this.taskQueue.size()>0){
            try{
                Thread.sleep(1);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

}
