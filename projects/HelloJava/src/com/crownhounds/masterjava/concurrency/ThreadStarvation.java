package com.crownhounds.masterjava.concurrency;

import java.util.concurrent.locks.ReentrantLock;

public class ThreadStarvation {

    // ! THREAD STARVATION: threads aren't given the opportunity to progress due to threat priority - assigning a high priority to a thread means the OS should try and run the thread before other waiting threads.

    // ! THREAD DEAD LOCKS: application freezes during execution due to unreleased INTRINSIC LOCKS - the synchronized shared-resource code executes one at a time and the single running thread is holding the objects INTRINSIC LOCK blocking other threads that WAIT for the lock release via NOTIFY
    // ! THREAD SYNCHRONIZATION +  DEADLOCKS: key to avoiding deadlocks(when 2 or more threads are competing for 2 or more INTRINSIC LOCKS), you want to make sure that all threads are synchronized or all the threads will try to obtain the locks in the same order.
    private static Object lock = new Object();

    // ! THREAD SYNCHRONIZATION + EXCEPTION HANDLING + INTRINSIC REENTRANT LOCK: in TRY-FINALLY code block, use ReentrantLock.lock() to acquire the object's intrinsic lock & execute code one at a time -- other calling threads will suspend until the single running thread calls Reentrant.unlock() to pass the class/object's INTRINSIC LOCK.
    // ! FAIR LOCK: assign true (first come, first serve) as parameter for REENTRANT LOCK, but FAIR LOCKS negatively affect speed performance
    private static ReentrantLock reentrantLock = new ReentrantLock(true);

    // CONSTANTS/static class variables assigned FINAL value before compilation/instantiation
    private static final String PRIORITY = "Priority ";

    public static void main(String[] args) {

        // ? All threads will be competing for single memory instance of lock object due to being STATIC
        // ! THREADS + GENERIC CLASSES/LAMBDAS: Thread.instance w/ parameter class instance that implements Runnable INTERFACE & uses .start() instance on it's own thread in the HEAP
        Thread t1 = new Thread(new Worker(ThreadColor.ANSI_RED), PRIORITY + "10");
        Thread t2 = new Thread(new Worker(ThreadColor.ANSI_BLUE), PRIORITY + "8");
        Thread t3 = new Thread(new Worker(ThreadColor.ANSI_GREEN), PRIORITY + "6");
        Thread t4 = new Thread(new Worker(ThreadColor.ANSI_CYAN), PRIORITY + "4");
        Thread t5 = new Thread(new Worker(ThreadColor.ANSI_PURPLE), PRIORITY + "2");

        t1.setPriority(10);
        t2.setPriority(8);
        t3.setPriority(6);
        t4.setPriority(4);
        t5.setPriority(2);

        // ! THREADS .start(): only JVM executes .run() for a given single Thread (always a new Thread instance), including priority-assigned threads, and CANNOT assume Thread instance execution order
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }

    // INNER CLASS: logically grouped class-components within a parent super class
    // INTERFACE + OOP POLYMORPHISM: all publicly-shared method signatures must be uniquely implemented/@Overridden by designated set of classes for standardization
    private static class Worker implements Runnable {

        // private class variables
        private int runCount;
        private String threadColor;

        // OOP CONSTRUCTOR that initializes the class fields on class/object instantiation
        public Worker(String threadColor) {
            this.threadColor = threadColor;
            this.runCount = 1;
        }

        @Override
        public void run() {
            for(int i = 0; i < 100; i++) {
                // ! THREAD SYNCHRONIZATION + CRITICAL CODE: use 'synchronization' keyword to notify all other threads, that also want to call the same critical sections, to suspend until the single thread running the synchronized code block exits & passes the object's INTRINSIC LOCK, thus preventing THREAD INTERFERENCE when using a shared resource
//                synchronized(lock) {
//                    System.out.format(threadColor + "%s: runCount = %d\n", Thread.currentThread().getName(), runCount++);
//                    // critical code section
//                }

                // ! EXCEPTION HANDLING easier to ask for forgiveness than permission: use try-catch block to handle errors
                // ! THREAD SYNCHRONIZATION + INTRINSIC REENTRANT FAIR LOCK: in TRY-FINALLY code block, use ReentrantLock.lock() to acquire the object's intrinsic lock & execute code one at a time -- other calling threads will suspend until the single running thread calls Reentrant.unlock() to pass the class/object's INTRINSIC LOCK.
                reentrantLock.lock();
                try {
                    System.out.format(threadColor + "%s: runCount = %d\n", Thread.currentThread().getName(), runCount++);
                    // critical code section
                } finally {
                    reentrantLock.unlock();
                }
            }
        }
    }
}
