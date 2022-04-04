package crownhounds.learnjava;

public class Inheritance_Ferrari extends Inheritance_Car {

    // private class fields/ object instance members
    private int roadServiceMonths;

    // constructors to initialize class fields on class/object instantiation
    public Inheritance_Ferrari(int roadServiceMonths) {
        // inherited fields called with 'super', set default values for all Ferrari class instances
        super(4, 2, 6, false, "Ferrari", "4WD");
        this.roadServiceMonths = roadServiceMonths;
    }

    // unique class method/behavior
    public void accelerate(int rate) {

        int newVelocity = super.getCurrentVelocity() + rate;

        if(newVelocity == 0) {

            super.stop();
            super.setCurrentGear(1); // due to being an automatic gear box

        } else if(newVelocity > 0 && newVelocity <= 10) {

            super.setCurrentGear(1);

        } else if(newVelocity > 10 && newVelocity <= 20) {

            super.setCurrentGear(2);

        } else if(newVelocity > 20 && newVelocity <= 30) {

            super.setCurrentGear(3);

        } else {

            super.setCurrentGear(4);

        }

        if(newVelocity > 0) {
            super.changeVelocity(newVelocity, super.getCurrentDirection());
        }
    }

    // getters & setters
    public int getRoadServiceMonths() {
        return roadServiceMonths;
    }

    public void setRoadServiceMonths(int roadServiceMonths) {
        this.roadServiceMonths = roadServiceMonths;
    }
}
