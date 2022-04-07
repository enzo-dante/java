package crownhounds.learnjava;

public class Encapsulation_Player {

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
