package crownhounds.learnjava;

public class Inheritance_Fish extends Inheritance_Animal {

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
