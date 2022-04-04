package crownhounds.learnjava;

public class Encapsulation_Printer {

    // !ENCAPSULATION: protect object instance members/class fields from external access for direct inappropriate update

    // class fields/object instance members
    // * ENCAPSULATION: use 'private' keyword to limit access & set default values
    private int tonerLevel;
    private int numPagesPrinted;
    private boolean isDuplexPrinter;

    // * ENCAPSULATION: use constructor that has parameter validation to initialize fields on class instantiation
    public Encapsulation_Printer(int tonerLevel, boolean isDuplexPrinter) {
        if(tonerLevel >= 0 && tonerLevel <= 100) {
            this.tonerLevel = tonerLevel;
        } else {
            this.tonerLevel = -1;
        }
        this.isDuplexPrinter = isDuplexPrinter;
        this.numPagesPrinted = 0;
    }

    // unique object behaviors/class non-static methods
    public int printPages(int pages) {

        // duplex mode means divide by 2 that handles odd numbers
        if(this.isDuplexPrinter) {
            pages = (pages / 2) + (pages % 2);
            System.out.println("printing in duplex mode:" + isDuplexPrinter());
        }

        this.numPagesPrinted += pages;
        return pages;
    }

    // * ENCAPSULATION: getters & setters will limit accessibility
    public int getTonerLevel() {
        System.out.println("Printer.getTonerLevel() was called");
        return this.tonerLevel;
    }

    public int setTonerLevel(int tonerLevel) {
        System.out.println("Printer.setTonerLevel() was called");
        if(tonerLevel > 0 && (tonerLevel + this.tonerLevel) < 100) {
            this.tonerLevel += tonerLevel;
            return this.tonerLevel;
        } else {
            return -1;
        }
    }

    public boolean isDuplexPrinter() {
        System.out.println("Printer.isDuplexPrinter() was called");
        return this.isDuplexPrinter;
    }

    public int getNumPagesPrinted() {
        return numPagesPrinted;
    }
}
