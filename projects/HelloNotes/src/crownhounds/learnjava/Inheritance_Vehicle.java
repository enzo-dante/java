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
