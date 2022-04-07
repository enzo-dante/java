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

class Composition_Bed {

    // object instance members/class fields
    private String style;
    private int pillows;
    private int height;
    private int sheets;
    private int quilt;

    // constructor that initializes the fields on class instantiation
    public Composition_Bed(String style, int pillows, int height, int sheets, int quilt) {
        this.style = style;
        this.pillows = pillows;
        this.height = height;
        this.sheets = sheets;
        this.quilt = quilt;
    }

    // unique behaviors/class methods
    public void make() {
        System.out.println("Bed.make() was called");
    }

    // getters & setters
    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public int getPillows() {
        return pillows;
    }

    public void setPillows(int pillows) {
        this.pillows = pillows;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getSheets() {
        return sheets;
    }

    public void setSheets(int sheets) {
        this.sheets = sheets;
    }

    public int getQuilt() {
        return quilt;
    }

    public void setQuilt(int quilt) {
        this.quilt = quilt;
    }
}

class Composition_Ceiling {

    // class fields
    private int height;
    private int paintedColor;

    // constructor
    public Composition_Ceiling(int height, int paintedColor) {
        this.height = height;
        this.paintedColor = paintedColor;
    }

    // getters & setters
    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getPaintedColor() {
        return paintedColor;
    }

    public void setPaintedColor(int paintedColor) {
        this.paintedColor = paintedColor;
    }
}

class Composition_Lamp {

    // class fields
    private String style;
    private boolean hasBattery;
    private int globeRating;

    // constructor
    public Composition_Lamp(String style, boolean hasBattery, int globeRating) {
        this.style = style;
        this.hasBattery = hasBattery;
        this.globeRating = globeRating;
    }

    // unique behavior/class methods
    public void turningOn() {
        System.out.println("Lamp.turningOn() was called");
    }

    // getters & setters
    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public boolean isHasBattery() {
        return hasBattery;
    }

    public void setHasBattery(boolean hasBattery) {
        this.hasBattery = hasBattery;
    }

    public int getGlobeRating() {
        return globeRating;
    }

    public void setGlobeRating(int globeRating) {
        this.globeRating = globeRating;
    }
}

class Composition_Wall {
    // object instance members/class fields
    private String direction;

    // constructor
    public Composition_Wall(String direction) {
        this.direction = direction;
    }

    // getters & setters
    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }
}
