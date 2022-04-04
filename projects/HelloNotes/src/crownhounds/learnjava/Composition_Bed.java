package crownhounds.learnjava;

public class Composition_Bed {

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
