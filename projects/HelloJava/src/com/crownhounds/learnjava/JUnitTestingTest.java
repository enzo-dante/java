package com.crownhounds.learnjava;

import org.junit.jupiter.api.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;

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