package com.crownhounds.masterjava;

import org.junit.jupiter.api.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;

public class Testing {
    /*
       ! Test Driven Development (TDD)
            writing code that tests your other code to ensure a level of performance quality when your app is in production.
            TDD makes refactoring and collaboration safer and bug-free

            * 1. development BEGINS by writing RED failing tests

            * 2. once tests are written, write the MINIMUM amount of GREEN code necessary to make tests pass

            * 3. refactor = clean up the code, while ensuring that tests still pass

            * 4. once tests pass, a feature is considered complete

       ! TDD STEPS

         ? JUnit TESTING step 1A: update project structure JUnit library dependency to compile
            File -> project structure -> Modules -> Dependencies Tab ->
                Export window -> Junit ->
                    open dropdown -> change "Test" to "Compile" -> Ok

        ? JUnit TESTING step 2.1: define class, method signatures, & test suite

        ? JUnit TESTING step 2.2: create JUnit Test class & generate methods to test in root
            ! click yellow light bulb onHover over independent class name
            ! FIX if IDE is unable to identify built-in JUnit Test class
            ! select specific methods to test

        ? JUnit TESTING step 1B: add JUnit Library
            ! right-click add "JUnit" to class path
            ! select "Use JUnit from IntelliJ IDEA distribution"
            ! click Ok

        ? JUnit TESTING step 3: BEFORE running, add fail(NOT_IMPLEMENTED) to each Test class method stub

        ? JUnit TESTING step 4: run expected failing tests suite

        ? JUnit TESTING step 5: review run configuration for all tests
            want to test class in application, NOT the application itself

            ! right-click outside created Test class & select run Test class
            ! right-click outside created Test class & select modify run configuration
            ! review configurations & click Ok
            ! review right-corner dropdown is respective Test suite

        ? JUnit TESTING step 6: setup tests objects run before & after teardown every test run
            ! @BeforeAll: STATIC execute only once before all test suit is run
                example: read data from db for tests

            ! @AfterAll: STATIC execute only once after all test suit is run

            ! @BeforeEach: execute code in setup() before each test is run

            ! @AfterEach: execute code in setup() after each test is run

        ? JUnit TESTING step 7: write test method assertions that test against class functionality
            in testSuite, click on green arrow/red x in gutter next to specific method to test

            review only passing or only failing tests with toggle in top-left of Test window

            ? JUnit TRY-CATCH: handle expected exceptions handing modify @Test annotation

                try {
                    double balance = checkingsAccount.withdraw(600.00, false);
                    assertEquals(400.00, balance, 0);
                } catch(IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }

            * BEST PRACTICE:
                write easily understood test method names

                    getBalance_deposit()
                    getBalance_withdraw()

                write on 1 independent assertion for 1 independent test
                setup any independent class instances that can be reused (without cross-pollination) on each test method

            ! assertEquals(expectedValue, actualTestValue);
            ! assertNotEquals(expectedValue, actualTestValue);

            ! assertTrue(actualTestValue, failMsg);
            ! assertFalse(actualTestValue, failMsg);

            ! assertArrayEquals(expectedArray, actualTestArray);
                consider two arrays equal if length & every element in order identical

            ! assertNull(actualTestValue);
            ! assertNotNull(actualTestValue);
                easy-to-read check for null values

            ! assertSame(expectedValue, actualTestValue);
            ! assertNotSame(expectedValue, actualTestValue);
                compares object references,
                    unlike assertEquals that checks if instances are the same

            ! assertThat(expectedValue, actualTestValue);
                compare the actual value against a matcher range of values

        ? JUnit TESTING step 5: write method implementation in file

        ? JUnit TESTING step 6: individually run implemented functions until all failing tests resolved in test suite
     */

    public static void main(String[] args) {

        // ! DEBUGGING: setting BREAKPOINTS & FIELD WATCHPOINTS to monitor, manipulate, & manage app state
//        Debugging debugging = new Debugging();

        JUnitTesting jUnitTesting = new JUnitTesting("Eunice", "Iger", 1202.44, 1);
    }
}

// ! OOP INHERITANCE: child subclass inherits class fields & methods from extending parent super-class
class Debugging extends Notes {
        /*
            ? DEBUGGER: examine state & manage what values were passed into a method & what values returned from a method
                essential when developers don't have access to third-party source code
                    download library JAR and source code JAR
                        save: File -> Project Structure -> Libraries -> Plus Sign (+) -> select locations for both

                prod apps usually don't have debug info bc apps run slower due to extra processing required
                    * due to slower compilation, THREADING issues masked & are harder to resolve via a debugger

            ! DEBUGGING: setting BREAKPOINTS & FIELD WATCHPOINTS to monitor, manipulate, & manage app state

            ? DEBUGGING step 1: set a pre-line suspending red breakpoint(s) on the FIRST/target line in problematic method by clicking in left-gutter

                ! BREAKPOINT (red dot): suspend app up-to but before line is executed

                ! FIELD WATCHPOINTS (red-dash dot): identify code for unexpected update to an instance field variable's value by suspending onUpdate
                    alternative:
                        Run -> View Breakpoints -> Plus Icon (+) -> Java Field Watchpoints -> select Class, Instance field
                        right-click on already added FIELD WATCHPOINT -> select more

                    * Field Modification (default): suspend app EVERYTIME a FIELD WATCHPOINT is updated/modified

                    Field Access: suspend when a field watchpoint is simply used
                    remove

                    Remove Once Hit: on 1st field access, suspend app, than remove FIELD WATCHPOINT on app resume

            ? DEBUGGING step 2: run debugger by selecting debugging icon in top-right corner of the app window (ladybug) to open Debugger
                alternative: right click on main scope and select "Debug" or Ctrl-Shift-D mac shortcut

                * Variables Window: current values of the parameters passed to this method
                    the variables themselves can be expanded via dropdowns

                    ! SET VALUE: select & set variable on the fly in debugger to test app on resume
                        right-click on variable in Debugger -> Variables window
                        select "resume program" button


                * Watches Window: isolate & monitor tagged instance variables (aviator glasses icon) during debugging process
                        tag instance variables: right-click on term in Variables window and select 'Add to Watches'

                * Frames Window: execution stack trace, with dropdown for ALL THREADS & their respective states

            ? DEBUGGING step 3: use debug buttons to review & identify issue

                ! SHOW EXECUTION POINT button: return to current execution line in Debugger
                    suspended before current execution line highlighted in non-red background

                ! STEP OVER button: advance the execution point by one statement without in-statement method details
                    don't care about what happening in a method(s) in statement

                ! STEP INTO button: step into non-JDK methods called by the next statement for their details & suspend before line execution
                    care to see what is happening inside a method(s) in statement

                    * SMART STEP INTO: on statement with nested methods, select which method to step into for suspended execution details
                        Run -> Debugging Actions -> Smart Step Into -> arrow-key select method

                ! FORCE STEP INTO button: force step into ALL methods (including JDK) called by the next statement for their details & suspend before line execution

                ! STEP OUT button: debugger will run the rest of the method, return to the caller execution line, & suspend before line execution

                ! DROP FRAME button: rewind the application by 1 frame
                    app suspended before the highlighted line of code is executed

                    only local variables will be reverted;
                        good for experimenting for branching code paths

                    no update for: network traffic, database changes, & static & instance variables

                ! RUN TO CURSOR button: run the application up to the current cursor location & suspend before the execution line

            ? JAVA DEBUGGING step 4: resume program to next breakpoint OR remove breakpoints & resume program in debugger
                ! VIEW BREAKPOINTS button: view all breakpoints to remove/review a breakpoint: select red breakpoint in the left-gutter or deselect in view breakpoint window
                    alternative: Run window -> View Breakpoints

                ! RESUME PROGRAM button: run the application to completion or up to next red breakpoint
         */


    // CONSTANTS/static class variables assigned FINAL value before compilation/instantiation
    private static final String DEBUGGING = "Debugging";

    // OOP constructor that initializes the class fields on class/object instantiation
    public Debugging() {
    // ! OOP INHERITANCE: child subclass inherits class fields & methods from extending parent super-class
        super(DEBUGGING);
        getNotes();
    }

    // ! INTERFACE: uniquely implement all publicly-shared signatures for set of classes via @Override
    @Override
    public void getNotes() {
        StringUtilities utils = new StringUtilities();
        utils.buildString();

        Util.printSeparator();

        String str = "abcdefg";

        // ? DEBUGGING step 1: set a pre-line suspending red breakpoint to target line in left-gutter
        String result = utils.upperAndPrefix(utils.addSuffix(str));
        // ? DEBUGGING step 2: run debugger
        /*
            ? DEBUGGING step 3: use debugger buttons to review & identify issue
                * SMART STEP INTO: on statement with nested methods, select which method to step into for suspended execution details
         */

        Util.printSeparator();

    }

    // ! OOP COMPOSITION + INNER CLASS: logically grouped parent object that has child-object components
    class StringUtilities {

        // CONSTANTS/static class variables assigned FINAL value before instantiation
        private static final char CHARACTER = 'a';

        // ENCAPSULATION: security access-modifier private class variables WITH default values
        private StringBuilder stringBuilder = new StringBuilder();

        // ? FIELD WATCHPOINTS (red-dash dot): identify code for unexpected update to an instance field variable's value by suspending onUpdate
        private int charsAdded = 0;

        // non-static unique behavior/class methods
        public void buildString() {

            StringBuilder stringBuilder = new StringBuilder();

            while(stringBuilder.length() < 10) {
                addChar(stringBuilder, CHARACTER);
            }

            System.out.println(stringBuilder);
        }

        private void addChar(StringBuilder stringBuilder, char character) {
             // ? JAVA DEBUGGING step 1: set a pre-line suspending red breakpoint(s) on the FIRST/target line in problematic method by clicking in left-gutter
//            this.stringBuilder.append(character);

            // ? JAVA DEBUGGING step 2: select debugging icon in top-right corner of the app window (ladybug) to open Debugger

            /*
            ? JAVA DEBUGGING step 3: use debug buttons to review & identify issue
                debugger step over: shows that code is updating instance variable via 'this.stringBuilder' instead of the 'stringBuilder' argument
                    loop will never terminate, this.stringBuilder instance will continue to grow until memory-exception

                debugger step out: debugger will run the rest of the method, return to the caller execution line, & suspend before line execution

            ? JAVA DEBUGGING step 4: resume program to next breakpoint OR remove breakpoints & resume program in debugger
             */
            stringBuilder.append(character);
            charsAdded++;
        }

        private String upperAndPrefix(String str) {
            String upper = str.toUpperCase();
            return "Prefix__" + upper;
        }

        private String addSuffix(String str) {
            return str + "__Suffix";
        }
    }
}

// ! OOP INHERITANCE: child subclass inherits class fields & public methods from extending parent super-class
class JUnitTesting extends Notes {
    /*
        ? JUnit TESTING:
            JUnit is a Java built-in package/module
            1 Unit = 1 Method

            ! to create a test, the class needs to be independent (not an inner class)

        * JUnit PARAMETERIZED TESTS: run a test multiple times with different arguments
            * https://mkyong.com/junit5/junit-5-parameterized-tests/

                ! @ValueSource =  For a single argument test.

                ! @EnumSource = Run tests that take Enum as an argument.

                ! @MethodSource = Run tests that take a static method to generate arguments.

                ! @CsvSource = Multiple arguments

                ! @CsvFileSource = Run tests that take a comma-separated values (csv) as arguments.

                ! @ArgumentsSource = Create a reusable argument provider.

        ? JUnit TESTING step 1A: update project structure JUnit library dependency to compile
            File -> project structure -> Modules -> Dependencies Tab ->
                Export window -> Junit ->
                    open dropdown -> change "Test" to "Compile" -> Ok

        ? JUnit TESTING step 2.1: define class, method signatures, & test suite

        ? JUnit TESTING step 2.2: create JUnit Test class & generate methods to test in root
            ! click yellow light bulb onHover over independent class name
            ! FIX if IDE is unable to identify built-in JUnit Test class
            ! select specific methods to test

        ? JUnit TESTING step 1B: add JUnit Library
            ! right-click add "JUnit" to class path
            ! select "Use JUnit from IntelliJ IDEA distribution"
            ! click Ok

        ? JUnit TESTING step 3: BEFORE running, add fail(NOT_IMPLEMENTED) to each Test class method stub

        ? JUnit TESTING step 4: run expected failing tests suite

        ? JUnit TESTING step 5: review run configuration for all tests
            want to test class in application, NOT the application itself

            ! right-click outside created Test class & select run Test class
            ! right-click outside created Test class & select modify run configuration
            ! review configurations & click Ok
            ! review right-corner dropdown is respective Test suite

        ? JUnit TESTING step 6: setup tests objects run before & after teardown every test run
            ! @BeforeAll: STATIC execute only once before all test suit is run
                example: read data from db for tests

            ! @AfterAll: STATIC execute only once after all test suit is run

            ! @BeforeEach: execute code in setup() before each test is run

            ! @AfterEach: execute code in setup() after each test is run


        ? JUnit TESTING step 7: write test method assertions that test against class functionality
            in testSuite, click on green arrow/red x in gutter next to specific method to test

            review only passing or only failing tests with toggle in top-left of Test window

            ? JUnit TRY-CATCH: handle expected exceptions handing modify @Test annotation

                try {
                    double balance = checkingsAccount.withdraw(600.00, false);
                    assertEquals(400.00, balance, 0);
                } catch(IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }

            * BEST PRACTICE:
                write easily understood test method names

                    getBalance_deposit()
                    getBalance_withdraw()

                write on 1 independent assertion for 1 independent test
                setup any independent class instances that can be reused (without cross-pollination) on each test method

            ! assertEquals(expectedValue, actualTestValue);
            ! assertNotEquals(expectedValue, actualTestValue);

            ! assertTrue(actualTestValue, failMsg);
            ! assertFalse(actualTestValue, failMsg);

            ! assertArrayEquals(expectedArray, actualTestArray);
                consider two arrays equal if length & every element in order identical

            ! assertNull(actualTestValue);
            ! assertNotNull(actualTestValue);
                easy-to-read check for null values

            ! assertSame(expectedValue, actualTestValue);
            ! assertNotSame(expectedValue, actualTestValue);
                compares object references,
                    unlike assertEquals that checks if instances are the same

            ! assertThat(expectedValue, actualTestValue);
                compare the actual value against a matcher range of values

        ? JUnit TESTING step 5: write method implementation in file

        ? JUnit TESTING step 6: individually run implemented functions until all failing tests resolved in test suite
     */

    // CONSTANTS/static class variables assigned FINAL value before instantiation/compilation
    private static final String JUNIT_TESTING = "JUnit Testing";
    private static final int CHECKING = 1;
    private static final int SAVING = 2;

    // OOP ENCAPSULATION security access modifiers private class fields
    private String firstName;
    private String lastName;
    private Double balance;
    private int accountType;

    // OOP constructor that initializes class fields on class/object instantiation
    public JUnitTesting(String firstName, String lastName, double balance, int accountType) {
        // ! OOP INHERITANCE: child subclass inherits class fields & public methods from extending parent super-class
        super(JUNIT_TESTING);
        getNotes();

        this.accountType = accountType;
        this.firstName = firstName;
        this.lastName = lastName;

        // ! AUTOBOXING: convert primitive dataType -> Wrapper Class dataType w/ greater functionality
        this.balance = balance;
    }

    // non-static unique behavior/class methods
    // ! INTERFACE + OOP POLYMORPHISM: uniquely implement all signatures publicly-shared within a set of classes via @Override
    @Override
    public void getNotes() {

    }

    /**
     * add an amount to the current balance for this specific instance of the BankAccount
     * @param amount value to be added to a BankAccount instance balance
     * @param branch is true if customer is performing the transaction at the branch w/ a teller, false if at ATM
     * @return the running balance of this BankAccount instance
     */
    public Double deposit(double amount, boolean branch) {
        // ! AUTOBOXING: convert primitive dataType -> Wrapper Class dataType w/ greater functionality
        this.balance += amount;
        return this.balance;
    }

    /**
     * remove an amount from the current balance for this specific instance of the BankAccount
     * @param amount value to be added to a BankAccount instance balance
     * @param branch is true if customer is performing the transaction at the branch w/ a teller, false if at ATM
     * @return the running balance of this BankAccount instance
     */
    public Double withdraw(double amount, boolean branch) {
        // ? JUnit TESTING parameter validation: check that withdraw is less than or equal to 500 at branch
        if((amount > 500D) && !branch) {
            throw new IllegalArgumentException();
        }
        // ! AUTOBOXING: convert primitive dataType -> Wrapper Class dataType w/ greater functionality
        this.balance -= amount;
        return this.balance;
    }

    public boolean isSavings() {
        return accountType == SAVING;
    }

    public boolean isChecking() {
        return accountType == CHECKING;
    }

    // OOP getters & setters

    // static (class, no instance required) class methods
    public static int setChecking() {
        return 1;
    }

    // OOP getters & setters
    public Double getBalance() {
        return balance;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}

class JUnitTestingTest {

    // ENCAPSULATION: CONSTANTS/static class variables assigned FINAL value before instantiation/compilation
    private static final String AFTER_EACH = "@AfterEach runs after each test case";
    private static final String BEFORE_ALL = "@BeforeAll runs before any test cases";
    private static final String AFTER_ALL = "@AfterAll runs after all test cases";
    private static final String NOT_IMPLEMENTED = "This test has not been implemented yet";
    private static final String RUNNING_TEST = "Running a test".toUpperCase();
    private static final String NOT_CHECKING = "This is not a checkings account";
    private static final String NOT_SAVINGS = "This is not a savings account";
    private static final String COUNT = "\nCount = ";
    private static final String THROW_ILLEGAL_ARGUMENT = "Should have thrown an IllegalArgumentException";

    // ENCAPSULATION: secure access-modifier private class fields/object instance members
    private JUnitTesting checkingsAccount;
    private JUnitTesting savingsAccount;

    // ! STATIC: only 1 instance associated with the class & shared across memory
    private static int count;

    // ? JUnit TESTING step 6: setup tests objects run before & after every test run
    @BeforeAll
    static void beforeAll() {
        System.out.println(BEFORE_ALL + COUNT + count++);
    }

    // ? JUnit TESTING step 6: setup tests objects run before & after teardown every test run
    @BeforeEach
    void setUp() {
        checkingsAccount = new JUnitTesting("Lauren", "Wild", 1000.00, JUnitTesting.setChecking());
        savingsAccount = new JUnitTesting("Phil", "Yosemiti", 1000.00, 2);
        System.out.println(RUNNING_TEST);
    }

    @AfterEach
    void tearDown() {
        System.out.println(AFTER_EACH + COUNT + count++);
    }

    @AfterAll
    static void afterAll() {
        System.out.println(AFTER_ALL + COUNT + count++);
    }

    // ? JUnit TESTING step 3: BEFORE running, add fail(NOT_IMPLEMENTED) to each Test class method stub
    @Test
    void withdrawChecking_branch_true() {
//        fail(NOT_IMPLEMENTED);

        double balance = checkingsAccount.withdraw(600.00, true);
        assertEquals(400.00, balance, 0);
    }

    @Test
    void withdrawChecking_notBranch_false() throws Exception {

        // ? JUnit TRY-CATCH: handle expected exceptions handing modify @Test annotation
        // atm withdraw over 500 should throw IllegalArugmentException
        // check that withdraw is less than or equal to 500 at branch
        try {

            checkingsAccount.withdraw(600.00, false);
            fail(THROW_ILLEGAL_ARGUMENT);

        } catch(IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    // ? TESTING BEST PRACTICE: write on 1 independent assertion for 1 independent test
    @Test
    void deposit_branch() throws Exception{
        // ! UNBOXING: converting Wrapper class dataType -> primitive dataType
        double balance = checkingsAccount.deposit(200D, true);

        // ? JUnit TESTING: assertEquals(expected, actual) delta parameter allows for difference within specified delta value
        assertEquals(1200D, balance, 0);
    }

    @Test
    void getBalance_deposit_branch() throws Exception{
        checkingsAccount.deposit(200D, true);

        // ? JUnit TESTING: assertEquals(expected, actual) delta parameter allows for difference within specified delta value
        assertEquals(1200D, checkingsAccount.getBalance(), 0);
    }

    @Test
    void getBalance_withdraw_branch() throws Exception{
        checkingsAccount.withdraw(200D, true);

        // ? JUnit TESTING: assertEquals(expected, actual) delta parameter allows for difference within specified delta value
        assertEquals(800D, checkingsAccount.getBalance(), 0);
    }

    @Test
    void isSavings_true() throws Exception {
        assertTrue(savingsAccount.isSavings());
    }

    @Test
    void isSavings_false() throws Exception {
        assertFalse(checkingsAccount.isSavings(), NOT_SAVINGS);
    }

    @Test
    void isChecking_true() throws Exception {
        assertTrue(checkingsAccount.isChecking());
    }

    @Test
    void isChecking_false() throws Exception {
        assertFalse(savingsAccount.isChecking(), NOT_CHECKING);
    }
}

// ? JUnit PARAMETERIZED TESTS: run a test multiple times with different arguments
class ValueSourceParameterizedTest {

    // CONSTANTS/static class variables assigned FINAL value on instantiation/compilation
    private static final String PT_NAME = "#{index} - Run test with args={0}";
    private static final String RUNNING_TEST = "Running a test...".toUpperCase();

    // ? JUnit TESTING step 6: setup tests objects run before & after tear down every test run
    @BeforeEach
    void setup() {
        System.out.println(RUNNING_TEST);
    }

    // This test will run 3 times with different arguments
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void test_int_arrays(int arg) {
        assertTrue(arg > 0);
    }

    @ParameterizedTest(name = PT_NAME)
    @ValueSource(ints = {1, 2, 3})
    void test_int_arrays_custom_name(int arg) {
        assertTrue(arg > 0);
    }

    @ParameterizedTest(name = PT_NAME)
    @ValueSource(strings = {"apple", "banana", "orange"})
    void test_string_arrays_custom_name(String arg) {
        assertTrue(arg.length() > 1);
    }
}