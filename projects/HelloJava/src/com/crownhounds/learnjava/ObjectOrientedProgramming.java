package com.crownhounds.learnjava;

public class ObjectOrientedProgramming {

    public static void main(String[] args) {

        OOP oopNotes = new OOP();
        InheritanceNotes inheritanceNotes = new InheritanceNotes();
    }

}

class OOP extends Notes {

    public OOP() {
         /*
            a constructor enables you to set class fields when initializing an instance of class
                instead of setting the fields one by one with a field setter method

            it's not uncommon to use multiple constructors in a class
                One constructor handles all field initialization
                the other constructor should just call the other major constructor
         */
        super("Object Oriented Programming (OOP)");
        getNotes();
    }

    // OOP CLASS METHODS: non-static unique object behavior
    // ! INTERFACE + OOP POLYMORPHISM: must uniquely-implement/@Override all publicly-shared signatures for designated classes
    @Override
    public void getNotes() {
        // ? 3 unique & new instances of the Vehicle class/blueprint
        Vehicle bike = new Vehicle("bike", 2);
        Vehicle car = new Vehicle("car", 4);
        Vehicle boat = new Vehicle("boat", 0);

        // ? OOP GETTERS & SETTERS: call class/object's updating BEHAVIOR with each instance to update it's state & differentiate it
        bike.setNumWheels(3);
        System.out.println(bike.getType() + ".getWheels(): " + bike.getNumWheels());

        Util.printSeparator();

        bike.speedUp(30);
        car.speedUp(10);

        System.out.println(boat.getType() + ".getSpeed(): " + boat.getSpeed() + " mph");

        car.stop();

        Util.printSeparator();
    }
}

class InheritanceNotes extends Notes {

    // OOP constructor that initializes the class fields on class/object instantiation
    public InheritanceNotes() {
        // ! INHERITANCE: child subclass inherits class fields & methods from extending parent super-class
        super("Inheritance");
        getNotes();
    }

    // OOP CLASS METHODS: non-static unique object behavior
    // ! INTERFACE + OOP POLYMORPHISM: must uniquely-implement/@Override all publicly-shared signatures for designated set of classes
    @Override
    public void getNotes() {
        /*
            ? OOP inheritance refers to how child classes can inherit state and behavior from parent classes
                All classes uses inheritance in Java by extending the Java Object class

            0. define parent and child classes
            1. to specify inheritance between classes in Java, use 'extends' keyword in class definition
            2. child class uses 'super' keyword in it's constructor to call parent class constructor to inherit fields

            ex:

                public class Dog extends Animal {

                    public Dog(String name, int brain, int body, int size, int weight) {
                        super(name, brain, body, size, weight);
                    }

                }
         */

        Car porsche = new Car(false, "Porsche 911");
        System.out.println("OVERRIDE Vehicle.Car.getType(): " + porsche.getType());
        System.out.println("Car.isConvertible(): " + porsche.isConvertable());
        porsche.speedUp(25);
        porsche.stop(20);
    }
}

// ? OOP CLASS: define a class object/blueprint
class Vehicle {

    // CONSTANTS/static class variables assigned FINAL value before compilation/instantiation
    private static final String SPEED_UP = ".speedUp() to ";
    private static final String STOPPED = ".stop() to ";
    private static final String MPH = " miles per hour";

    // ? OOP CLASS: decide how member variables/fields & methods are accessible
    // OOP ENCAPSULATION private class fields
    private String type;
    private Integer numWheels;
    private Integer speed;

    // ? OOP constructor that initializes the class fields on class/object instantiation
    public Vehicle(String type, int numWheels) {
        this.type = type;
        // ! AUTOBOXING: convert primitive dataType -> Wrapper class dataType
        this.numWheels = numWheels;

        // default values
        this.speed = 0;
    }

    // ? OOP CLASS METHODS: non-static unique object behaviors
    public Integer speedUp(int amount) {
        this.speed += amount;

        // ? 'this' keyword is referencing the specific details of the calling instance of the class/blueprint
        System.out.println("Vehicle." + this.type + SPEED_UP + this.speed + MPH);
        return this.speed;
    }
    // ! OVERLOADED METHOD: similar methods with same name, but different parameters, run unique logic which optimizes readability & scalability of codebase
    public void stop(int amount) {

        if(this.speed > 0 && ((this.speed - amount) >= 0)) {
            this.speed -= amount;
        } else {
            this.speed = 0;
        }

        System.out.println("Vehicle." + this.type + STOPPED + this.speed + MPH);
    }

    public void stop() {
        this.speed = 0;
        System.out.println("Vehicle." + this.type + STOPPED + this.speed + MPH);
    }

    // ? OOP GETTERS & SETTERS: call class/object's updating BEHAVIOR with each instance to update it's state & differentiate it
    public String getType() {
        return type;
    }

    public Integer getSpeed() {
        return speed;
    }

    public void setNumWheels(Integer numWheels) {
        this.numWheels = numWheels;
    }

    public Integer getNumWheels() {
        return numWheels;
    }
}

// ? OOP INHERITANCE: child subclass inherits class fields + methods from extending parent super-class
class Car extends Vehicle {

    // OOP ENCAPSULATION private class fields
    private boolean isConvertable;
    private String model;

    // OOP constructor that initializes the class fields on class/object instantiation
    public Car(boolean isConvertable, String model) {
    // ? OOP INHERITANCE: child subclass inherits class fields + methods from extending parent super-class
        super("Car", 4);
        this.isConvertable = isConvertable;
        this.model = model;
    }

    // OOP CLASS METHODS: non-static unique object behaviors
    // ? OOP INHERITANCE + POLYMORPHISM: inherited method from extending parent super class @Override with unique logic for child subclass instances
    @Override
    public String getType() {
        return super.getType() + ":" + this.model;
    }

    // OOP getters & setters
    public String getModel() {
        return model;
    }

    public boolean isConvertable() {
        return isConvertable;
    }

    public void setConvertable(boolean convertable) {
        isConvertable = convertable;
    }
}