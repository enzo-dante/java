package com.crownhounds.learnjava;

public class AbstractClasses {

    public static void main(String[] args) {
        /*
            ! ABSTRACTION: defining the inherited signature, WITHOUT implementation

                Interfaces and the defined shared method signatures are also an example of ABSTRACTION

            ? ABSTRACT CLASSES

                force child subclass INHERITANCE of method, signatures, & parent super-class fields for a set of classes
                by mandating POLYMORPHISM method signatures to be defined in order to execute respectively-unique implementation
                ! CANNOT instantiate an ABSTRACT CLASS, must use a normal class that inherits from ABSTRACT CLASS for instantiation

            ? Interfaces vs Abstract Classes

                ABSTRACT CLASSES can have class fields/object instance members inherited AND define abstract publicly-shared signatures

                INTERFACES can ONLY define publicly-shared signatures

                    interfaces can have essentially-constant variables defined as "public static final"
         */

        AbstractSubclassDog dog = new AbstractSubclassDog("Stone");
        dog.breathe();
        dog.eat();

        // ! OOP INHERITANCE: call Animal.getName() from subclass Dog using 'super' keyword
        System.out.println(dog.getName());
        System.out.println(dog.getColor());

        Util.printSeparator();

        AbstractSubclassParrot parrot = new AbstractSubclassParrot("Lago", 0);
        // ! OOP POLYMORPHISM enable same-name methods unique functionality per class
        parrot.breathe();
        parrot.eat();

        // ! OOP INHERITANCE: call Animal.getName() from abstract subclass Bird using 'super' keyword
        System.out.println(parrot.getName());

        // ! OOP INHERITANCE: call POLYMORPHISM abstract Bird.isFlying() from implementing subclass Parrot using @Override keyword
        System.out.println(parrot.isFlying());
        parrot.setFlying(true);
        System.out.println(parrot.isFlying());

        Util.printSeparator();

        // ! OOP INHERITANCE: call POLYMORPHISM abstract Bird.isFlying() from implementing subclass Parrot using @Override keyword
        AbstractSubclassPenguin penguin = new AbstractSubclassPenguin("King", 0);
        System.out.println(penguin.getName());
        System.out.println(penguin.isFlying());

    }
}

// ? Java ABSTRACT CLASSES are defined with the keyword 'abstract'
abstract class AbstractClassAnimal {

    // class fields/object instance members
    private String name;

    // OOP constructor that initializes the class fields on class/object instantiation
    public AbstractClassAnimal(String name) {
        this.name = name;
    }

    // ? ABSTRACTION: only define publicly-shared method signatures with keyword 'abstract'
    public abstract void eat();
    public abstract void breathe();

    // getters & setters
    public String getName() {
        return name;
    }
}

// ! OOP INHERITANCE: child-class constructor needs to extend parent super-class Animal in addition to abstract class method implementation
class AbstractSubclassDog extends AbstractClassAnimal {

    // CONSTANTS

    // private class fields
    private String color;

    // constructor that initializes the class fields on class/object instantiation
    public AbstractSubclassDog(String name) {
        // ! Dog constructor needs 'super' keyword to extend ABSTRACT CLASS Animal in addition to abstract class method implementation
        super(name);

        // default values
        this.color = "yellow";
    }

    // non-static class methods/unique behavior
    // ! ABSTRACT CLASS OOP INHERITANCE Dog needs to implement the shared abstract method signatures via OOP POLYMORPHISM @Override
    @Override
    public void eat() {
        System.out.println("AbstractAnimal.Dog.eat() was called");
    }

    @Override
    public void breathe() {
        // ! OOP INHERITANCE: call Animal.getName() from subclass Dog using 'super' keyword
        System.out.println("AbstractAnimal.Dog.breath() was called by " + super.getName());
    }

    // getters & setters
    public String getColor() {
        return this.color;
    }
}

// ? Java ABSTRACT CLASSES can extend other ABSTRACT CLASSES by extending them
abstract class AbstractSubclassBird extends AbstractClassAnimal {

    // CONSTANTS

    // private class fields/object instance members
    private Double speed;

    // OOP constructor that initializes the class fields on class/object instantiation
    public AbstractSubclassBird(String name, double speed) {
        // ! OOP INHERITANCE: child class extends parent super class
        super(name);

        // ! AUTOBOXING: automatically convert primitive datatype -> Wrapper class datatype (higher functionality)
        this.speed = speed;
    }

    // non-static unique behaviors/class methods
    // ! ABSTRACT CLASS INHERITANCE: force implementation for abstract method signatures (with shared class fields) via OOP POLYMORPHISM @Override
    @Override
    public void eat() {
        System.out.println("AbstractAnimal.Bird.eat() was called");
    }

    @Override
    public void breathe() {
        System.out.println("AbstractAnimal.Bird.breathe() was called");
    }

    // ! ABSTRACTION: define publicly-shared abstract signatures, without implementation
    //      since not all birds can fly, define abstract signature that can be implemented by inheriting child subclass
    public abstract boolean isFlying();

    // getters & setters
    public Double getSpeed() {
        System.out.println("AbstractBird.getSpeed() was called");
        return this.speed;
    }

    public void setSpeed(Double speed) {
        System.out.println("AbstractBird.setSpeed() was called");
        this.speed = speed;
    }
}

// ! OOP INHERITANCE + ABSTRACT CLASSES: child subclass inherits class fields from extending parent super-class
class AbstractSubclassParrot extends AbstractSubclassBird {

    // CONSTANTS
    private final String CLASS_NAME = getClass().getSimpleName();

    // private class fields
    private boolean isFlying;

    // OOP constructor that initializes the class fields on class/object instantiation
    public AbstractSubclassParrot(String name, double speed) {
        // ! OOP INHERITANCE + ABSTRACT CLASSES: child subclass inherits class fields from extending parent super-class
        super(name, speed);

        // default values
        this.isFlying = false;
    }

    // ! OOP ABSTRACT CLASS INHERITANCE + POLYMORPHISM: implement abstract signatures inherited by parent ABSTRACT CLASS via @Override
    @Override
    public boolean isFlying() {
        System.out.println("AbstractAnimal.AbstractBird.Parrot.isFlying() was called");

        return this.isFlying;
    }

    public void setFlying(boolean flying) {
        System.out.println("AbstractAnimal.AbstractBird.Parrot.setFlying() was called");

        this.isFlying = flying;

        if(this.isFlying) {
            super.setSpeed(5D);
            System.out.println(super.getSpeed());
        }
    }
}

// ! OOP INHERITANCE
class AbstractSubclassPenguin extends AbstractSubclassBird {

    // OOP constructor that initializes the class fields on class/object instantiation
    public AbstractSubclassPenguin(String name, double speed) {
        super(name, speed);
    }

    // ! OOP ABSTRACT CLASS INHERITANCE + POLYMORPHISM: implement abstract signatures inherited by parent ABSTRACT CLASS via @Override
    @Override
    public boolean isFlying() {
        System.out.println("AbstractBird.Penguin.isFlying() was called, but penguins cannot fly");
        return false;
    }
}