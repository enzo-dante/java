package com.crownhounds.masterjava;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * ? InnerClasses object = static nested class
 */
public class InnerClasses {

    // class fields
    private static Scanner scanner = new Scanner(System.in);
    private static LocalClassButton btnPrint = new LocalClassButton("Print");

    public static void main(String[] args) {
        /*
            ? 4 Types of Java nested classes

                * 1. static nested classes
                    needs a non-static class instance to execute functionality

                * 2. non-static INNER CLASS
                    logically grouped subclass that needs a base class instance to execute functionality

                * 3. local (scope-block defined) class
                    a defined class that implements an interface but the class isn't used in a shared env

                * 4. anonymous (no-name) class
                    a local class that has no name and need to execute functionality once
         */

        Util.printSeparator("Non-static Inner Classes");

        /*
            ! PUBLIC inner class
            ? to instantiate a PUBLIC INNER CLASS that the BASE CLASS is dependent on

                * baseClassInstance.new InnerClass(args)
         */

        // ? INNER CLASSES: logically grouped subclass that needs a base class instance to execute functionality
        BaseClassRobot baseClassBadRobot = new BaseClassRobot("Bad Robot");

        BaseClassRobot.InnerClassActivationSwitch activationSwitch =
                baseClassBadRobot.new InnerClassActivationSwitch(true);

        System.out.println(baseClassBadRobot.isPowerOn(activationSwitch));

        Util.printSeparator();

        /*
            ! PRIVATE inner class
            ? to instantiate a PRIVATE INNER CLASS that the BASE CLASS is dependent on
         */

        // ? INNER CLASSES: logically grouped subclass that needs a base class instance to execute functionality
        //      mcLaren instance constructs gearBox with INNER CLASS gear instance in constructor
        BaseClassGearbox mcLaren = new BaseClassGearbox(6);

        Util.printSeparator();

        mcLaren.operateClutch(true);
        mcLaren.changeGear(1);
        mcLaren.operateClutch(false);
        System.out.println(mcLaren.wheelSpeed(1000));

        mcLaren.changeGear(2);
        System.out.println(mcLaren.wheelSpeed(3000));

        mcLaren.operateClutch(true);
        mcLaren.changeGear(3);
        mcLaren.operateClutch(false);
        System.out.println(mcLaren.wheelSpeed(6000));

        Util.printSeparator("Local Classes");

        // a defined class that implements an interface but the class isn't used in a shared env
        class ClickListener implements LocalClassButton.OnClickListener {

            // CONSTANTS
            private static final String INVALID_INPUT = "Invalid input, try again";

            // constructor that initializes the class fields on class/object instantiation
            public ClickListener() {
                System.out.println(getClass().getSimpleName() + " has been initialized & attached");
            }

            // unique static behavior/class methods
            public static void listen() {

                boolean quit = false;

                while(!quit) {

                    System.out.println("choice:");

                    // only capture valid user input
                    if(scanner.hasNextInt()) {

                        // save user input
                        int choice = scanner.nextInt();

                        // handle 'enter' key down
                        scanner.nextLine();

                        switch(choice) {
                            case 0:
                                quit = true;
                                break;
                            case 1:
                                btnPrint.onClick();
                                break;
                            default:
                                break;
                        }

                    } else {
                        scanner = new Scanner(System.in);
                        System.out.println(INVALID_INPUT);
                    }
                }
            }

            // unique non-static behavior/class methods
            // ! OOP INHERITANCE & POLYMORPHISM
            @Override
            public void onClick(String title) {
                System.out.println(getClass().getSimpleName() + ".onClick() was called by " + title);
            }
        }

        // locally-defined class is being instantiated & attached to normal class
        ClickListener clickListener = new ClickListener();
        btnPrint.setOnClickListener(clickListener);

        ClickListener.listen();

        Util.printSeparator("Anonymous Inner Class");

        // ? a local class that has no name and need to execute functionality once
        btnPrint.setOnClickListener(new LocalClassButton.OnClickListener() {

            // ! OOP INHERITANCE & POLYMORPHISM
            @Override
            public void onClick(String title) {
                System.out.println(title + " was clicked from an (no name) Anonymous Class...");
            }
        });

        ClickListener.listen();
    }
}

/**
 * ! INNER CLASS logic = an Object COMPOSITION will always depend on a component Object
 *      a Gearbox will always use a Gear
 */
class BaseClassRobot {

    // private class fields
    private String name;

    // ! OOP: constructor that initializes the fields on class/object instantiation
    public BaseClassRobot(String name) {
        this.name = name;
    }

    // ! INNER CLASS & OOP COMPOSITION
    public class InnerClassActivationSwitch  {

        // private class fields/object instance members
        private boolean powerOn;

        // ! OOP: constructor that initializes the fields on class/object instantiation
        public InnerClassActivationSwitch(boolean powerOn) {
            this.powerOn = powerOn;
        }

        // unique non-static behaviors/class methods

        // getters & setters
        public boolean isPowerOn() {
            System.out.println(getClass().getSimpleName() + ".isPowerOn() was called");
            return powerOn;
        }

        public void setPowerOn(boolean powerOn) {
            this.powerOn = powerOn;
        }
    }

    // unique non-static behaviors/class methods

    // ! POLYMORPHISM
    public boolean isPowerOn(InnerClassActivationSwitch activationSwitch) {
        System.out.println(getClass().getSimpleName() + ".isPowerOn() was called for " + this.name);
        return activationSwitch.isPowerOn();
    }
}

/**
 * ! INNER CLASS logic = an Object COMPOSITION will always depend on a component Object
 *      a Gearbox will always use a Gear
 */
class BaseClassGearbox {

    // CONSTANTS
    private final String CLASS_NAME = getClass().getSimpleName();

    // private class fields/object instance members
    private ArrayList<InnerClassGear> gears;
    private int maxGears;
    private int currentGear;
    private boolean clutchIsIn;
    private double defaultRatio;

    // constructor that initializes the fields on class/object instantiation
    public BaseClassGearbox(int maxGears) {
        this.maxGears = maxGears;

        // default values
        InnerClassGear neutral = new InnerClassGear(0,0.0);
        this.gears = new ArrayList<>();
        this.gears.add(neutral);
        this.clutchIsIn = false;
        this.defaultRatio = 5.3;

        // ! OOP ENCAPSULATION: protect class fields accessibility to prevent inappropriate update
        for(int i = 0; i < this.maxGears; i++) {
            addGear(i, i * defaultRatio);
        }
    }

    // ! OOP ENCAPSULATION: protect class fields accessibility to prevent inappropriate update
    private class InnerClassGear {

        /*
             ? don't share class field names between a base & inner class
                ex: currentGear should NOT be named gearNumber
         */

        // CONSTANTS
        private final String CLASS_NAME = getClass().getSimpleName();

        // private class fields/object instance members
        private int gearNumber;
        private Double ratio;

        // constructor that initializes the fields on class/object instantiation
        public InnerClassGear(int gearNumber, double ratio) {
            this.gearNumber = gearNumber;

            // ! AUTOBOXING = automatically converting primitive datatype -> more function Object Wrapper class datatype
            this.ratio = ratio;
        }

        // ? INNER CLASS unique instance behavior/non-static class methods
        public double driveSpeed(int revs) {
            System.out.println(CLASS_NAME + ".driveSpeed() was called");
            return (double) revs * (this.ratio);
        }

        // INNER CLASS getters & setters
        public int getGearNumber() {
            return gearNumber;
        }

        public void setGearNumber(int gearNumber) {
            this.gearNumber = gearNumber;
        }

        public double getRatio() {
            return ratio;
        }

        public void setRatio(double ratio) {
            this.ratio = ratio;
        }
    }

    // ? BASE/OUTER CLASS unique non-static behaviors
    public void operateClutch(boolean in) {
        this.clutchIsIn = in;
        System.out.println(CLASS_NAME + ".operateClutch() was called" +
                "\nclutchIsIn: " + this.clutchIsIn);
    }

    private void addGear(int gearNumber, double ratio) {
        System.out.println(CLASS_NAME + ".addGear() was called");
        if((gearNumber > 0) && (gearNumber <= this.maxGears)) {

            // add new Gear instance to arrayList gears for Gearbox
            this.gears.add(new InnerClassGear(gearNumber, ratio));
        }
    }

    public void changeGear(int newGear) {
        if((newGear > 0) &&
                (newGear < this.gears.size()) &&
                this.clutchIsIn) {

            this.currentGear = newGear;
            System.out.println(CLASS_NAME + ".changeGear() was called; new currentGear: " + this.currentGear);
        } else {
            this.currentGear = 0;
            System.out.println(CLASS_NAME + ".changeGear() was called; gears grinding.....");
        }
    }

    public double wheelSpeed(int revs) {

        System.out.println(CLASS_NAME + ".wheelSpeed() was called");

        if(this.clutchIsIn) {
            return 0.0;
        }

        // implied else-statement
        return (double) revs * (this.gears.get(this.currentGear).getRatio());
    }

    // BASE/OUTER CLASS getters & setters
    public ArrayList<InnerClassGear> getGears() {
        return gears;
    }

    public void setGears(ArrayList<InnerClassGear> gears) {
        this.gears = gears;
    }

    public int getMaxGears() {
        return maxGears;
    }

    public void setMaxGears(int maxGears) {
        this.maxGears = maxGears;
    }

    public int getCurrentGear() {
        return currentGear;
    }

    public void setCurrentGear(int currentGear) {
        this.currentGear = currentGear;
    }
}

class LocalClassButton {

    // private class fields
    private String title;
    private OnClickListener onClickListener;

    // OOP constructor that initializes the class fields on class/object instantiation
    public LocalClassButton(String title) {
        this.title = title;
    }

    // unique non-static behaviors/class methods
    public void onClick() {
        this.onClickListener.onClick(this.title);

    }
    // getters & setters
    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    public String getTitle() {
        return this.title;
    }

    // ! INTERFACES: prevent breaking code bc public constant variables shared by set of classes will not change
    public interface OnClickListener {
        void onClick(String title);
    }
}