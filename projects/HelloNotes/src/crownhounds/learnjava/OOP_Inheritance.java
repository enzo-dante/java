package crownhounds.learnjava;

/**
 * Please refer to ObjectOrientedProgramming class
 */
public class OOP_Inheritance {
        /*
            OOP inheritance refers to how child classes can inherit state and behavior from parent classes
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

}

class Inheritance_Animal {

    // parent class fields that will be INHERITED by some child classes
    private String name;
    private int brain;
    private int body;
    private int size;
    private int weight;

    // constructor that will initialize fields on class instantiation
    public Inheritance_Animal(String name, int brain, int body, int size, int weight) {
        this.name = name;
        this.brain = brain;
        this.body = body;
        this.size = size;
        this.weight = weight;
    }

    // public methods/shared behaviors that are inherited by all types of animals
    public void eat() {
        System.out.println("Animal.eat() was called");
    }

    public void move(int speed) {
        System.out.println("Animal.move() at speed " + speed);

    }

    // getters & setters for class fields
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBrain() {
        return brain;
    }

    public void setBrain(int brain) {
        this.brain = brain;
    }

    public int getBody() {
        return body;
    }

    public void setBody(int body) {
        this.body = body;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}

// to specify inheritance between classes in Java, use 'extends' keyword in class definition
class Inheritance_Dog extends Inheritance_Animal {

    // class instance members/fields that are unique to the Inheritance_Dog class
    private int eyes;
    private int legs;
    private int tail;
    private int teeth;
    private String coat;

    // child class uses 'super' keyword in its constructor to call parent class constructor to inherit fields from the Inheritance_Animal class
    // the constructor can contain a mixture of inherited fields and fields that are unique to this class
    public Inheritance_Dog(String name, int size, int weight, int eyes, int legs, int tail, int teeth, String coat) {
        super(name, 1, 1, size, weight);
        this.eyes = eyes;
        this.legs = legs;
        this.tail = tail;
        this.teeth = teeth;
        this.coat = coat;
    }

    private void chew() {
        System.out.println("Dog.chew() was called");
    }

    // override inherited Animal.eat() method with Inherited_Dog.chew()
    @Override
    public void eat() {
        System.out.println("override Dog.eat() was called");
        chew();

        // super = automatically call inherited Animal.eat() method & ignore if method overridden
        super.eat();
    }

    public void walk() {
        System.out.println("Dog.walk() was called");
        // given 'super' keyword, calling Animal.move() was using overriding method functionality from Dog class
        super.move(5);
    }

    public void run() {
        System.out.println("Dog.run() was called");
        // calling overridden Dog.move() functionality found in Dog class
        move(10);
    }

    public void moveLegs(int speed) {
        System.out.println("Dog.moveLegs() was called");
    }

    // override inherited Animal.move() method with Dog.moveLegs()
    @Override
    public void move(int speed) {
        System.out.println("Dog.move() was called");
        moveLegs(speed);
        super.move(speed);
    }
}

class Inheritance_Fish extends Inheritance_Animal {

    // class instance members/fields that are unique Fish class
    private int gills;
    private int fins;
    private int eyes;

    // child class uses 'super' keyword in its constructor to call parent class constructor to inherit fields from the Inheritance_Animal class
    // the constructor can contain a mixture of inherited fields and fields that are unique to this class
    // define default values instead passing as an argument
    public Inheritance_Fish(String name, int size, int weight, int gills, int eyes, int fins) {
        super(name, 1, 1, size, weight);
        this.gills = gills;
        this.eyes = eyes;
        this.fins = fins;
    }

    // public methods/behaviors that are unique to Fish class
    public void rest() {
        System.out.println("rest() was called");
    }

    public void moveMuscle() {
        System.out.println("moveMuscle() was called");
    }

    public void moveBackFin() {
        System.out.println("moveBackFin() was called");
    }

    public void swim(int speed) {
        System.out.println("swim() was called");
        moveMuscle();
        moveBackFin();
        // super = automatically call inherited Animal.move() method & ignore if method overridden
        super.move(speed);
    }

    // getters & setters
    public int getGills() {
        return gills;
    }

    public void setGills(int gills) {
        this.gills = gills;
    }

    public int getFins() {
        return fins;
    }

    public void setFins(int fins) {
        this.fins = fins;
    }

    public int getEyes() {
        return eyes;
    }

    public void setEyes(int eyes) {
        this.eyes = eyes;
    }
}

class Inheritance_Vehicle {

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
