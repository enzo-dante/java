package crownhounds.learnjava;

public class Composition_Lamp {

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
