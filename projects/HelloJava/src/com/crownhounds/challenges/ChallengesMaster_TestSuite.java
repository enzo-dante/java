package com.crownhounds.challenges;

import com.crownhounds.datastructures_and_algorithms.Employee;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ChallengesMaster_TestSuite {

    // CONSTANTS/static class variables assigned FINAL value before instantiation/compilation
    public static final String NOT_IMPLEMENTED_FAIL = "This test is failing because it hasn't been implemented yet";
    public static final String INVALID_VALUE = "Invalid Value";

    public static final String BEFORE_ALL = "Message @beforeAll tests begin";
    public static final String AFTER_ALL = "All tests have been run";
    public static final String BEFORE_EACH = "Before test, instantiate class";
    public static final String AFTER_EACH = "Test has been run, reset instance to null";

}

class AreaCalculatorTest extends ChallengesMaster_TestSuite {

    /**
     * ? Write a class called AreaCalculator
     *
     * ? Write a method called area with 1 double parameter named radius
     *      return -1 if radius is negative
     *      return a double value that represents the area of a circle
     *
     * * area_circle = radius * radius * Math.PI
     *
     * ? Write an overloaded method with 2 parameters x & y (both doubles & a side of a rectangle)
     *      return -1 if either or both parameters are negative
     *      the method returns the area of a rectangle
     *
     * * area_rectangle = x * y
     */
    private AreaCalculator areaCalculator;

    @BeforeAll
    static void beforeAll() {
        System.out.println(BEFORE_ALL);
    }

    @BeforeEach
    void setUp() {
        areaCalculator = new AreaCalculator();
    }

    @AfterEach
    void tearDown() {
    }

    @AfterAll
    static void afterAll() {
        System.out.println(AFTER_ALL);
    }

    @Test
    void areaSingleOverloaded_negativeOne() {
        Double result = areaCalculator.area(-10);
        assertEquals(-1, result, 0);
    }

    @Test
    void areaSingleOverloaded_circleArea() {
        Double result = areaCalculator.area(10);
        assertEquals(10 * 10 * Math.PI, result, 0);
    }

    @Test
    void areaDoubleOverloaded_negativeOne() {
        Double result;

        result = areaCalculator.area(-10, 20);
        assertEquals(-1, result, 0);

        result = areaCalculator.area(20, -10);
        assertEquals(-1, result, 0);

        result = areaCalculator.area(-20, -10);
        assertEquals(-1, result, 0);
    }

    @Test
    void areaDoubleOverloaded_circleArea() {
        Double result = areaCalculator.area(10, 20);
        assertEquals(200, result, 0);
    }


}

class SpeedConverterTest extends ChallengesMaster_TestSuite {

    /**
     * ? Write a speed converter class
     *
     * ? Write a method called toMilesPerHour that has 1 parameter of type double with the name kilometersPerHour.
     *     This method needs to return the rounded value of the calculation of type long
     *
     *     If the parameter kilometersPerHour is less than 0,
     *         the method toMilesPerHour needs to return -1 to indicate an invalid value.
     *
     *     Otherwise, if kilometersPerHour is positive,
     *         calculate the value of miles per hour, round it and return it.
     *
     *         NOTE: 1.609 kilometers per hour is 1 mile per hour
     *
     *             milesPerHour = kilometersPerHour / 1.609
     *
     *         Use method Math.round to round the number of calculated miles per hour(double). The method round returns long.
     *
     *             The Math.round() is a built-in math method which returns the closest long to the argument.
     *             The result is rounded to an integer by adding 1/2, taking the floor of the result after adding 1/2, and typecasting the result to type long.
     *
     *             The method returns the value of the argument rounded to the nearest int value.
     *
     * ? Write another method called printConversion with 1 parameter of type double with the name kilometersPerHour.
     *     This method should not return anything (void) and it needs to calculate milesPerHour from the kilometersPerHour parameter.
     *
     *         Then it needs to print a message in the format "XX km/h = YY mi/h".
     *             XX represents the original value kilometersPerHour.
     *             YY represents the rounded milesPerHour from the kilometersPerHour parameter.
     *
     *     If the parameter kilometersPerHour is < 0 then print the text "Invalid Value"
     */
    // OOP ENCAPSULATION private class fields
    SpeedConverter speedConverter;

    @BeforeEach
    void setUp() {
        System.out.println(BEFORE_ALL);
        speedConverter = new SpeedConverter();
    }

    @AfterEach
    void tearDown() {
        System.out.println(AFTER_ALL);
    }

    @Test
    void toMilesPerHour() {
        Long actualValue = speedConverter.toMilesPerHour(-52);
        Long expectedValue = -1L;
        assertEquals(expectedValue, actualValue, 0);

        actualValue = speedConverter.toMilesPerHour(8);
        expectedValue = 13L;
        assertEquals(expectedValue, actualValue, 0);
    }

}

class NumberToWordsTest extends ChallengesMaster_TestSuite {

    /**
     * ? Write a NumberToWords class
     *
     * ? Write a method called numberToWords that has 1 parameter of type int with the name number.
     *     This method should print out the passed number using words for the digits
     *          Extract the last digit of the given number using the remainder operator.
     *          Convert the value of the digit found in Step 1 into a word. There are 10 possible values for that digit, those being 0, 1, 2, 3, 4, 5, 6, 7, 8, 9. Print the corresponding word for each digit, e.g. print "Zero" if the digit is 0, "One" if the digit is 1, and so on.
     *          Remove the last digit from the number.
     *          Repeat Steps 2 through 4 until the number is 0.
     *
     *     if the number is negative, print "Invalid Value"
     *
     * ? Write a method called reverse that has 1 parameter of type int with the name number.
     *     This method should return the reversed number and any negatives
     *
     * ? Write a method called getDigitCount that has 1 parameter of type int with the name number.
     *     This method should return the count of the digits in that number
     *     if number is negative, return -1
     *
     * ? use reverse in numberToWords
     */
    // OOP ENCAPSULATION private class fields
    NumberToWords numberToWords;

    @BeforeAll
    static void beforeAll() {
        System.out.println(BEFORE_ALL);
    }

    @AfterAll
    static void afterAll() {
        System.out.println(AFTER_ALL);
    }

    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void reverse() {
        int result;

        result = NumberToWords.reverse(-121);
        assertEquals(-121, result, 0);

        result = NumberToWords.reverse(1212);
        assertEquals(2121, result, 0);

        result = NumberToWords.reverse(1234);
        assertEquals(4321, result, 0);

        result = NumberToWords.reverse(100);
        assertEquals(1, result, 0);
    }

    @Test
    void getDigitCount() {
        int result;

        result = NumberToWords.getDigitCount(0);
        assertEquals(1, result, 0);

        result = NumberToWords.getDigitCount(123);
        assertEquals(3, result, 0);

        result = NumberToWords.getDigitCount(-12);
        assertEquals(-1, result, 0);

        result = NumberToWords.getDigitCount(5200);
        assertEquals(4, result, 0);
    }
}

// ! OOP INHERITANCE: child subclass inherits class fields + public methods from extending parent superclass
class MegaByteConverterTest extends ChallengesMaster_TestSuite {

    /*
       ? Write a megabyte converter class

       ? Write a method called printMegaBytesAndKiloBytes that has 1 parameter of type int with the name kiloBytes.
           The method should not return anything(void)

           it needs to calculate the megabytes and remaining kilobytes from the kilobytes parameter.

               1 MB = 1024 KB

       ? Then it needs to print a message in the format "XX KB = YY MB and ZZ KB".
           XX represents the original value kiloBytes.
           YY represents the calculated megabytes.
           ZZ represents the calculated remaining kilobytes.

           If the parameter kiloBytes is less than 0 then print the text "Invalid Value".
     */
    @BeforeAll
    static void beforeAll() {
        System.out.println(BEFORE_ALL);
    }

    @AfterAll
    static void afterAll() {
        System.out.println(AFTER_ALL);
    }

    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void printMegaBytesAndKiloBytes_invalid() {
        String actualValue;

        actualValue = MegaByteConverter.printMegaBytesAndKiloBytes(-1024);
        assertEquals("Invalid Value", actualValue);
    }

    @Test
    void printMegaBytesAndKiloBytes_success() {
        String actualValue;
        String expectedValue;

        actualValue = MegaByteConverter.printMegaBytesAndKiloBytes(2500);
        expectedValue = "2500 KB = 2 MB and 452 KB";

        assertEquals(expectedValue, actualValue);
    }
}

class BarkingDogTest extends ChallengesMaster_TestSuite {

/*
   ? Write a BarkingDog class

   ? We have a dog that likes to bark.
       We need to wake up if the dog is barking at night!

   ? Write a method shouldWakeUp that has 2 parameters.
       1st parameter should be of type boolean and be named barking
           it represents if our dog is currently barking.

       2nd parameter represents the hour of the day
           is of type int with the name hourOfDay and has a valid range of 0-23.
           If the hourOfDay parameter is less than 0 or greater than 23 return false.

       We have to wake up if the dog is barking before 8 or after 22 hours so in that case return true.

       In all other cases return false.
*/

    // OOP ENCAPSULATION private class fields
    private boolean actualValue;
    private boolean expectedValue;

    @Test
    void shouldWakeUp_barking_true() {

        actualValue = BarkingDog.shouldWakeUp(true, 1);
        assertTrue(actualValue);

        actualValue = BarkingDog.shouldWakeUp(true, 23);
        assertTrue(actualValue);
    }

    @Test
    void shouldWakeUp_barking_false() {

        actualValue = BarkingDog.shouldWakeUp(true, -1);
        assertFalse(actualValue);

        actualValue = BarkingDog.shouldWakeUp(true, 8);
        assertFalse(actualValue);

        actualValue = BarkingDog.shouldWakeUp(true, 19);
        assertFalse(actualValue);
    }

    @Test
    void shouldWakeUp_notBarking() {

        actualValue = BarkingDog.shouldWakeUp(false, 2);
        assertFalse(actualValue);

        actualValue = BarkingDog.shouldWakeUp(false, 10);
        assertFalse(actualValue);
    }
}

class ArraySorterTest extends ChallengesMaster_TestSuite {

    private ArraySorter arraySorter;
    @BeforeAll
    static void beforeAll() {
        System.out.println(BEFORE_ALL);
    }

    @BeforeEach
    void setUp() {
        arraySorter = new ArraySorter();
        System.out.println(BEFORE_EACH);
    }

    @AfterAll
    static void afterAll() {
        System.out.println(AFTER_ALL);
    }

    @AfterEach
    void tearDown() {
        System.out.println(AFTER_EACH);
    }

    @Test
    void sortIntegers_success() {
        int[] testInput = {1000, 0, 4, 1, 299};
        int[] expected = {0, 1, 4, 299, 1000};
        int[] actual = arraySorter.sortIntegers(testInput);
        assertEquals(Arrays.toString(expected), Arrays.toString(actual));
    }

    @Test
    void sortIntegers_negativeInput() {
        int[] testInput = {299, -1000, 1, 0, 4};
        int[] expected = {-1000, 0, 1, 4, 299};
        int[] actual = arraySorter.sortIntegers(testInput);
        assertEquals(Arrays.toString(expected), Arrays.toString(actual));
    }

    @Test
    void sortIntegers_emptyInput() {
        int[] testInput = {};
        int[] actual = arraySorter.sortIntegers(testInput);
        assertNull(actual);
    }

    @Test
    void sortIntegers_shortInput() {
        int[] testInput = {2,1,3};
        int[] actual = arraySorter.sortIntegers(testInput);
        assertNull(actual);
    }

    @Test
    void sortIntegers_longInput() {
        int[] testInput = {2,1,3,7,10,0};
        int[] actual = arraySorter.sortIntegers(testInput);
        assertNull(actual);
    }
}

class MinElementTest extends ChallengesMaster_TestSuite {

    // OOP ENCAPSULATION private class fields
    MinElement minElement;

    @BeforeAll
    static void beforeAll() {
        System.out.println(BEFORE_ALL);
    }

    @BeforeEach
    void setUp() {
        System.out.println(BEFORE_EACH);
        minElement = new MinElement();
    }

    @AfterAll
    static void afterAll() {
        System.out.println(AFTER_ALL);
    }

    @AfterEach
    void tearDown() {
        System.out.println(AFTER_EACH);
    }

    @Test
    void findMin_success() {
        int[] testInput = {5, 2, 3};
        int expected = 2;
        int actual = minElement.findMin(testInput);
        assertEquals(expected, actual);
    }

    @Test
    void findMin_badInput() {
        int[] testInput = {};
        int expected = -1;
        int actual = minElement.findMin(testInput);
        assertEquals(expected, actual);
    }
}

class GroceryAppTest extends ChallengesMaster_TestSuite {

    // CONSTANTS/static class variables assigned FINAL value before compilation/instantiation
    private static final String TEST_TIRAMISU = "Tiramisu".toLowerCase();
    private static final String TEST_CHEESE = "Cheese".toLowerCase();
    private static final String TEST_WATER = "Water".toLowerCase();
    private static final String TEST_MILK = "Milk".toLowerCase();

    // OOP ENCAPSULATION private class fields
    GroceryApp groceryList;
    List<String> testInput;
    boolean actual;

    @BeforeEach
    void setup() {
        groceryList = new GroceryApp();

        testInput = new ArrayList<>();
        testInput.add(TEST_CHEESE);
        testInput.add(TEST_WATER);
        testInput.add(TEST_MILK);

        System.out.println(BEFORE_EACH);
    }

    @AfterEach
    void tearDown() {
        testInput.clear();
        System.out.println(AFTER_EACH);
    }

    @Test
    void addItem_true() {
        actual = groceryList.addItem(testInput, TEST_TIRAMISU);
        assertTrue(actual);
    }

    @Test
    void addItem_falseBadItem() {
        actual = groceryList.addItem(testInput, TEST_CHEESE);
        assertFalse(actual);
    }

    @Test
    void updateItem_true() {
        actual = groceryList.updatedItem(testInput, 2, TEST_TIRAMISU);
        assertTrue(actual);
    }

    @Test
    void updateItem_falseBadIndex() {

        actual = groceryList.updatedItem(testInput, -1, TEST_TIRAMISU);
        assertFalse(actual);

        actual = groceryList.updatedItem(testInput, 100, TEST_TIRAMISU);
        assertFalse(actual);
    }

    @Test
    void updateItem_falseEmptyList() {
        testInput = new ArrayList<>();

        actual = groceryList.updatedItem(testInput, 2, TEST_TIRAMISU);
        assertFalse(actual);
    }


    @Test
    void deleteItem_true() {
        actual = groceryList.updatedItem(testInput, 2, TEST_TIRAMISU);
        assertTrue(actual);
    }

    @Test
    void deleteItem_falseEmptyList() {
        testInput = new ArrayList<>();

        boolean actual = groceryList.updatedItem(testInput, 2, TEST_TIRAMISU);
        assertFalse(actual);
    }

    @Test
    void deleteItem_falseBadIndex() {
        boolean actual = groceryList.updatedItem(testInput, -1, TEST_TIRAMISU);
        assertFalse(actual);

        actual = groceryList.updatedItem(testInput, 100, TEST_TIRAMISU);
        assertFalse(actual);
    }

    @Test
    void queryForItem_success() {
        String actual = groceryList.queryForItem(testInput, TEST_MILK);
        assertEquals(TEST_MILK, actual);
    }

    @Test
    void queryForItem_notFound() {
        String actual = groceryList.queryForItem(testInput, "Chicken");
        assertEquals(GroceryApp.ITEM_NOT_FOUND, actual);
    }


    @Test
    void queryForItem_EmptyItem() {
        String actual = groceryList.queryForItem(testInput, "");
        assertEquals(INVALID_VALUE, actual);
    }

    @Test
    void queryForItem_EmptyList() {
        testInput = new ArrayList<>();
        String actual = groceryList.queryForItem(testInput, TEST_CHEESE);
        assertEquals(INVALID_VALUE, actual);
    }
     @Test
    void queryForIndex_success() {
        String actual = groceryList.queryForItem(testInput, 2);
        assertEquals(TEST_MILK, actual);
    }

    @Test
    void queryForIndex_badIndex() {
        String actual = groceryList.queryForItem(testInput, 100);
        assertEquals(INVALID_VALUE, actual);
    }

    @Test
    void queryForIndex_EmptyList() {
        testInput = new ArrayList<>();
        String actual = groceryList.queryForItem(testInput, 2);
        assertEquals(INVALID_VALUE, actual);
    }
}

class MergeSortDescendingTest extends ChallengesMaster_TestSuite {

    // OOP ENCAPSULATION private class fields
    MergeSortDescending mergeSort;
    private static int[] testInput;
    private static final int[] expected = {55, 35, 20, 7, 1, -15, -22};

    @BeforeAll
    static void beforeAll() {
        System.out.println(BEFORE_ALL);
    }

    @BeforeEach
    void setUp() {
        System.out.println(BEFORE_EACH);
        testInput = new int[]{20, 35, -15, 7, 55, 1, -22};
    }

    @AfterAll
    static void afterAll() {
        System.out.println(AFTER_ALL);
    }

    @AfterEach
    void tearDown() {
        System.out.println(AFTER_EACH);
    }

    @Test
    void mergeSortExecute_success() {

        int[] actual = MergeSortDescending.execute(testInput);
        assertArrayEquals(expected, actual);
    }

    @Test
    void mergeSortExecute_badInput() {

        testInput = new int[] {};
        int[] actual = MergeSortDescending.execute(testInput);
        assertNull(actual);
    }
}

class SecondsAndMinutesTest extends ChallengesMaster_TestSuite {

    // OOP ENCAPSULATION private class fields
    String expected = "XXh YYm ZZs";
    String actual;

    @BeforeAll
    static void beforeAll() {
        System.out.println(BEFORE_ALL);

    }

    @BeforeEach
    void setup() {
        System.out.println(BEFORE_EACH);

    }

    @AfterEach
    void tearDown() {
        System.out.println(AFTER_EACH);
        expected = INVALID_VALUE;
        actual = null;
    }

    @AfterAll
    static void afterAll() {
        System.out.println(AFTER_ALL);
    }

    @Test
    void getDurationString1_success() {

        // BONUS: for input 61 minutes = '01h 01m 00s' || '1h 1m 0s'
        expected = "01h 01m 00s";
        actual = SecondsAndMinutes.getDurationString(61, 0);
        assertEquals(expected, actual);

    }

    @Test
    void getDurationString1_negative() {

        expected = INVALID_VALUE;

        actual = SecondsAndMinutes.getDurationString(-30, 18);
        assertEquals(expected, actual);

        actual = SecondsAndMinutes.getDurationString(40, -23);
        assertEquals(expected, actual);

        actual = SecondsAndMinutes.getDurationString(-20, -20);
        assertEquals(expected, actual);

        actual = SecondsAndMinutes.getDurationString(10, 88);
        assertEquals(expected, actual);
    }

    @Test
    void getDurationString2_success() {

        expected = "02h 06m 34s";
        actual = SecondsAndMinutes.getDurationString(7594);
        assertEquals(expected, actual);

        expected = "00h 00m 09s";
        actual = SecondsAndMinutes.getDurationString(9);
        assertEquals(expected, actual);
    }

    @Test
    void getDurationString2_fail() {

        expected = INVALID_VALUE;

        actual = SecondsAndMinutes.getDurationString(-15);
        assertEquals(expected, actual);
    }
}

class NumberPalindromeTest extends ChallengesMaster_TestSuite {

    // OOP ENCAPSULATION private class fields

    @BeforeAll
    static void beforeAll() {
        System.out.println(BEFORE_ALL);
    }

    @BeforeEach
    void setup() {
        System.out.println(BEFORE_EACH);
    }

    @AfterEach
    void tearDown() {
        System.out.println(AFTER_EACH);
    }

    @AfterAll
    static void afterAll() {
        System.out.println(AFTER_ALL);
    }

    @Test
    void isPalindrome_true() {
        boolean actual = NumberPalindrome.isPalindrome(-303);
        assertTrue(actual);
    }

    @Test
    void isPalindrome_trueSingle() {
        boolean actual = NumberPalindrome.isPalindrome(-6);
        assertTrue(actual);

        actual = NumberPalindrome.isPalindrome(3);
        assertTrue(actual);
    }

    @Test
    void isPalindrome_false() {
        boolean actual = NumberPalindrome.isPalindrome(125);
        assertFalse(actual);

        actual = NumberPalindrome.isPalindrome(-411);
        assertFalse(actual);
    }
}

class EvenDigitSumTest extends ChallengesMaster_TestSuite {

    // OOP ENCAPSULATION private class fields
    EvenDigitSum evenDigitSum;

    @BeforeAll
    static void beforeAll() {
        System.out.println(BEFORE_ALL);
    }

    @BeforeEach
    void setup() {
        System.out.println(BEFORE_EACH);
        evenDigitSum = new EvenDigitSum();
    }

    @AfterEach
    void tearDown() {
        System.out.println(AFTER_EACH);
    }

    @AfterAll
    static void afterAll() {
        System.out.println(AFTER_ALL);
    }

    @Test
    void getEvenDigitSum_success() {
        int expected = 20;
        int actual = evenDigitSum.getEvenDigitSum(10);
        assertEquals(expected, actual);
    }

    @Test
    void getEvenDigitSum_failBadInput() {
        int expected = -1;
        int actual = evenDigitSum.getEvenDigitSum(-22);
        assertEquals(expected, actual);
    }
}

class SharedDigitTest extends ChallengesMaster_TestSuite {

    // ! OOP ENCAPSULATION: protect object instance members/class fields from external access of direct inappropriate update
    // private class fields
    private SharedDigit sharedDigit;

    @BeforeAll
    static void beforeAll() {
        System.out.println(BEFORE_ALL);
    }

    @BeforeEach
    void setup() {
        System.out.println(BEFORE_EACH);
        sharedDigit = new SharedDigit();
    }

    @AfterEach
    void tearDown() {
        System.out.println(AFTER_EACH);
    }

    @AfterAll
    static void afterAll() {
        System.out.println(AFTER_ALL);
    }

    @Test
    void hasSharedDigit_true() {
        // ! UNBOXING: casting greater functionality Wrapper class -> primitive dataType
        Integer a = 25;
        Integer b = 58;

        boolean actual = SharedDigit.hasSharedDigit(a, b);
        assertTrue(actual);
    }

    @Test
    void hasSharedDigit_false() {
        // ! UNBOXING: casting greater functionality Wrapper class -> primitive dataType
        Integer a = 25;
        Integer b = 68;

        boolean actual = SharedDigit.hasSharedDigit(a, b);
        assertFalse(actual);
    }

    @Test
    void hasSharedDigit_badInput() {
        // ! UNBOXING: casting greater functionality Wrapper class -> primitive dataType
        Integer a = -1;
        Integer b = 50;
        assertFalse(SharedDigit.hasSharedDigit(a,b));

        a = 100;
        assertFalse(SharedDigit.hasSharedDigit(a,b));

        a = 50;
        b = -1;
        assertFalse(SharedDigit.hasSharedDigit(a,b));

        a = 50;
        b = 100;
        assertFalse(SharedDigit.hasSharedDigit(a,b));

        a = -1;
        b = 100;
        assertFalse(SharedDigit.hasSharedDigit(a,b));

        a = 100;
        b = -1;
        assertFalse(SharedDigit.hasSharedDigit(a,b));
    }
}

class RecursiveInsertionSortTest extends ChallengesMaster_TestSuite {

    // CONSTANTS/static class variables assigned FINAL value before compilation/instantiation
    private static final int[] EXPECTED = {-22, -15, 1, 7, 20, 35, 55};

    @BeforeAll
    static void beforeAll() {
        System.out.println(BEFORE_ALL);
    }

    @BeforeEach
    void setup() {
        System.out.println(BEFORE_EACH);
    }

    @AfterEach
    void tearDown() {
        System.out.println(AFTER_EACH);
    }

    @AfterAll
    static void afterAll() {
        System.out.println(AFTER_ALL);
    }

    @Test
    void duelInsertionSort_isRecursive() {
        int[] actual = DuelInsertionSort.execute(true);
        assertArrayEquals(EXPECTED, actual);
    }

    @Test
    void duelInsertionSort_isIterative() {
        int[] actual = DuelInsertionSort.execute(false);
        assertArrayEquals(EXPECTED, actual);
    }
}

class RadixSortTest extends ChallengesMaster_TestSuite {

    // CONSTANTS/static class variables assigned FINAL value before compilation/instantiation
    private static String[] EXPECTED = {
            "abcde",
            "bbbbb",
            "bcdef",
            "dbaqc",
            "omadd"
    };

    @BeforeAll
    static void beforeAll() {
        System.out.println(BEFORE_ALL);
    }

    @BeforeEach
    void setup() {
        System.out.println(BEFORE_EACH);
    }

    @AfterEach
    void tearDown() {
        System.out.println(AFTER_EACH);
    }

    @AfterAll
    static void afterAll() {
        System.out.println(AFTER_ALL);
    }

    @Test
    void radixSort_success() {
        String[] actual = RadixSort.execute();
        assertArrayEquals(EXPECTED, actual);
    }
}

class BankAccountTest extends ChallengesMaster_TestSuite {

    // ! OOP ENCAPSULATION: private/protected class fields/methods that prevent external access & inappropriate use
    private BankAccount bankAccount;

    @BeforeAll
    static void beforeAll() {
        System.out.println(BEFORE_ALL);
    }

    @BeforeEach
    void setup() {
        System.out.println(BEFORE_EACH);
        bankAccount = new BankAccount(1, 100, "Test Customer", "test@gmail.com", "123-123-1234");
    }

    @AfterEach
    void tearDown() {
        System.out.println(AFTER_EACH);
    }

    @AfterAll
    static void afterAll() {
        System.out.println(AFTER_ALL);
    }

    @Test
    void deposit_success() {
        int testAmount = 50;
        int expected = 150;
        int actual = bankAccount.deposit(testAmount);
        assertEquals(expected, actual);
    }

    @Test
    void deposit_invalidAmount() {
        int testAmount = -50;
        int expected = -1;
        int actual = bankAccount.deposit(testAmount);
        assertEquals(expected, actual);
    }

    @Test
    void withdraw_success() {
        int testAmount = 50;
        int expected = 50;
        int actual = bankAccount.withdraw(testAmount);
        assertEquals(expected, actual);
    }

    @Test
    void withdraw_emptyAccount() {
        int testAmount = 150;
        int expected = -1;
        bankAccount.setBalance(0);
        int actual = bankAccount.withdraw(testAmount);
        assertEquals(expected, actual);
    }

    @Test
    void withdraw_overdraft() {
        int testAmount = 150;
        int expected = -1;
        int actual = bankAccount.withdraw(testAmount);
        assertEquals(expected, actual);
    }

    @Test
    void withdraw_zero() {
        int testAmount = 100;
        int expected = 0;
        int actual = bankAccount.withdraw(testAmount);
        assertEquals(expected, actual);
    }

    @Test
    void withdraw_invalidAmount() {
        int testAmount = -50;
        int expected = -1;
        int actual = bankAccount.withdraw(testAmount);
        assertEquals(expected, actual);
    }
}

class GSDTest extends ChallengesMaster_TestSuite {

    // ! OOP ENCAPSULATION: use access-modifiers to protect public class fields & methods from external inappropriate use
    // ! ACCESS-MODIFIER private: method or variable w/ accessability limited to scope of defining class
    // private class fields
    private GSD gsd;
    @BeforeAll
    static void beforeAll() {
        System.out.println(BEFORE_EACH);
    }

    @AfterAll
    static void afterAll() {
        System.out.println(AFTER_EACH);
    }

    @BeforeEach
    void setup() {
        System.out.println(BEFORE_ALL);
        gsd = new GSD(10);
    }

    @AfterEach
    void teardown() {
        System.out.println(AFTER_ALL);
    }

    @Test
    void getGreatestCommonDivisor_success() {

        int testInputFirst = 12; // 12-1 6-2 4-3
        int testInputSecond = 30; // 30-1 15-2 10-3 6-5

        Integer expected = 6;
        Integer actual = gsd.getGreatestCommonDivisor(testInputFirst, testInputSecond);
        assertEquals(expected, actual);
    }

    @Test
    void getGreatestCommonDivisor_badInput() {

        int testInputFirst = 11;
        int testInputSecond = 9;

        Integer expected = -1;

        // ! AUTOBOXING: casting a primitive dataType -> greater functionality compatible Wrapper class dataType
        Integer actual = gsd.getGreatestCommonDivisor(testInputFirst, testInputSecond);
        assertEquals(expected, actual);

        testInputFirst = -1;
        testInputSecond = 11;

        actual = gsd.getGreatestCommonDivisor(testInputFirst, testInputSecond);
        assertEquals(expected, actual);

        testInputFirst = -5;
        testInputSecond = -9;

        actual = gsd.getGreatestCommonDivisor(testInputFirst, testInputSecond);
        assertEquals(expected, actual);
    }
}

class FactorPrinterTest extends ChallengesMaster_TestSuite {

    // ! OOP ENCAPSULATION: use access-modifiers to protect variables & methods from external inappropriate use
    // private class fields
    private String expected;

    @BeforeAll
    static void beforeAll() {
        System.out.println(BEFORE_ALL);
    }

    @BeforeEach
    void beforeEach() {
        System.out.println(BEFORE_EACH);

    }

    @AfterEach
    void afterEach() {
        System.out.println(AFTER_EACH);
    }

    @AfterAll
    static void afterAll() {
        System.out.println(AFTER_ALL);
    }

    @Test
    void printFactors_success() {

        int testInput = 6;
        expected = "All factors printed";
        String actual = FactorPrinter.printFactors(testInput);
        assertEquals(expected, actual);
    }

    @Test
    void printFactors_fail() {

        int testInput = -1;
        expected = "Invalid Value";
        String actual = FactorPrinter.printFactors(testInput);
        assertEquals(expected, actual);
    }
}

class PerfectNumberTest extends ChallengesMaster_TestSuite {

    // ! OOP ENCAPSULATION: use access-modifiers to protect variables & methods from external inappropriate use
    // private class fields
    private boolean expected;

    @BeforeAll
    static void beforeAll() {
        System.out.println(BEFORE_ALL);
    }

    @BeforeEach
    void beforeEach() {
        System.out.println(BEFORE_EACH);

    }

    @AfterEach
    void afterEach() {
        System.out.println(AFTER_EACH);
    }

    @AfterAll
    static void afterAll() {
        System.out.println(AFTER_ALL);
    }

    @Test
    void isPerfectNumber_success() {

        int testInput = 6;
        boolean actual = PerfectNumber.isPerfectNumber(testInput);
        assertTrue(actual);
    }

    @Test
    void isPerfectNumber_fail() {

        int testInput = 7;
        boolean actual = PerfectNumber.isPerfectNumber(testInput);
        assertFalse(actual);
    }


    @Test
    void isPerfectNumber_badInput() {

        int testInput = 0;
        boolean actual = PerfectNumber.isPerfectNumber(testInput);
        assertFalse(actual);
    }
}

class LeapYearCalculatorTest extends ChallengesMaster_TestSuite {

    // ! OOP ENCAPSULATION: access-modifier protection from external inappropriate use
    // private class fields
    private LeapYearCalculator leapYearCalculator;

    @BeforeAll
    static void beforeAll() {
        System.out.println(BEFORE_ALL);
    }

    @AfterAll
    static void afterAll() {
        System.out.println(AFTER_ALL);
    }

    @BeforeEach
    void setup() {
        System.out.println(BEFORE_EACH);
    }

    @AfterEach
    void teardown() {
        System.out.println(AFTER_EACH);
    }

    @Test
    void isLeapYear_true() {

        // ! WRAPPER CLASS: a dataType with greater functionality than comprable primitive dataType
        // ! UNBOXING: casting wrapper class dataType -> primitive dataType
        Integer test = 1600;
         // REFERENCE LeapYearCalculator class
        boolean actual = LeapYearCalculator.isLeapYear(test);
        assertTrue(actual);

        test = 2000;
        actual = LeapYearCalculator.isLeapYear(test);
        assertTrue(actual);

        // TEST numbers in range(1,100)
        test = 4;
        actual = LeapYearCalculator.isLeapYear(test);
        assertTrue(actual);

        test = 1924;
        actual = LeapYearCalculator.isLeapYear(test);
        assertTrue(actual);
    }

    @Test
    void isLeapYear_false() {

        // REFERENCE LeapYearCalculator class
        Integer test = 2017;
        boolean actual = LeapYearCalculator.isLeapYear(test);
        assertFalse(actual);

        // TEST divisibility by 100 AND 4 BUT_NOT 400
        test = 1800;
        actual = LeapYearCalculator.isLeapYear(test);
        assertFalse(actual);

        test = 1900;
        actual = LeapYearCalculator.isLeapYear(test);
        assertFalse(actual);
    }

    @Test
    void isLeapYear_badInput() {

        Integer test = -1600;
        boolean actual = LeapYearCalculator.isLeapYear(test);
        assertFalse(actual);
    }
}

class EmployeeDoublyLinkedListTest extends ChallengesMaster_TestSuite {

    // ! OOP ENCAPSULATION: access-modifier protection from external inappropriate use
    // private class fields
    private EmployeeDoublyLinkedList linkedList;
    private Employee test = new Employee("Stone", "Vernon", 999);

    @BeforeAll
    static void beforeAll() {
        System.out.println(BEFORE_ALL);
    }

    @AfterAll
    static void afterAll() {
        System.out.println(AFTER_ALL);
    }

    @BeforeEach
    void setup() {
        System.out.println(BEFORE_EACH);
        linkedList = new EmployeeDoublyLinkedList();

        linkedList.addToFront(new Employee("Jane", "Jones", 123));
        linkedList.addToFront(new Employee("John", "Doe", 456));
        linkedList.addToFront(new Employee("Mary", "Smith", 789));
        linkedList.addToFront(new Employee("Mike", "Wilson", 135));
        linkedList.addToFront(new Employee("Bill", "Elvin", 246));
    }

    @AfterEach
    void teardown() {
        System.out.println(AFTER_EACH);
        linkedList = null;
    }

    @Test
    void isEmpty_true() {
        linkedList = new EmployeeDoublyLinkedList();
        assertTrue(linkedList.isEmpty());
    }

    @Test
    void isEmpty_false() {
        assertFalse(linkedList.isEmpty());
    }

    @Test
    void getSize_success() {
        int expected = 5;
        int actual = linkedList.getSize();
        linkedList.printList();
        assertEquals(expected, actual);
    }

    @Test
    void getSize_empty() {
        linkedList = new EmployeeDoublyLinkedList();
        int expected = -1;
        int actual = linkedList.getSize();
        linkedList.printList();
        assertEquals(expected, actual);
    }

    @Test
    void addBefore_true() {
        Employee e2 = new Employee("Mary", "Smith", 789);
        int expectedSize = 6;

        boolean actual = linkedList.addBefore(test, e2);
        linkedList.printList();
        assertTrue(actual);
        assertEquals(expectedSize, linkedList.getSize());
    }

    @Test
    void addBefore_true2() {
        Employee e2 = new Employee("John", "Doe", 456);
        int expectedSize = 6;

        boolean actual = linkedList.addBefore(test, e2);
        linkedList.printList();
        assertTrue(actual);
        assertEquals(expectedSize, linkedList.getSize());
    }

    @Test
    void addBefore_newHeadTrue() {
        Employee e2 = new Employee("Bill", "Elvin", 246);
        int expectedSize = 6;

        boolean actual = linkedList.addBefore(test, e2);
        linkedList.printList();
        assertTrue(actual);

        linkedList.printList();
        assertEquals(test, linkedList.getHead());


        assertEquals(expectedSize, linkedList.getSize());
    }

    @Test
    void addBefore_missingExistingFalse() {
        Employee e1 = new Employee("Jane", "Jones", 123);
        Employee e2 = new Employee("test", "test", 000);
        int expectedSize = 5;

        boolean actual = linkedList.addBefore(e1, e2);
        linkedList.printList();
        assertFalse(actual);

        assertEquals(expectedSize, linkedList.getSize());
    }

    @Test
    void addBefore_badInputFalse() {
        Employee e1 = new Employee("Jane", "Jones", 123);
        Employee e2 = new Employee("Mary", "Smith", 789);

        boolean actual = linkedList.addBefore(null, null);
        linkedList.printList();
        assertFalse(actual);

        actual = linkedList.addBefore(null, e2);
        assertFalse(actual);

        actual = linkedList.addBefore(e1, null);
        assertFalse(actual);
    }

    @Test
    void addBefore_emptyFalse() {
        linkedList = new EmployeeDoublyLinkedList();
        Employee e1 = new Employee("Jane", "Jones", 123);
        Employee e2 = new Employee("Mary", "Smith", 789);

        boolean actual = linkedList.addBefore(e1, e2);
        linkedList.printList();
        assertFalse(actual);
    }

    @Test
    void addToFront_emptyAdd() {
        linkedList = new EmployeeDoublyLinkedList();
        Employee expected =  test;

        linkedList.addToFront(expected);
        linkedList.printList();
        assertEquals(expected, linkedList.getHead());
    }

    @Test
    void addToFront_populatedAdd() {
        Employee expected = new Employee("Stone", "Vernon", 999);
        int expectedSize = 6;

        linkedList.addToFront(expected);
        linkedList.printList();
        assertEquals(expected, linkedList.getHead());
        assertEquals(expectedSize, linkedList.getSize());
    }

    @Test
    void addToFront_badInputFail() {
        test = null;

        Employee expected = new Employee("Bill", "Elvin", 246);
        int expectedSize = 5;

        linkedList.addToEnd(test);
        linkedList.printList();
        assertEquals(expected, linkedList.getHead());
        assertEquals(expectedSize, linkedList.getSize());
    }

    @Test
    void addToEnd_emptyAdd() {
        linkedList = new EmployeeDoublyLinkedList();

        linkedList.addToEnd(test);
        linkedList.printList();
        assertEquals(test, linkedList.getHead());
    }

    @Test
    void addToEnd_populateAdd() {
        int expectedSize = 6;
        linkedList.addToEnd(test);

        assertEquals(test, linkedList.getTail());
        assertEquals(expectedSize, linkedList.getSize());

        Employee current = linkedList.getHead();

        while(current.getNext() != null) {
            current = current.getNext();
        }
        assertEquals(test, current);
        linkedList.printList();
    }

    @Test
    void addToEnd_badInputFail() {
        test = null;
        Employee expected = new Employee("Bill", "Elvin", 246);

        linkedList.addToEnd(test);
        linkedList.printList();
        assertEquals(expected, linkedList.getHead());
        assertNull(linkedList.getTail());
    }

    @Test
    void removeFromFront_success() {
        Employee expected = new Employee("Bill", "Elvin", 246);
        int expectedSize = 4;

        Employee actual = linkedList.removeFromFront();
        linkedList.printList();
        assertEquals(expected, actual);
        assertEquals(expectedSize, linkedList.getSize());
    }

    @Test
    void removeFromFront_emptyFail() {
        linkedList = new EmployeeDoublyLinkedList();

        Employee actual = linkedList.removeFromFront();
        linkedList.printList();
        assertNull(actual);
    }

    @Test
    void removeFromEnd_success() {
        Employee expected = new Employee("Jane", "Jones", 123);
        int expectedSize = 4;

        Employee actual = linkedList.removeFromEnd();
        System.out.println("REMOVED: " + actual);
        linkedList.printList();
        assertEquals(expected, actual);
        assertEquals(expectedSize, linkedList.getSize());

        expected = new Employee("John", "Doe", 456);
        assertEquals(expected, linkedList.getTail());
    }

    @Test
    void removeFromEnd_emptyFail() {
        linkedList = new EmployeeDoublyLinkedList();

        Employee actual = linkedList.removeFromEnd();
        linkedList.printList();
        assertNull(actual);
    }
}

class VehicleTest extends ChallengesMaster_TestSuite {

    // private class fields
    private Ferrari enzo;

    @BeforeAll
    static void beforeAll() {
        System.out.println(BEFORE_ALL);
    }

    @AfterAll
    static void afterAll() {
        System.out.println(AFTER_ALL);
    }

    @BeforeEach
    void setup() {
        System.out.println(BEFORE_EACH);
        enzo = new Ferrari("Enzo", 6);
    }

    @AfterEach
    void teardown() {
        System.out.println(AFTER_EACH);
    }

    @Test
    void changingGears_success() {
        enzo.setSpeed(25);
        boolean actual = enzo.changingGears(2);
        assertTrue(actual);
    }

    @Test
    void changingGears_invalidInputFail() {
        boolean actual = enzo.changingGears(7);
        assertFalse(actual);
    }


    @Test
    void changingGears_stallingFail() {
        boolean actual = enzo.changingGears(4);
        assertFalse(actual);
    }


    @Test
    void accelerating_success() {

        int test = 10;

        int expected = 10;
        int actual = enzo.accelerating(test);
        assertEquals(expected, actual);

        test = 25;

        expected = 35;
        actual = enzo.accelerating(test);
        assertEquals(expected, actual);
    }

    @Test
    void accelerating_inputFail() {

        int test = 0;

        int expected = -1;
        int actual = enzo.accelerating(test);
        assertEquals(expected, actual);

        test = 10;
        enzo.accelerating(test);

        test = 0;
        int expectedGetSpeed = 10;
        enzo.accelerating(test);
        assertEquals(expectedGetSpeed, enzo.getSpeed());
    }

    @Test
    void accelerating_zeroTotalSuccess() {

        int test = 1;

        int expected = 1;
        int actual = enzo.accelerating(test);
        assertEquals(expected, actual);


        test = -1;
        expected = 0;
        actual = enzo.accelerating(test);
        assertEquals(expected, actual);

        test = 1;
        enzo.accelerating(test);
        test = -5;
        actual = enzo.accelerating(test);
        expected = 0;
        assertEquals(expected, actual);
    }


    @Test
    void accelerating_negativeInputSuccess() {

        int test = 35;

        int expected = 35;
        int actual = enzo.accelerating(test);
        assertEquals(expected, actual);


        test = -7;

        expected = 28;
        actual = enzo.accelerating(test);
        assertEquals(expected, actual);
    }


    @Test
    void isMoving_true() {
        int test = 35;
        enzo.accelerating(test);

        assertTrue(enzo.isMoving());
    }

    @Test
    void isMoving_false() {
        assertFalse(enzo.isMoving());
    }

    @Test
    void handSteering_success() {
        int test = 10;

        int expected = 10;
        int actual = enzo.handSteering(test);
        assertEquals(expected, actual);

        expected = 20;
        enzo.setDirection(10);
        actual = enzo.handSteering(test);
        assertEquals(expected, actual);

        expected = 9;
        enzo.setDirection(359);
        actual = enzo.handSteering(test);
        assertEquals(expected, actual);
    }

    @Test
    void handSteering_inputFail() {

        int test = 0;

        int expected = -1;
        int actual = enzo.handSteering(test);
        assertEquals(expected, actual);

        test = 360;
        actual = enzo.handSteering(test);
        assertEquals(expected, actual);

        test = -360;
        actual = enzo.handSteering(test);
        assertEquals(expected, actual);

        test = 361;
        actual = enzo.handSteering(test);
        assertEquals(expected, actual);

        test = -361;
        actual = enzo.handSteering(test);
        assertEquals(expected, actual);
    }

    @Test
    void handSteering_negativeSuccess() {

        enzo.setDirection(10);

        int test = -10;
        int expected = 10;
        int actual = enzo.handSteering(test);
        assertEquals(expected, actual);

        test = -355;
        expected = -345;
        enzo.setDirection(10);
        actual = enzo.handSteering(test);
        assertEquals(expected, actual);

        test = -359;
        expected = -9;
        enzo.setDirection(-10);
        actual = enzo.handSteering(test);
        assertEquals(expected, actual);
    }
}