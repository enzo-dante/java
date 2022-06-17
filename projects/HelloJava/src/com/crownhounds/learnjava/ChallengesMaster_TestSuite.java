package com.crownhounds.learnjava;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class ChallengesMaster_TestSuite {

    // CONSTANTS/static class variables assigned FINAL value before instantiation/compilation
    public static final String NOT_IMPLEMENTED_FAIL = "This test is failing because it hasn't been implemented yet";
//    fail(NOT_IMPLEMENTED_FAIL);

    public static final String BEFORE_ALL = "Message @beforeAll tests begin";
    public static final String AFTER_ALL = "All tests have been run";

}

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