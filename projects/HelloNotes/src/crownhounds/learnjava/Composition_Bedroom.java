package crownhounds.learnjava;

public class Composition_Bedroom {

    // object instance members/class fields & state
    private String name;
    private Composition_Wall wall1;
    private Composition_Wall wall2;
    private Composition_Wall wall3;
    private Composition_Wall wall4;
    private Composition_Ceiling ceiling;
    private Composition_Bed bed;
    private Composition_Lamp lamp;

    // constructor that initializes the fields on class instantiation
    public Composition_Bedroom(String name, Composition_Wall wall1, Composition_Wall wall2, Composition_Wall wall3, Composition_Wall wall4, Composition_Ceiling ceiling, Composition_Bed bed, Composition_Lamp lamp) {
        this.name = name;
        this.wall1 = wall1;
        this.wall2 = wall2;
        this.wall3 = wall3;
        this.wall4 = wall4;
        this.ceiling = ceiling;
        this.bed = bed;
        this.lamp = lamp;
    }

    // unique class behavior/methods
    public void makeBed() {
        System.out.println("Bedroom.makeBed() was called");
        getBed().make();

    }

    // getters & setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Composition_Wall getWall1() {
        return wall1;
    }

    public void setWall1(Composition_Wall wall1) {
        this.wall1 = wall1;
    }

    public Composition_Wall getWall2() {
        return wall2;
    }

    public void setWall2(Composition_Wall wall2) {
        this.wall2 = wall2;
    }

    public Composition_Wall getWall3() {
        return wall3;
    }

    public void setWall3(Composition_Wall wall3) {
        this.wall3 = wall3;
    }

    public Composition_Wall getWall4() {
        return wall4;
    }

    public void setWall4(Composition_Wall wall4) {
        this.wall4 = wall4;
    }

    public Composition_Ceiling getCeiling() {
        return ceiling;
    }

    public void setCeiling(Composition_Ceiling ceiling) {
        this.ceiling = ceiling;
    }

    public Composition_Bed getBed() {
        return bed;
    }

    public void setBed(Composition_Bed bed) {
        this.bed = bed;
    }

    public Composition_Lamp getLamp() {
        return lamp;
    }

    public void setLamp(Composition_Lamp lamp) {
        this.lamp = lamp;
    }
}
