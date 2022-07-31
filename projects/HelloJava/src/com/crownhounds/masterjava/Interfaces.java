package com.crownhounds.masterjava;

public class Interfaces {
    /*
        ! INTERFACE: an abstract collection of public signatures that designated classes MUST uniquely implement/@Override for standardization

            abstract = no logic, only define the method names & parameters (signature) shared across adhering classes

        ? INTERFACES: prevent breaking code bc constant variables shared by set of classes will not change

        * Interfaces vs Abstract Classes

            ABSTRACT CLASSES can have class fields/object instance members inherited AND define abstract publicly-shared signatures

                abstract classes must have a constructor for INHERITANCE for subclasses BUT abstract classes cannot be instantiated
                abstract classes signatures, implemented methods, & variables can have public or private access modifiers

            INTERFACES can ONLY define publicly-shared signatures

                interfaces can have essentially-constant variables defined as "public static final"
                interfaces do NOT have a constructor since it cannot be instantiated
                interfaces signature & variables must be public

     */

    public static void main(String[] args) {

        Util.printSeparator("Interface Desk Phone");

        int testNumber1 = 1231231234;
        int testNumber2 = 1112223333;
        boolean danteCalling;
        boolean mobileCalling;

        // ? define the interface instance
        ITelephone dantePhone;

        // ? create a new class instance that implements defined interface by setting it to interface instance
        dantePhone = new InterfaceDeskPhone(testNumber1);
        dantePhone.powerOn();
        danteCalling = dantePhone.callPhone(testNumber1);
        dantePhone.answer();

        Util.printSeparator("Interface Mobile Phone");

        // ? reassign the interface instance
        // ? create a new class instance that implements defined interface by setting it to interface instance
        dantePhone = new InterfaceMobilePhone(testNumber2);

        // should fail since mobile phone instance is not on
        dantePhone.callPhone(testNumber1);
        dantePhone.answer();

        dantePhone.powerOn();
        dantePhone.dial(testNumber1);
        dantePhone.answer();

        Util.printSeparator("Interface vs Abstraction");

        /*
            not all birds can fly despite having wings,
            so implement an interface ICanFly in an ABSTRACT CLASS Bird (shared bird qualities),
            then implement ICanFly.fly() per child subclass that extends parent super AbstractClassBird
         */

        InterfaceClassRobin robin = new InterfaceClassRobin("Robin");
        System.out.println(robin.getName());
        robin.fly();

        Util.printSeparator();

        InterfaceClassPenguin penguin = new InterfaceClassPenguin("Emperor Penguin");
        System.out.println(penguin.getName());
        penguin.fly();

    }
}

// ? define publicly accessible interface with 'interface' keyword and a capital 'I' at the beginning of the name
interface ITelephone {

    // CONSTANTS

    // ? define the public 'signature' (only method names & parameters) of the shared behavior used by the set of class
    void powerOn();
    void dial(int phoneNumber);
    void answer();
    boolean callPhone(int phoneNumber);
    boolean isRinging();

    final String NO_POWER = "No action taken, phone does not have a power button";
    final String ANSWERING = "Answering the phone";
    final String RINGING = "Ring ring ring";
    final String POWER_OFF = "No action taken, phone is off";
}

// ? to use an INTERFACE, the class definition 'implements' said interface
class InterfaceDeskPhone implements ITelephone{

    // private class fields/object instance members
    private int myNumber;
    private boolean isRinging;

    // constructor that initializes the class fields on class/object instantiation
    public InterfaceDeskPhone(int myNumber) {
        // default values given no parameters
        this.isRinging = false;

        this.myNumber = myNumber;
    }
    // standardized INTERFACE methods with unique logic per class
    // ! must implement ALL INTERFACE methods regardless of practical value to specific class
    @Override
    public void powerOn() {
        System.out.println(NO_POWER);
    }

    @Override
    public void dial(int phoneNumber) {
        System.out.println("Now ringing " + phoneNumber + " on desk phone");
    }

    @Override
    public void answer() {
        System.out.println(ANSWERING);
        isRinging = false;
    }

    @Override
    public boolean callPhone(int phoneNumber) {

        if(phoneNumber == this.myNumber) {
            System.out.println(RINGING);
            this.isRinging = true;
        } else {
            this.isRinging = false;
        }

        return this.isRinging;
    }

    @Override
    public boolean isRinging() {
        return isRinging;
    }
}

// ? to use an INTERFACE, class definition 'implements' said interface
class InterfaceMobilePhone implements ITelephone {

    // ! ENCAPSULATION: CONSTANTS not shared by INTERFACE & only unique to this class
    private final String MOBILE_ON = "Mobile phone powered on";
    private final String MELODY_PLAYING = "Mobile phone melody is playing";

    // private class fields/object instance members
    private int myNumber;
    private boolean isRinging;
    private boolean isOn;

    // constructor that initializes the class fields on class/object instantiation
    public InterfaceMobilePhone(int myNumber) {

        this.myNumber = myNumber;

        // default values
        this.isOn = false;
        this.isRinging = false;
    }

    // ? standardized INTERFACE behaviors/methods shared by a set of classes
    // ! must implement ALL INTERFACE methods with unique logic per class
    @Override
    public void powerOn() {
        this.isOn = true;
        System.out.println(MOBILE_ON);

    }

    @Override
    public void dial(int phoneNumber) {

        if(this.isOn && this.myNumber != phoneNumber) {
            System.out.println("Now ringing " + phoneNumber + "on mobile phone");
            this.isRinging = true;
        } else {
            System.out.println(RINGING);
            this.isRinging = false;
        }
    }

    @Override
    public void answer() {
        System.out.println(ANSWERING);
    }

    @Override
    public boolean callPhone(int phoneNumber) {
        if(phoneNumber == this.myNumber && this.isOn) {
            this.isRinging = true;
            System.out.println(MELODY_PLAYING);
        } else {
            System.out.println(POWER_OFF);
            this.isRinging = false;
        }
        return this.isRinging;
    }

    @Override
    public boolean isRinging() {
        return this.isRinging;
    }
}

// ? define publicly accessible interface with 'interface' keyword and a capital 'I' at the beginning of the name
interface ICanFly {

    // ? define the public 'signature' (only method names & parameters) of the shared behavior used by the set of class
    void fly();
}

// ! ABSTRACT CLASS cannot instantiate, must rely on normal class instance that extends ABSTRACT CLASS via OOP INHERITANCE
// ? to use an INTERFACE, class definition 'implements' said interface
abstract class InterfaceAbstractClassBird implements ICanFly {

    // private class fields
    private String name;

    // OOP constructor that initializes the class fields on class/object instantiation
    // ! ABSTRACT CLASS cannot instantiate, must rely on normal class instance that extends ABSTRACT CLASS via OOP INHERITANCE
    public InterfaceAbstractClassBird(String name) {
        this.name = name;
    }

    // ! INTERFACE: implement ALL publicly-shared signature via POLYMORPHISM @Override
    @Override
    public void fly() {
        System.out.println("AbstractBird.fly() that implements ICanFly interface was called");
    }

    // getters & setters
    public String getName() {
        System.out.println("AbstractBird.getName() was called");
        return this.name;
    }
}


// ! OOP INHERITANCE: child subclass inherits class fields from extending parent super-class
class InterfaceClassRobin extends InterfaceAbstractClassBird {

    // ENCAPSULATION private class fields
    private String color;

    // OOP constructor that initializes class fields on class/object instantiation
    public InterfaceClassRobin(String name) {
        // ! OOP INHERITANCE: child subclass inherits class fields from extending parent super-class
        super(name);

        // default values
        this.color = "red";
    }

    // getters & setters
    public String getColor() {
        System.out.println("Robin.getColor() was called");
        return this.color;
    }
}

class InterfaceClassPenguin extends InterfaceAbstractClassBird {

    // ENCAPSULATION class fields

    // OOP constructor that initializes class fields on class/object instantiation
    public InterfaceClassPenguin(String name) {
        // ! INHERITANCE: child subclass inherits class fields from extending parent super-class
        super(name);
    }

    // non-static unique behaviors/class methods
    // ! INTERFACES + ABSTRACT CLASS OOP POLYMORPHISM
    @Override
    public void fly() {
        super.fly();
        System.out.println("Penguin.fly(): Unfortunately, penguins cannot fly");
    }
}