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
