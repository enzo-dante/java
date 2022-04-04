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
