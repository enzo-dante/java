package crownhounds.learnjava;

public class Inheritance_Animal {

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
