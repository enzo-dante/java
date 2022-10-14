package com.crownhounds.masterjava.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

public class ConsumersAndProducers {
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

        ! SYNCHRONIZATION: the sequential heap process of generally controlling when threads execute (can never assume order though) code via an object's INTRINSIC LOCKS that prevents THREAD INTERFERENCE within designated code block

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

    // CONSTANTS/static class variables assigned a FINAL value before compilation/instantiation
    // STATIC: class variable saved in a single space in memory and that single reference is used across entire application
    private static final String COMPLETED = "completed".toUpperCase();
    private static final String THREAD_INTERFERENCE = "=== Thread Interference ===";
    private static final String REENTRANT_LOCKS = "=== Reentrant Locks & Unlocks ===";
    // ACCESS-MODIFIER private: accessibility to public class fields & methods are limited to the defining class scope and it's subclasses within the package
    protected static final String EOF = "EOF";

    // ACCESS-MODIFIER public: variable is accessible from any scope
    // STATIC: class variable saved in a single space in memory and shared across entire application
    // VOID: return null
    public static void main(String[] args) {

//        // ! THREADS + ATOMIC OPERATIONS: A Java Thread CANNOT be suspended during reading & writing reference variables, reading & writing primitive variables (except long and double), reading & writing volatile variables
//        Message message = new Message();
//
//        // ! THREADS + ANONYMOUS CLASSES/LAMBDA: when using anonymous classes, immediately executing no-name Thread class w/ Thread.subclass parameter that implements Runnable interface to .start() on its own thread in the HEAP
//        // Thread 1
//        new Thread(new Writer(message)).start();
//
//        // Thread 2
//        new Thread(new Reader(message)).start();

        System.out.println(THREAD_INTERFERENCE);

        // ! SYNCHRONIZATION + THREAD SAFE critical section: all shared-resource code executes one a time: other calling threads will suspend until the single running thread exits the synchronized code block and passes the class/object's INTRINSIC LOCK.
        // ! SYNCHRONIZATION + THREAD SAFE critical section: must synchronize all critical sections when using an ArrayList bc an ArrayList is NOT a thread safe shared-resource
        ReentrantLock reentrantLock = new ReentrantLock();

        // ! THREAD SYNCHRONIZATION + EXCEPTION HANDLING + INTRINSIC REENTRANT LOCK: in TRY-FINALLY code block, use ReentrantLock.lock() to acquire the object's intrinsic lock & execute code one at a time -- other calling threads will suspend until the single running thread calls Reentrant.unlock() to pass the class/object's INTRINSIC LOCK.
        List<String> buffer = new ArrayList<>();
        MyProducer producer = new MyProducer(buffer, ThreadColor.ANSI_YELLOW, reentrantLock);
        MyConsumer consumer1 = new MyConsumer(buffer, ThreadColor.ANSI_PURPLE, reentrantLock);
        MyConsumer consumer2 = new MyConsumer(buffer, ThreadColor.ANSI_CYAN, reentrantLock);

        // ! THREAD: a unit of execution within a process, each process can have multiple threads, a method for a program to "split" itself into two or more simultaneously or pseudo-simultaneously running tasks.
        // ! THREAD INTERFERENCE/race condition: when 2 or more threads are writing/updating a shared resource in the HEAP, the constantly updating resource interferes with each thread's execution & yields unpredictable results

        // ! THREAD POOLS + ExecutorService: optimize a managed set of threads, thus reducing the overhead of thread creation
        int numberOfThreads = 3;
        ExecutorService executorService = Executors.newFixedThreadPool(numberOfThreads);

        executorService.execute(producer);
        executorService.execute(consumer1);
        executorService.execute(consumer2);

        // ! THREAD POOLS + Future: a return value from an executed thread in a thread pool
        // ! THREADS + ANONYMOUS CLASSES/LAMBDA: when using anonymous classes, immediately executing no-name Thread class w/ Thread.subclass parameter that implements Runnable interface to .start() on its own thread in the HEAP
        // GENERICS: enforce dataType parameter to improve OOP ENCAPSULATION
        Future<String> future = executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println(ThreadColor.ANSI_WHITE + "executorService.submit() was called");
                return "This is the callable result";
            }
        });

        // EXCEPTION HANDLING easier to ask for forgiveness than permission: use try-catch block to handle exceptions
        try {
            System.out.println(future.get());
        } catch(ExecutionException e) {
            System.out.println(e.getMessage());
        } catch (InterruptedException e) {
            System.out.println("Thread running the task was interrupted");
        }

        // ! THREAD POOLS + ExecutorService: need to manually shutdown thread pools
        executorService.shutdown();
    }

    // INNER CLASS: logically grouped class components within a parent super class
    static class Message {

        // OOP ENCAPSULATION: access-modifier protected class fields that guard against inappropriate external access & use
        // private class fields
        private String message;
        private boolean isEmpty = true;

        // ! SYNCHRONIZATION + THREAD SAFE critical section: all shared-resource code executes one a time: other calling threads will suspend until the single running thread exits the synchronized code block and passes the class/object's INTRINSIC LOCK.
        public synchronized String read() {

            // ! THREAD SYNCHRONIZATION + DEAD LOCKS: application freezes during execution due to unreleased INTRINSIC LOCKS - the synchronized shared-resource code executes one at a time and the single running thread is holding the objects INTRINSIC LOCK blocking other threads that WAIT for the lock release via NOTIFY
            // ! THREAD SYNCHRONIZATION wait(): always call .wait() in a loop for conditional validation that avoids unresolved blocking DEAD LOCKS - never assume a Thread has been woken up because the condition the thread is waiting on has changed
            while(isEmpty) {

                // EXCEPTION HANDLING easier to ask for forgiveness than permission: use try-catch block to handle potential exceptions and avoid applications breaking
                try {
                    wait();
                } catch(InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }

            // ! THREAD SYNCHRONIZATION notifyAll(): avoid unresolved blocking DEAD-LOCKS by letting all WAITING threads in the HEAP know that the shared-resource's INTRINSIC LOCK has been released after the single running thread completes executing the synchronized critical section
            notifyAll();

            isEmpty = true;
            return message;
        }

        // ! THREAD SYNCHRONIZATION + THREAD SAFE critical section: all shared-resource code executes one a time -- other calling threads will suspend until the single running thread exits the synchronized code block and passes the class/object's INTRINSIC LOCK.
        public synchronized void write(String message) {

            // ! THREAD SYNCHRONIZATION + DEAD LOCKS: application freezes during execution due to unreleased INTRINSIC LOCKS - the synchronized shared-resource code executes one at a time and the single running thread is holding the objects INTRINSIC LOCK blocking other threads that WAIT for the lock release via NOTIFY
            // ! THREAD SYNCHRONIZATION wait(): always call .wait() in a loop for conditional validation that avoids unresolved blocking DEAD LOCKS - never assume a Thread has been woken up because the condition the thread is waiting on has changed
            while(!isEmpty) {

                // EXCEPTION HANDLING easier to ask for forgiveness than permission: use try-catch block to handle potential exceptions and avoid applications breaking
                try {
                    wait();
                } catch(InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }

            // ! THREAD SYNCHRONIZATION notifyAll(): avoid unresolved blocking DEAD-LOCKS by letting all WAITING threads in the HEAP know that the shared-resource's INTRINSIC LOCK has been released after the single running thread completes executing the synchronized critical section
            notifyAll();

            isEmpty = false;
            this.message = message;
        }
    }

    static class Writer implements Runnable {

        // private class fields
        private Message message;

        // OOP CONSTRUCTOR that initializes the class fields & INTRINSIC LOCK on class/object instantiation
        public Writer(Message message) {
            this.message = message;
        }

        // ! THREADS: only use .start() for every new Thread instance bc only JVM manages priority .run() for current single Thread in HEAP of multiple Threads that don't have an assumed execution order
        @Override
        public void run() {

            String[] messages = {
                    "Breaking Bad is a great show",
                    "Better Call Saul is a great show",
                    "Marvelous Mrs. Maisel is a great show",
                    "Star Trek is a great show",
            };

            Random random = new Random();

            for(int i = 0; i < messages.length; i++) {

                this.message.write(messages[i]);

                // ! EXCEPTION HANDLING easier to ask for forgiveness than permission: use a try-catch block to handle any exceptions
                try {
                    int randomSeconds = random.nextInt(2000);
                    Thread.sleep(randomSeconds);
                } catch(InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }
            this.message.write(COMPLETED);
        }
    }

    // INTERFACE + OOP POLYMORPHISM: all publicly-defined method signatures must be uniquely implemented/@Override by each class in the implementing set for standardization
    static class Reader implements Runnable {

        // OOP ENCAPSULATION private class fields
        private Message message;

        // OOP CONSTRUCTOR that initializes the class fields & INTRINSIC LOCK on class/object instantiation
        public Reader(Message message) {
            this.message = message;
        }

        // CLASS METHODS: unique object behavior
        @Override
        public void run() {

            Random random = new Random();
            for(String latestMessage = this.message.read();
                !latestMessage.equals(COMPLETED);
                latestMessage = message.read()) {

                System.out.println(latestMessage);

                // ! EXCEPTION HANDLING easier to ask for forgiveness than permission: use a try-catch block to handle any exceptions
                try {

                    int randomSeconds = random.nextInt(2000);
                    Thread.sleep(randomSeconds);

                } catch(InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}

// INTERFACE + OOP POLYMORPHISM: must uniquely implement/@Override all publicly-shared method signatures for designated classes for standardization
class MyProducer implements Runnable {

    // OOP ENCAPSULATION: use access-modifiers to guard class functionality against inappropriate external access
    // ACCESS-MODIFIER private: accessibility to public class fields & methods are limited to the defining class scope
    // private class fields
    private List<String> buffer;
    private String color;
    private ReentrantLock reentrantLock;

    // OOP CONSTRUCTOR that initializes class fields & INTRINSIC LOCK on class/object instantiation
    public MyProducer(List<String> buffer, String color, ReentrantLock reentrantLock) {
        this.buffer = buffer;
        this.color = color;
        this.reentrantLock = reentrantLock;
    }

    // ! THREADS: only use .start() for every new Thread instance bc only JVM manages priority .run() for current single Thread in HEAP of multiple Threads that don't have an assumed execution order
    @Override
    public void run() {

        Random random = new Random();
        String[] nums = {"1", "2", "3", "4", "5"};

        // ! THREAD SYNCHRONIZATION + THREAD SAFE critical section: all shared-resource code executes one at a time -- other calling threads will suspend until the single running thread exits the synchronized code block and passes the class/object's INTRINSIC LOCK.
        for(String num : nums) {

            // ! EXCEPTION HANDLING easier to ask for forgiveness than permission: use try-catch block to handle exceptions
            try {
                System.out.println(color + " adding..." + num);

                // ! THREAD SYNCHRONIZATION + EXCEPTION HANDLING + INTRINSIC REENTRANT LOCK: in TRY-FINALLY code block, use ReentrantLock.lock() to acquire the object's intrinsic lock & execute code one at a time -- other calling threads will suspend until the single running thread calls Reentrant.unlock() to pass the class/object's INTRINSIC LOCK.
                reentrantLock.lock();
                try {
                    buffer.add(num);
                } finally {
                    reentrantLock.unlock();
                }

                Thread.sleep(random.nextInt(1000));

            } catch(InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println(color + "Adding EOF and exiting...");

        // ! THREAD SYNCHRONIZATION + EXCEPTION HANDLING + INTRINSIC REENTRANT LOCK: in TRY-FINALLY code block, use ReentrantLock.lock() to acquire the object's intrinsic lock & execute code one at a time -- other calling threads will suspend until the single running thread calls Reentrant.unlock() to pass the class/object's INTRINSIC LOCK.
        reentrantLock.lock();
        try {
            buffer.add(ConsumersAndProducers.EOF);
        } finally {
            reentrantLock.unlock();
        }
    }
}

// INTERFACE + OOP POLYMORPHISM: must uniquely implement/@Override all publicly-shared method signatures for designated classes for standardization
class MyConsumer implements Runnable {

    private List<String> buffer;
    private String color;
    private ReentrantLock reentrantLock;

    public MyConsumer(List<String> buffer, String color, ReentrantLock reentrantLock) {
        this.buffer = buffer;
        this.color = color;
        this.reentrantLock = reentrantLock;
    }

    @Override
    public void run() {

        int counter = 0;

        // ! THREAD SYNCHRONIZATION + DEAD LOCKS: application freezes during execution due to unreleased INTRINSIC LOCKS - the synchronized shared-resource code executes one at a time and the single running thread is holding the objects INTRINSIC LOCK blocking other threads that WAIT for the lock release via NOTIFY
        while(true) {

            // ! THREAD SYNCHRONIZATION + EXCEPTION HANDLING + INTRINSIC REENTRANT LOCK: in TRY-FINALLY code block, use ReentrantLock.tryLock() to check availability of object's intrinsic lock and then acquire & execute code one at a time -- other calling threads will suspend until the single running thread calls Reentrant.unlock() to pass the class/object's INTRINSIC LOCK.
            if(reentrantLock.tryLock()) {
                try {
                    if(buffer.isEmpty()) continue;

                    System.out.println(color + "The counter = " + counter);
                    counter = 0;

                    if(buffer.get(0).equals(ConsumersAndProducers.EOF)) {
                        System.out.println(color + "Exiting");
                        break;
                    } else {
                        System.out.println(color + " removed " + buffer.remove(0));
                    }
                } finally {
                    reentrantLock.unlock();
                }
            }
            counter++;
        }
    }
}