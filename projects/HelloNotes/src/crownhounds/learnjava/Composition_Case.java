package crownhounds.learnjava;

public class Composition_Case {

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
