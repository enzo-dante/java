package crownhounds.learnjava;

// to specify inheritance between classes in Java, use 'extends' keyword in class definition
public class Inheritance_Dog extends Inheritance_Animal {

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
