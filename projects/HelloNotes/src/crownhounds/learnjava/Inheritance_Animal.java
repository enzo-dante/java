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
