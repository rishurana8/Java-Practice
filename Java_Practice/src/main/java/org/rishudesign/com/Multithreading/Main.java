package org.rishudesign.com.Multithreading;



public class Main {

    private static Runnable getIncrementingRunnable(CounterSynchronised counter){
          return () -> {
             for(int i=0;i<10000;i++){
                 counter.incandget();
             }
              System.out.println("Thread1 final count: " + counter.get());
          };
    }

    private static Runnable getIncrementingRunnableUpdated(CounterSynchronised counter){
        return () -> {
          synchronized (counter){
              for(int i=0;i<10000;i++){
                  counter.incandget();
              }
          }
            System.out.println("Update incrementing thread count: " + counter);
        };
    }

    private static Runnable getReadingRunnable(CounterSynchronised counter){
        return () ->{
          for(int i=0;i<5;i++){
              try{
                  Thread.sleep(1);
              }catch(InterruptedException e){
                  e.printStackTrace();
              }
          }
            System.out.println("Thread2 final count: " + counter.get());
        };
    }

    public static void main(String args[]){
        Runnable runnable = new MyRunnable();


        // we are passing same runnable object so count will have only copy so it will create race condition
        Thread thread1 = new Thread(runnable, "Runnable1");
        Thread thread2 = new Thread(runnable, "Runnable2");

        thread1.start();
        thread2.start();

        Threadlocal threadlocal = new Threadlocal();
        threadlocal.startThreads();

        CounterSynchronised counter = new CounterSynchronised();

        Thread threadn = new Thread(getIncrementingRunnable(counter));
        Thread threadm = new Thread(getReadingRunnable(counter));


        threadn.start();
        threadm.start();

        MyObject myObject= new MyObject();

        Runnable runnable1 = new MyRunnableObjs(myObject);
        Runnable runnable2 = new MyRunnableObjs(myObject);

        Thread threadr = new Thread(runnable1,"Threadr");
        Thread threads = new Thread(runnable2,"Threads");

        threadr.start();
        threads.start();

        // now since threadm and threadn will cause problem becuase in those runnables count is pointing to same heap memory


    }
}
