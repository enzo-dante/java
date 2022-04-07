package crownhounds.learnjava;

public class Inheritance_Vehicle {

    // private class fields/object instance members
    private int currentVelocity;
    private int currentDirection;
    private String name;
    private String size;

    // constructors to initialize fields on class/object instantiation
    public Inheritance_Vehicle(String name, String size) {
        this.name = name;
        this.size = size;

        // set default value
        this.currentVelocity = 0;
        this.currentDirection = 0;
    }

    // methods that use OOP inheritance should NOT be static, since being shared
    public void steer(int direction) {
        this.currentDirection += direction;
        System.out.println("Vehicle.steer(): steering at " + this.currentDirection + " degrees.");
    }

    public void move(int velocity, int direction) {
        this.currentVelocity = velocity;
        this.currentDirection = direction;

        System.out.println("Vehicle.move(): move at " + this.currentVelocity + " in direction " + this.currentDirection);
    }

    public void stop() {
        this.currentVelocity = 0;
    }

    // getters & setters
    public int getCurrentVelocity() {
        return this.currentVelocity;
    }

    public void setCurrentVelocity(int currentVelocity) {
        this.currentVelocity = currentVelocity;
    }

    public int getCurrentDirection() {
        return this.currentDirection;
    }

    public void setCurrentDirection(int currentDirection) {
        this.currentDirection = currentDirection;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return this.size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}

class Inheritance_Car extends Inheritance_Vehicle {

    // private class/object fields
    private int wheels;
    private int doors;
    private int gears;
    private boolean isManual;

    private int currentGear;

    // constructors to initialize fields on class instantiation
    public Inheritance_Car(int wheels, int doors, int gears, boolean isManual, String name, String size) {
        // inherited fields called with 'super'
        super(name, size);
        this.wheels = wheels;
        this.doors = doors;
        this.gears = gears;
        this.isManual = isManual;
    }

    public void changeVelocity(int speed, int direction) {
        System.out.println("Car.changeVelocity(): velocity: " + speed + ", direction: " + direction);
        move(speed, direction);
    }

    // getters & setters
    public int getWheels() {
        return wheels;
    }

    public void setWheels(int wheels) {
        this.wheels = wheels;
    }

    public int getDoors() {
        return doors;
    }

    public void setDoors(int doors) {
        this.doors = doors;
    }

    public int getGears() {
        return gears;
    }

    public void setGears(int gears) {
        this.gears = gears;
    }

    public boolean isManual() {
        return isManual;
    }

    public void setManual(boolean manual) {
        isManual = manual;
    }

    public int getCurrentGear() {
        return currentGear;
    }

    public void setCurrentGear(int currentGear) {
        this.currentGear = currentGear;
        System.out.println("Car.setCurrentGear(): changed to " + this.currentGear);
    }
}

class Inheritance_Ferrari extends Inheritance_Car {

    // private class fields/ object instance members
    private int roadServiceMonths;

    // constructors to initialize class fields on class/object instantiation
    public Inheritance_Ferrari(int roadServiceMonths) {
        // inherited fields called with 'super', set default values for all Ferrari class instances
        super(4, 2, 6, false, "Ferrari", "4WD");
        this.roadServiceMonths = roadServiceMonths;
    }

    // unique class method/behavior
    public void accelerate(int rate) {

        int newVelocity = super.getCurrentVelocity() + rate;

        if(newVelocity == 0) {

            super.stop();
            super.setCurrentGear(1); // due to being an automatic gear box

        } else if(newVelocity > 0 && newVelocity <= 10) {

            super.setCurrentGear(1);

        } else if(newVelocity > 10 && newVelocity <= 20) {

            super.setCurrentGear(2);

        } else if(newVelocity > 20 && newVelocity <= 30) {

            super.setCurrentGear(3);

        } else {

            super.setCurrentGear(4);

        }

        if(newVelocity > 0) {
            super.changeVelocity(newVelocity, super.getCurrentDirection());
        }
    }

    // getters & setters
    public int getRoadServiceMonths() {
        return roadServiceMonths;
    }

    public void setRoadServiceMonths(int roadServiceMonths) {
        this.roadServiceMonths = roadServiceMonths;
    }
}
