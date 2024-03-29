package com.crownhounds.challenges;

import com.crownhounds.datastructures_and_algorithms.Employee;
import com.crownhounds.datastructures_and_algorithms.Helper;
import org.junit.jupiter.api.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class ChallengesLeetCode_TestSuite {

    // CONSTANTS/static class variables assigned FINAL value before instantiation/compilation
    public static final String NOT_IMPLEMENTED_FAIL = "This test is failing because it hasn't been implemented yet";
    public static final String INVALID_VALUE = "Invalid Value";

    public static final String BEFORE_ALL = "Message @beforeAll tests begin";
    public static final String AFTER_ALL = "All tests have been run";
    public static final String BEFORE_EACH = "Before test, instantiate class";
    public static final String AFTER_EACH = "Test has been run, reset instance to null";
}

class LeetCodeIntegersTest extends ChallengesLeetCode_TestSuite {

    // OOP ENCAPSULATION private class fields
    LeetCodeIntegers leetCodeIntegers;

    @BeforeAll
    static void beforeAll() {
        System.out.println(BEFORE_ALL);
    }

    @BeforeEach
    void setUp() {
        leetCodeIntegers = new LeetCodeIntegers();
    }

    @AfterAll
    static void afterAll() {
        System.out.println(AFTER_ALL);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void singleNumber_alternating() {
        int[] testInput = {4,1,2,1,2};
        int expected = 4;
        int actual = leetCodeIntegers.singleNumber(testInput);
        assertEquals(expected, actual);
    }

    @Test
    void singleNumber_singleInput() {
        int[] testInput = {1};
        int expected = 1;
        int actual = leetCodeIntegers.singleNumber(testInput);
        assertEquals(expected, actual);
    }

    @Test
    void singleNumber_repeatingInput() {
        int[] testInput = {2,2,1};
        int expected = 1;
        int actual = leetCodeIntegers.singleNumber(testInput);
        assertEquals(expected, actual);
    }

    @Test
    void singleNumber_badInput() {
        int[] testInput = {};
        int expected = -1;
        int actual = leetCodeIntegers.singleNumber(testInput);
        assertEquals(expected, actual);
    }

    @Test
    void reverseInteger_positiveInput() {
        int testInput = 123;

        int expected = 321;
        int actual = leetCodeIntegers.reverseInteger(testInput);
        assertEquals(expected, actual);
    }

    @Test
    void reverseInteger_negativeInput() {
        int testInput = -123;

        int expected = -321;
        int actual = leetCodeIntegers.reverseInteger(testInput);
        assertEquals(expected, actual);
    }

    @Test
    void reverseInteger_smallerOutput() {
        int testInput = 120;

        int expected = 21;
        int actual = leetCodeIntegers.reverseInteger(testInput);
        assertEquals(expected, actual);
    }
}

class LeetCodeStringsTest extends ChallengesLeetCode_TestSuite {

    // OOP ENCAPSULATION private class fields
    LeetCodeStrings leetCodeStrings;

    @BeforeAll
    static void beforeAll() {
        System.out.println(BEFORE_ALL);
    }

    @BeforeEach
    void setUp() {
        leetCodeStrings = new LeetCodeStrings();
    }

    @AfterAll
    static void afterAll() {
        System.out.println(AFTER_ALL);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void fizzBuzz_0() {

        ArrayList<String> actualValues = leetCodeStrings.fizzBuzz(-3);
        assertEquals(null, actualValues);
    }

    @Test
    void fizzBuzz_3() {

        ArrayList<String> actualValues = leetCodeStrings.fizzBuzz(3);

        ArrayList<String> expectedValues = new ArrayList<>();
        expectedValues.add("1");
        expectedValues.add("2");
        expectedValues.add("Fizz");

        assertEquals(expectedValues, actualValues);
    }

    @Test
    void fizzBuzz_5() {

        ArrayList<String> actualValues = leetCodeStrings.fizzBuzz(5);

        ArrayList<String> expectedValues = new ArrayList<>();
        expectedValues.add("1");
        expectedValues.add("2");
        expectedValues.add("Fizz");
        expectedValues.add("4");
        expectedValues.add("Buzz");

        assertEquals(expectedValues, actualValues);
    }

    @Test
    void fizzBuzz_3And5() {

        ArrayList<String> actualValues = leetCodeStrings.fizzBuzz(15);

        ArrayList<String> expectedValues = new ArrayList<>();
        expectedValues.add("1");
        expectedValues.add("2");
        expectedValues.add("Fizz");
        expectedValues.add("4");
        expectedValues.add("Buzz");

        expectedValues.add("Fizz");
        expectedValues.add("7");
        expectedValues.add("8");
        expectedValues.add("Fizz");
        expectedValues.add("Buzz");

        expectedValues.add("11");
        expectedValues.add("Fizz");
        expectedValues.add("13");
        expectedValues.add("14");
        expectedValues.add("FizzBuzz");

        assertEquals(expectedValues, actualValues);
    }

    @Test
    void isPalindrome_true() {
        boolean actualValue = leetCodeStrings.isPalindrome(101);
        assertEquals(true, actualValue);
    }

    @Test
    void isPalindrome_false() {

        boolean actualValue;

        actualValue = leetCodeStrings.isPalindrome(98);
        assertEquals(false, actualValue);

        actualValue = leetCodeStrings.isPalindrome(-22);
        assertEquals(false, actualValue);
    }

    @Test
    void trailingZeroFactorial_null() {
        Integer actualValue;
        Integer expectedValue;

        actualValue = leetCodeStrings.trailingZeroFactorial(-5);
        expectedValue = -1;
        assertEquals(expectedValue, actualValue, 0);
    }

    @Test
    void trailingZeroFactorial_one() {
        Integer actualValue;
        Integer expectedValue;

        actualValue = leetCodeStrings.trailingZeroFactorial(5);
        expectedValue = 1;
        assertEquals(expectedValue, actualValue, 0);
    }

    @Test
    void trailingZeroFactorial_many() {
        Integer actualValue;
        Integer expectedValue;

        actualValue = leetCodeStrings.trailingZeroFactorial(15);
        expectedValue = 3;
        assertEquals(expectedValue, actualValue, 0);
    }

    @Test
    void reverseString_null() {
        String actualValue;
        String expectedValue;

        actualValue = leetCodeStrings.reverseString("");
        assertEquals(null, actualValue);
    }

    @Test
    void reverseString_success() {
        String actualValue;
        String expectedValue;

        actualValue = leetCodeStrings.reverseString("abcde");
        expectedValue = "edcba";
        assertEquals(expectedValue, actualValue);
    }

    @Test
    void reverseString_fail() {
        String actualValue;
        String expectedValue;

        actualValue = leetCodeStrings.reverseString(NOT_IMPLEMENTED_FAIL);
        expectedValue = INVALID_VALUE;
        assertNotEquals(expectedValue, actualValue);
    }

    @Test
    void power_success() {
        double actualValue;
        double expectedValue;

        actualValue = leetCodeStrings.power(2.1, 3L);
        expectedValue = 9.261;
        assertEquals(expectedValue, actualValue, 0.1);
    }

    @Test
    void power_invalid() {
        double actualValue;
        double expectedValue;

        actualValue = leetCodeStrings.power(0, 3L);
        expectedValue = -1D;
        assertEquals(expectedValue, actualValue);
    }

    @Test
    void power_negative() {
        double actualValue;
        double expectedValue;

        actualValue = leetCodeStrings.power(2.1, -3L);
        expectedValue = 1 / 9.261;
        assertEquals(expectedValue, actualValue, 0.001);
    }

    @Test
    void power_fail() {
        double actualValue;
        double expectedValue;

        actualValue = leetCodeStrings.power(1.1, 3L);
        expectedValue = 9.261;
        assertNotEquals(expectedValue, actualValue, 0.1);
    }

    @Test
    void longestCommonPrefix_null() {

        String actualValue;

        actualValue = leetCodeStrings.longestCommonPrefix(new ArrayList<>());
        assertEquals(null, actualValue);
    }

    @Test
    void longestCommonPrefix_success() {

        String actualValue;
        String expectedValue;

        ArrayList<String> data = new ArrayList<>();
        data.add("bear");
        data.add("beaver");
        data.add("beat");
        data.add("bee");

        actualValue = leetCodeStrings.longestCommonPrefix(data);
        expectedValue = "be";
        assertEquals(expectedValue, actualValue);
    }

    @Test
    void longestCommonPrefix_fail() {

        String actualValue;
        String expectedValue;

        ArrayList<String> data = new ArrayList<>();
        data.add("test");
        data.add("game");
        data.add("preview");
        data.add("summer");

        actualValue = leetCodeStrings.longestCommonPrefix(data);
        expectedValue = "pre";
        assertNotEquals(expectedValue, actualValue);
    }

    @Test
    void findRepeatDNA_null() {
        String test = "abcefghijkl";
        List<String> actualResults = leetCodeStrings.findRepeatDNA(test);
        List<String> expectedResults = new ArrayList<String>();

        assertEquals(expectedResults, actualResults);
    }

    @Test
    void findRepeatDNA_success() {
        String test = "AAAAAAAAAAA";
        List<String> actualResults = leetCodeStrings.findRepeatDNA(test);
        List<String> expectedResults = new ArrayList<String>();
        expectedResults.add("AAAAAAAAAA");

        assertEquals(expectedResults, actualResults);
    }

    @Test
    void longestSubstring_b() {
        String test = "bbbb";

        Integer actualResult = leetCodeStrings.longestSubstring(test);
        Integer expectedResult = 1; // "b"
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void longestSubstring_wke() {
        String test = "pwwkew";

        Integer actualResult = leetCodeStrings.longestSubstring(test);
        Integer expectedResult = 3; // "wke" || "kew"
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void longestSubstring_badInput() {
        String test = "";

        Integer actualResult = leetCodeStrings.longestSubstring(test);
        Integer expectedResult = -1;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void decodeString_success() {
        String test = "3[a2[c]]";
        String actualResult = leetCodeStrings.decodeString(test);
        String expectedResult = "accaccacc";
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void decodeString_fail() {
        String test = "3[a4[c]]";
        String actualResult = leetCodeStrings.decodeString(test);
        String expectedResult = "accaccacc";
        assertNotEquals(expectedResult, actualResult);
    }

    @Test
    void decodeString_badInput() {
        String input = "";
        String actualResult = leetCodeStrings.decodeString(input);
        assertNull(actualResult);
    }

    @Test
    void longestValidParentheses_sequence() {
        String test = ")()())";
        Integer actualResult = leetCodeStrings.longestValidParentheses(test);
        Integer expectedResult = 4;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void longestValidParentheses_nested() {
        String test = "())((())";
        Integer actualResult = leetCodeStrings.longestValidParentheses(test);
        Integer expectedResult = 4;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void longestValidParentheses_badInput() {
        String test = "";
        Integer actualResult = leetCodeStrings.longestValidParentheses(test);
        Integer expectedResult = -1;
        assertEquals(expectedResult, actualResult);
    }
    @Test
    void groupAnagrams_success() {
        ArrayList<String> testInput = new ArrayList<>();
        testInput.add("eat");
        testInput.add("tea");
        testInput.add("tan");
        testInput.add("ate");
        testInput.add("nat");
        testInput.add("bat");

        List<List<String>> expected = new ArrayList<>();
        ArrayList<String> e1 = new ArrayList<>();
        e1.add("eat");
        e1.add("tea");
        e1.add("ate");

        ArrayList<String> e3 = new ArrayList<>();
        e3.add("tan");
        e3.add("nat");

        ArrayList<String> e2 = new ArrayList<>();
        e2.add("bat");

        expected.add(e1);
        expected.add(e2);
        expected.add(e3);

        List<List<String>> actual = leetCodeStrings.groupAnagrams(testInput);
        assertEquals(expected, actual);
    }

    @Test
    void groupAnagrams_badInput() {
        ArrayList<String> testInput = new ArrayList<>();

        List<List<String>> actual = leetCodeStrings.groupAnagrams(testInput);
        assertNull(actual);
    }

    @Test
    void validParenthesis_success() {
        String testInput = "()";
        assertTrue(leetCodeStrings.validParenthesis(testInput));
    }

    @Test
    void validParenthesis_fail() {
        String testInput = "(}";
        assertFalse(leetCodeStrings.validParenthesis(testInput));
    }

    @Test
    void validParenthesis_different() {
        String testInput = "()[]{}";
        assertTrue(leetCodeStrings.validParenthesis(testInput));
    }

    @Test
    void validParenthesis_badInput() {
        String testInput = "";
        assertFalse(leetCodeStrings.validParenthesis(testInput));
    }
}

class LeetCodeArrayTest extends ChallengesLeetCode_TestSuite {

    // OOP ENCAPSULATION private class fields
    private LeetCodeArrays leetCodeArrays;

    @BeforeAll
    static void beforeAll() {
        System.out.println(BEFORE_ALL);
    }

    @BeforeEach
    void setUp() {
        leetCodeArrays = new LeetCodeArrays();
        System.out.println(BEFORE_EACH);
    }

    @AfterAll
    static void afterAll() {
        System.out.println(AFTER_ALL);
    }

    @AfterEach
    void tearDown() {
        leetCodeArrays = null;
        System.out.println(AFTER_EACH);
    }

    @Test
    void twoSums_success() {
        ArrayList<Integer> test = new ArrayList<>();
        test.add(2); test.add(7); test.add(11); test.add(15);
        int target = 9;

        ArrayList<Integer> expectedResults = new ArrayList<>();
        expectedResults.add(0); expectedResults.add(1);

        ArrayList<Integer> actualResults = leetCodeArrays.twoSums(test, target);
        assertEquals(expectedResults, actualResults);
    }

    @Test
    void twoSums_fail() {
        ArrayList<Integer> test = new ArrayList<>();
        test.add(2); test.add(7); test.add(11); test.add(15);
        int target = 10;

        ArrayList<Integer> expectedResults = new ArrayList<>();
        expectedResults.add(0); expectedResults.add(1);

        ArrayList<Integer> actualResults = leetCodeArrays.twoSums(test, target);
        assertNotEquals(expectedResults, actualResults);
    }

    @Test
    void twoSums_null() {
        ArrayList<Integer> test = new ArrayList<>();
        int target = 9;

        ArrayList<Integer> actualResults =leetCodeArrays.twoSums(test, target);
        assertNull(actualResults);
    }

    @Test
    void containsDuplicate_true() {
        int[] test = {1,2,3,4,3};
        boolean actualResult = leetCodeArrays.containsDuplicate(test);
        assertTrue(actualResult);
    }

    @Test
    void containsDuplicate_false() {
        int[] test = {1,2,3,4,5};
        boolean actualResult = leetCodeArrays.containsDuplicate(test);
        assertFalse(actualResult);
    }

    @Test
    void containsDuplicate_null() {
        int[] test = {};
        boolean actualResult = leetCodeArrays.containsDuplicate(test);
        assertFalse(actualResult);
    }

    @Test
    void canPlaceFlowers_true() {
        int[] test = {1,0,0,0,1};
        int n = 1;
        boolean actualResult = leetCodeArrays.canPlaceFlowers(test, n);
        assertTrue(actualResult);
    }

    @Test
    void canPlaceFlowers_false() {
        int[] test = {1,0,0,0,1};
        int n = 2;
        boolean actualResult = leetCodeArrays.canPlaceFlowers(test, n);
        assertFalse(actualResult);
    }

    @Test
    void canPlaceFlowers_nullInputArray() {
        int[] test = {};
        int n = 1;
        boolean actualResult = leetCodeArrays.canPlaceFlowers(test, n);
        assertFalse(actualResult);
    }

    @Test
    void canPlaceFlowers_badInputN() {
        int[] test = {1,0,0,0,1};
        int n = 0;
        boolean actualResult = leetCodeArrays.canPlaceFlowers(test, n);
        assertFalse(actualResult);
    }

    @Test
    void bestBuySellStockII_success() {
        int[] test = {7,1,5,3,6,4};

        int expectedResult = 7;
        int actualResult = leetCodeArrays.bestBuySellStockII(test);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void bestBuySellStockII_fail() {
        int[] test = {7,1,5,3,6,4};

        int expectedResult = 8;
        int actualResult = leetCodeArrays.bestBuySellStockII(test);
        assertNotEquals(expectedResult, actualResult);
    }

    @Test
    void bestBuySellStockII_badInput() {
        int[] test = {};

        int expectedResult = -1;
        int actualResult = leetCodeArrays.bestBuySellStockII(test);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void jumpGame_true() {
        int[] test = {2,3,1,1,4};
        boolean actualResult = leetCodeArrays.jumpGame(test);
        assertTrue(actualResult);
    }

    @Test
    void jumpGame_false() {
        int[] test = {3,2,1,0,4};
        boolean actualResult = leetCodeArrays.jumpGame(test);
        assertFalse(actualResult);
    }

    @Test
    void jumpGame_nullInputArray() {
        int[] test = {};
        boolean actualResult = leetCodeArrays.jumpGame(test);
        assertFalse(actualResult);
    }

    @Test
    void plusOne_success200() {
        int[] test = {1,9,9};
        int[] expectedResult = {2,0,0};
        int[] actualResult = leetCodeArrays.plusOne(test);
        assertEquals(Arrays.toString(expectedResult), Arrays.toString(actualResult));
    }

    @Test
    void plusOne_success1000() {
        int[] test = {1,9,9,9};
        int[] expectedResult = {2,0,0,0};
        int[] actualResult = leetCodeArrays.plusOne(test);
        assertEquals(Arrays.toString(expectedResult), Arrays.toString(actualResult));
    }

    @Test
    void plusOne_fail() {
        int[] test = {2,2, 3};
        int[] expectedResult = {1,2,4};
        int[] actualResult = leetCodeArrays.plusOne(test);
        assertNotEquals(Arrays.toString(expectedResult), Arrays.toString(actualResult));
    }

    @Test
    void plusOne_badInput() {
        int[] test = {};
        assertNull(leetCodeArrays.plusOne(test));
    }

    @Test
    void findAllNumbersDisappearedInAnArray_success() {
        int[] test = {1,2,2,4,1};

        List<Integer> expectedResults = new ArrayList<>();
        expectedResults.add(3);
        expectedResults.add(5);

        List<Integer> actualResults = leetCodeArrays.findAllNumbersDisappearedInAnArray(test);
        assertEquals(expectedResults, actualResults);
    }

    @Test
    void findAllNumbersDisappearedInAnArray_fail() {
        int[] test = {1,3,2,4,1};

        List<Integer> unexpectedResults = new ArrayList<>();
        unexpectedResults.add(3);
        unexpectedResults.add(5);

        List<Integer> actualResults = leetCodeArrays.findAllNumbersDisappearedInAnArray(test);
        assertNotEquals(unexpectedResults, actualResults);
    }

    @Test
    void findAllNumbersDisappearedInAnArray_badInput() {
        int[] test = {};
        assertNull(leetCodeArrays.findAllNumbersDisappearedInAnArray(test));
    }

    @Test
    void minDominoesForEqualRow_successA() {
        int[] testA = {2,1,2,4,2,2};
        int[] testB = {5,2,6,2,3,2};
        int expectedResult = 2;
        int actualResult = leetCodeArrays.minDominoForEqualRow(testA, testB);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void minDominoesForEqualRow_fail() {
        int[] testA = {3,5,1,2,3};
        int[] testB = {3,6,3,3,4};
        int expectedResult = -1;
        int actualResult = leetCodeArrays.minDominoForEqualRow(testA, testB);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void minDominoesForEqualRow_badInput() {
        int[] testA = {};
        int[] testB = {};
        int expectedResult = -1;
        int actualResult = leetCodeArrays.minDominoForEqualRow(testA, testB);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void slidingMaxWindow_success() {
        int[] testArray = {1,3,-1,-3,-4,3,6,7};
        int testK = 3;

        int[] expected = {3,3,-1,3,6,7};
        int[] actual = leetCodeArrays.slidingMaxWindow(testArray, testK);
        assertEquals(Arrays.toString(expected), Arrays.toString(actual));
    }

    @Test
    void slidingMaxWindow_fail() {
        int[] testArray = {1,3,-1,-3,5,3,6,7};
        int testK = 4;

        int[] expected = {3,3,5,5,6,7};
        int[] actual = leetCodeArrays.slidingMaxWindow(testArray, testK);
        assertNotEquals(Arrays.toString(expected), Arrays.toString(actual));
    }

    @Test
    void slidingMaxWindow_badInput() {
        int[] testArray = {};
        int testK = -1;

        int[] actual = leetCodeArrays.slidingMaxWindow(testArray, testK);
        assertNull(actual);
    }

    @Test
    void lengthOfLastWord_success() {
        String test = " the sky  is blue  ";

        int expected = 4;
        int actual = leetCodeArrays.lengthOfLastWord(test.trim());

        assertEquals(expected, actual);
    }

    @Test
    void lengthOfLastWord_badInput1() {
        String test = "";

        int expected = -1;
        int actual = leetCodeArrays.lengthOfLastWord(test.trim());

        assertEquals(expected, actual);
    }

    @Test
    void lengthOfLastWord_badInput2() {
        String test = " ";

        int expected = -1;
        int actual = leetCodeArrays.lengthOfLastWord(test.trim());

        assertEquals(expected, actual);
    }

    @Test
    void sequentialDigits_success() {
        int inputLow = 100;
        int inputHigh = 300;

        List<Integer> expected = new ArrayList<>();
        expected.add(123);
        expected.add(234);

        List<Integer> actual = LeetCodeArrays.sequentialDigits(inputLow, inputHigh);
        assert actual != null;
        assertArrayEquals(expected.toArray(), actual.toArray());

        inputLow = 1000;
        inputHigh = 13000;

        expected = new ArrayList<>();
        expected.add(1234);
        expected.add(2345);
        expected.add(3456);
        expected.add(4567);
        expected.add(5678);
        expected.add(6789);
        expected.add(12345);

        actual = LeetCodeArrays.sequentialDigits(inputLow, inputHigh);
        assert actual != null;
        assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @Test
    void sequentialDigits_none() {
        int inputLow = 1;
        int inputHigh = 1;

        List<Integer> expected = new ArrayList<>();
        expected.add(123);
        expected.add(234);

        List<Integer> actual = LeetCodeArrays.sequentialDigits(inputLow, inputHigh);
        assertNull(actual);
    }

    @Test
    void sequentialDigits_badInput() {
        int inputLow = -1;
        int inputHigh = 10;

        List<Integer> actual = LeetCodeArrays.sequentialDigits(inputLow, inputHigh);
        assertNull(actual);

        inputLow = 10;
        inputHigh = -1;
        actual = LeetCodeArrays.sequentialDigits(inputLow, inputHigh);
        assertNull(actual);

        inputLow = -1;
        inputHigh = -1;
        actual = LeetCodeArrays.sequentialDigits(inputLow, inputHigh);
        assertNull(actual);
    }

    @Test
    void findAllDuplicates_success() {
        int[] testInput = {1,1,2,3,3};

        ArrayList<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(3);

        ArrayList<Integer> actual = leetCodeArrays.findAllDuplicates(testInput);
        assertEquals(expected, actual);
    }

    @Test
    void findAllDuplicates_none() {
        int[] testInput = {1,2,3};

        ArrayList<Integer> expected = new ArrayList<>();
        ArrayList<Integer> actual = leetCodeArrays.findAllDuplicates(testInput);
        assertEquals(expected, actual);
    }

    @Test
    void findAllDuplicates_badInput() {
        int[] testInput = {};
        ArrayList<Integer> actual = leetCodeArrays.findAllDuplicates(testInput);
        assertNull(actual);
    }

    @Test
    void rotateArray_success() {

        int[] test = {1,2,3,4,5,6,7};
        int rotations = 3;

        int[] expected = {5,6,7,1,2,3,4};

        int[] actual = LeetCodeArrays.rotateArray(test, rotations);
        assertArrayEquals(expected, actual);
    }

    @Test
    void rotateArray_fail_badInput() {
        int[] test = {};
        int rotations = 3;

        int[] actual = LeetCodeArrays.rotateArray(test, rotations);
        assertNull(actual);
    }

    @Test
    void mergeSortedArray_success() {

        int[] input1 = {1,2,3,0,0,0};
        int[] input2 = {2,5,6};
        int m = 3;
        int n = 3;

        int[] expected = {1,2,2,3,5,6};
        int[] actual = LeetCodeArrays.mergeSortedArray(input1, m, input2, n);

        assertArrayEquals(expected, actual);
    }

    @Test
    void mergeSortedArray_fail() {
        int[] input1 = {};
        int[] input2 = {};
        int m = 0;
        int n = 0;

        int[] actual = LeetCodeArrays.mergeSortedArray(input1, m, input2, n);

        assertNull(actual);
    }

    @Test
    void sortColors_success() {
        int[] input = {2,0,2,1,1,0};

        int[] expected = {0,0,1,1,2,2};
        int[] actual = LeetCodeArrays.sortColors(input);
        assertArrayEquals(expected, actual);
    }

    @Test
    void sortColors_fail_badInput() {
        int[] input = {};

        int[] actual = LeetCodeArrays.sortColors(input);
        assertNull(actual);
    }

    @Test
    void jumpGame3_true() {
        int[] input = {4,2,3,0,3,1,2};
        int start = 5;
        boolean actual = LeetCodeArrays.jumpGame3(input, start);
        assertTrue(actual);
    }

    @Test
    void jumpGame3_false() {
        int[] input = {};
        int start = -1;
        boolean actual = LeetCodeArrays.jumpGame3(input, start);
        assertFalse(actual);
    }

    @Test
    void bestBuySellStock_success() {

        int[] input = {7, 1, 5, 3, 6, 4};

        int expected = 5; // 6 - 1
        int actual = LeetCodeArrays.bestStock(input);
        assertEquals(expected, actual);
    }

    @Test
    void bestBuySellStock_badInput() {
        int[] input = {};

        int expected = 0;
        int actual = LeetCodeArrays.bestStock(input);
        assertEquals(expected, actual);
    }

    @Test
    void moveZeroes_success() {
        int[] input = {0,1,0,3,12};

        int[] expected = {1,3,12,0,0};
        LeetCodeArrays.moveZeroes(input);
        assertArrayEquals(expected, input);

        input = new int[] {0};

        expected = new int[] {0};
        LeetCodeArrays.moveZeroes(input);
        assertArrayEquals(expected, input);
    }

    @Test
    void kDiffPairs_success() {
        int[] inputArray = {3,1,4,1,5};
        int k = 2;

        int expected = 2;
        int actual = LeetCodeArrays.kDiffPairs(inputArray, k);
        assertEquals(expected, actual);

        inputArray = new int[]{1,2,3,4,5};
        k = 1;

        expected = 4;
        actual = LeetCodeArrays.kDiffPairs(inputArray, k);
        assertEquals(expected, actual);
    }

    @Test
    void kDiffPairs_fail_badInput() {
        int[] inputArray = {};
        int k = -1;

        int expected = -1;
        int actual = LeetCodeArrays.kDiffPairs(inputArray, k);
        assertEquals(expected, actual);
    }
}

class LeetCodeTwoPointersTest extends ChallengesLeetCode_TestSuite {

    // OOP ENCAPSULATION private class fields
    private LeetCodeTwoPointers leetCodeTwoPointers;

    @BeforeAll
    static void beforeAll() {
        System.out.println(BEFORE_ALL);
    }

    @BeforeEach
    void setUp() {
        leetCodeTwoPointers = new LeetCodeTwoPointers();
        System.out.println(BEFORE_EACH);
    }

    @AfterAll
    static void afterAll() {
        System.out.println(AFTER_ALL);
    }

    @AfterEach
    void tearDown() {
        leetCodeTwoPointers = null;
        System.out.println(AFTER_EACH);
    }

    @Test
    void isSubsequence_success() {
        String test1 = "bcd";
        String test2 = "abcde";

        boolean actual = leetCodeTwoPointers.isSubsequence(test1, test2);
        assertTrue(actual);
    }

    @Test
    void isSubsequence_fail() {
        String test1 = "abc";
        String test2 = "jklm";

        boolean actual = leetCodeTwoPointers.isSubsequence(test1, test2);
        assertFalse(actual);
    }

    @Test
    void isSubsequence_badInput() {
        String test1 = "";
        String test2 = "abc";

        boolean actual = leetCodeTwoPointers.isSubsequence(test1, test2);
        assertFalse(actual);
    }

    @Test
    void trappingRainWater_success() {
        int[] testInput = {0,1,0,2,1,0,1,3,2,1,2,1};
        int expected = 6;
        int actual = leetCodeTwoPointers.trappingRainWater(testInput);
        assertEquals(expected, actual);
    }

    @Test
    void trappingRainWater_fail() {
        int[] testInput = {0,1,0,2,1,0,1,3,2,1,2,1};
        int expected = 5;
        int actual = leetCodeTwoPointers.trappingRainWater(testInput);
        assertNotEquals(expected, actual);
    }

    @Test
    void trappingRainWater_badInputEmpty() {
        int[] testInput = {};
        int expected = -1;
        int actual = leetCodeTwoPointers.trappingRainWater(testInput);
        assertEquals(expected, actual);
    }

    @Test
    void trappingRainWater_badInputNegative() {
        int[] testInput = {0,1,0,2,1,0,1,3,-2,1,2,1};
        int expected = -1;
        int actual = leetCodeTwoPointers.trappingRainWater(testInput);
        assertEquals(expected, actual);
    }

    @Test
    void validPalindrome_true() {
        String testInput = "abcba";

        boolean actual = leetCodeTwoPointers.validPalindrome(testInput);
        assertTrue(actual);
    }

    @Test
    void validPalindrome_false() {
        String testInput = "abcde";

        boolean actual = leetCodeTwoPointers.validPalindrome(testInput);
        assertFalse(actual);
    }

    @Test
    void validPalindrome_ignoreCasing() {
        String testInput = "aBcbA";

        boolean actual = leetCodeTwoPointers.validPalindrome(testInput);
        assertTrue(actual);
    }

    @Test
    void validPalindrome_onlyAlphabet() {
        String testInput = "A man, a plan, a canal: Panama";

        boolean actual = leetCodeTwoPointers.validPalindrome(testInput);
        assertTrue(actual);
    }

    @Test
    void validPalindrome_badInput() {
        String testInput = "";

        boolean actual = leetCodeTwoPointers.validPalindrome(testInput);
        assertFalse(actual);
    }

    @Test
    void squareOfSortedArray_success() {

        int[] testInput = {-4,-1,0,3,10};
        LeetCodeSort leetCodeSort = new LeetCodeSort();
        testInput = leetCodeSort.mergeSort(testInput);

        String expected = Arrays.toString(new int[]{0, 1, 9, 16, 100});
        String actual = Arrays.toString(leetCodeTwoPointers.squareOfSortedArray(testInput));
        assertEquals(expected, actual);
    }

    @Test
    void squareOfSortedArray_badInput() {
        int[] testInput = {};
        int[] actual = leetCodeTwoPointers.squareOfSortedArray(testInput);
        assertNull(actual);

    }
}

class LeetCodeRecursionTest extends ChallengesLeetCode_TestSuite {

    // OOP ENCAPSULATION private class fields
    private LeetCodeRecursion leetCodeRecursion;

    @BeforeAll
    static void beforeAll() {
        System.out.println(BEFORE_ALL);
    }

    @BeforeEach
    void setUp() {
        leetCodeRecursion = new LeetCodeRecursion();
        System.out.println(BEFORE_EACH);
    }

    @AfterAll
    static void afterAll() {
        System.out.println(AFTER_ALL);
    }

    @AfterEach
    void tearDown() {
        leetCodeRecursion = null;
        System.out.println(AFTER_EACH);
    }

    @Test
    void generateParenthesis_success(){
        int test = 2;

        List<String> expected = new ArrayList<>();
        expected.add("(())");
        expected.add("()()");

        List<String> actual = leetCodeRecursion.generateParenthesis(test);
        assertEquals(expected, actual);
    }

    @Test
    void generateParenthesis_fail(){
        int test = 1;

        List<String> expected = new ArrayList<>();
        expected.add("()");

        List<String> actual = leetCodeRecursion.generateParenthesis(test);
        assertEquals(expected, actual);
    }

    @Test
    void generateParenthesis_badInput(){
        int test = 0;
        List<String> actual = leetCodeRecursion.generateParenthesis(test);
        assertNull(actual);
    }

    @Test
    void combineSum_failEmptyInput() {

        int[] integers = {};
        int target = 7;

        List<List<Integer>> actual = leetCodeRecursion.combinationSum(integers, target);
        assertNull(actual);
    }

    @Test
    void combineSum_failBadTarget() {

        int[] integers = {2,3,6,7};
        int target = 0;

        List<List<Integer>> actual = leetCodeRecursion.combinationSum(integers, target);
        assertNull(actual);
    }

    @Test
    void combineSum_failBadInputs() {

        int[] integers = {};
        int target = -1;

        List<List<Integer>> actual = leetCodeRecursion.combinationSum(integers, target);
        assertNull(actual);
    }

    @Test
    void combineSum_success1() {

        int[] integers = {2,3,5};
        int target = 8;

        List expected = new ArrayList<>();
        LinkedList<Integer> row1 = new LinkedList<>();
        row1.add(2);
        row1.add(2);
        row1.add(2);
        row1.add(2);
        expected.add(row1);

        LinkedList<Integer> row2 = new LinkedList<>();
        row2.add(2);
        row2.add(3);
        row2.add(3);
        expected.add(row2);

        LinkedList<Integer> row3 = new LinkedList<>();
        row3.add(3);
        row3.add(5);
        expected.add(row3);

        List<List<Integer>> actual = leetCodeRecursion.combinationSum(integers, target);
        assertEquals(expected, actual);
    }

    @Test
    void combineSum_success2() {

        int[] integers = {2,3,6,7};
        int target = 7;

        List expected = new ArrayList<>();
        LinkedList<Integer> row1 = new LinkedList<>();
        row1.add(2);
        row1.add(2);
        row1.add(3);
        expected.add(row1);

        LinkedList<Integer> row2 = new LinkedList<>();
        row2.add(7);
        expected.add(row2);

        List<List<Integer>> actual = leetCodeRecursion.combinationSum(integers, target);
        assertEquals(expected, actual);
    }
}

class LeetCodeFamousAlgorithmsTest extends ChallengesLeetCode_TestSuite {

    // OOP ENCAPSULATION private class fields
    private LeetCodeFamousAlgorithms leetCodeFamousAlgorithms;

    @BeforeAll
    static void beforeAll() {
        System.out.println(BEFORE_ALL);
    }

    @BeforeEach
    void setUp() {
        leetCodeFamousAlgorithms = new LeetCodeFamousAlgorithms();
        System.out.println(BEFORE_EACH);
    }

    @AfterAll
    static void afterAll() {
        System.out.println(AFTER_ALL);
    }

    @AfterEach
    void tearDown() {
        leetCodeFamousAlgorithms = null;
        System.out.println(AFTER_EACH);
    }

    @Test
    void majorityElement_sucess(){
        int[] test = {2,2,1,1,1,2,2};
        int expected = 2;
        int actual = leetCodeFamousAlgorithms.majorityElement(test);
        assertEquals(expected, actual);
    }

    @Test
    void majorityElement_oneElement(){
        int[] test = {3};
        int expected = 3;
        int actual = leetCodeFamousAlgorithms.majorityElement(test);
        assertEquals(expected, actual);
    }

    @Test
    void majorityElement_badInput(){
        int[] test = {};
        int expected = -1;
        int actual = leetCodeFamousAlgorithms.majorityElement(test);
        assertEquals(expected, actual);
    }
}

class LeetCodeSortTest extends ChallengesLeetCode_TestSuite {

    // OOP ENCAPSULATION private class fields
    private LeetCodeSort leetCodeSort;

    @BeforeAll
    static void beforeAll() {
        System.out.println(BEFORE_ALL);
    }

    @BeforeEach
    void setUp() {
        leetCodeSort = new LeetCodeSort();
        System.out.println(BEFORE_EACH);
    }

    @AfterAll
    static void afterAll() {
        System.out.println(AFTER_ALL);
    }

    @AfterEach
    void tearDown() {
        leetCodeSort = null;
        System.out.println(AFTER_EACH);
    }

    @Test
    void mergeSort_success() {
        int[] testInput = {4,2,5,8,6,9,1};
        int[] expected = {1,2,4,5,6,8,9};
        int[] actual = leetCodeSort.mergeSort(testInput);
        assertEquals(Arrays.toString(expected), Arrays.toString(actual));
    }

    @Test
    void mergeSort_fail() {
        int[] testInput = {4,2,5,8,6,9,1};
        int[] expected = {1,2,4,6,5,8,9};
        int[] actual = leetCodeSort.mergeSort(testInput);
        assertNotEquals(expected, actual);
    }

    @Test
    void mergeSort_badInput() {
        int[] testInput = {};
        int[] actual = leetCodeSort.mergeSort(testInput);
        assertNull(actual);
    }

    @Test
    void quickSort_success() {
        int[] testInput = {8,4,3,6,1,7,2,9,5};
        int[] expected = {1,2,3,4,5,6,7,8,9};
        int[] actual = leetCodeSort.quickSort(testInput, 0 , testInput.length);
        assertEquals(Arrays.toString(expected), Arrays.toString(actual));
    }

    @Test
    void quickSort_fail() {
        int[] testInput = {8,4,3,6,1,7,2,9,5};
        int[] expected = {1,2,3,5,4,6,7,8,9};
        int[] actual = leetCodeSort.quickSort(testInput, 0 , testInput.length);
        assertNotEquals(Arrays.toString(expected), Arrays.toString(actual));
    }

    @Test
    void quickSort_badInput() {
        int[] testInput = {};
        int[] actual = leetCodeSort.quickSort(testInput, 0 , testInput.length);
        assertNull(actual);
    }
}

class LeetCodeArray2DTest extends ChallengesLeetCode_TestSuite {

    // OOP ENCAPSULATION private class fields
    private LeetCodeArray2D leetCodeArray2D;

    @BeforeAll
    static void beforeAll() {
        System.out.println(BEFORE_ALL);
    }

    @BeforeEach
    void setUp() {
        leetCodeArray2D = new LeetCodeArray2D();
        System.out.println(BEFORE_EACH);
    }

    @AfterAll
    static void afterAll() {
        System.out.println(AFTER_ALL);
    }

    @AfterEach
    void tearDown() {
        leetCodeArray2D = null;
        System.out.println(AFTER_EACH);
    }

    @Test
    void rangeSumQuery_success() {
        int[][] testMatrix = {
                {3,0,1,4,2},
                {5,6,3,2,1},
                {1,2,0,1,5},
                {4,1,0,1,7},
                {1,0,3,0,5}
        };
        int[] testUpperLeft = {1,1};
        int[] testLowerRight = {2,2};

        int expected = 11;
        int actual = leetCodeArray2D.rangeSumQuery(testMatrix, testUpperLeft, testLowerRight);
        assertEquals(expected, actual);
    }

    @Test
    void rangeSumQuery_fail() {
        int[][] testMatrix = {
                {3,0,1,4,2},
                {5,6,3,2,1},
                {1,2,0,1,5},
                {4,1,0,1,7},
                {1,0,3,0,5}
        };
        int[] testUpperLeft = {1,1};
        int[] testLowerRight = {2,3};

        int expected = 8;
        int actual = leetCodeArray2D.rangeSumQuery(testMatrix, testUpperLeft, testLowerRight);
        assertNotEquals(expected, actual);
    }

    @Test
    void rangeSumQuery_emptyMatrix() {
        int[][] testMatrix = {};
        int[] testUpperLeft = {1,1};
        int[] testLowerRight = {2,3};

        int expected = -1;
        int actual = leetCodeArray2D.rangeSumQuery(testMatrix, testUpperLeft, testLowerRight);
        assertEquals(expected, actual);
    }

    @Test
    void rangeSumQuery_emptyUpperLeft() {
        int[][] testMatrix = {
                {3,0,1,4,2},
                {5,6,3,2,1},
                {1,2,0,1,5},
                {4,1,0,1,7},
                {1,0,3,0,5}
        };
        int[] testUpperLeft = {};
        int[] testLowerRight = {2,3};

        int expected = -1;
        int actual = leetCodeArray2D.rangeSumQuery(testMatrix, testUpperLeft, testLowerRight);
        assertEquals(expected, actual);
    }

    @Test
    void rangeSumQuery_emptyLowerRight() {
        int[][] testMatrix = {
                {3,0,1,4,2},
                {5,6,3,2,1},
                {1,2,0,1,5},
                {4,1,0,1,7},
                {1,0,3,0,5}
        };
        int[] testUpperLeft = {1,1};
        int[] testLowerRight = {};

        int expected = -1;
        int actual = leetCodeArray2D.rangeSumQuery(testMatrix, testUpperLeft, testLowerRight);
        assertEquals(expected, actual);
    }

    @Test
    void rangeSumQuery_longLowerRight() {
        int[][] testMatrix = {
                {3,0,1,4,2},
                {5,6,3,2,1},
                {1,2,0,1,5},
                {4,1,0,1,7},
                {1,0,3,0,5}
        };
        int[] testUpperLeft = {1,1};
        int[] testLowerRight = {2,3,4};

        int expected = -1;
        int actual = leetCodeArray2D.rangeSumQuery(testMatrix, testUpperLeft, testLowerRight);
        assertEquals(expected, actual);
    }

    @Test
    void rangeSumQuery_longUpperLeft() {
        int[][] testMatrix = {
                {3,0,1,4,2},
                {5,6,3,2,1},
                {1,2,0,1,5},
                {4,1,0,1,7},
                {1,0,3,0,5}
        };
        int[] testUpperLeft = {1,1,1};
        int[] testLowerRight = {2,3};

        int expected = -1;
        int actual = leetCodeArray2D.rangeSumQuery(testMatrix, testUpperLeft, testLowerRight);
        assertEquals(expected, actual);
    }

    @Test
    void mergeIntervals_success() {
        int[][] testInput = new int[4][2];
        testInput[0] = new int[]{1,3};
        testInput[1] = new int[]{2,6};
        testInput[2] = new int[]{8,10};
        testInput[3] = new int[]{15,18};

        int[][] expected = {
                {1,6},
                {8,10},
                {15,18}
        };

        int[][] actual = leetCodeArray2D.mergeIntervals(testInput);
        boolean isEqual = Objects.deepEquals(expected, actual);
        assertTrue(isEqual);
    }

    @Test
    void searchAMatrix_true() {

        int target = 3;
        int[][] input = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        };

        boolean actual = LeetCodeArray2D.searchAMatrix(input, target);
        assertTrue(actual);

        target = 20;
        actual = LeetCodeArray2D.searchAMatrix(input, target);
        assertTrue(actual);

        target = 23;
        actual = LeetCodeArray2D.searchAMatrix(input, target);
        assertTrue(actual);
    }

    @Test
    void searchAMatrix_false() {

        int target = 13;
        int[][] input = {
                {1, 4, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        };

        boolean actual = LeetCodeArray2D.searchAMatrix(input, target);
        assertFalse(actual);
    }

    @Test
    void searchAMatrix_falseBadInput() {

        int target = 3;
        int[][] input = {};

        boolean actual = LeetCodeArray2D.searchAMatrix(input, target);
        assertFalse(actual);

        input = new int[][]{
                {1, 4, 5, 7},
                {10, 16, 20},
                {23, 30, 34, 50}
        };

        actual = LeetCodeArray2D.searchAMatrix(input, target);
        assertFalse(actual);
    }

    @Test
    void rotateImage_success3x3() {

        int[][] test = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };

        int[][] expected = {
                {7,4,1},
                {8,5,2},
                {9,6,3}
        };

        int[][] actual = LeetCodeArray2D.rotateImage(test);
        assertArrayEquals(expected, actual);
    }
    @Test
    void rotateImage_success4x4() {

        int[][] test = {
                {5, 1, 9, 11},
                {2, 4, 8, 10},
                {13, 3, 6, 7},
                {15, 14, 12, 16},
        };

        int[][] expected = {
                {15, 13, 2, 5},
                {14, 3, 4 ,1},
                {12, 6, 8,9},
                {16, 7, 10, 11},
        };

        int[][] actual = LeetCodeArray2D.rotateImage(test);
        assertArrayEquals(expected, actual);
    }

    @Test
    void rotateImage_failBadInput() {
        int[][] test = {};

        int[][] actual = LeetCodeArray2D.rotateImage(test);
        assertNull(actual);

        test = new int[][] {
                {7,4},
                {8,5,2},
                {9,6,3}
        };
        actual = LeetCodeArray2D.rotateImage(test);
        assertNull(actual);
    }

    @Test
    void matrixDiagonalSum_success() {
        int[][] test = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };

        int expected = 25;
        int actual = LeetCodeArray2D.matrixDiagonalSum(test);
        assertEquals(expected, actual);
    }

    @Test
    void matrixDiagonalSum_fail_badInput() {
        int[][] test = {};

        int expected = -1;
        int actual = LeetCodeArray2D.matrixDiagonalSum(test);
        assertEquals(expected, actual);
    }
}

class LeetCodeLinkedListTest extends ChallengesLeetCode_TestSuite {

    // OOP ENCAPSULATION private class fields
    private LeetCodeLinkedList leetCodeLinkedList;
    private LeetCodeLinkedList.SinglyLinkedList singlyLinkedList;
    private LinkedListNode<Integer> testNode;

    @BeforeAll
    static void beforeAll() {
        System.out.println(BEFORE_ALL);
    }

    @BeforeEach
    void setUp() {
        leetCodeLinkedList = new LeetCodeLinkedList();
        singlyLinkedList = leetCodeLinkedList.new SinglyLinkedList();

        MinStack minStack = new MinStack();

        int testInput = 5;
        testNode = minStack.push(testInput);

        testInput = 4;
        testNode = minStack.push(testInput);

        testInput = 3;
        testNode = minStack.push(testInput);

        testInput = 2;
        testNode = minStack.push(testInput);

        testInput = 1;
        testNode = minStack.push(testInput);

        System.out.println(BEFORE_EACH);
    }

    @AfterAll
    static void afterAll() {
        System.out.println(AFTER_ALL);
    }

    @AfterEach
    void tearDown() {
        leetCodeLinkedList = null;
        System.out.println(AFTER_EACH);
    }

    @Test
    void getMiddleLinkedList_success() {
        // ! GENERICS: improve OOP ENCAPSULATION by creating classes, interfaces, & methods that only take a specific dataType parameter
        LinkedList<Integer> test = new LinkedList<>();
        test.add(1);
        test.add(2);
        test.add(3);
        test.add(4);
        test.add(5);

        LinkedList<Integer> expected = new LinkedList<>();
        expected.add(3);
        expected.add(4);
        expected.add(5);

        LinkedList<Integer> actual = leetCodeLinkedList.getMiddleLinkedList(test);
        assertEquals(expected, actual);
    }

    @Test
    void getMiddleLinkedList_badInput() {
        // ! GENERICS: improve OOP ENCAPSULATION by creating classes, interfaces, & methods that only take a specific dataType parameter
        LinkedList<Integer> test = new LinkedList<>();

        LinkedList<Integer> actual = leetCodeLinkedList.getMiddleLinkedList(test);
        assertNull(actual);
    }

    @Test
    void hasCycle_true(){
        // ! GENERICS: improve OOP ENCAPSULATION by enforcing a parameter dataType for a class, interface, or method
        LeetCodeLinkedList.CircularLinkedList test = leetCodeLinkedList.new CircularLinkedList();
        test.add(1);
        test.add(2);
        test.add(3);
        test.add(4);
        test.add(5);

        boolean actual = test.hasCycle();
        assertTrue(actual);
    }

    @Test
    void hasCycle_badInput(){
        // ! GENERICS: improve OOP ENCAPSULATION by enforcing a parameter dataType for a class, interface, or method
        LeetCodeLinkedList.CircularLinkedList test = leetCodeLinkedList.new CircularLinkedList();
        boolean actual = test.hasCycle();
        assertFalse(actual);
    }

    @Test
    void singlyLinkedList_addToHead_empty() {
        Employee[] employees = Helper.getEmployees();

        singlyLinkedList.addToHead(employees[0]);

        assertEquals(employees[0], singlyLinkedList.getHead().getEmployee());
        singlyLinkedList.printList();
    }

    @Test
    void singlyLinkedList_addToHead_populated() {
        Employee[] employees = Helper.getEmployees();

        singlyLinkedList.addToHead(employees[0]);
        singlyLinkedList.addToHead(employees[1]);
        singlyLinkedList.addToHead(employees[2]);

        assertEquals(employees[2], singlyLinkedList.getHead().getEmployee());
        singlyLinkedList.printList();
    }

    @Test
    void singlyLinkedList_getSize() {
        Employee[] employees = Helper.getEmployees();

        singlyLinkedList.addToHead(employees[0]);
        singlyLinkedList.addToHead(employees[1]);
        singlyLinkedList.addToHead(employees[2]);

        int expected = 3;
        int actual = singlyLinkedList.getSize();
        assertEquals(expected, actual);
    }

    @Test
    void singlyLinkedList_getSize_empty() {
        int expected = 0;
        int actual = singlyLinkedList.getSize();
        assertEquals(expected, actual);
    }

    @Test
    void singlyLinkedList_pop_success() {
        Employee[] employees = Helper.getEmployees();

        singlyLinkedList.addToHead(employees[0]);
        singlyLinkedList.addToHead(employees[1]);
        singlyLinkedList.addToHead(employees[2]);

        Employee expected = employees[2];
        assertEquals(expected, singlyLinkedList.pop().getEmployee());
        assertEquals(2, singlyLinkedList.getSize());
    }

    @Test
    void singlyLinkedList_pop_null() {
        assertNull(singlyLinkedList.pop());
    }

    @Test
    void singlyLinkedList_getHead_empty() {
        assertNull(singlyLinkedList.getHead());
    }

    @Test
    void singlyLinkedList_getHead_success() {
        Employee[] employees = Helper.getEmployees();

        singlyLinkedList.addToHead(employees[0]);
        singlyLinkedList.addToHead(employees[1]);
        singlyLinkedList.addToHead(employees[2]);

        Employee expected = employees[2];
        assertEquals(expected, singlyLinkedList.getHead().getEmployee());
    }
}

class MinStackTest extends ChallengesLeetCode_TestSuite {

    // ! OOP ENCAPSULATION: access-modifier protected object instance members/class fields from inappropriate external access
    // ! ACCESS-MODIFIER private: limit the accessibility of method/variable within scope of defined class and exclude external access
    // private class fields
    private MinStack minStack;
    private LinkedListNode<Integer> expected;
    private LinkedListNode<Integer> actual;
    private Integer testInput;

    @BeforeAll
    static void beforeAll() {
        System.out.println(BEFORE_ALL);
    }

    @BeforeEach
    void setUp() {
        System.out.println(BEFORE_EACH);

        minStack = new MinStack();

        testInput = 3;
        actual = minStack.push(testInput);

        testInput = 2;
        actual = minStack.push(testInput);

        testInput = 1;
        actual = minStack.push(testInput);
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
    void minStack_pushEmpty() {

        minStack = new MinStack();

        testInput = 1;

        expected = minStack.push(testInput);
        actual = minStack.push(testInput);
        assertEquals(expected.getValue(), actual.getValue());
    }

    @Test
    void minStack_pushFilled() {

        minStack = new MinStack();

        expected = new LinkedListNode<>(1, 1);
        expected.setNext(new LinkedListNode<>(2, 2));
//        expected.next.next = new LinkedListNode<>(3, 3);
        expected.getNext().setNext(new LinkedListNode<>(3, 3));

        testInput = 3;
        actual = minStack.push(testInput);

        testInput = 2;
        actual = minStack.push(testInput);

        testInput = 1;
        actual = minStack.push(testInput);

        assertEquals(expected.getValue(), actual.getValue());
        assertEquals(expected.getNext().getValue(), 2);
        assertEquals(expected.getNext().getNext().getValue(), 3);
    }

    @Test
    void minStack_popNull() {
        minStack = new MinStack();
        actual = minStack.pop();
        assertNull(actual);
    }

    @Test
    void minStack_pop() {
        expected = new LinkedListNode<>(1, 1);
        actual = minStack.pop();
        assertEquals(expected.getValue(), actual.getValue());
        assertEquals(2, minStack.getHead().getValue());
    }

    @Test
    void minStack_topNull() {
        minStack = new MinStack();
        actual = minStack.pop();
        assertNull(actual);
    }

    @Test
    void minStack_top() {
        expected = new LinkedListNode<>(1, 1);
        actual = minStack.pop();
        assertEquals(expected.getValue(), actual.getValue());
    }

    @Test
    void minStack_getMin() {

        minStack = new MinStack();

        testInput = 2;
        actual = minStack.push(testInput);

        testInput = 1;
        actual = minStack.push(testInput);

        testInput = 3;
        actual = minStack.push(testInput);

        // ! AUTOBOXING: casting primitive dataType -> greater functionality Wrapper class dataType
        Integer expected = 1;
        Integer actual = minStack.getMin();
        assertEquals(expected, actual);
    }

    @Test
    void minStack_getMinEmpty() {

        // ! AUTOBOXING: casting primitive dataType -> greater functionality Wrapper class dataType
        Integer expected = -1;

        minStack = new MinStack();
        Integer actual = minStack.getMin();
        assertEquals(expected, actual);
    }
}

class LeetCodeBinarySearchTest extends ChallengesLeetCode_TestSuite {

    @BeforeAll
    static void beforeAll() {
        System.out.println(BEFORE_ALL);
    }

    @BeforeEach
    void setUp() {
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
    void binarySearch_success() {
        int[] nums = {1,2,3,4,5,6,7,8,11,13,14,17};
        int target = 11;

        Integer expectedResult = 8;
        Integer actualResult = LeetCodeBinarySearch.binarySearch(nums, target);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void binarySearch_badInput() {
        int[] nums = {};
        int target = 11;

        Integer expectedResult = -1;
        Integer actualResult = LeetCodeBinarySearch.binarySearch(nums, target);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void searchRotatedArray_success() {
        int[] inputArray = {4,5,6,7,0,1,2};
        int target = 0;

        int expected = 4;
        int actual = LeetCodeBinarySearch.searchRotatedArray(inputArray, target);
        assertEquals(expected, actual);
    }

    @Test
    void searchRotatedArray_fail_badInput() {
        int[] inputArray = {};
        int target = -1;

        int expected = -1;
        int actual = LeetCodeBinarySearch.searchRotatedArray(inputArray, target);
        assertEquals(expected, actual);
    }
}


