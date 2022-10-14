package com.crownhounds.masterjava.concurrency;

public class LiveLock {

    // CONSTANTS/static class variables assigned FINAL value before compilation/instantiation
    private static final String WORKER = "Worker ";
    public static void main(String[] args) {

        // ! THREAD SYNCHRONIZATION + LIVE LOCK: threads will NEVER progress, but technically none of the threads are blocked
        // since both workers are active, both keep handing the shared resource to the other thread and can't actually make any progress.
        boolean activeLiveLock = true;
        final Worker worker1 = new Worker(WORKER + "1", activeLiveLock);
        final Worker worker2 = new Worker(WORKER + "2", activeLiveLock);
        final SharedResource sharedResource = new SharedResource(worker1);

        // ! THREAD INTERFERENCE + SLIPPED CONDITION: a thread in a multi-threaded app is suspended between reading a condition and acting on it, and requires all critical sections to be synchronized

        // ! THREADS + ANONYMOUS CLASSES/LAMBDA: when using anonymous classes, immediately executing no-name Thread class w/ Thread.subclass parameter that implements Runnable interface to .start() on its own thread in the HEAP
        // ! THREADS .start(): only JVM executes .run() for a given single Thread (always a new Thread instance), including priority-assigned threads, and CANNOT assume Thread instance execution order
        // thread 1
        new Thread(new Runnable() {
            @Override
            public void run() {
                worker1.work(sharedResource, worker2);
            }
        }).start();

        // thread 2
        new Thread(new Runnable() {
            @Override
            public void run() {
                worker2.work(sharedResource, worker1);
            }
        }).start();
    }

    // INNER CLASS: logically grouped components within an extending super class
    static class Worker {

        // OOP ENCAPSULATION: use access modifiers to guard class functionality from inappropriate external use
        // private class fields
        private String name;
        private boolean active;

        // OOP CONSTRUCTOR that initializes class fields on class/object instantiation
        public Worker(String name, boolean active) {
            this.name = name;
            this.active = active;
        }

        // CLASS METHODS: unique object behavior
        // ! THREAD SYNCHRONIZATION + CRITICAL CODE: use 'synchronization' keyword to notify all other threads, that also want to call the same critical sections, to suspend until the single thread running the synchronized code block exits & passes the object's INTRINSIC LOCK, thus preventing THREAD INTERFERENCE when using a shared resource
        public synchronized void work(SharedResource sharedResource, Worker otherWorker) {

            // the active thread validates shared resource ownership, wait 10 milliseconds, check again if it's acquired & now owns the shared resource
            while(this.active) {

                if(sharedResource.getOwner() != this) {
                    // EXCEPTION HANDLING easier to ask for forgiveness than permission: use try-catch block to handle errors
                    try {
                        wait(10);
                    } catch(InterruptedException e) {
                        System.out.println(e.getMessage());
                    }
                    continue;
                }

                // this.thread will only complete a loop iteration when it owns the shared resource, and the other thread isn't active.
                if(otherWorker.isActive()) {
                    System.out.println(this.getName() + " : give the shared resource to the other worker " + otherWorker.getName());
                    sharedResource.setOwner(otherWorker);
                    continue;
                }

                System.out.println(this.getName() + " : working on the common resource");
                this.active = false;
                sharedResource.setOwner(otherWorker);
            }
        }

        // OOP GETTERS & SETTERS
        public String getName() {
            return name;
        }

        public boolean isActive() {
            return active;
        }
    }

    static class SharedResource {

        // private class fields
        private Worker owner;

        // OOP CONSTRUCTOR that initializes the class fields on class/object instantiation
        public SharedResource(Worker owner) {
            this.owner = owner;
        }

        // OOP GETTERS & SETTERS
        public Worker getOwner() {
            return owner;
        }

        // ! THREAD SYNCHRONIZATION + CRITICAL CODE: use 'synchronization' keyword to notify all other threads, that also want to call the same critical sections, to suspend until the single thread running the synchronized code block exits & passes the object's INTRINSIC LOCK, thus preventing THREAD INTERFERENCE when using a shared resource
        public synchronized void setOwner(Worker worker) {
            this.owner = worker;
        }
    }
}

