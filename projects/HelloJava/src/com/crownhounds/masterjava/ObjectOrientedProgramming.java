package com.crownhounds.masterjava;

public class ObjectOrientedProgramming {

    public static void main(String[] args) {

//        OOP oopNotes = new OOP();
//        InheritanceNotes inheritanceNotes = new InheritanceNotes();
        CompositionNotes compositionNotes = new CompositionNotes();
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

// ! OOP INHERITANCE: child subclass inherits class fields & methods from a parent super class
class CompositionNotes extends Notes {
    /*
        OOP_Composition refers to an Object 'having' components or mini-Objects that make up the larger Object

        ex: A Computer has a motherboard, a monitor, and a case
            each component (motherboard, monitor, and case are their classes/objects)
     */

    // CONSTANTS/static class variables assign FINAL value before compilation/instantiation
    private static final String COMPOSITION = "Composition";

    // OOP ENCAPSULATION private class fields

    // OOP constructor that initializes the class fields on class/object instantiation
    public CompositionNotes() {

        // ! OOP INHERITANCE: child subclass inherits the class fields & methods from a parent super-class
        super(COMPOSITION);

        getNotes();
    }

    // OOP CLASS METHODS: non-static unique behavior
    // ! INTERFACE + OOP POLYMORPHISM: must uniquely implement/@Override all publicly-shared signatures for designated classes
    @Override
    public void getNotes() {

        Case computerCase = new Case(new Dimensions(10, 10, 10), "Apple Air", "Apple Inc", "Intel");
        Motherboard motherboard = new Motherboard("M2", "Apple Inc", 0, 2, "Top of the line quality assurance");

        Resolution nativeResolution = new Resolution(256, 256);
        Monitor monitor = new Monitor("MacBook Pro", "Apple Inc", 18, nativeResolution);

        PC pc = new PC(computerCase, monitor, motherboard);

        pc.powerOn();

        pc.getMotherboard().loadProgram("Knights of the Old Republic", pc.getMonitor());

    }

    // OOP getter & setters

    // ! INNER CLASS + OOP COMPOSITION: parent super-class has logically grouped components within itself
    // ! ACCESS MODIFIER package-private: default visibility that limits the scope to this package
    class PC {

        // ? OOP ENCAPSULATION + COMPOSITION: object instance members/class fields that are each a class/object themselves
        private Case computerCase;
        private Monitor monitor;
        private Motherboard motherboard;

        // OOP constructor that initializes the class fields on class/object instantiation
        public PC(Case computerCase, Monitor monitor, Motherboard motherboard) {
            this.computerCase = computerCase;
            this.monitor = monitor;
            this.motherboard = motherboard;
        }

        // OOP CLASS METHOD: non-static unique class behavior
        public void powerOn() {
            System.out.println(getClass().getSimpleName() + ".powerOn() was called");
            getComputerCase().pressPowerButton();
            drawLogo();
        }

        public void drawLogo() {
            System.out.println(getClass().getSimpleName() + ".drawLogo() was called");
            getMonitor().drawPixel(20, 30, "Red");
        }

        // OOP getters & setters
        public Case getComputerCase() {
            return computerCase;
        }

        public Monitor getMonitor() {
            return monitor;
        }

        public Motherboard getMotherboard() {
            return motherboard;
        }
    }

    // ! OOP ENCAPSULATION private class fields w/ limited scope visibility
    private class Case {

        // ? OOP ENCAPSULATION + COMPOSITION: object instance members/class fields that are each a class/object themselves
        private Dimensions dimensions;
        private String model;
        private String manufacturer;
        private String powerSupply;

        // OOP constructor that initializes the class fields on class/object instantiation
        public Case(Dimensions dimensions, String model, String manufacturer, String powerSupply) {
            this.dimensions = dimensions;
            this.model = model;
            this.manufacturer = manufacturer;
            this.powerSupply = powerSupply;
        }

        // OOP CLASS METHOD: non-static unique class behavior
        public void pressPowerButton() {
            System.out.println(getClass().getSimpleName() + ".pressPowerButton() was called");
        }

        // OOP getters & setters
    }

    private class Dimensions {

        // OOP ENCAPSULATION private class fields/object instance members
        private int height;
        private int width;
        private int depth;

        // OOP constructor that initializes the class fields on class/object instantiation
        public Dimensions(int height, int width, int depth) {
            this.height = height;
            this.width = width;
            this.depth = depth;
        }

        // OOP getters & setters
        public int getHeight() {
            return height;
        }

        public int getWidth() {
            return width;
        }

        public int getDepth() {
            return depth;
        }
    }

    private class Monitor {

        // OOP ENCAPSULATION private class fields/object instance members
        private String model;
        private String manufacturer;
        private int size;

        // ? OOP ENCAPSULATION + COMPOSITION: object instance members/class fields that are each a class/object themselves
        private Resolution nativeResolution;

        // OOP constructor that initializes the class fields on class/object instantiation
        public Monitor(String model, String manufacturer, int size, Resolution nativeResolution) {
            this.model = model;
            this.manufacturer = manufacturer;
            this.size = size;
            this.nativeResolution = nativeResolution;
        }

        // OOP CLASS METHODS: non-static unique object behavior
        public void drawPixel(int x, int y, String color) {
            System.out.println("Drawing pixel at " + x + ", " + y + " in color " + color);
        }

        // OOP getters & setters
    }

    private class Motherboard {

        // OOP ENCAPSULATION private class instance members/fields
        private String model;
        private String manufacturer;
        private int ramSlots;
        private int cardSlots;
        private String bios;

        // OOP constructor that initializes the class fields on class/object instantiation
        public Motherboard(String model, String manufacturer, int ramSlots, int cardSlots, String bios) {
            this.model = model;
            this.manufacturer = manufacturer;
            this.ramSlots = ramSlots;
            this.cardSlots = cardSlots;
            this.bios = bios;
        }

        // OOP CLASS METHOD: non-static unique object behavior
        public void loadProgram(String programName, Monitor monitor) {
            System.out.println("Program " + programName + " is now loading...");
            monitor.drawPixel(5, 5, "White");
        }

        // OOP getters & setters
        public int getRamSlots() {
            return ramSlots;
        }

        public void setRamSlots(int ramSlots) {
            this.ramSlots = ramSlots;
        }

        public int getCardSlots() {
            return cardSlots;
        }

        public void setCardSlots(int cardSlots) {
            this.cardSlots = cardSlots;
        }

        public String getBios() {
            return bios;
        }

        public void setBios(String bios) {
            this.bios = bios;
        }
    }

    private class Resolution {

        // OOP ENCAPSULATION private class fields
        private int height;
        private int width;

        // OOP constructor that initializes the class fields on class/object instantiation
        public Resolution(int height, int width) {
            this.height = height;
            this.width = width;
        }
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