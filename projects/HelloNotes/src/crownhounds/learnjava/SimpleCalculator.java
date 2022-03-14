package crownhounds.learnjava;

public class SimpleCalculator {

    /*
        SimpleCalculator class object/blueprint's member variables/fields
        ! best practice: set to private and use setter & getter behavior to update instance state
     */

    private double firstNumber;
    private double secondNumber;

    public double getFirstNumber() {
        return this.firstNumber;
    }

    public double getSecondNumber() {
        return this.secondNumber;
    }

    public void setFirstNumber(double firstNumber) {
        this.firstNumber = firstNumber;
    }

    public void setSecondNumber(double secondNumber) {
        this.secondNumber = secondNumber;
    }

    public double getAdditionResult() {
        return this.firstNumber + this.secondNumber;
    }

    public double getSubtractionResult() {
        return this.firstNumber - this.secondNumber;
    }

    public double getMultiplicationResult() {
        return this.firstNumber * this.secondNumber;
    }

    public double getDivisionResult() {

        if(this.secondNumber == 0d) {
            return 0d;
        }

        return this.firstNumber / this.secondNumber;
    }
}