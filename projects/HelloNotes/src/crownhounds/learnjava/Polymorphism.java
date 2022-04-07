package crownhounds.learnjava;

// ! POLYMORPHISM with INHERITANCE
public class Polymorphism {
       /*
            POLYMORPHISM is the mechanism in OOP that enables methods
                to function differently based on the type of object that is executing the method
        */
}

class Movie {

    // private class fields/object instance members
    private String name;

    // constructor that initializes the class fields on class instantiation
    public Movie(String name) {
        this.name = name;
    }

    // unique behaviors/class methods
    public String getPlot() {
        return "no plot here";
    }

    // getters & setters
    public String getName() {
        return this.name;
    }
}

class Jaws extends Movie {

    // constructor that initializes the class fields on class instantiation
    //      using 'super' to inherit from base class Movie
    public Jaws() {
        super("Jaws");
    }

    // OVERLOAD method for unique behaviors/class methods
    public String getPlot() {
        return "A shark eats lots of people";
    }
}

class IndependenceDay extends Movie {

    // constructor that initializes the class fields on class instantiation
    //      using 'super' to inherit from base class Movie
    public IndependenceDay() {
        super("Independence Day");
    }

    // OVERLOAD method for unique behaviors/class methods
    public String getPlot() {
        return "Aliens attempt to take over planet earth";
    }
}

class MazeRunner extends Movie {

    // constructor that initializes the class fields on class instantiation
    //      using 'super' to inherit from base class Movie
    public MazeRunner() {
        super("Maze Runner");
    }

    @Override
    public String getPlot() {
        return "Kids try and escape a maze";
    }
}

class StarWars extends Movie {

    // constructor that initializes the class fields on class instantiation
    //      using 'super' to inherit from base class Movie
    public StarWars() {
        super("Star Wars");
    }

    @Override
    public String getPlot() {
        return "Imperial forces try to take over the universe";
    }
}

class ForgettableMovie extends Movie {

    // constructor that initializes the class fields on class instantiation
    //      using 'super' to inherit from base class Movie
    public ForgettableMovie() {
        super("Forgettable Movie");
    }

    // ! NO getPlot() method to demonstrate polymorphism
}

class Polymorphism_Car {

    // object instance members/class fields
    private int cylinders;
    private boolean engine;
    private String name;
    private int wheels;

    // constructor that initializes the object instance members/class fields on object/class instantiation
    // set default certain fields to default values by not passing as parameters
    public Polymorphism_Car(int cylinders, String name) {

        this.cylinders = cylinders;
        this.name = name;

        // default values
        this.engine = true;
        this.wheels = 4;
    }

    // unique non-static class methods/object behaviors
    public String startEngine() {
        return "Car.startEngine() was called";
    }

    public String accelerate() {
        return "Car.accelerate() was called";
    }

    public String brake() {
        return "Car.brake() was called";
    }

    // getters & setters
    public int getCylinders() {
        return cylinders;
    }

    public void setCylinders(int cylinders) {
        this.cylinders = cylinders;
    }

    public boolean isEngine() {
        return engine;
    }

    public void setEngine(boolean engine) {
        this.engine = engine;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWheels() {
        return wheels;
    }

    public void setWheels(int wheels) {
        this.wheels = wheels;
    }
}

class Polymorphism_Ferrari extends Polymorphism_Car {

    // constructor that initializes the object instance members/class fields on object/class instantiation
    public Polymorphism_Ferrari() {

        // use 'super' keyword to inherit Car class fields
       super(4, "Ferrari Enzo");
    }

    /*
        * use @Override to demonstrate POLYMORPHISM

        POLYMORPHISM is the mechanism in OOP that enables methods with same name
            to function differently
            based on the type of object that is executing the method
     */

    @Override
    public String startEngine() {
        return "Ferrari.startEngine() was called";
    }

    @Override
    public String accelerate() {
        return "Ferrari.accelerate() was called";
    }

    @Override
    public String brake() {
        return "Ferrari.brake() was called";
    }
}

class Polymorphism_Ford extends Polymorphism_Car {

    // constructor that initializes the object instance members/class fields on object/class instantiation
    public Polymorphism_Ford() {

        // use 'super' keyword to inherit Car class fields
        super(4, "Ford Bronco");
    }

    /*
        * use @Override to demonstrate POLYMORPHISM

        POLYMORPHISM is the mechanism in OOP that enables methods with same name
            to function differently
            based on the type of object that is executing the method
     */

    @Override
    public String startEngine() {
        return "Ford.startEngine() was called";
    }

    @Override
    public String accelerate() {
        return "Ford.accelerate() was called";
    }

    @Override
    public String brake() {
        return "Ford.brake() was called";
    }
}

class Polymorphism_Porsche extends Polymorphism_Car {

    // constructor that initializes the object instance members/class fields on object/class instantiation
    public Polymorphism_Porsche() {

        // use 'super' keyword to inherit Car class fields
        super(4, "Porsche 911");
    }

    /*
        * use @Override to demonstrate POLYMORPHISM

        POLYMORPHISM is the mechanism in OOP that enables methods with same name
            to function differently
            based on the type of object that is executing the method
     */

    @Override
    public String startEngine() {
        return getClass().getSimpleName() + ".startEngine() was called";
    }

    @Override
    public String accelerate() {
        return getClass().getSimpleName() + ".accelerate() was called";
    }

    @Override
    public String brake() {
        return getClass().getSimpleName() +".brake() was called";
    }
}

