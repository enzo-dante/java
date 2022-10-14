package com.crownhounds.masterjava.concurrency;

public class MultipleThreads {
     /*
        ! CONCURRENCY the ability of software to execute processes simultaneously (one task doesn't have to complete before another one can start)

            Now that doesn't necessarily mean that the application is doing more than one thing at a time or at the same time, what it means is that progress can be made on more than one task.

        ! BENEFITS

            BENEFIT 1:
                free up the main thread so that it can continue working and executing, you can report progress or accept user input and perform those other tasks on the screen or in other parts of the program,
                while another long-running task that we kicked off in another thread continues to execute in the background.

            BENEFIT 2: might want to use threads is because an API requires us to provide one.

                EXAMPLE:
                    an application wants to download data and draw a shape on the screen.
                    So if it's a concurrent application, what it can do is it can download a bit of data, then switch to drawing part of the shape and switch back to downloading some more data, then switch back to drawing more of the shape, and so on.

        ! PROCESS: an instance of a computer program with its own memory space that's sequentially executed by a computer system that has the ability to run several computer programs concurrently.

            java virtual machine instance ->
                    the JVM runs as a process ->
                        running a java console application ->
                            we're initiating said PROCESS

        ! THREAD: a unit of execution within a process, each process can have multiple threads, a method for a program to "split" itself into two or more simultaneously or pseudo-simultaneously running tasks.

            creating a thread doesn't require as many resources as creating a process.
            generally, a thread is contained inside a process and different threads in the same process share the same resources while different processes in the same multitasking operating system do not.

            every Java process or application has at least one thread and that's the main thread

            almost every java process also has multiple system threads that handle everyday tasks like memory management and input/output.
                for UI applications, this is just called the JavaFx application thread.

        ! MULTITHREADING: the JVM is multi-processed and multithreaded and has background processes running while a single-thread (main) process/application is executing.

            So every process has a heap (shared app memory) and every thread has a thread stack (specific thread memory).

            when multiple threads are working with the same object, the memory required to store an object's instance value is allocated on the heap, they in fact share the same object or share that object.

        ! SYNCHRONIZATION: the sequential heap process of controlling when threads execute code that prevents THREAD INTERFERENCE within designated code block

            When working with threads, we have to synchronize all areas where we think or where interference can happen.

        ! SYNCHRONIZATION blocks/methods: all other threads that want to call any synchronized sections in that class will suspend until the single thread running the method exits it and passes the object's INTRINSIC LOCK.

            if a class has three synchronized methods, then only one of these methods can ever run at a time and only on one thread.

            since only one thread can execute a synchronized method at a time, threads can't interleave when running a synchronized method.

            that prevents thread interference within synchronized methods, but not outside those methods.

                if the same instance variables referenced within a synchronized method are also referenced outside it in code that multiple threads can run and that particular code isn't synchronized, then we may still see thread interference.

            In Java to synchronize a method, all we really have to do is add the synchronized keyword to a method declaration.

        ! STATIC OBJECT SYNCHRONIZATION: the intrinsic lock that's used is owned by the class object

            synchronize a block of statements that work with an object by forcing threads to acquire the object's lock before they execute the statement block.

            only one thread can hold the lock at a time, so other threads that want the lock will be suspended until the running thread releases it.

            Then one and only one of the waiting threads can get the lock and continue executing.

         // ! THREAD SYNCHRONIZATION + EXCEPTION HANDLING + INTRINSIC REENTRANT LOCK: in TRY-FINALLY code block, use ReentrantLock.lock() to acquire the object's intrinsic lock & execute code one at a time -- other calling threads will suspend until the single running thread calls Reentrant.unlock() to pass the class/object's INTRINSIC LOCK.

        // ! THREAD SYNCHRONIZATION + DEAD LOCKS: application freezes during execution due to unreleased INTRINSIC LOCKS - the synchronized shared-resource code executes one at a time and the single running thread is holding the objects INTRINSIC LOCK blocking other threads that WAIT for the lock release via NOTIFY
     */

    public static void main(String[] args) {
        CountdownThread.Countdown countdown = new CountdownThread.Countdown();

        CountdownThread t1 = new CountdownThread(countdown);
        t1.setName("Thread 1");

        CountdownThread t2 = new CountdownThread(countdown);
        t2.setName("Thread 2");

        // ! THREAD INTERFERENCE/race condition: when 2 or more threads are writing/updating a shared resource in the HEAP, the updated resource interfere yields unpredictable results with a given thread's execution
        t1.start();
        t2.start();

    }
}

class CountdownThread extends Thread {

    // CONSTANTS/static class variables assigned FINAL value before compilation/instantiation
    private static final String THREAD_ONE = "Thread 1";
    private static final String THREAD_TWO = "Thread 2";

    // private class fields
    private Countdown threadCountdown;

    public CountdownThread(Countdown countdown) {
        this.threadCountdown = countdown;
    }

    @Override
    public void run() {
        threadCountdown.doCountDown();
    }

    // INNER CLASS: logically grouped components with a parent class
    // STATIC: class variable saved in a single space in memory and utilized across entire app
    static class Countdown {

        // OOP ENCAPSULATION: access-modifiers for a class to guard against inappropriate external use
        // private class fields
        private int i;

        // ! SYNCHRONIZATION blocks/methods: all other threads that want to call any synchronized sections in that class will suspend until the single thread running the method exits it and passes the object's INTRINSIC LOCK.
        public synchronized void doCountDown() {
            String color;
            String threadName = Thread.currentThread().getName();

            switch (threadName) {
                case THREAD_ONE:
                    color = ThreadColor.ANSI_CYAN;
                    break;
                case THREAD_TWO:
                    color = ThreadColor.ANSI_PURPLE;
                    break;
                default:
                    color = ThreadColor.ANSI_GREEN;
                    break;
            }

            synchronizedLoop(color, threadName);
        }

        // ! SYNCHRONIZATION + THREAD SAFE critical section: all shared-resource code executes one a time: other calling threads will suspend until the single running thread exits the synchronized code block and passes the class/object's INTRINSIC LOCK.
        private void synchronizedLoop(String color, String threadName) {
            synchronized (this) {
                for(i = 10; i > 0; i--) {
                    System.out.println(color + threadName + ": i = " + i);
                }
            }
        }
    }
}