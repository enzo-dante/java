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
    void binarySearch_success() {
        int[] nums = {1,2,3,4,5,6,7,8,11,13,14,17};
        int target = 11;

        Integer expectedResult = 8;
        Integer actualResult = leetCodeStrings.binarySearch(nums, target);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void binarySearch_badInput() {
        int[] nums = {};
        int target = 11;

        Integer expectedResult = -1;
        Integer actualResult = leetCodeStrings.binarySearch(nums, target);
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

        List<Integer> expected = new ArrayList<>();
        expected.add(123);
        expected.add(234);

        List<Integer> actual = leetCodeArrays.sequentialDigits(100, 300);
        assertEquals(expected, actual);
    }

    @Test
    void sequentialDigits_none() {
        List<Integer> actual = leetCodeArrays.sequentialDigits(1, 9);
        assertNull(actual);

        actual = leetCodeArrays.sequentialDigits(-10, 10);
        assertNull(actual);
    }

    @Test
    void sequentialDigits_badInput() {
        List<Integer> actual = leetCodeArrays.sequentialDigits(200, 100);
        assertNull(actual);

        actual = leetCodeArrays.sequentialDigits(200, 200);
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

}

class LeetCodeLinkedListTest extends ChallengesLeetCode_TestSuite {

    // OOP ENCAPSULATION private class fields
    private LeetCodeLinkedList leetCodeLinkedList;
    private LeetCodeLinkedList.SinglyLinkedList singlyLinkedList;

    @BeforeAll
    static void beforeAll() {
        System.out.println(BEFORE_ALL);
    }

    @BeforeEach
    void setUp() {
        leetCodeLinkedList = new LeetCodeLinkedList();
        singlyLinkedList = leetCodeLinkedList.new SinglyLinkedList();

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

    @Test
    void addTwoNumbers_success() {

        fail(NOT_IMPLEMENTED_FAIL);
    }

    @Test
    void addTwoNumbers_fail() {

        fail(NOT_IMPLEMENTED_FAIL);
    }
}