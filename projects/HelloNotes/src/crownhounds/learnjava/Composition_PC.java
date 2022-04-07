package crownhounds.learnjava;

public class Composition_PC {

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
