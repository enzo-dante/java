package crownhounds.learnjava;

public class Composition_Dimensions {

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
