package crownhounds.learnjava;

public class OOP_BankAccount {

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
