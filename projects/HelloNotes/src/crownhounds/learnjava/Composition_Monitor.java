package crownhounds.learnjava;

public class Composition_Monitor {

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
