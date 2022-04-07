package crownhounds.learnjava;

public class ObjectOrientedProgramming {

    public static void main(String[] args) {

//        objectInstantiation();
//        classConstructors();
//        inheritance();
//        composition();
//        encapsulation();
        polymorphism();
    }

    private static void objectInstantiation() {
        /*
            * create a class object/blueprint
                decide how member variables/fields & methods are accessible

            * instantiate 3 new instances of the OOP_Car class/blueprint
                ! new = each instance will be initialized with it's own unique place in memory
         */

        OOP_Car porsche = new OOP_Car();
        OOP_Car ferrari = new OOP_Car();
        OOP_Car ford = new OOP_Car();

        /*
            * call class' updating BEHAVIOR with each instance to update it's state & differentiate it
                ! SETTERS & GETTERS = class' updating behavior
         */
        porsche.setModel("Porsche 911");
        System.out.println("Car Object porsche instance's model: \n" + porsche.getModel());

        ferrari.setModel("Ferrari Enzo");
        System.out.println("Car Object ferrari instance's model: \n" + ferrari.getModel());

        // ! due to Car Object's setter's input validation, cannot update state for ford instance
        ford.setModel("bronco");
        System.out.println("Car Object ford instance's model: \n" + ford.getModel());

    }

    private static void classConstructors() {
        /*
            a constructor enables you to set class fields when initializing an instance of class
                instead of setting the fields one by one with a field setter method

            it's not uncommon to use multiple constructors in a class
                One constructor handles all field initialization
                the other constructor should just call the other major constructor
         */

        // the instance is using the overload constructor method to set fields on class instantiation
        OOP_BankAccount bankAccount = new OOP_BankAccount(12345, 500,
                "Enzo", "test@gmail.com", "123-456-1789");

        System.out.println(bankAccount.getCustomerName());
        System.out.println(bankAccount.getBalance());
    }

    private static void inheritance() {
        /*
            OOP inheritance refers to how child classes can inherit state and behavior from parent classes
                All classes uses inheritance in Java by extending the Java Object class

            0. define parent and child classes
            1. to specify inheritance between classes in Java, use 'extends' keyword in class definition
            2. child class uses 'super' keyword in it's constructor to call parent class constructor to inherit fields

            ex:

                public class Dog extends Animal {

                    public Dog(String name, int brain, int body, int size, int weight) {
                        super(name, brain, body, size, weight);
                    }

                }
         */

        Inheritance_Animal animal = new Inheritance_Animal("animal", 1, 1, 5, 10);

        Inheritance_Dog dog = new Inheritance_Dog("terrier", 2, 2, 2, 4, 1, 20, "rough");

        // even though .eat() was defined in Inheritance_Animal class, Inheritance_Dog has inherited that method since it's a child extension class
//        dog.eat();

        // given 'super' keyword in Dog.walk(), calling Animal.move() was NOT using @Overriding method functionality from Dog class
            // which is why Dog.moveLegs() was called
//        dog.walk();

        // given @Overriding method functionality from Dog class, Animal.move() was overridden
//        dog.run();

        Inheritance_Fish fish = new Inheritance_Fish("goldfish", 1, 1, 10, 2, 4);

        fish.swim(5);

    }

    private static void composition() {
        /*
            Composition refers to an Object 'having' components or mini-Objects that make up the larger Object

            ex: A Computer has a motherboard, a monitor, and a case
                each component (motherboard, monitor, and case are their classes/objects)
         */

        Composition_Dimensions dimensions = new Composition_Dimensions(20, 20, 5);
        Composition_Case computerCase = new Composition_Case("220B", "Dell", "240", dimensions);

        // can define one-time variables/objects in the definition of another object with 'new' keyword
        // *example: new Composition_Resolution(2540, 1440)
        Composition_Monitor monitor = new Composition_Monitor("27 inch Beast", "Acer", 27, new Composition_Resolution(2540, 1440));

        Composition_Motherboard motherboard = new Composition_Motherboard("BJ-200", "Asus", 4, 6, "v2.44");

        // construct PC object that has object components, demonstrating COMPOSITION
        Composition_PC pc = new Composition_PC(computerCase, monitor, motherboard);

        // ! if public, call Monitor.drawPixelAt() from the PC object using COMPOSITION to get monitor instance
//        pc.getTheMonitor().drawPixelAt(1500, 1200, "red");

        // ! if public, call Motherboard.loadProgram() from the PC object using COMPOSITION to get motherboard instance
//        pc.getTheMotherboard().loadProgram("Windows 1.0");

        // ! if public, call Case.pressPowerButton() from the PC object using COMPOSITION to get case instance
//        pc.getTheCase().pressPowerButton();

        // internally access PC getters to use COMPOSITION to utilize pc instance methods
        pc.powerUp();
    }

    private static void encapsulation() {
        /*
            ENCAPSULATION enables restricting access to certain components
                !READ: protect object instance members/class fields from external access for direct inappropriate update

            example:
                EnhancedPlayer demonstrates ENCAPSULATION by using private class fields and validation in constructor
                    unlike Player that uses public class fields and default constructor
         */

        Encapsulation_Player player = new Encapsulation_Player();

        // can manually set public class fields/object instance attributes
        player.name = "Tim";
        player.health = 20;
        player.weapon = "sword";

        int damage = 10;
        player.loseHealth(damage);
        System.out.println("Player.getHealth(): " + player.getHealth());

        damage = 11;
        player.loseHealth(damage);
        System.out.println("Player.getHealth(): " + player.getHealth());

        // !READ: protect object instance members/class fields from external access for direct inappropriate update
        player.health = 200;
        System.out.println("INAPPROPRIATE Player.health: " + player.health);

        System.out.println("\n---\n");

        Encapsulation_EnhancedPlayer enhancedPlayer = new Encapsulation_EnhancedPlayer("Dante", 50, "Axe");
        System.out.println("Initial EnhancedPlayer.getHealth(): " + enhancedPlayer.getHealth());

        Encapsulation_EnhancedPlayer badEnhancedPlayer = new Encapsulation_EnhancedPlayer("Steve", 250, "Gun");
        System.out.println("BAD Initial EnhancedPlayer.getHealth(): " + badEnhancedPlayer.getHealth());
    }

    private static void polymorphism() {
       /*
            POLYMORPHISM is the mechanism in OOP that enables methods
                to function differently based on the type of object that is executing the method
        */

        for(int i = 1; i < 11; i++) {

            Movie movie = getRandomMovie();

            // ! assigning different method functionality depending on the type of object we created, even though we inherited from same base class
            // * given that ForgettableMovie does NOT have a getPlot(), it inherits the getPlot() from the extended Movie class
            System.out.println("Movie #" + i + ": " + movie.getName() +
                    "\nPlot: " + movie.getPlot() + "\n");
        }
    }

    /**
     * Get a random movie
     * @return Movie
     */
    public static Movie getRandomMovie() {

        // cast return of 1-5 range from module as an int from default double
        // Math.random() returns number from 0-1
        int randomNumber = (int) (Math.random() * 5 ) + 1;
        System.out.println("randomNumber: " + randomNumber);

        // get Movie based on randomNumber using a switch
        // no need for break since returning Movie object
        switch(randomNumber) {
            case 1:
                return new Jaws();
            case 2:
                return new IndependenceDay();
            case 3:
                return new MazeRunner();
            case 4:
                return new StarWars();
            case 5:
                return new ForgettableMovie();
            default:
                return null;
        }
    }
}
