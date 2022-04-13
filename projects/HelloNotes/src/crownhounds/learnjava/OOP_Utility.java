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
public class OOP_Utility {

}

class OOP_BankAccount {

    private static final String INVALID_INPUT = "Invalid input";
    private static final String INSUFFICIENT_FUNDS = "Insufficient funds";

    // Private class fields
    private double accountNumber;
    private double balance;
    private String customerName;
    private String email;
    private String phoneNumber;

    // * OOP_BankAccount constructor #1
    // class constructor that can be manually called at the beginning to set fields when creating an instance of a class
    // when defining an instance of class, they are automatically called
    public OOP_BankAccount() {

        // if using the original manual constructor method, use 'this()' as the FIRST statement to define default field values
        this(12345, 130, "default name", "default email", "default number");
        System.out.println("\nclass constructor that can be manually called at the beginning to set fields when creating an instance of a class\n");
    }

    // * OOP_BankAccount constructor #2
    // overloaded class constructor method by changing number of parameters
    public OOP_BankAccount(double accountNumber, double balance, String customerName, String email, String phoneNumber) {

        // ! DON'T CALL SETTERS IN CONSTRUCTORS
        // due to inheritance issue, it's better to save the parameter value directly to the field
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.customerName = customerName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    // * OOP_BankAccount constructor #3

    // public getters & setters methods that are NOT static because they are shared by class instances
    public double getAccountNumber() {
        return this.accountNumber;
    }

    public double getBalance() {
        return this.balance;
    }

    public String getCustomerName() {
        return this.customerName;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setAccountNumber(double accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void depositFunds(double amount) {

        if(amount > 0) {
            this.balance += amount;
            System.out.println("current balance: " + this.balance);
        } else {
            System.out.println(INVALID_INPUT);
        }
    }

    public double withdrawFunds(double amount) {

        if(this.balance - amount > 0) {
            this.balance -= amount;
            System.out.println("remaining balance: " + this.balance);
            return amount;
        } else {
            System.out.println(INSUFFICIENT_FUNDS);
            return -1d;
        }
    }
}

class OOP_Car {

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

class OOP_Person {

    /*
        private initial state of Object's member variables/fields
     */
    private String firstName;
    private String lastName;
    private int age;

    // Object method's that are NOT static since they are shared by instances
    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public int getAge() {
        return this.age;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(int age) {
        if(age < 0 || age > 100) {
            this.age = 0;
        } else {
            this.age = age;
        }
    }

    public boolean isTeen() {

        if(this.age > 12 && this.age < 20) {

            return true;

        }

        return false;
    }

    public String getFullName() {

        if(this.firstName.isEmpty() && this.lastName.isEmpty()) {

            return "";

        } else if(this.firstName.isEmpty()) {

            return this.lastName;

        } else if(this.lastName.isEmpty()) {

            return this.firstName;

        }

        return this.firstName + " " + this.lastName;
    }


}

class OOP_VipCustomer {

    // class instance members/fields
    private String name;
    private Long creditLimit;
    private String emailAddress;

    // constructors to initialize fields on class instantiation
    // constructor methods can be overloaded like other methods

    // 1st: empty constructor should call the constructor with 3 params with default values
    public OOP_VipCustomer() {
        this("Enzo", 100000L, "enzo@gmail.com");
    }

    // 2nd: constructor should pass on the 2 values it receives and add a default value for the 3rd
    public OOP_VipCustomer(String name, Long creditLimit) {
        this(name, creditLimit, "unknown@gmail.com");
    }

    // 3rd: constructor should save all fields
    public OOP_VipCustomer(String name, Long creditLimit, String emailAddress) {
        this.name = name;
        this.creditLimit = creditLimit;
        this.emailAddress = emailAddress;
    }

    public String getName() {
        return name;
    }

    public Long getCreditLimit() {
        return creditLimit;
    }

    public String getEmailAddress() {
        return emailAddress;
    }
}

class OOP_Wall {

    private double width;
    private double height;

    // constructors that will initialize the fields on class/object instantiation
    // default constructor
    public OOP_Wall() {

    }

    // overloaded constructor
    public OOP_Wall(double width, double height) {

        if(width < 0) {

            width = 0;

        }

        if(height < 0) {

            height = 0;
        }

        this.width = width;
        this.height = height;

    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {

        if(width < 0) {

            width = 0;

        }

        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {

        if(height < 0) {

            height = 0;

        }

        this.height = height;
    }

    public double getArea() {
//        return this.width * this.height;
        return getWidth() * getHeight();
    }
}

class OOP_SimpleCalculator {

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