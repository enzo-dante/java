package crownhounds.learnjava;

public class OOP_VipCustomer {

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
