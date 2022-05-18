package crownhounds.learnjava;

/**
 * Please refer to ObjectOrientedProgramming class
 */
public class OOP_Encapsulation {
        /*
            ENCAPSULATION enables restricting access to certain components
                !READ: protect object instance members/class fields from external access for direct inappropriate update

            example:
                EnhancedPlayer demonstrates ENCAPSULATION by using private class fields and validation in constructor
                    unlike Player that uses public class fields and default constructor
         */

}

class Encapsulation_Player {

    // object instance members/class fields
    public String name;
    public int health;
    public String weapon;

    // default constructor that does NOT initialize the class fields on class instantiation
    // * will have to manually set public class fields/object instance attributes AFTER instantiation
    public Encapsulation_Player() {

    }

    // unique object behaviors/class methods
    public void loseHealth(int damage) {

        System.out.println("Player.loseHealth() was called");
        this.health -= damage;

        if(this.health <= 0) {
            System.out.println("Player knocked out");
            // reduce the number of lives remaining for the player
        }
    }

    // getter & setters
    public int getHealth() {
        return this.health;
    }
}

class Encapsulation_EnhancedPlayer {

    // object instance members/class fields
    private String name;
    private int health = 100; // define default health value
    private String weapon;

    // constructor that initializes the class fields on class instantiation
    public Encapsulation_EnhancedPlayer(String name, int health, String weapon) {

        this.name = name;

        if((health > 0) && (health <= 200)) {
            this.health = health;
        }
        this.weapon = weapon;
    }

    // unique object behaviors/class methods
    public void loseHealth(int damage) {

        System.out.println("Player.loseHealth() was called");
        this.health -= damage;

        if(this.health <= 0) {
            System.out.println("Player knocked out");
            // reduce the number of lives remaining for the player
        }
    }

    // getter & setters
    public int getHealth() {
        return this.health;
    }
}

class Encapsulation_Printer {

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
