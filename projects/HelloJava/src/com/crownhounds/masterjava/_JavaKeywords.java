package com.crownhounds.masterjava;

// imported PACKAGES
import com.crownhounds.oracle_exam.TestPackageKeyword;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

public class _JavaKeywords {

    // CONSTANTS

    // ENCAPSULATION private class fields

    public static void main(String[] args) {

        /*
            ! NAMING CONVENTIONS: standardizing names for variables, methods, & objects significantly improve readability & scalability
         */

//        PackageKeyword packageKeyword = new PackageKeyword();

//        ScopeKeyword scopeKeyword = new ScopeKeyword();

//        AccessModifiers accessModifiers = new AccessModifiers();

//        StaticStatement staticStatement = new StaticStatement();
//        int answer = staticStatement.multiply(6);
//        System.out.println("answer: " + answer);

//        FinalKeyword finalKeyword = new FinalKeyword();
    }
}

/**
 * ! NAMING CONVENTIONS: package use unique all-lowercase names with reversed internet-domain prefix
 *      package example: com.experts_exchange
 *      bc packages create a new namespace, class & interface name conflicts are avoided
 */
class PackageKeyword extends Notes {

    /*
        ? PACKAGES: bundled infrastructure code is automatically provided via imports that optimizes time & resources
            easily determine if classes are related with a package
            easy to find classes & interfaces that can provide the functions provided by the package
            classes within a package can have unrestricted access each other, but still have external access restrictions

        ? IMPORTED PACKAGES

            * you can import an entire package with '*'
            import java.awt.*;

            * you can import only what you need from a package
            import java.awt.event.WindowAdapter;
            import java.awt.event.WindowEvent;

         ? CREATE PACKAGES
            in IntelliJ under 'src' directory, right-click & select new package

            package statement defines which package the file class belongs to
            the directory structure has to ALSO match the component parts of the package name

                package com.example.packageKeyword;

            ! then import package for use

          ? CREATE JAR = exported package/library

            files can be grouped & imported into a jar file (package/library)
                resulting jar file can be imported into another project

            ! EXPORT JAR IntelliJ Steps:

                File Tab -> Project Structure dropdown -> Artifacts

                    Artifacts Plus button (+) -> JAR -> 'from modules with dependencies' button

                    Create JAR from Modules window -> 'extract to target JAR' selected -> OK

                        * to create an executable JAR file = specify main class

                    ! approve output directory for new JAR -> OK button

                    Build Tab -> Make Project button -> Build Artifacts -> Build

                        * to validate, new JAR file should be found in out/artifacts directory

            ! IMPORT JAR IntelliJ Steps:

                 File Tab -> Project Structure dropdown -> Libraries

                    Libraries Plus button (+) -> Java -> select JAR file in finder -> OK -> OK

                        * to validate, new JAR file should be found in External libraries
     */

    // CONSTANTS
    private static final String WINDOW_TITLE = "Complete Java";

    // OOP constructor that initializes class fields on class/object instantiation
    public PackageKeyword() {
        super("Packages");
        getNotes();
    }

    // ! INTERFACES: must implement publicly shared method signatures for assigned set of classes
    @Override
    public void getNotes() {

        MyWindow myWindow = new MyWindow(WINDOW_TITLE);
        myWindow.setVisible(true);

        Util.printSeparator("Creating packages");

        TestPackageKeyword.getName();

        Util.printSeparator();

        Monster monster = new Monster("Vampire Ben", 100, 50);
        Player p1 = new Player("Player 1", 100, 20, "sword");

        System.out.println(p1.getName() + " attacks " + monster.getName());

        Util.printSeparator();
    }

    // ! NON-STATIC INNER CLASSES: logically grouped subclass that needs a base class instance to execute functionality
    // ! OOP INHERITANCE: child subclass inherits class fields & public methods from extending parent super-class
    public class MyWindow extends Frame {

        // CONSTANTS
        private final String HEADER = "The Complete Java Developer Course";
        private final String BY_AUTHOR = "by Anonymous";

        // ENCAPSULATION private class fields

        @Override
        public void paint(Graphics g) {
            super.paint(g);
            Font sansSerifLarge = new Font("SansSerif", Font.BOLD, 18);
            Font sansSerifSmall = new Font("SansSerif", Font.BOLD, 12);
            g.setFont(sansSerifLarge);
            g.drawString(HEADER, 60, 60);
            g.setFont(sansSerifSmall);
            g.drawString(BY_AUTHOR, 60, 100);
        }

        // OOP constructor that initializes the class fields on class/object instantiation
        public MyWindow(String title) {
            // ! OOP INHERITANCE: child subclass inherits class fields & public methods from extending parent super-class
            super(title);
            setSize(500, 140);

            // ! ANONYMOUS INNER CLASS: no-name function that is only executed once for a specific purpose
            addWindowListener(new WindowAdapter() {
                // ! OOP POLYMORPHISM: use same-name methods but with different functionality per object via @Override
                // close app onCloseWindow
                @Override
                public void windowClosing(WindowEvent e) {
                    System.exit(0);
                }
            });
        }
    }

    // ! INTERFACE: defined publicly-shared method signatures, without implementation, for set of classes
    // ! OOP ENCAPSULATION: manage functionality via access modifiers
    private interface ISaveable {

        // shared methods signatures without implementation
        List<String> write();
        void read(List<String> savedValues);
    }

    // ! INTERFACE + OOP ENCAPSULATION: implementation of interface for this class
    private class Monster implements ISaveable {

        // OOP ENCAPSULATION private class fields
        private String name;
        private int hitPoints;
        private int strength;

        // OOP constructor that initializes class fields on class/object instantiation
        public Monster(String name, int hitPoints, int strength) {
            this.name = name;
            this.hitPoints = hitPoints;
            this.strength = strength;
        }

        // non-static unique behaviors/class methods
        // ! INTERFACE + OOP POLYMORPHISM: implementation of interface signatures that's unique to only this class via @Override
        @Override
        public List<String> write() {
            return null;
        }

        @Override
        public void read(List<String> savedValues) {

        }

        // getters & setters
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getHitPoints() {
            return hitPoints;
        }

        public void setHitPoints(int hitPoints) {
            this.hitPoints = hitPoints;
        }

        public int getStrength() {
            return strength;
        }

        public void setStrength(int strength) {
            this.strength = strength;
        }
    }

    // ! INTERFACE: define class that implements the interface & it's publicly-shared signatures
    // ! OOP ENCAPSULATION: manage functionality security with access modifiers
    private class Player implements ISaveable {

        // OOP ENCAPSULATION private class fields
        private String name;
        private int hitPoints;
        private int strength;
        private String weapon;

        // OOP constructor that initializes the class fields on class/object instantiation
        public Player(String name, int hitPoints, int strength, String weapon) {
            this.name = name;
            this.hitPoints = hitPoints;
            this.strength = strength;
            this.weapon = weapon;
        }

        // non-static unique behaviors/class methods
        // ! INTERFACE + OOP POLYMORPHISM: implementation of publicly-shared method signatures unique to this class via @Override
        @Override
        public List<String> write() {
            return null;
        }

        @Override
        public void read(List<String> savedValues) {

        }

        // getters & setters
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getHitPoints() {
            return hitPoints;
        }

        public void setHitPoints(int hitPoints) {
            this.hitPoints = hitPoints;
        }

        public int getStrength() {
            return strength;
        }

        public void setStrength(int strength) {
            this.strength = strength;
        }

        public String getWeapon() {
            return weapon;
        }

        public void setWeapon(String weapon) {
            this.weapon = weapon;
        }
    }

}

// ! OOP INHERITANCE: child subclass inherits class fields & public methods from extending parent super-class
class ScopeKeyword extends Notes {

    /*
        ? SCOPE: the visibility (and subsequently accessibility) of a class, member, or variable
     */

    // OOP ENCAPSULATION private class fields
    private String title;

    // OOP constructor that initializes the class fields on class/object instantiation
    public ScopeKeyword() {

        // ! OOP INHERITANCE: child subclass inherits class fields from extending parent super-class
        // default values
        super("Scope");
        getNotes();
    }

    // non-static (need instance) unique behavior/class methods
    // ! INTERFACE + OOP POLYMORPHISM: must implement all publicly-shared interface signatures via @Override
    @Override
    public void getNotes() {

        String privateVariable = "testing...one...two...one...two".toUpperCase();

        ScopeCheck scopeCheck = new ScopeCheck();

        System.out.println("int publicVariable in ScopeCheck class: " + scopeCheck.publicVariable);
        System.out.println("privateVariable in ScopeCheck class scope: " + scopeCheck.getPrivateVariable1());
        System.out.println("privateVariable in getNotes() scope: " + privateVariable);

        // ? SCOPE + OOP ENCAPSULATION: manage functionality security with access modifiers that limit scope
//        System.out.println(scopeCheck.privateVariable);

        Util.printSeparator();

        scopeCheck.timesTwo();

        Util.printSeparator();

        ScopeCheck.InnerClass scopeCheckInnerClass = scopeCheck.new InnerClass();

        scopeCheckInnerClass.timesTwo();

        Util.printSeparator();

        scopeCheckInnerClass.timesTwo(true);

        Util.printSeparator();

        scopeCheck.useInner();
    }
}

class ScopeCheck {

    // CONSTANTS
    private final String CLASS_NAME = getClass().getSimpleName();

    // class fields
    public int publicVariable = 0;
    private int privateVariable1 = 1;

    // OOP constructor that initializes class fields on class/object instantiation
    public ScopeCheck() {
        System.out.println("CONSTRUCTOR: publicVariable: " + publicVariable + "; privateVariable: " + privateVariable1);
    }

    // unique object behaviors/class methods
    public void timesTwo() {
        int privateVariable2 = 2;
        for(int i = 0; i < 10; i++) {
            System.out.println(i + "x2 = " + (i * privateVariable2));
        }

        System.out.println("method-level scope privateVariable2: " + privateVariable2);
        System.out.println("class-level scope this.privateVariable2: " + this.privateVariable1);
    }

    public void useInner() {
        InnerClass innerClass = new InnerClass();

        // ? SCOPE: visibility of innerClass scope does extend private fields to the outerClass with defined instance
        System.out.println("innerClass-scope private var3: " + innerClass.privateVariable3);
    }

    // getters & setters
    public int getPrivateVariable1() {
        System.out.println(CLASS_NAME + ".getPrivateVariable() was called");
        return privateVariable1;
    }

    // ! INNER CLASSES: logically grouped subclass that needs a base class instance to execute functionality
    public class InnerClass {

        // CONSTANTS
        private final String CLASS_NAME = getClass().getSimpleName();

        // ENCAPSULATION private class fields
        private int privateVariable3 = 3;

        // OOP constructor that initializes class fields on class/object instantiation
        public InnerClass() {
            System.out.println(CLASS_NAME + " was created;" +
                    "\nprivateVariable3: " + this.privateVariable3);
        }

        // non-static unique behavior/class methods
        public void timesTwo() {
            for(int i = 0; i < 10; i++) {
                System.out.println(i + "x innerClass.privateVariable(3) = " + (i* privateVariable3));
            }
        }

        // ! OVERLOADED METHOD: optimize codebase & readability by writing methods with same names/different params
        public void timesTwo(boolean inScopeCheckClass) {
            for(int i = 0; i < 10; i++) {
                System.out.println(i + "x ScopeCheck.privateVariable(1) = " + (i*ScopeCheck.this.privateVariable1));
            }
        }
    }
}

// ! OOP INHERITANCE: child subclass inherits class fields & methods from extending parent super-class
class AccessModifiers extends Notes {

    /*
        ? ACCESS MODIFIERS: access control at the class/interface/package top-level or method/variable member-level

           * TOP-LEVEL

            PUBLIC: object (classes, interfaces, or enums) visible everywhere

                you cannot have a private top-level object

            PACKAGE-PRIVATE: object only available within the default (not-specified) scope of its own package

                not including public or any access modifier sets object to default PACKAGE-PRIVATE

                class PackagePrivateClass {

                }

            * MEMBER-LEVEL

            PUBLIC: member (class field or method) visible everywhere

            PACKAGE-PRIVATE: object only available within the default scope of its own package

            PRIVATE: object visible only in declared class

            PROTECTED: object visible only in declared class & subclasses (even if in another package)
     */

    // CONSTANTS

    // OOP constructor that initializes class fields on class/object instantiation
    public AccessModifiers() {
        super("Access Modifier: PUBLIC & PRIVATE ");
        getNotes();
    }

    // ! INTERFACE: force implementation of publicly-shared signatures among a set of classes
    public void getNotes() {

        Account timAccount = new Account("Tim");
        timAccount.deposit(1000);
        timAccount.withdraw(500);

        timAccount.withdraw(-200);
        timAccount.deposit(-20);

        timAccount.calculateBalance();
        System.out.println("Account.getBalance(): " + timAccount.getBalance());

        Util.printSeparator();

        System.out.println("IAccessible.Account.getInterestRate(): " + timAccount.getInterestRate());

    }

    // ! INTERFACE: standardization via PUBLICLY-shared variables & method signatures that force a set of classes to implement
    // ? ACCESS MODIFIERS package-private: object only available within the default (not-specified) scope of its own package
    interface IAccessible {

        // ! INTERFACE: PUBLICLY-shared defined variables & method signatures
        int INTEREST_RATE = 100;
        boolean flagFraudulant();
    }

    // ? ACCESS MODIFIER PUBLIC: object (classes, interfaces, or enums) visible everywhere
    // ! INNER CLASSES: logically grouped subclass that needs a base class instance to execute functionality
    public class Account implements IAccessible {

        // CONSTANTS
        // ? ACCESS MODIFIER private: object visible only in declared class
        private static final String NEGATIVE_DEPOSIT_WARNING = "Cannot deposit negative sums";
        private static final String NEGATIVE_WITHDRAW_WARNING = "Cannot withdraw negative sums";
        private static final String CALCULATED_BALANCE = "Calculated balance: ";
        private static final String DEPOSITED_BALANCE = " deposited. Balance is now ";
        private static final String WITHDRAW_BALANCE = " withdraw. Balance is now ";

        // ? ACCESS MODIFIERS = ENCAPSULATION private class fields
        private String accountName;
        private Integer balance;

        // ! GENERICS: improve OOP ENCAPSULATION by creating classes, interfaces, & methods that only take specific dataType parameter
        private ArrayList<Integer> transactions;

        // OOP constructor that initializes the class fields on class/object instantiation
        public Account(String accountName) {

            this.accountName = accountName;

            // default values
            this.transactions = new ArrayList<Integer>();
            this.balance = 0;
        }

        // non-static unique behavior/class methods
        // ? ACCESS MODIFIER public: member (class field or method) visible everywhere
        public void deposit(int amount) {
            if(amount > 0) {
                this.transactions.add(amount);
                // ! AUTOBOXING: convert primitive dataType -> Wrapper Class dataType
                this.balance += amount;

                System.out.println(amount + DEPOSITED_BALANCE + this.balance);
            } else {
                System.out.println(NEGATIVE_DEPOSIT_WARNING);
            }
        }

        public void withdraw(int amount) {

            int withdrawal = -amount;

            if(withdrawal < 0) {
                this.transactions.add(withdrawal);
                this.balance += withdrawal;
                System.out.println(amount + WITHDRAW_BALANCE + this.balance);
            } else {
                System.out.println(NEGATIVE_WITHDRAW_WARNING);
            }
        }

        public void calculateBalance() {
            this.balance = 0;

            for(int i : this.transactions) {
                this.balance += i;
            }

            System.out.println(CALCULATED_BALANCE + this.balance);
        }

        // ! INTERFACE + POLYMORPHISM: must implement method signature with unique logic via @Override
        @Override
        public boolean flagFraudulant() {
            return false;
        }

        // getters & setters
        public Integer getInterestRate() {
            return INTEREST_RATE;
        }

        public String getAccountName() {
            return accountName;
        }

        public void setAccountName(String accountName) {
            this.accountName = accountName;
        }

        public int getBalance() {
            return balance;
        }

        public void setBalance(int balance) {
            this.balance = balance;
        }

        public ArrayList<Integer> getTransactions() {
            return transactions;
        }

        public void setTransactions(ArrayList<Integer> transactions) {
            this.transactions = transactions;
        }
    }
}

// ! ACCESS MODIFIER package-private + INHERITANCE: private & only visible within default (not specified) scope of this class
class StaticStatement extends Notes {

    /*
        ! STATIC FIELD: a single memory unique class-level shared variable belong to class blueprint and NOT with any specific instances
            only 1 unique version of a STATIC FIELD exists in memory at any time, which instance is used is inconsequential

        ! STATIC FIELD: memory-shared variable only requires class reference and without an instance

        ! STATIC INITIALIZATION BLOCKS: one-time on-initialization execution of 'static {}' and their assigned STATIC FINAL variables
     */

    // CONSTANTS
    private final String CLASS_NAME = getClass().getSimpleName();

    // ACCESS MODIFIERS + ENCAPSULATION private STATIC class fields
    public static int multiplier = 7;

    // OOP constructor that initializes class fields on class/object instantiation
    public StaticStatement() {
        // ! OOP INHERITANCE: child subclass inherits class fields & methods from extending parent super-class
        super("Static Statement");

        getNotes();
    }

    // ! INTERFACE: must implement all publicly-shared method signatures from interface
    // non-static unique behaviors/class methods
    public void getNotes() {

        StaticTest firstStaticTest = new StaticTest("First Static Test");
        System.out.println(firstStaticTest.getName() + "is instance number " + firstStaticTest.getNumInstances());

        StaticTest secondStaticTest = new StaticTest("Second Static Test");
        System.out.println(secondStaticTest.getName() + "is instance number " + secondStaticTest.getNumInstances());

        Util.printSeparator();

        StaticTest thirdStaticTest = new StaticTest("Third Static Test");

        // ? STATIC FIELD: only 1 unique version of a STATIC FIELD exists in memory at any time, which instance is used is inconsequential
        System.out.println(thirdStaticTest.getName() + "is secondStaticTest.getNumInstances(): " + secondStaticTest.getNumInstances());

        Util.printSeparator();

        // ? STATIC FIELD: memory-shared variable only requires class reference and without an instance
        System.out.println("StaticTest.numInstances(): " + StaticTest.numInstances);

        Util.printSeparator();

        // ? both STATIC INITIALIZATION BLOCKS - static {variables} - will be called before the class constructor & non-static methods
        System.out.println(CLASS_NAME + ".getNotes() was called");
        StaticInitializationBlocks staticInitializationBlocks = new StaticInitializationBlocks();
        staticInitializationBlocks.warning();

        System.out.println("static {} owner: " + staticInitializationBlocks.OWNER);
    }

    public int multiply(int n) {
        return n * multiplier;
    }

    // ! PACKAGE-PRIVATE + INNER CLASS: logically grouped object (only scope visible) that needs base instance to execute functionality
    class StaticTest {

        // ENCAPSULATION via ACCESS MODIFIERS private class fields
        // ! AUTOBOXING: converting primitive dataType -> Wrapper Class obj
        // ? STATIC FIELD: a unique class-level shared variable associated with class blueprint and NOT with any specific instances
        private static Integer numInstances = 0;
        private String name;

        // OOP constructor that initializes the class fields on class/object instantiation
        public StaticTest(String name) {
            this.name = name;
            numInstances++;
        }

        // OOP getters & setters
        public Integer getNumInstances() {
            return numInstances;
        }

        public void setNumInstances(Integer numInstances) {
            this.numInstances = numInstances;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    // ? STATIC INITIALIZATION BLOCKS are only executed ONCE on initialization
    class StaticInitializationBlocks {

        // CONSTANTS/static class variables assigned FINAL value at initialization
        private static final String OWNER;
        private static final String FIRST_STATIC_MSG;
        private static final String SECOND_STATIC_MSG;
        private final String CLASS_NAME = getClass().getSimpleName();

        // ENCAPSULATION: secure access-modifier private class fields
        private String constructorMsg;

        // ? STATIC INITIALIZATION BLOCKS: one-time on-initialization execution of 'static {}' and their assigned STATIC FINAL variables
        static {
            OWNER = "Tim";
            FIRST_STATIC_MSG = "STATIC INITIALIZATION BLOCKS: one-time on-initialization execution of 'static {}' and their assigned STATIC FINAL variables";
            System.out.println(FIRST_STATIC_MSG);
        }

        // OOP constructor that initializes the class fields on class/object instantiation
        public StaticInitializationBlocks() {
            this.constructorMsg = CLASS_NAME + "() constructor was also called";
            System.out.println(this.constructorMsg);
        }

        static {
            SECOND_STATIC_MSG = "onInitialization 2nd static {} was called";
            System.out.println(SECOND_STATIC_MSG);
        }

        // non-static unique behaviors/class methods
        public void warning() {
            System.out.println(CLASS_NAME + ".warning() was called");
        }

    }
}

// ! OOP INHERITANCE: child subclass inherits class fields from extending parent super-class
class FinalKeyword extends Notes {
    /*
        ? FINAL: variables that can only be modified once & before the class constructor compiles
            final fields are NOT constants

        ? using FINAL, each class instance will maintain its own value

        ? STATIC FINAL: once initial value (often a constant) of a 'final' variable has been set, cannot be changed
            if value is CONSTANT and a unique copy is NOT required for each class instance

        ? final CLASS with a private constructor cannot be instantiated or extended as a subclass
            functionality can only be executed in a static context

        ? making some methods FINAL to PREVENT methods from being @Overridden via OOP POLYMORPHISM + INHERITANCE
     */

    // CONSTANTS/static class variables

    // ACCESS-MODIFIER + ENCAPSULATION: private class fields

    // OOP constructor that initializes the class fields on class/object instantiation
    public FinalKeyword() {
        // ! OOP INHERITANCE: child subclass inherits class fields from extending parent super-class
        super("Final Keyword");

        getNotes();
    }

    // non-static unique behavior/class methods

    // ! INTERFACE + OOP POLYMORPHISM: uniquely implement all publicly-shared method signatures assigned to a standardized set of classes via @Override
    @Override
    public void getNotes() {

        Identification one = new Identification("ID One");
        Identification two = new Identification("ID Two");
        Identification three = new Identification("ID Three");

        System.out.println("instanceNum: " + one.getInstanceNumber());
        System.out.println("instanceNum: " + two.getInstanceNumber());
        System.out.println("instanceNum: " + three.getInstanceNumber());

        Util.printSeparator();

        System.out.println("static final -> " + Math.PI);

        Util.printSeparator();

        int pw = 674312;
        Password password = new Password(pw);

        System.out.println("Non-final unencrypted pw:\n" + pw);
        password.storePassword();

        Util.printSeparator();

        password.letMeIn(1);
        password.letMeIn(674312);

        Util.printSeparator();

        ExtendedPassword extendedPassword = new ExtendedPassword(pw);
        extendedPassword.letMeIn(1);
        extendedPassword.letMeIn(674312);

    }

    // ! INNER CLASS + OOP COMPOSITION: logically grouped components within a parent object
    // ! ACCESS MODIFIER package-private: only-privately visible within the scope of this class in this package
    class Identification {

        // CONSTANTS/static class variables
        private static int classCounter = 0;
        private static final String CREATED = " created, instance number: ";

        // ACCESS-MODIFIER + ENCAPSULATION: private class fields
        // ? FINAL: variables that can only be modified once & before the class constructor compiles
        private final String name;
        public final int instanceNumber;

        // OOP constructor that initializes class fields on class/object instantiation
        public Identification(String name) {
            this.name = name;

            // default values
            // ? FINAL: variables that can only be modified once & before the class constructor compiles
            classCounter++;
            instanceNumber = classCounter;

            System.out.println(this.name + CREATED + this.instanceNumber);
        }

        // getters & setters
        // ? making some methods FINAL to PREVENT methods from being @Overridden via OOP POLYMORPHISM + INHERITANCE
        public final int getInstanceNumber() {
            return instanceNumber;
        }
    }

    // ! INNER CLASS + OOP COMPOSITION: logically grouped components within a parent object
    // ! ACCESS MODIFIER package-private: only privately visible within scope of this class in this package
    class Password {

        // CONSTANTS/static class variables
        // ? STATIC FINAL: once initial value (often a constant) of a 'final' variable has been set, cannot be changed
        private static final String WELCOME = "Welcome:".toUpperCase() +
                "\n\tprovided correct unencrypted password!";
        private static final String INVALID_PW = "Invalid Unencrypted Password:".toUpperCase() +
                "\n\thash pw does NOT match final instance-unique encrypted pw";
        private static final String SAVING_PW = "Final instance-unique encrypted saved password:\n";
        private static final String PROVIDED_PW = "\nPROVIDED PW: ".toLowerCase();

        // ACCESS-MODIFIER ENCAPSULATION: private class fields
        private static final int key = 748576362;
        private final int encryptedPassword;

        // OOP constructor that initializes class fields on class/object instantiation
        public Password(int password) {
            this.encryptedPassword = encryptDecrypt(password);
        }

        // non-static unique behavior/class methods
        private int encryptDecrypt(int password) {
            // XOR the values: check bits & return 1 in any position where there is a 1 in any value
            return password ^ key;
        }

        public void storePassword() {
            System.out.println(SAVING_PW + this.encryptedPassword);
        }

        public boolean letMeIn(int password) {

            System.out.println(PROVIDED_PW + password);

            if(this.encryptedPassword == encryptDecrypt(password)) {
                System.out.println(WELCOME);
                return true;
            }

            // implied else-statement
            System.out.println(INVALID_PW);
            return false;
        }
    }

    // ! INNER CLASS + OOP COMPOSITION: logically grouped component within a parent class
    // ! OOP INHERITANCE: child subclass inherits class fields & methods from extending parent super class
    class ExtendedPassword extends Password {

        // CONSTANTS/static class variables that have FINAL initial value set
        private static final String SAVING_DECRYPTED = "Saving password: ";
        private static final String EXTENDED_PW = "Extended Password";

        // ENCAPSULATION: access modifier private class fields
        private int decryptedPassword;

        // OOP constructor that initializes the class fields on class/object instantiation
        public ExtendedPassword(int password) {
            // ! OOP INHERITANCE: child subclass inherits class fields & methods from extending parent super class
            super(password);
            this.decryptedPassword = password;

            System.out.println(EXTENDED_PW);
        }

        // ! OOP POLYMORPHISM + INHERITANCE: @Override with unique functionality for same-name method per class
        @Override
        public void storePassword() {
            System.out.println(SAVING_DECRYPTED + this.decryptedPassword);
        }
    }
}