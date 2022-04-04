package crownhounds.learnjava;

public class Composition_Ceiling {

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
