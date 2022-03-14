package crownhounds.learnjava;

/**
 * ? ACCESS MODIFIER
 * public = unrestricted access modifier for other classes
 *      private = no access modifier for other classes
 *      protected = only accessible for classes in shared package
 *      no access modifier
 *
 * ? OBJECTS
 * * an object is a data structure that has STATE and BEHAVIOR
 *
 * ! class = an object 'blueprint' that can have accessible methods and member variables/fields
 *      class instances = implemented objects based on a shared blueprint
 *          ! encapsulation = limit outside accessibility of specific class fields and methods
 *              a class' member variables/fields are generally defined as private
 * *            the class object's public methods are BEHAVIORS strictly used to update the STATE of a class instance/model
 *                  SETTER & GETTER methods
 */

public class OOP_Car {

    // * Car Object's initial state
    private int doors;
    private int wheels;
    private String model;
    private String engine;
    private String color;

    // * Car Object's behavior: setters & getters for Car instance's state
    // ! do NOT use static since it is updating the state of an instance of a class object
    public void setModel(String model) {

        // input standardization & validation
        String validModel = model.toLowerCase();

        if(validModel.equals("porsche 911") || validModel.equals("ferrari enzo")) {
            // this = keyword to reference class/blueprint field
            this.model = model;
        }
    }

    // ! do NOT use static since it is updating the state of an instance of a class object
    // otherwise, you will not be able to use "this" keyword for field access

    public String getModel() {

        if(this.model == null) {
            System.out.println("\nclass object's member variable/field this.model not set\n".toUpperCase());
        }

        // this = keyword to reference class/blueprint field
        return this.model;
    }

}
