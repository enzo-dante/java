package crownhounds.learnjava;

public class Composition_Resolution {

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
