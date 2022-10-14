package com.crownhounds.masterjava.concurrency;

public class Threads {
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

        ! METHOD SYNCHRONIZATION: when a thread is executing the method, all other threads that want to call the method or any other synchronized method in that class will suspend until the thread running the method exits it. Then another thread can run a synchronized method then another, etc.

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

        ! THREAD SYNCHRONIZATION + DEAD LOCKS: application freezes during execution due to unreleased INTRINSIC LOCKS - the synchronized shared-resource code executes one at a time and the single running thread is holding the objects INTRINSIC LOCK blocking other threads that WAIT for the lock release via NOTIFY

        ! THREAD SYNCHRONIZATION + DEADLOCKS: key to avoiding deadlocks when two or more threads will be competing for two or more locks. You want to make sure that all threads or all the threads will try to obtain the locks in the same order.

        ! THREAD STARVATION: threads aren't given the opportunity to progress due to threat priority - assigning a high priority to a thread means the OS should try and run the thread before other waiting threads.

        ! THREAD INTERFERENCE = race condition

        ! ATOMIC ACTIONS: once a thread starts these actions, they cannot be suspended during execution, and must complete

            reading and writing reference variables

            reading and writing primitive variables, exception long & double

            reading and writing volatile variables

        ! VOLATILE VARIABLES: the JVM writes the value back to main memory immediately after a thread updates the value in its CPU cache, and it also guarantees that every time a variable reads from a volatile variable, it will get the latest value.

            can cause a memory consistency error (cache values out-of-sync with each other & the main memory values) when reading from the cache often yields faster app performance, where each thread may be running on a different CPU with its own cache, which can contain copies of values that are in the main memory.
     */

    // ! ATOMIC ACTIONS: once a thread starts these actions, they cannot be suspended during execution, and must complete
    // reading and writing volatile variables
    public volatile int volatileVariable;

    public static void main(String[] args) {

        // ! ATOMIC ACTIONS: once a thread starts these actions, they cannot be suspended during execution, and must complete
        // reading and writing reference variables
        // reading and writing primitive variables (exception long & double)
        int atomicAction1 = 1;
        int atomicAction2 = atomicAction1;

        // ! THREADS .start(): only JVM executes .run() for a given single Thread (always a new Thread instance), including priority-assigned threads, and CANNOT assume Thread instance execution order
        System.out.println(ThreadColor.ANSI_PURPLE + "Hello from the main Thread");
        AnotherThread anotherThread = new AnotherThread();
        anotherThread.setName("===Another Thread===");

        anotherThread.start();
        anotherThread.run();

        // ! THREADS + ANONYMOUS CLASSES/LAMBDA: when using anonymous classes, immediately executing no-name Thread class
        new Thread() {
            @Override
            public void run() {
                System.out.println(ThreadColor.ANSI_GREEN + "Hello from anonymous class Thread");
            }
        }.start();

        // ! THREADS + GENERIC CLASSES/LAMBDAS: Thread.instance w/ parameter class instance that implements Runnable INTERFACE & immediately .start() no-name instance on it's own thread in the HEAP
        Thread myRunnableThread = new Thread(new MyRunnableThread());
        myRunnableThread.start();

        // ! THREADS + ANONYMOUS CLASSES/LAMBDA: when using anonymous classes, immediately executing no-name Thread class w/ Thread.subclass parameter that implements Runnable interface to .start() on its own thread in the HEAP
        new Thread(new MyRunnableThread(){
            @Override
            public void run() {
                System.out.println(ThreadColor.ANSI_RED + "Hello from ANONYMOUS PARENT SUPER CLASS implementation of Runnable Thread");
            }
        }).start();

        // ! THREADS: use instance of Thread class w/ Thread anonymous subclass that implements Runnable interface as parameter to execute Thread.start() on its own thread
        Thread anonymousRunnableThread = new Thread(new MyRunnableThread() {
            @Override
            public void run() {
                System.out.println(ThreadColor.ANSI_RED + "Hello from ANONYMOUS CHILD SUBCLASS implementation of Runnable Thread");
                try {
                    // ! THREAD JOIN: And when we join a thread to a second thread, the first thread will wait for the second thread to terminate or reach timeout value and then it will wake to continue to execute.
//                    anotherThread.interrupt();
                    int timeout = 2000;
                    anotherThread.join(timeout);
                    System.out.println(ThreadColor.ANSI_RED + "AnotherThread terminated or timed out, so I'm running again");
                } catch(InterruptedException e) {
                    System.out.println(ThreadColor.ANSI_RED + "this.thread couldn't wait...I was interrupted");
                }
            }
        });
        anonymousRunnableThread.start();
        System.out.println(ThreadColor.ANSI_PURPLE + "Again, hello from the main Thread");
    }
}

// ! THREAD: a unit of execution within a process, each process can have multiple threads, a method for a program to "split" itself into two or more simultaneously or pseudo-simultaneously running tasks.
class AnotherThread extends Thread {
    @Override
    public void run() {
        System.out.println(ThreadColor.ANSI_BLUE + "Hello from Thread subclass " + currentThread().getName());

        // ! EXCEPTION HANDLING easier to ask for forgiveness than permission = use try-catch block to catch exceptions
        try {

            int timeout = 5000;
            Thread.sleep(timeout);

        } catch(InterruptedException e) {
            System.out.println(ThreadColor.ANSI_BLUE + "AnotherThread woke me up");

            // if there is thread interruption, return to terminate Thread instance
            return;
        }
        System.out.println(ThreadColor.ANSI_BLUE + "3 seconds have passed and AnotherThread is now awake");
    }
}

class MyRunnableThread implements Runnable {
    @Override
    public void run() {
        System.out.println(ThreadColor.ANSI_RED + "Hello from MyRunnableThread interface implementation of .run()");
    }
}


