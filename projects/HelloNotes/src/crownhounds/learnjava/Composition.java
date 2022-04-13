package crownhounds.learnjava;

/**
 * Please refer to ObjectOrientedProgramming class
 */
public class Composition {
        /*
            Composition refers to an Object 'having' components or mini-Objects that make up the larger Object

            ex: A Computer has a motherboard, a monitor, and a case
                each component (motherboard, monitor, and case are their classes/objects)
         */

}

class Composition_Bedroom {

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

class Composition_PC {

    // object instance members/class fields that are each an object themselves; which demonstrates COMPOSITION
    private Composition_Case theCase;
    private Composition_Monitor theMonitor;
    private Composition_Motherboard theMotherboard;

    // constructor that initializes the fields (in this case, which are objects themselves demonstrating COMPOSITION) on class instantiation
    public Composition_PC(Composition_Case theCase, Composition_Monitor theMonitor, Composition_Motherboard theMotherboard) {
        this.theCase = theCase;
        this.theMonitor = theMonitor;
        this.theMotherboard = theMotherboard;
    }

    // unique behaviors/class methods
    public void powerUp() {
        System.out.println("PC.powerUp() was called");
        getTheCase().pressPowerButton();
        drawLogo();
    }

    private void drawLogo() {
        System.out.println("PC.drawLogo() was called");
        getTheMonitor().drawPixelAt(1200, 50, "yellow");

    }
    // getters & setters
    private Composition_Case getTheCase() {
        return theCase;
    }

    public void setTheCase(Composition_Case theCase) {
        this.theCase = theCase;
    }

    private Composition_Monitor getTheMonitor() {
        return theMonitor;
    }

    public void setTheMonitor(Composition_Monitor theMonitor) {
        this.theMonitor = theMonitor;
    }

    private Composition_Motherboard getTheMotherboard() {
        return theMotherboard;
    }

    public void setTheMotherboard(Composition_Motherboard theMotherboard) {
        this.theMotherboard = theMotherboard;
    }
}

class Composition_Case {

    // class instance members/object fields
    private String model;
    private String manufacturer;
    private String powerSupply;
    private Composition_Dimensions dimensions;

    // constructor that initializes the fields on class instantiation
    public Composition_Case(String model, String manufacturer, String powerSupply, Composition_Dimensions dimensions) {

        this.model = model;
        this.manufacturer = manufacturer;
        this.powerSupply = powerSupply;
        this.dimensions = dimensions;

    }

    // unique behaviors/class methods
    public void pressPowerButton() {
        System.out.println("pressPowerButton() was called; power is on");
    }

    // getters & setters
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getPowerSupply() {
        return powerSupply;
    }

    public void setPowerSupply(String powerSupply) {
        this.powerSupply = powerSupply;
    }

    public Composition_Dimensions getDimensions() {
        return dimensions;
    }

    public void setDimensions(Composition_Dimensions dimensions) {
        this.dimensions = dimensions;
    }
}

class Composition_Dimensions {

    // class instance members/object fields
    private int width;
    private int height;
    private int depth;

    // constructor that initializes the fields on class/object instantiation
    public Composition_Dimensions(int width, int height, int depth) {
        this.width = width;
        this.height = height;
        this.depth = depth;
    }

    // getters & setters
    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }
}

class Composition_Monitor {

    // class instance members/fields
    private String model;
    private String manufacturer;
    private int size;
    // nativeResolution is an instance of a class that demonstrates Composition
    private Composition_Resolution nativeResolution;

    // constructor that initializes the fields on class instantiation
    public Composition_Monitor(String model, String manufacturer, int size, Composition_Resolution nativeResolution) {
        this.model = model;
        this.manufacturer = manufacturer;
        this.size = size;
        this.nativeResolution = nativeResolution;
    }

    // unique behavior/methods
    public void drawPixelAt(int x, int y, String color) {
        System.out.println("Drawing pixel at " + x + ", " + y + " in color " + color);
    }

    // getters & setters
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Composition_Resolution getNativeResolution() {
        return nativeResolution;
    }

    public void setNativeResolution(Composition_Resolution nativeResolution) {
        this.nativeResolution = nativeResolution;
    }
}

class Composition_Motherboard {

    // class instance members/fields
    private String model;
    private String manufacturer;
    private int ramSlots;
    private int cardSlots;
    private String bios;

    // constructor that initializes the fields on class instantiation
    public Composition_Motherboard(String model, String manufacturer, int ramSlots, int cardSlots, String bios) {
        this.model = model;
        this.manufacturer = manufacturer;
        this.ramSlots = ramSlots;
        this.cardSlots = cardSlots;
        this.bios = bios;
    }

    public void loadProgram(String programName) {
        System.out.println("Program " + programName + " is now loading...");
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getRamSlots() {
        return ramSlots;
    }

    public void setRamSlots(int ramSlots) {
        this.ramSlots = ramSlots;
    }

    public int getCardSlots() {
        return cardSlots;
    }

    public void setCardSlots(int cardSlots) {
        this.cardSlots = cardSlots;
    }

    public String getBios() {
        return bios;
    }

    public void setBios(String bios) {
        this.bios = bios;
    }
}

class Composition_Resolution {

    // class instance members/object fields
    private int height;
    private int width;

    // constructor that initializes the fields on class/object instantiation
    public Composition_Resolution(int height, int width) {
        this.height = height;
        this.width = width;
    }

    // getters & setters
    public int getHeight() {
        return this.height;
    }

    public int getWidth() {
        return this.width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWidth(int width) {
        this.width = width;
    }
}
