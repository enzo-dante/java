package com.crownhounds.masterjava.concurrency;

import java.util.stream.Stream;

public class ThreadCreation {
    /*
        ! CONCURRENCY the ability of software to execute processes simultaneously (one task doesn't have to complete before another one can start)

            Now that doesn't necessarily mean that the application is doing more than one thing at a time or at the same time, what it means is that progress can be made on more than one task.

        ! BENEFITS

            BENEFIT 1:
                free up the main thread so that it can continue working and executing and you can report progress or accept user input and perform those other tasks on the screen or in other parts of the program,
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

            So every process has a heap and every thread has a thread stack.

        ! SYNCHRONIZATION: the process of controlling when threads execute code and therefore when they can access the heap is called synchronization.

            When working with threads, we have to synchronize all areas where we think or where interference can happen.

        ! METHOD SYNCHRONIZATION: when a thread is executing the method, all other threads that want to call the method or any other synchronized method in that class will suspend until the thread running the method exits it. Then another thread can run a synchronized method then another, etc.

            if a class has three synchronized methods, then only one of these methods can ever run at a time and only on one thread.

            since only one thread can execute a synchronized method at a time, threads can't interleave when running a synchronized method.

            that prevents thread interference within synchronized methods, but not outside of those methods.

                if the same instance variables referenced within a synchronized method are also referenced outside it in code that multiple threads can run and that particular code isn't synchronized, then we may still see thread interference.

            In Java to synchronize a method, all we really have to do is add the synchronized keyword to a method declaration.

        ! STATIC OBJECT SYNCHRONIZATION: the intrinsic lock that's used is owned by the class object

            synchronize a block of statements that work with an object by forcing threads to acquire the object's lock before they execute the statement block.

            only one thread can hold the lock at a time, so other threads that want the lock will be suspended until the running thread releases it.

            Then one and only one of the waiting threads can get the lock and continue executing.
     */

    // main() will spawn two asynchronous threads
    public static void main(String[] args) throws InterruptedException {

        // thread instance 1: task will print numbers in increments of 5
        Thread t1 = new MyCustomThread("Fives: ", 5);

        // thread instance 2: task will print numbers in increments of 7
        Thread t2 = new MyCustomThread("Sevens: ", 7);

        // ? Thread.start() executes .run()
        t1.start();
        t2.start();

        // ? Pause current thread for 3 seconds allowing other asynchronous tasks time to run a bit
        Thread.sleep(3000);

        // interrupt one of the threads
        t2.interrupt();

        // on current thread, execute some work
        for(int i = 0; i < 3; i++) {
            Thread.sleep(1500);
            System.out.println("\nmain thread executing: " + i);
        }

        // pause current thread again
        Thread.sleep(3000);

        // interrupt 2nd asynchronous thread
        t1.interrupt();

        // stay in loop until asynchronous thread terminates
        while(t1.isAlive()) {
            System.out.println("\nwaiting for " + t1.getName() + " to terminate");
            Thread.sleep(150);
        }

        System.out.println("\nall thread interrupted, Terminating");
    }
}

// ! CREATE NEW THREAD 1: instantiating a subclass of Thread (INHERITANCE) & @Override the Thread class run()
class MyCustomThread extends Thread {

    // OOP ENCAPSULATION private class fields
    // passing a seed value, code will print numbers in increments of the seed value
    private int seed;

    // OOP constructor that initializes the class fields/instance members on class object/instantiation
    MyCustomThread(String threadName, int seed) {
        // ! INHERITANCE: child subclass inherits class fields & public methods from extending parent super class
        super(threadName);
        this.seed = seed;

    }

    // ! OOP POLYMORPHISM + INTERFACE: must uniquely implement all publicly shared method signatures for designated classes
    @Override
    public void run() {

        // Infinite stream of numbers, defined by seed attribute
        // ! LAMBDA/anonymousFunction = shortcut that does not return anything
        Stream<Integer> infiniteStream = Stream.iterate(this.seed, (t) -> (t + this.seed));

        // ! EXCEPTION HANDLING: EASY TO ASK FOR FORGIVENESS THAN PERMISSION (EAFTP) = use try-catch block
        try {
            infiniteStream.forEach(s -> {

                try {
                    // numbers printed every 1/2 second
                    sleep(500);

                } catch(Exception e) {
                    System.out.println(e.getMessage());
                }
                // print threadName & numbers
                System.out.println(this.getName() + ": " + s + " ");
            });
        } catch(RuntimeException e) {
            System.out.println("\nInterrupted " + this.getName() +"'s execution: " + e.getMessage());
        }
    }
}
