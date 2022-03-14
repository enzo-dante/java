package crownhounds.learnjava;

public class ObjectOrientedProgramming {

    public static void main(String[] args) {

        objectInstantiation();
        classConstructors();
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

    }
}

