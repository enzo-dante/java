package com.crownhounds.challenges;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class ChallengesMaster_TestSuite {

    // CONSTANTS/static class variables assigned FINAL value before instantiation/compilation
    public static final String NOT_IMPLEMENTED_FAIL = "This test is failing because it hasn't been implemented yet";
    public static final String INVALID_VALUE = "Invalid Value";

    public static final String BEFORE_ALL = "Message @beforeAll tests begin";
    public static final String AFTER_ALL = "All tests have been run";

}

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
class AreaCalculatorTest extends ChallengesMaster_TestSuite {

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
class SpeedConverterTest extends ChallengesMaster_TestSuite {

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
class NumberToWordsTest extends ChallengesMaster_TestSuite {

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
// ! OOP INHERITANCE: child subclass inherits class fields + public methods from extending parent superclass
class MegaByteConverterTest extends ChallengesMaster_TestSuite {

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

class BarkingDogTest extends ChallengesMaster_TestSuite {

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