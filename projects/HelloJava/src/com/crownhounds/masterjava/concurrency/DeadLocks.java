package com.crownhounds.masterjava.concurrency;

public class DeadLocks {
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

            So every process has a heap and every thread has a thread stack.

        ! SYNCHRONIZATION: the process of controlling when threads execute code and therefore when they can access the heap is called synchronization.

            When working with threads, we have to synchronize all areas where we think or where interference can happen.

        ! THREAD SYNCHRONIZATION code blocks: use synchronization keyword so that all other threads that want to call any synchronized sections in that class will suspend until the single thread running the synchronized code block exits it & passes the object's INTRINSIC LOCK.

            if a class has three synchronized methods, then only one of these methods can ever run at a time and only on one thread.

            since only one thread can execute a synchronized method at a time, threads can't interleave when running a synchronized method.

            that prevents thread interference within synchronized methods, but not outside those methods.

                if the same instance variables referenced within a synchronized method are also referenced outside it in code that multiple threads can run and that particular code isn't synchronized, then we may still see thread interference.

            In Java to synchronize a method, all we really have to do is add the synchronized keyword to a method declaration.

        ! STATIC OBJECT SYNCHRONIZATION: the intrinsic lock that's used is owned by the class object

            synchronize a block of statements that work with an object by forcing threads to acquire the object's lock before they execute the statement block.

            only one thread can hold the lock at a time, so other threads that want the lock will be suspended until the running thread releases it.

            Then one and only one of the waiting threads can get the lock and continue executing.

        ! THREAD SYNCHRONIZATION + EXCEPTION HANDLING + INTRINSIC REENTRANT LOCK: in TRY-FINALLY code block, use ReentrantLock.lock() to acquire the object's intrinsic lock & execute code one at a time -- other calling threads will suspend until the single running thread calls Reentrant.unlock() to pass the class/object's INTRINSIC LOCK.

        ! THREADS DEAD LOCKS: application freezes during execution due to unreleased INTRINSIC LOCKS - the synchronized shared-resource code executes one at a time and the single running thread is holding the objects INTRINSIC LOCK blocking other threads that WAIT for the lock release via NOTIFY

        ! THREAD SYNCHRONIZATION +  DEADLOCKS: key to avoiding deadlocks(when 2 or more threads are competing for 2 or more INTRINSIC LOCKS), you want to make sure that all threads are synchronized or all the threads will try to obtain the locks in the same order.

        ! THREAD STARVATION: threads aren't given the opportunity to progress due to threat priority - assigning a high priority to a thread means the OS should try and run the thread before other waiting threads.
     */

    // ACCESS-MODIFIER public: variable is accessible from any scope
    // STATIC: single class variable is saved in a single space in memory and accessible throughout application
    // ! THREAD SYNCHRONIZATION + DEAD LOCKS: application freezes during execution due to unreleased INTRINSIC LOCKS - the synchronized shared-resource code executes one at a time and the single running thread is holding the objects INTRINSIC LOCK blocking other threads that WAIT for the lock release via NOTIFY
    public static Object lock1 = new Object();
    public static Object lock2 = new Object();

    public static void main(String[] args) {

        // ! THREAD INTERFERENCE/race condition: when 2 or more threads are writing/updating a shared resource in the HEAP, the updated resource interfere yields unpredictable results with a given thread's execution
        // ! THREADS + ANONYMOUS CLASSES/LAMBDA: when using anonymous classes, immediately executing no-name Thread class
        // ! THREADS .start(): only JVM executes .run() for a given single Thread (always a new Thread instance), including priority-assigned threads, and CANNOT assume Thread instance execution order
        new Thread1().start();
        new Thread2().start();
    }

    // INNER CLASS: logically grouped class components within a super class
    // ACCESS-MODIFIER private: accessibility to the variable is limited to the scope of the defining class
    // OOP INHERITANCE: child subclass gains access to the public class fields and methods from an extending parent super class
    private static class Thread1 extends Thread {
        // CONSTANTS: static class variables assigned FINAL value before compilation/instantiation
        private static final String THREAD_1 = "Thread 1: ";

        public void run() {
            // ! THREAD SYNCHRONIZATION code blocks: use synchronization keyword so that all other threads that want to call any synchronized sections in that class will suspend until the single thread running the method exits it & passes the object's INTRINSIC LOCK.
            // ! THREAD SYNCHRONIZATION + DEADLOCKS: key to avoiding deadlocks when two or more threads will be competing for two or more locks. You want to make sure that all threads or all the threads will try to obtain the locks in the same order.
            synchronized (lock1) {
                System.out.println(THREAD_1 + "has lock 1");

                // EXCEPTION HANDLING easier to ask for forgiveness than permission: use try-catch block to handle exceptions
                try {
                    Thread.sleep(1000);
                } catch(InterruptedException e) {
                    System.out.println(e.getMessage());
                }

                System.out.println(THREAD_1 + "waiting for lock 2");

                // ! THREAD SYNCHRONIZATION code blocks: use synchronization keyword so that all other threads that want to call any synchronized sections in that class will suspend until the single thread running exits & passes the object's INTRINSIC LOCK
                synchronized (lock2) {
                    System.out.println(THREAD_1 + "has lock 1 and lock 2");
                }
                System.out.println(THREAD_1 + "released lock 2");
            }
            System.out.println(THREAD_1 + "released lock 1. exiting...");
        }
    }

    private static class Thread2 extends Thread {
        private static final String THREAD_2 = "Thread 2: ";

        public void run() {
            // ! THREAD SYNCHRONIZATION code blocks: use synchronization keyword so that all other threads that want to call any synchronized sections in that class will suspend until the single thread running exits & passes the object's INTRINSIC LOCK
            // ! THREAD SYNCHRONIZATION + DEADLOCKS: key to avoiding deadlocks when two or more threads will be competing for two or more locks. You want to make sure that all threads or all the threads will try to obtain the locks in the same order.
            synchronized (lock1) {
                System.out.println(THREAD_2 + "has lock 2");

                // EXCEPTION HANDLING easier to ask for forgiveness than permission: use try-catch block to handle exceptions
                try {
                    Thread.sleep(1000);
                } catch(InterruptedException e) {
                    System.out.println(e.getMessage());
                }

                System.out.println(THREAD_2 + "waiting for lock 1");

                // ! THREAD SYNCHRONIZATION code blocks: use synchronization keyword so that all other threads that want to call any synchronized sections in that class will suspend until the single thread running exits & passes the object's INTRINSIC LOCK
                synchronized (lock2) {
                    System.out.println(THREAD_2 + "has lock 2 and lock 1");
                }
                System.out.println(THREAD_2 + "released lock 1");
            }
            System.out.println(THREAD_2 + "released lock 2. exiting...");
        }
    }
}

