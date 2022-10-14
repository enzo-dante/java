package com.crownhounds.masterjava.concurrency;

public class HelloDeadlocks {

    public static void main(String[] args) {

        final PolitePerson jane = new PolitePerson("Jane");
        final PolitePerson ben = new PolitePerson("Ben");

        // multiple threads: deadlocks
        // ! THREAD SYNCHRONIZATION + DEAD LOCKS: app freezes during execution due to unreleased INTRINSIC LOCKS - the synchronized shared-resource code executes one at a time and the single running thread is holding the objects INTRINSIC LOCK blocking other threads that WAIT for the lock release via NOTIFY
        // ! THREADS + ANONYMOUS CLASS/LAMBDAS: Thread.instance w/ parameter class instance that implements Runnable INTERFACE & immediately .start() no-name instance on its own thread in the HEAP
        new Thread(new Runnable() {
            @Override
            public void run() {
                jane.sayHello(ben);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                ben.sayHello(jane);
            }
        }).start();
    }

    // STATIC: class variables saved in a single space in memory and used across entire application
    static class PolitePerson {

        // ACCESS-MODIFIER private: accessibility to the variable is limited to the scope of the defining class
        // FINAL: assigned value before compilation/instantiation that cannot be changed
        // object instance members
        private final String name;

        // OOP CONSTRUCTOR that initializes the class fields on class/object instantiation
        public PolitePerson(String name) {
            this.name = name;
        }

        // CLASS METHODS: unique object behavior
        // ! THREAD SYNCHRONIZATION blocks/methods: all other threads that want to call any synchronized sections in that class will suspend until the single thread running the method exits & passes the object's INTRINSIC LOCK via NOTIFY
        public synchronized void sayHello(PolitePerson person) {

            // first %s = this.name
            // second %s = person.getName()
            // %n = new line
            System.out.format("%s: %s" + " has said hello to me!%n", this.name, person.getName());
            person.sayHelloBack(this);
        }

        public synchronized void sayHelloBack(PolitePerson person) {
            System.out.format("%s: %s" + " has said hello to back to me!%n", this.name, person.getName());
        }

        // OOP GETTERS & SETTERS
        public String getName() {
            return name;
        }
    }
}
