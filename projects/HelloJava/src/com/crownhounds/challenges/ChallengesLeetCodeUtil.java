package com.crownhounds.challenges;

import com.crownhounds.datastructures_and_algorithms.Employee;

import java.util.*;

public class ChallengesLeetCodeUtil {

    /**
     * ? LeetCode n:
     *
     * ?
     *
     * * Logic:
     *
     * * O() TIME COMPLEXITY:
     * * O() SPACE COMPLEXITY:
     */

    public static void main(String[] args) {

    }
}

class LeetCodeIntegers extends ChallengesLeetCodeUtil {

    /**
     * ? LeetCode 136: Amazon
     *
     * ? Given a non-empty array of integers (nums), every element appears twice except for one. Find that single one.
     * ? You must implement a solution with a linear runtime complexity and use only constant extra spit.
     *
     * * Logic:
     *      ! use XOR operator: for two same bits, results in 0
     *      XOR = ^
     *
     *      [2,2,1]
     *
     *          2 ^ 2 = 0
     *          0 ^ 1 = 1
     *
     *          return 1
     *
     * * O(n) linear TIME COMPLEXITY:
     * * O(1) constant TIME COMPLEXITY:
     */
    public int singleNumber(int[] nums) {

        if(nums.length == 0) {
            return -1;
        }

        int uniqueNum = nums[0];
        int startIndex = 1;

        for(int i = startIndex; i < nums.length; i++) {
            uniqueNum = uniqueNum ^ nums[i];
        }
        return uniqueNum;
    }

    /**
     * ? Facebook LeetCode 7:
     *
     * ? Given a signed 32-bit integer x, return x with its digits reversed
     * ? if reversing x causing it to go outside the signed 32-bit integer range, return 0
     *
     * ! assume env does not allow 64-bit integers
     *
     * * Logic:
     *
     * * O(1) constant TIME COMPLEXITY: dependent length of n
     * * O(1) constant SPACE COMPLEXITY:
     */
    public int reverseInteger(int x) {

        boolean isNegative = false;
        int result = 0;

        if(x < 0) {
            x *= -1;
            isNegative = true;
        }

        // ? RECURSION: an algorithm calls itself & each call is placed on the call stack waiting for a return value until the algorithm can no longer call itself (the base case/breaking condition)
        result = recursiveReverse(x, result);

        if(isNegative) {
            result *= -1;
        }

        return result;
    }

    private int recursiveReverse(int x, int result) {

        // ? RECURSION base case/breaking condition: the algorithm either upward propagates recursive call return for stack resolution or experiences a stack overflow
        boolean isBaseCase = (x <= 0);

        if(isBaseCase) {
            return result;
        }

        int lastDigit = x % 10;
        x /= 10;

        result = (result * 10) + lastDigit;

        return recursiveReverse(x, result);
    }

}

class LeetCodeStrings extends ChallengesLeetCodeUtil {

    // OOP constructor that initializes the class fields on class/object instantiation
    public LeetCodeStrings() {
        // ! OOP INHERITANCE: child subclass inherits the class fields & public methods from the extending parent super-class
        super();
    }

    /**
     * ? write a program that outputs the string representation of a long number from 1 to n
     *     returns an arrayList of GENERIC CLASS strings
     *
     *     for multiples of:
     *         3 it should return "Fizz" instead of the number
     *         5 it should return "Buzz" instead of the number
     *         5 AND 3 it should return "FizzBuzz" instead of the number
     */
    public ArrayList<String> fizzBuzz(long n) {

        // ! GENERIC CLASS: improve ENCAPSULATION by enforcing the elements to be of a specific dataType
        ArrayList<String> strings = new ArrayList<>();
        int i = 1;

        // ! EXCEPTION HANDLING: conditional if-else block (LBYL)
        if(n <= 0) {
            return null;
        }

        while(i <= n) {

            if ((i % 5 == 0) && (i % 3) == 0) {
                strings.add("FizzBuzz");
            } else if(i % 3 == 0) {
                strings.add("Fizz");
            } else if(i % 5 == 0) {
                strings.add("Buzz");
            } else {
                strings.add(Long.toString(i));
            }

            i++;
        }

        return strings;
    }

    /**
     * ? write a program that determines whether an integer is a palindrome.
     *      return a boolean
     *
     * * HINT: An integer is a palindrome when it reads the same backward as forward
     */
    public boolean isPalindrome(int n) {

        String[] numbers = Integer.toString(n).split("");
        int i = 0;
        int j = numbers.length - 1;
        int midPoint = numbers.length / 2;

        // ! EXCEPTION HANDLING: conditional if-else statement (LBYL)
        if(n < 0) {
            return false;
        }

        while(i < midPoint) {

            if(!numbers[i].equals(numbers[j])) {
                return false;
            }

            i++;
            j--;
        }

        return true;
    }

    /**
     * ? given an integer n, return the number of trailing zeroes in n!
     *
     * ! must solve in logarithmic time complexity
     *     O(log(n))
     *
     * * HINT:
     *
     *     1. n would have a trailing 0 when multiplied by 10
     *         each multiple of 10 would add a 0
     *             7 * 10 = 1 trailing 0s
     *             8 * 100 = 2 trailing 0s
     *
     *     2. 10 = 2 * 5
     *         if n has factorials 2 & 5, then there is at least 1 trailing 0
     *
     *             ex: n = !5
     *
     *             !5 = 1 * 2 * 3 * 4 * 5 = 120
     *
     *             !5 = 1 * 3 * (2 * 2) * (2 * 5) = 120
     *
     *             if you track the number of multiples of 5, you will get number of trailing 0s
     *                 given that there are multiple 2s,
     *
     *             !5 has 1 trailing 0
     */
    public Integer trailingZeroFactorial(int n) {

        int count5 = 0;
        // ! AUTOBOXING: converting primitive dataType -> Wrapper Class dataType
        Integer nFactorial = n;

        if(n < 0) {
            return -1;
        }

        while(nFactorial % 5 == 0) {

            nFactorial /= 5;

            // ex) 15 / 5 = returns 3
            //      meaning there are three 5's in 15
            count5 += nFactorial;
        }

        return count5;
    }

    /**
     * ? LeetCode 50: power(x,n) calculates x raised to the power of n
     *
     *      2.1^3 = 9.261
     *
     * ? Big(O) Notation: log2(n) time complexity
     *
     * * HINT: use casting
     *
     * @param b double base
     * @param e long exponent
     * @return Double
     */
    public Double power(double b, long e) {

        double product = 1D;
        long originalExponent = e;

        if(b == 0 || e == 0) {

            return -1D;

        } else if(e < 0) {

            // if exponent is negative, get absolute value
            e *= -1L;
        }

        // loop through until exponent = 0
        while(e > 0) {

            boolean isEvenExponent = (e % 2) == 0;

            if(isEvenExponent) {
                /*
                 if even:
                    increasing base by multiple of itself
                    splitting exponent by half

                    * 2^14 = 4^7
                 */
                b *= b;
                e /= 2;

            } else {
                /*
                 if odd:
                    increasing final product by multiple of base
                    subtract exponent by 1
                 */
                product = product * b;
                e -= 1;
            }
        }

        // if post-calculation exponent is negative, product is a fraction
        if(originalExponent < 0) {
            product = 1D / product;
        }

        return (double) product;
    }

    /**
     * ? LeetCode 344: Write a function that reverses a String.
     *
     * ! TIME COMPLEXITY: o(n) linear time complexity where n is the length of the given array
     * ! SPACE COMPLEXITY: o(1) since it's happening in place
     *
     * @param input The input String is given an array of characters.
     * @return a reversed String
     */
    public String reverseString(String input) {

        char letter = ' ';
        String result = "";

        if(input.isEmpty()) {
            return null;
        }

        for(int i = (input.length() - 1); i >= 0; i--) {
            letter = input.charAt(i);
            result += letter;
        }

        return result;
    }

    /**
     * ? LeetCode 14: Write a function to find the longest common prefix (beginning of a word) string amongst an array of strings
     *
     * ! LINEAR TIME COMPLEXITY O(n): where n is the sum of all string lengths in a given array
     * ! SPACE COMPLEXITY O(1)
     *
     * @param strings
     * @return if there is no common prefix, return empty string
     */
    // ! GENERICS: improve OOP ENCAPSULATION by allowing us to create classes, interfaces, & methods that take dataType parameter
    public String longestCommonPrefix(ArrayList<String> strings) {

        if(strings.isEmpty()) {
            return null;
        }

        // ! ArrayList.get(index) = get value of element at given index
        String prefix = strings.get(0);
        String word = "";

        // loop will validate first string as prefix and then continuously remove last letter
        for(int i = 0; i < strings.size(); i++) {
            word = strings.get(i);

            // ? ArrayList.indexOf(dataType) = get index of given value if arrayList contains it
            while(word.indexOf(prefix) != 0) {

                // remove last letter to create a new comparison substring
                int lastIndex = prefix.length() - 1;
                prefix = prefix.substring(0, lastIndex);

                if(prefix.isEmpty()) {
                    return null;
                }
            }
        }

        return prefix;
    }

    /**
     * ? LeetCode 187: Write a function to find all the 10-letter long sequences substrings that occur more than once in a DNA molecule.
     *
     * All DNA is composed of a series of nucleotides abbreviated as "A" "C" "G", "T" entity.
     * For example, "ACGAATTCCG" this string, when studying DNA, it is sometimes useful to identify repeated sequences within the DNA right.
     *
     * * O(N) linear TIME COMPLEXITY: loop through length of given strings
     * * O(N) linear SPACE COMPLEXITY: create hashmap
     */
    public List<String> findRepeatDNA(String s) {

//        ! MAPS INTERFACE + GENERICS: collection of key-value pair HASHMAP implementations that use GENERIC CLASS dataStructures w/ 2 parameters: UNIQUE key & value
        Map<String, Integer> hashmap = new HashMap<>();
        List<String> substrings = new ArrayList<String>();

        int lastValidSubstringLength = s.length() - 10;

        // loop through the string and add 10 char substring to hashmap
        for(int i = 0; i <= lastValidSubstringLength; i++) {
            String substring = s. substring(i , i + 10);
            Integer count = hashmap.getOrDefault(substring, 0 ) + 1;
            hashmap.put(substring, count);
        }

        // loop through hashmap key-value results
        for(Map.Entry<String, Integer> item: hashmap.entrySet()) {

            int itemCount = item.getValue();
            String substring = item.getKey();

            if(itemCount > 1) {
                substrings.add(substring);
            }
        }

        return substrings;
    }

    /**
     * ? LeetCode 3: Given a string s, find the length of the longest substring without repeating characters
     *
     * ! HINT: Math.max(a,b) = return largest value between a and b
     * ! HINT: track index of unique characters that makeup unique substring in string and the substring length
     *
     * * O(N) linear TIME COMPLEXITY: loop through length of given strings
     * * O(N) linear SPACE COMPLEXITY: create hashmap
     * */
    public Integer longestSubstring(String s) {

        int uniqueSubstringLength = 0;
        // ! MAPS INTERFACE: collection of GENERICS unique_key-value pair HASHMAP implementations
        Map<Character, Integer> hashmap = new HashMap<>();

        if(!s.isEmpty()) {

            // loop & track unique characters indices left-to-right
            for(int rightIndex = 0, leftIndex = 0; rightIndex < s.length(); rightIndex++) {

                char character = s.charAt(rightIndex);

                if(hashmap.containsKey(character)) {
                    /*
                        on duplicate key,
                        increment leftIndex by 1 to shift leftIndex to the next uniqueCharacterIndex in currentSubstring
                     */
                    int duplicateKeyIndex = hashmap.get(character);
                    int nextUniqueCharIndex = duplicateKeyIndex + 1;
                    leftIndex = Math.max(leftIndex, nextUniqueCharIndex);
                }

                // add or update key-value (character-characterIndex) pair with new or most recent duplicate key index
                hashmap.put(character, rightIndex);

                // calculate length of currentSubString & compare to uniqueSubstring length
                // currentSubString could be longer given leftIndex shifting
                int currentSubStringLength = rightIndex - leftIndex + 1;
                uniqueSubstringLength = Math.max(uniqueSubstringLength, currentSubStringLength);
            }
            return uniqueSubstringLength;
        }
        return -1;
    }

    /**
     * ? LeetCode 394: write a function that decodes encoded string
     *
     *      input = 3[a2[c]]
     *
     *      LOGIC:
     *           2[c] = cc
     *           a2[c] = acc
     *           3[a2[c]] = acc + acc + acc
     *
     *      track numbers in numStack and letters in stringStack separately
     *      track brackets and on complete bracket set pop() from string stack
     *
     * ! HINT: use LIFO stacks & start at center & work outwards
     *
     * * O(n) linear TIME COMPLEXITY for push(), pop(), & peek() via stack w/ ARRAY-backing
     *
     * @return decoded String
     */
    public String decodeString(String s) {

        // ! GENERICS: improve OOP ENCAPSULATION by creating classes, interfaces, & methods that only take a specific dataType parameter
        Stack<Integer> numStack = new Stack<>();
        Stack<String> strStack = new Stack<>();
        String result = "";
        int repeat = 0;

        if(s.isEmpty()) {
            return null;
        }

        // loop over string & get character at string[index]
        for(int i = 0; i < s.length(); i++) {

            char character = s.charAt(i);

            boolean isSingleDigit = character >= '0' && character <= '9';
            boolean isIncompleteBracket = character == '[';
            boolean isCompleteBracket = character == ']';

            if(isSingleDigit) {

                repeat = repeat * 10 + (character - '0');

            } else if(isIncompleteBracket) {

                // add character to LIFO stack and reset trackers
                numStack.push(repeat);
                strStack.push(result);

                repeat = 0;
                result = "";

            } else if(isCompleteBracket) {

                // on complete bracket set, LIFO stack.pop() most recent number of character repeats & most recent character respectively
                int numLoops = numStack.pop();
                String repeatString = strStack.pop();

                // build tempString with characters that may or may not repeat on complete bracket set
                for(int j = 0; j < numLoops; j++) {
                    repeatString += result;
                }

                // build final result string
                result = repeatString;

            } else {
                // add alphabetical character to result string for looping Stack LIFO processing
                result += character;
            }
        }
        return result;
    }
    /**
     * ? write a function that gets the longest length of valid parentheses
     *
     * ! HINT: use LIFO stacks
     *
     * * STACK O(n) linear TIME COMPLEXITY for push(), pop(), & peek() via stack w/ ARRAY-backing
     * * STACK O(n) LINEAR SPACE COMPLEXITY: stack data structure
     *
     * @return longest length
     */
    public Integer longestValidParentheses(String s) {

        if(!s.isEmpty()) {

            // ! GENERICS: improve ENCAPSULATION by using parameter dataType Wrapper class
            // ! STACKS: (LIFO) last-in, first-out abstract class implemented by a LINKED LIST that uses push, pop, peek methods
            //      * STACK O(n) LINEAR TIME COMPLEXITY: traverse string once left-right
            //      * STACK O(n) LINEAR SPACE COMPLEXITY: stack data structure
            Stack<Integer> numStack = new Stack<>();
            numStack.push(-1); // -1 = stack boundary

            int longestValidLength = 0;

            for(int i = 0; i < s.length(); i++) {

                // get parenthesis character
                char c = s.charAt(i);

                if(c == '('){
                    // if starting bracket, add index to stack
                    numStack.push(i);
                } else {
                    // if closing bracket, remove index from stack
                    numStack.pop();

                    // if stack is empty, reset by adding current index to stack
                    if(numStack.size() == 0) {
                        numStack.push(i);
                    } else {
                        // stack.peek() = get top of stack
                        // Math.max() = get largest value of 2 variables
                        int substringValidLength = i - numStack.peek();
                        longestValidLength = Math.max(longestValidLength, substringValidLength);
                    }
                }
            }
            return longestValidLength;
        }
        // ! AUTOBOXING: convert primitive dataType to Wrapper class dataType
        return -1;
    }

    /**
     * ? LeetCode 704: write a function to search target in numbers
     * ?        given an array of integers, numbers sorted in ascending order & an integer target
     * ?        if target exists, return index else -1
     *
     * ! HINT: left-to-right comparisons & recursion
     *
     * * BINARY SEARCH only works with SORTED arrays using partitions
     *
     * * O(logn) LOGARITHMIC TIME COMPLEXITY: second-best performance O of log n to the base 2
     *
     * @return index or -1 error
     */
    public Integer binarySearch(int[] nums, int target) {

//        ! EXCEPTION HANDLING: LOOK BEFORE YOU LEAP (LBYL) = use conditional if-else block
        if(nums.length != 0) {

            int leftIndex = 0;
            int rightIndex = nums.length - 1;

            while(leftIndex <= rightIndex) {
                int midIndex = (rightIndex + leftIndex) / 2;

                if(nums[midIndex] == target) {
                    return midIndex;
                }

                // partition array
                if(nums[midIndex] < target) {
                    leftIndex = midIndex + 1;
                } else {
                    rightIndex = midIndex - 1;
                }
            }
        }

        // ! AUTOBOXING: automatically casting primitive dataType to Wrapper class dataType
        return -1;
    }

    /**
     * ? Facebook LeetCode 49:
     *
     * ? Given an array of strings, find group anagrams.
     * ? all inputs will be lowercase, output order does not matter
     *
     * * Logic:
     *      [eat, tea, tan, ate]
     *
     *      eat, tea, ate = anagrams (same content, different order)
     *
     *      key         |       value
     *
     *      "aet"               ["eat", "tea", ...]
     *      "ant"               ["tan", ...]
     *
     * * O(n klogk) TIME COMPLEXITY: k = n length input array, k max length of word
     * * O(nk) SPACE COMPLEXITY:
     */
    public List<List<String>> groupAnagrams(ArrayList<String> strings) {

        if(strings.isEmpty()) {
            return null;
        }

        // ! GENERICS: improve OOP ENCAPSULATION by creating classes, interfaces, & methods that only take a specific dataType parameter
        // ! MAPS INTERFACE: collection of key-value pair HASHMAP implementations that use GENERIC CLASS dataStructures w/ 2 parameters: UNIQUE key & value
        Map<String, List<String>> hashmap = new HashMap<>();

        for(String word : strings) {

            char[] charArray = word.toCharArray();
            Arrays.sort(charArray);

            String key = new String(charArray);

            if(!hashmap.containsKey(key)) {
                hashmap.put(key, new ArrayList<>());
            }

            hashmap.get(key).add(word);
        }

        return new ArrayList<>(hashmap.values());
    }

    /**
     * ? Facebook LeetCode 20:
     *
     * ? given a string s, containing just characters "(", ")", "{", "}", "[", "]"
     * ? determine if the input string is valid.
     * ? only valid if:
     *      open brackets of the same type & in correct order
     *
     * * Logic:
     *
     * * O(n) linear TIME COMPLEXITY:
     * * O(n) linear SPACE COMPLEXITY:
     */
    public boolean validParenthesis(String s) {

        // ! EXCEPTION HANDLING: LOOK BEFORE YOU LEAP (LBYL) = use conditional if-else block
        if(s.isEmpty()) {
            return false;
        }

        // ! MAPS INTERFACE: collection of key-value pair HASHMAP implementations that use GENERIC CLASS dataStructures w/ 2 parameters: UNIQUE key & value
        Map<Character, Character> hashmap = new HashMap<>();
        hashmap.put(')', '(');
        hashmap.put('}', '{');
        hashmap.put(']', '[');

        // ! STACKS: (LIFO) last-in, first-out abstract class implemented by a LINKED LIST that uses push, pop, peek methods
        Stack<Character> stack = new Stack();

        for(int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);

            if(hashmap.containsKey(currentChar)) {

                char top = (stack.size() != 0) ? stack.pop() : '#';
                boolean isSameChar = (top == hashmap.get(currentChar));

                if(!isSameChar) {
                    return false;
                }

            } else {
                stack.push(currentChar);
            }
        }
        return stack.isEmpty();
    }
}

class LeetCodeArrays extends ChallengesLeetCodeUtil {

    // OOP constructor that initializes class fields on class/object instantiation
    public LeetCodeArrays() {
        // ! OOP INHERITANCE: a child subclass inherits class fields & public methods from extending parent super class
        super();
    }

    /**
     * ? LeetCode 1:
     * ?    Given an integer array nums & int target, return indices of the two numbers such that they add up to target in any order
     *  
     * ! HINT: each input has exactly one solution; you may not use the same element twice
     * ! HINT: use a HASHMAP implementation of the MAP interface
     *  
     * * O(N) linear TIME COMPLEXITY: loop through array once and track using a HASHMAP
     * * O(N) linear SPACE COMPLEXITY: create hashset
     *
     * @return indices of the two numbers such that they add up to target
     */
    public ArrayList<Integer> twoSums(ArrayList<Integer> nums, int target) {

        // ! MAPS INTERFACE: collection of key-value pair HASHMAP implementations that use GENERIC CLASS dataStructures w/ 2 parameters: UNIQUE key & value
        // ! GENERICS: improve ENCAPSULATION by enforcing parameter dataType for each element
        Map<Integer, Integer> hashmap = new HashMap<>();
        ArrayList<Integer> results = new ArrayList<>();
        int difference;
        int diffIndex;
        int element;

        if (nums.isEmpty()) {
            return null;
        }

        for (int i = 0; i < nums.size(); i++) {

            // ! UNBOXING: casting wrapper class dataType -> primitive dataType
            element = nums.get(i);
            difference = target - element;
            /*
                get difference and check if difference is in hashmap, if no add nums[index] to hashmap
                    target = 9
                    index_0 = 2
                    diff = 7 which does not initially exist in hashmap

             */

            if (!hashmap.containsKey(difference)) {
                // HASHMAP key-value
                hashmap.put(element, i);
            } else {
                // if difference is in hashmap, return respective indices
                diffIndex = hashmap.get(difference);
                results.add(diffIndex);
                results.add(i);

                break;
            }

            // for duplicates, updated index with the latest instance
            // if target value in hashset, skip
        }
        return results;
    }

    /**
     * ? LeetCode 217:
     * ?    Given an integer array nums,
     * ?        return true if any value appears at least twice in the array
     * ?        return false if every element is distinct
     *  
     * ! SETS INTERFACE: a computationally fast unordered collection without any duplicates implemented via HASHSET class
     *  
     * * O(N) linear TIME COMPLEXITY: loop through array once and track using a SET
     * * O(N) linear SPACE COMPLEXITY: create hashset
     */
    public boolean containsDuplicate(int[] nums) {

        // ! SET: unorganized abstract interface that only has unique elements (no duplicates) implemented via HASHSET
        // ! INTERFACE: abstract class that mandates that all designated classes must uniquely implement/@Override publicly-shared signatures
        // GENERICS: improve ENCAPSULATION by enforcing each parameter/element in data structure to be of a specific dataType
        Set<Integer> uniqueValues = new HashSet<>();

        if (nums.length != 0) {

            // left-to-right traversal
            for (int i = 0; i < nums.length; i++) {

                // ! AUTOBOXING: casting a primitive dataType -> respective wrapper class dataType
                Integer element = nums[i];

                if (uniqueValues.contains(element)) {
                    return true;
                }

                // implied else-statement
                uniqueValues.add(element);
            }
        }
        return false;
    }

    /**
     * ? LeetCode 605:
     * ?    Given an integer array flowerbed containing 0s (empty) & 1s (!empty) & int n (number of flowers to be planted)
     * ?    return if n can be planted in the flowerbed w/o violating the no-adjacent-flowers rule
     *  
     * ex:  [1,0,0,0,1] only can plant flower at index 2
     *  
     * * O(N) linear TIME COMPLEXITY: loop through array once
     * * O(1) constant SPACE COMPLEXITY: using an array
     */
    public boolean canPlaceFlowers(int[] flowerbed, int n) {

        // ! FINAL: variable assigned before compilation/instantiation that cannot be changed
        final int emptyPlot = 0;
        final int filledPlot = 1;

        boolean isEmptyCurrent;
        boolean isEmptyLeft;
        boolean isEmptyRight;
        boolean isOutOfBounds;
        int count = 0;

//        ! EXCEPTION HANDLING: LOOK BEFORE YOU LEAP (LBYL) = use conditional if-else block
        if (n > 0 && flowerbed.length != 0) {

            // traverse left-to-right to find closest !empty indices from both sides
            for (int i = 0; i < flowerbed.length; i++) {

                isEmptyCurrent = flowerbed[i] == 0;
                isOutOfBounds = (i - 1 < 0) || (i + 1 > flowerbed.length);

                if (isEmptyCurrent) {

                    isEmptyLeft = isOutOfBounds || flowerbed[i - 1] == emptyPlot;
                    isEmptyRight = isOutOfBounds || flowerbed[i + 1] == emptyPlot;

                    if (isEmptyLeft && isEmptyRight) {
                        count++;
                        flowerbed[i] = filledPlot;
                    }
                }
            }
            return count >= n;
        }
        return false;
    }

    /**
     * ? LeetCode 122:
     * ?    Given an integer array, get max profit
     * ?    must sell current stock before buying a stock but can make as many transactions
     *  
     * * ex:
     * [7, 1, 5, 3, 6, 4]
     *  
     * index 0 = day 1
     * 7 = stock price
     *  
     * ! HINT: track peeks & valleys in a graph & only sell on upward trajectory
     *  
     * * O(N) linear TIME COMPLEXITY: loop through array once
     * * O(1) constant SPACE COMPLEXITY: since using an array get()
     *
     * @param prices prices at given day index
     * @return maximum profit
     */
    public Integer bestBuySellStockII(int[] prices) {

        // ! AUTOBOXING: casting primitive dataType -> wrapper class dataType
        Integer maxProfit = 0;
        boolean isPriceIncrease;
        int todayProfit;

        if (prices.length != 0) {

            // start at first index to avoid outOfBounds exception
            for (int today = 1; today < prices.length; today++) {

                isPriceIncrease = prices[today] > prices[today - 1];

                if (isPriceIncrease) {

                    // MUST sell first, before buy
                    todayProfit = prices[today] - prices[today - 1];

                    maxProfit += todayProfit;
                }
            }
            return maxProfit;
        }
        return -1;
    }

    /**
     * ? LeetCode 55:
     * ?    Given an integer array of jumpLengths
     * ?    can you at least reach the last index of the array given sequential jump distance
     *
     * * ex) {2,3,1,1,4}
     *
     * baseIndex = 0
     * jumpDistance = jumps[0] = 2
     * jumpToIndex = 2
     *
     * repeat until end of array or cannot jump
     *
     * * O(N) linear TIME COMPLEXITY: loop through array once
     * * O(1) constant SPACE COMPLEXITY: using a HASHMAP
     *
     * @param jumps lengths of jumps
     * @return reached last index
     */
    public boolean jumpGame(int[] jumps) {

        int targetIndex = -1;
        int farthestReachableIndex = 0;
        int jumpDistance;
        Integer jumpToIndex;

//        ! EXCEPTION HANDLING: LOOK BEFORE YOU LEAP (LBYL) = use conditional if-else block
        if (jumps.length != 0) {

            targetIndex = jumps.length - 1;

            // traverse entire array & track reachableIndex from each index
            // while index is less than length AND index is less than or equal to the updating reachableIndex
            for (int i = 0; (i < jumps.length) && (i <= farthestReachableIndex); i++) {

                // ! AUTOBOXING: casting primitive dataType -> wrapper class dataType
                jumpDistance = jumps[i];
                jumpToIndex = i + jumpDistance;

                // Math.max(a,b): returns the largest of the 2 values
                farthestReachableIndex = Math.max(farthestReachableIndex, jumpToIndex);

                if (farthestReachableIndex >= targetIndex) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * ? LeetCode 66:
     * ?    Given an integer array of integers, must return an array with the value of the concatenated integers + 1
     *  
     * r = 1
     *  
     * [9,9,9] -> [9,9,0] -> [9,0,0] -> [0,0,0] -> [1,0,0,0]
     *  
     * * O(N) linear TIME COMPLEXITY: loop through array once
     * * O(N) linear SPACE COMPLEXITY: using an array
     *
     * @param nums
     * @return reached last index
     */
    public int[] plusOne(int[] nums) {

        // since starting in 1's place, remainder initialized to 1
        int remainder = 1;
        int sumNR;

        if (nums.length == 0) {
            return null;
        }

        // traverse array starting from end (the 1's place)
        for (int i = nums.length - 1; i >= 0; i--) {

            sumNR = nums[i] + remainder;
            boolean hasRemainder = sumNR >= 10;

            if (hasRemainder) {

                // zero out element and increment remainder
                remainder = 1;
                nums[i] = 0;

            } else {

                // zero out remainder and update element
                remainder = 0;
                nums[i] = sumNR;

            }
        }
        // after loop, if remainder is 1 than array is zeroed out
        // new array has all elements zeroed out by default
        if (remainder == 1) {

            int[] extendedNums = new int[nums.length + 1];
            extendedNums[0] = remainder;

            return extendedNums;
        }

        return nums;
    }

    /**
     * ? LeetCode 448:
     * ?    Given an integer array of integers, where 1 <= a[i] <= n (n = size of array) some elements appear twice and others once
     * ?    find elements that do not appear in array
     *  
     * * LOGIC:
     * converting elements to negative will flag element as already existing at index n + 1
     * for remaining positive elements (duplicates), adding 1 to the respective element's index will return missing number
     * add missing number to a new array and return
     *  
     * * O(2n) linear TIME COMPLEXITY: loop through 2 arrays once each
     * * O(1) constant SPACE COMPLEXITY: using an array
     *
     * @param nums
     * @return reached last index
     */
    public List<Integer> findAllNumbersDisappearedInAnArray(int[] nums) {

        List<Integer> results = new ArrayList<>();

        if (nums.length == 0) {
            return null;
        }

        // build array of negative elements left-to-right traversal
        for (int i = 0; i < nums.length - 1; i++) {

            // ! AUTOBOXING: casting primitive dataType -> wrapper class dataType
            // Math.abs() = return absolute value (disregard negative sign)
            Integer absoluteCurrentElement = Math.abs(nums[i]);
            Integer minusOneElement = nums[absoluteCurrentElement - 1];

            boolean currentElementNotAccounted = minusOneElement > 0;

            if (currentElementNotAccounted) {

                // convert to negative value to identify as accounted for
                nums[absoluteCurrentElement - 1] = minusOneElement * -1;
            }
        }

        // use positive numbers to find missing numbers by adding 1 to their index
        for (int i = 0; i < nums.length; i++) {

            boolean isPositiveElement = nums[i] > 0;

            if (isPositiveElement) {

                int missingNumber = i + 1;
                results.add(missingNumber);
            }
        }

        return results;
    }

    /**
     * ? LeetCode 1007:
     * ?    Given an integer array of integers, in a row of dominoes, A[i] and B[i] represent the top & bottom halves of the ith domino
     * ?    a domino = a tile w/ 2 numbers 1-6, one on each half of the tile
     * ?    we may rotate the ith domino so that A[i] & B[i] swap values
     *  
     * ?    return min number of rotations so that all the values in A are the same or all values in B are the same
     * ?    else return -1;
     *  
     * * LOGIC:
     * a = [2,1,2,4,2,2]
     * b = [5,2,6,2,3,2]
     *  
     * tile = a[0] & b[0] = 2 & 5
     *  
     * for all elements in a_array to be the same, must rotate indices 1 & 3 from b_array with a_array so that all element values in a_array = 2
     * track min rotation
     *  
     * target_a =  [2,2,2,2,2,2]
     * b =         [5,1,6,4,3,2]
     *  
     * * O(2n) linear TIME COMPLEXITY: loop through 2 arrays once each
     * * O(1) constant SPACE COMPLEXITY: using an array
     *
     * @param a
     * @param b
     * @return reached last index
     */
    public int minDominoForEqualRow(int[] a, int[] b) {

        int minRotations = -1;

        if ((a.length != 0 && b.length != 0) ||
                (a.length != b.length)) {

            // traverse left-to-right
            for (int value = 1; value <= 6; value++) {

                // validate array can be rotated so that all elements equal value in either a or b array
                int valueNumRotations = getValueMinRotations(a, b, value);

                boolean isFirstValidRotation = minRotations == -1 && valueNumRotations != 0;
                boolean isNewMinRotation = valueNumRotations != 0 && valueNumRotations < minRotations;

                if (isNewMinRotation || isFirstValidRotation) {
                    minRotations = valueNumRotations;
                }
            }
        }
        return minRotations;
    }

    private static int getValueMinRotations(int[] a, int[] b, int value) {

        int numRotationsA = 0;
        int numRotationsB = 0;

        for (int i = 0; i < a.length; i++) {

            int currentElementA = a[i];
            int currentElementB = b[i];

            if (currentElementA != value && currentElementB != value) {
                return 0;
            } else if (currentElementA != value) {
                numRotationsA++;
            } else if (currentElementB != value) {
                numRotationsB++;
            }
        }
        return Math.min(numRotationsA, numRotationsB);
    }

    /**
     * ? LeetCode 239:
     * ?    Given an integer array of integers,
     * ?    there is a sliding window of size k, which is moving from the very left of the area to the very right.
     * ?    you can only see the k numbers in the window.
     * ?    this time, the sliding window moves right by one position region, the max sliding window.
     *  
     * * LOGIC:
     * size of array with elements that equal the largest values in each window
     *  
     * n - k + 1
     * n = size of input array
     * k + 1 = size of window/array
     *  
     * * O(n) linear TIME COMPLEXITY: loop through array once
     * * O(n) linear SPACE COMPLEXITY: using an array
     *
     * @param nums array of integers
     * @param k    window size
     * @return max sliding window array
     */
    public int[] slidingMaxWindow(int[] nums, int k) {

        // ! EXCEPTION HANDLING: LOOK BEFORE YOU LEAP (LBYL) = use conditional if-else block
        if (nums.length == 0 || k == 0) {
            return null;
        }

        int totalMaxElements = nums.length - k + 1;
        int[] results = new int[totalMaxElements];

        // ! QUEUE: (FIFO) first-in, first-out abstract class implemented by a LINKED LIST that uses enqueue(), dequeue(), peek()
        Deque<Integer> window = new ArrayDeque<>();

        for (int currentNumsIndex = 0; currentNumsIndex < nums.length; ++currentNumsIndex) {

            // manage shifting window: remove indices that are out of bound in respect to window
            while (window.size() > 0 && window.peekFirst() <= (currentNumsIndex - k)) {
                window.pollFirst();
            }

            // ensure queue top is max: remove indices whose corresponding values are less than nums[i]
            while (window.size() > 0 && nums[window.peekLast()] < nums[currentNumsIndex]) {
                window.pollLast();
            }

            // if window is empty or has space within window bounds, add index of nums[i] to window queue
            window.offerLast(currentNumsIndex);

            // add maxElement in window (the top) via index to the results array if reached window end
            boolean reachedWindowEnd = currentNumsIndex >= (k - 1);

            if (reachedWindowEnd) {
                int maxWindowValue = nums[window.peekFirst()];
                int elementIndex = currentNumsIndex - k + 1;

                results[elementIndex] = maxWindowValue;
            }
        }
        return results;
    }

    /**
     * ? Amazon LeetCode 58:
     *
     * ? given a string s consisting of some words separated by some number of spaces,
     * ? return the length of the last word in the string
     * ? a word = max substring consisting of non-space characters only
     *
     * * Logic:
     *
     * * O(n) linear TIME COMPLEXITY: length of array
     * * O(1) constant TIME COMPLEXITY: using 1 array data structure
     */
    public int lengthOfLastWord(String s) {

        if(s.isEmpty()) {
            return -1;
        }

        int maxLength = 0;
        int count = 0;

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if(c != ' ') {
                count++;

                if(count > maxLength) {
                    maxLength = count;
                }
            } else {
                count = 0;
            }
        }
        return maxLength;
    }

    /**
     * ? LeetCode 1291:
     *
     * ? an integer has sequential digits, if and only if each digit in the number is one more than the previous digit
     * ? return a sorted list of all the integers in the range, low and high, inclusive that have sequential visits.
     *
     * * Logic:
     *      high = 300
     *      low = 100
     *      sequential = [123, 234]
     *
     * * O(1) constant TIME COMPLEXITY: will only run 64 times consistently
     * * O(n) linear SPACE COMPLEXITY: to construct arrayList
     */
    public List<Integer> sequentialDigits(int low, int high) {

        if((high <= low) ||
                (high <= 10 && low >= -10)) {
            return null;
        }

        List<Integer> result = new ArrayList<>();
        String digits = "123456789";

        for(int i = 1; i <= 9; i++) {

            for(int j = 0; j < digits.length() - i; j++) {

                String subString = digits.substring(j, j + i);
                int value = Integer.parseInt(subString);

                if(value <= high && value >= low) {
                    result.add(value);
                }
            }
        }
        return result;
    }

    /**
     * ? LeetCode 442:
     *
     * ? given an array of integers, 1 <= a[i] <= n (n = size of array)
     * ? some elements appear twice, others appear once
     * ? find all duplicates withing space O(1) && time O(n)
     *
     * * Logic:
     *      in an array w/ elements starting from 1 to n (array max cannot exceed array length)
     *      loop through array left-to-right
     *      identify future element index respective to currentElement by subtracting currentElement by 1
     *      flag elements as a duplicate by converting to negative
     *
     * * O(n) linear TIME COMPLEXITY:
     * * O(1) constant SPACE COMPLEXITY:
     */
    public ArrayList<Integer> findAllDuplicates(int[] input) {

        if(input.length == 0) {
            return null;
        }

        ArrayList<Integer> duplicates = new ArrayList<Integer>();

        // array max cannot exceed array length
        for(int i = 0; i < input.length; i++) {

            int currentElement = Math.abs(input[i]);
            int futureIndex = currentElement - 1;

            boolean isNegativeElement = input[futureIndex] < 0;

            if(isNegativeElement) {
                duplicates.add(currentElement);
            } else {

                // flag future elements (whose index = currentElement - 1) as negative
                input[futureIndex] *= -1;
            }
        }
        return duplicates;
    }
}

class LeetCodeArray2D extends ChallengesLeetCodeUtil {

    /**
     * ? Amazon LeetCode 304:
     * ?    Given a 2D matrix matrix, handle multiple queries of the following type
     * ?    Calculate the sum of the sub-matrix given upper left corner and lower right corner
     * ?    defined by its upper left corner (row1, column1), and lower right corner (row2, column2)
     *
     * * LOGIC:
     *
     *      [
     *          [3,0,1,4,2],
     *          [5,6,3,2,1],
     *          [1,2,0,1,5],
     *          [4,1,0,1,7],
     *          [1,0,3,0,5]
     *      ]
     *
     * * use dynamic programming table to subtract surrounding regions to find the sum of target region
     *
     * * ex) sum of the sub-matrix below = 7, given index of 3 top left and index of 1 bottom right
     *
     *       [3,2]
     *       [0,1]
     *       [0,1]
     *
     *      step 1: subtract sub-region:
     *
     *          [3,0,1,4]
     *
     *      step 2: subtract sub-region:
     *
     *          [3,0]
     *          [5,6]
     *          [1,2]
     *          [4,1]
     *
     *      step 3: add sub-region back in to negate double subtraction:
     *
     *          [3,0]
     *
     *      ? iterate from cell s (start) to cell e (end)
     *
     *      0   0   0   0   0   0
     *      0   s
     *      0
     *      0
     *      0
     *      0
     *      0                   e
     *
     *      ? each cell = (above current cell + left of current cell - duplicate value) + current index value
     *      must subtract duplicate of top left diagonal value
     *
     *          x = 0 + 0 + 3 = 3
     *          y = 0 + 3 + 0 = 3
     *          b = 0 + 8 + 2 = 10
     *
     *          z = 0 + 3 + 1 - 0 = 4
     *          a = 0 + 4 + 4 - 0 = 8
     *
     *      0   0   0   0   0   0
     *      0   x   y   z   a   b
     *      0
     *      0
     *      0
     *      0
     *      0
     *
     *      0   0   0   0   0   0
     *      0   3   3   4   8   10
     *      0   8   14  18  24  35
     *      0   9   25  29  36  76
     *      0   13  39  43  51  134
     *      0   14  53  60  68  207
     *
     * * O(mn) constant TIME COMPLEXITY: loop through array once
     * * O(mn) linear SPACE COMPLEXITY: using an array
     *
     * *    mn = height * width of the given matrix
     *
     * @param matrix array of integers
     * @param upperLeft indices in matrix
     * @param lowerRight indices in matrix
     * @return sum of sub-matrix
     */
    public int rangeSumQuery(int[][] matrix, int[] upperLeft, int[] lowerRight) {

        if(!validateRangeSumQueryArguments(matrix, upperLeft, lowerRight)) return -1;

        int sum = 0;
        int numRows = matrix.length + 1;
        int numColumns = matrix[0].length + 1;

        // ? first row & column elements are set to 0 by default
        int[][] dynamicProgrammingTable = new int[numRows][numColumns];

        dynamicProgrammingTable = populateDPT(dynamicProgrammingTable, matrix);

        sum = sumTargetMatrix(dynamicProgrammingTable, upperLeft[0], upperLeft[1], lowerRight[0], lowerRight[1]);

        return sum;
    }

    private int[][] populateDPT(int[][] dynamicProgrammingTable, int[][] matrix) {

        int totalRows = matrix.length;
        int totalColumns = matrix[0].length;

        /*
            // ? iterate from cell s (start) to cell e (end)

                0   0   0   0   0   0
                0   s
                0
                0
                0
                0
                0                   e
         */
        for(int row = 0; row < totalRows; row++) {
            for(int column = 0; column < totalColumns; column++) {

                int currentTopValue = dynamicProgrammingTable[row][column + 1];
                int currentLeftValue = dynamicProgrammingTable[row + 1][column];
                int currentDiagonalValue = dynamicProgrammingTable[row][column];

                int currentMatrixValue = matrix[row][column];

                dynamicProgrammingTable[row + 1][column + 1] = (currentTopValue + currentLeftValue - currentDiagonalValue) + currentMatrixValue;
            }
        }
        return dynamicProgrammingTable;
    }

    public int sumTargetMatrix(int[][] dynamicProgrammingTable, int row1, int column1, int row2, int column2) {

        int sumSubRegion1 = dynamicProgrammingTable[row2 + 1][column2 + 1];
        int sumSubRegion2 = dynamicProgrammingTable[row1][column2 + 1];
        int sumSubRegion3 = dynamicProgrammingTable[row2 + 1][column1];
        int subtractedRegion = dynamicProgrammingTable[row1][column1];

        return (sumSubRegion1 - sumSubRegion2 - sumSubRegion3) + subtractedRegion;
    }

    private boolean validateRangeSumQueryArguments(int[][] matrix, int[] upperLeft, int[] lowerRight) {

        if(matrix.length == 0 || upperLeft.length != 2 || lowerRight.length != 2) {
            return false;
        }

        for(int i = 0; i < matrix.length; i++) {

            int currentRowLength = matrix[i].length;
            int standardizedLength = matrix[0].length;

            if(currentRowLength == 0 || currentRowLength != standardizedLength) {
                return false;
            }
        }

        return true;
    }

    /**
     * ? Microsoft LeetCode 56:
     *
     * ? Given an array of intervals where intervals[i] = [start, end]
     * ? merge all overlapping intervals & return an array of non-overlapping intervals
     * ? that cover all the intervals in the input
     *
     * * Logic:
     *      INPUT:
     *          [
     *              [1, 3],
     *              [2, 6],
     *              [8, 10],
     *              [15, 18]
     *          ]
     *
     * *    since 2 is in the range of [1,3], these two interval arrays are overlapping
     * *    merged interval = [1,6]
     *
     *      OUTPUT:
     *          [
     *              [1, 6],
     *              [8, 10],
     *              [15, 18]
     *          ]
     *
     * * O() TIME COMPLEXITY:
     * * O() SPACE COMPLEXITY:
     */


}

class LeetCodeTwoPointers extends ChallengesLeetCodeUtil {

    // OOP constructor that initializes the class fields on class/ object instantiation
    public LeetCodeTwoPointers() {
        // ! OOP INHERITANCE: child subclass inherits class fields & public methods from extending parent super class
        super();
    }

    /**
     * ? LeetCode 392:
     * ?    given two Strings s & t, check if s is a subsequence of t
     *
     * * ex) "ace" is a subsequence of "abcde"
     *
     * * O(n) linear TIME COMPLEXITY: depending on longest string of two arguments
     * * O(1) constant TIME COMPLEXITY: using an array
     *
     * @return isSubsequence
     */
    public boolean isSubsequence(String s, String t) {

        if(!s.isEmpty() && !t.isEmpty()) {

            int i = 0;
            int j = 0;

            while(i < s.length() && j < t.length()) {

                boolean isSameChar = s.charAt(i) == t.charAt(j);

                if(isSameChar) {
                    i++;
                    j++;

                } else {
                    j++;
                }

                boolean eachCharInSMatched = i == s.length();

                if(eachCharInSMatched) {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * ? LeetCode 42:
     * ?    given in non-negative integers
     * ?    representing at elevation F or the width of each bar is one
     * ?    compute how much water it can travel after raining
     *
     * * LOGIC:
     *
     *      use start and end index as frame and traverse left to right and count open space
     *
     *      [4,2,0,3,2,5] = 9
     *
     *      o = open space for water to be trapped
     *      x = structure
     *
     *                x
     *      x o o o o x
     *      x o o x o x
     *      x x o x x x
     *      x x o x x x
     *
     * * O(n) linear TIME COMPLEXITY: depending on longest string of two arguments
     * * O(1) constant TIME COMPLEXITY: using an array
     *
     * @param heights array of non-negative numbers
     * @return amount of water trapped
     */
    public int trappingRainWater(int[] heights) {

        // ! EXCEPTION HANDLING: LOOK BEFORE YOU LEAP (LBYL) = use conditional if-else block
        if(heights.length == 0) {
            return -1;
        } else {
            for(int i = 0; i < heights.length; i++) {
                if(heights[i] < 0) {
                    return -1;
                }
            }
        }

        int unitsOfWaterTrapped = 0;

        int leftPointer = 0;
        int rightPointer = heights.length - 1;

        // left-to-right traversal
        while(leftPointer < rightPointer) {

            int leftBarrierHeight = heights[leftPointer];
            int rightBarrierHeight = heights[rightPointer];

            boolean inTrapRange = leftBarrierHeight <= rightBarrierHeight;

            if(inTrapRange) {

                // save current index for comparison
                int currentPointer = leftPointer;
                int currentPointerHeight = heights[currentPointer];

                // increment left pointer before execution for comparison
                while(heights[++leftPointer] < currentPointerHeight) {

                    // compare current height against height to the immediate left via the incremented leftPointer
                    int immediateRightHeight = heights[leftPointer];
                    int currentIndexWaterTrapped = currentPointerHeight - immediateRightHeight;

                    unitsOfWaterTrapped += currentIndexWaterTrapped;
                }

            } else {

                // save current index for comparison
                int currentPointer = rightPointer;
                int currentPointerHeight = heights[currentPointer];

                // increment right pointer before execution for comparison
                while(heights[--rightPointer] < currentPointerHeight) {

                    // compare current height against height to the immediate right via the incremented rightPointer
                    int immediateLeftHeight = heights[rightPointer];
                    int currentIndexWaterTrapped = currentPointerHeight - immediateLeftHeight;

                    unitsOfWaterTrapped += currentIndexWaterTrapped;
                }
            }
        }
        return unitsOfWaterTrapped;
    }

    /**
     * ? Facebook LeetCode 125:
     *
     * ? giving a string s and determine if it is a palindrome
     * ? considering only alphanumeric characters and ignoring cases.
     *
     * * Logic:
     *
     * * O(n) linear TIME COMPLEXITY: length of input string
     * * O(1) constant SPACE COMPLEXITY: always using 1 array
     */
    public boolean validPalindrome(String s) {

        // ! EXCEPTION HANDLING: LOOK BEFORE YOU LEAP (LBYL) = use conditional if-else block
        if(s.isEmpty()) {
            return false;
        }

        boolean isPalindrome = false;
        String onlyAlphanumericRegex = "[^A-Za-z0-9]";
        String[] letters = s.replaceAll(onlyAlphanumericRegex, "")
                .trim()
                .toLowerCase()
                .split("");

        int i = 0;
        int j = letters.length - 1;

        while(i < j) {

            if(letters[i].equals(letters[j])) {
                isPalindrome = true;
                i++;
                j--;
            } else {
                isPalindrome = false;
                break;
            }
        }
        return isPalindrome;
    }

    /**
     * ? Facebook LeetCode 977:
     *
     * ? Given an integer array nums sorted in non-decreasing order
     * ? return a newly sorted in-place array of the squares of each number sorted in non-decreasing order
     * ? nums can have negative numbers & can't use sorting algorithms
     *
     * * Logic:
     *      firstPointer at start, secondPointer at end
     *      loop through entire array once while populating temp array
     *      assign max of two pointers to temp array end
     *      move max element pointer towards center of array
     *      decrement results index as end of unsorted partition
     *
     *
     * * O(n) linear TIME COMPLEXITY:
     * * O(n) linear SPACE COMPLEXITY:
     */

    public int[] squareOfSortedArray(int[] nums) {

        if(nums.length == 0) {
            return null;
        }

        int leftPointer = 0;
        int rightPointer = nums.length - 1;
        int currentResultsIndex = rightPointer;
        int[] results = new int[nums.length];

        // ! RECURSION: an algorithm calls itself & each call is placed on the call stack waiting for a return value until the algorithm can no longer call itself (the base case/breaking condition)
        return recursiveSquareSortedArray(currentResultsIndex, leftPointer, rightPointer, nums, results);
    }

    private int[] recursiveSquareSortedArray(int current, int left, int right, int[] nums, int[] results) {

        // ? RECURSION base case/breaking condition: the algorithm either upward propagates recursive call return for stack resolution or experiences a stack overflow
        if(left > right) {
            return results;
        }

        int leftElement = nums[left] * nums[left];
        int rightElement = nums[right] * nums[right];

        // traverse towards center from each end
        boolean leftPointerGreaterOrEqual = leftElement >= rightElement;

        if(leftPointerGreaterOrEqual) {

            // assign larger of 2 pointer values to end of unsorted results index & decrement
            results[current] = leftElement;
            current--;

            // move left pointer closer to center since leftElement was sorted into results array
            left++;

        } else {

            // assign larger of 2 pointer values to end of unsorted results index & decrement
            results[current] = rightElement;
            current--;

            // move right pointer closer to center since rightElement was sorted into results array
            right--;
        }
        return recursiveSquareSortedArray(current, left, right, nums, results);
    }


}

class LeetCodeRecursion extends ChallengesLeetCodeUtil {

    // OOP constructor that initializes the class field on class object instantiation
    public LeetCodeRecursion() {
        // ! OOP INHERITANCE: child subclass inherits class fields + public methods from extending parent super class
        super();
    }

    /**
     * ? LeetCode 22:
     * ?    given a string
     *
     * use BACKTRACKING algorithm
     * * LOGIC:
     *
     *      BACKTRACKING recursive algorithm
     *          ! RECURSION: an algorithm calls itself & each call is placed on the call stack waiting for a return value until the algorithm can no longer call itself (the base case/breaking condition)
     *
     *          choice
     *              we can choose open "(" or close bracket ")"
     *
     *          constraint
     *              we can choose close bracket if left <= right
     *                  left = num open brackets
     *                  right = num close brackets
     *
     *          goal
     *              find (2 * max) valid parenthesis
     *
     * * O(n) linear TIME COMPLEXITY: depending on longest string of two arguments
     * * O(1) constant TIME COMPLEXITY: using an array
     *
     * @param n array of non-negative numbers
     * @return array of valid parenthesis max
     */
    public List<String> generateParenthesis(int n) {

        if(n <= 0) {
            return null;
        }

        List<String> maxValidParenthesis = new ArrayList<>();
        String currentParenthesis = "";
        int leftP = 0;
        int rightP = 0;

        // binary tree

        recursiveBackTracking(maxValidParenthesis, currentParenthesis, leftP, rightP, n);
        return maxValidParenthesis;
    }

    private void recursiveBackTracking(List<String> result, String currentParenthesis, int numOpened, int numClosed, int max) {

        int parenthesisSet = 2;
        int maxCombinations = parenthesisSet * max;
        boolean baseCase = currentParenthesis.length() == maxCombinations;
        String openingBracket = "(";
        String closingBracket = ")";

        // baseCase
        if(baseCase) {
            result.add(currentParenthesis);
            return;
        }

        // left-to-right
        if(numOpened < max) {
            String addedOpenParenthesis = currentParenthesis + openingBracket;
            int incrementedNumOpen = numOpened + 1;
            recursiveBackTracking(result, addedOpenParenthesis, incrementedNumOpen, numClosed, max);
        }

        if(numClosed < numOpened) {
            String addedCloseParenthesis = currentParenthesis + closingBracket;
            int incrementedNumClosed = numClosed + 1;
            recursiveBackTracking(result, addedCloseParenthesis, numOpened, incrementedNumClosed, max);
        }

    }

}

class LeetCodeFamousAlgorithms extends ChallengesLeetCodeUtil {

    // OOP constructor that initializes the class field on class object instantiation
    public LeetCodeFamousAlgorithms() {
        // ! OOP INHERITANCE: child subclass inherits class fields + public methods from extending parent super class
        super();
    }

    /**
     * ? LeetCode 169:
     * ?    given an array numbers of size n, return the majority element.
     * ?    The majority element is the element that appears more than n/2 times
     * ?    assume, the majority element always exists in the array
     *
     * * LOGIC:
     *      use partitions to track count & majority element
     *
     *      difference of majority frequency and minority frequency = count
     *          [7,7,5]
     *
     *          count = 1
     *          majorityElement = 7
     *          diff = 2 sevens - 1 five = 1 diff frequency
     *
     * ! single pass algorithm
     *
     * * O(n) linear TIME COMPLEXITY: depending on longest string of two arguments
     * * O(1) constant TIME COMPLEXITY: construct array data structure
     *
     * @param
     * @return majority element
     */
    public int majorityElement(int[] nums) {

        if(nums.length <= 0) {
            return -1;
        } else if(nums.length == 1) {
            return nums[0];
        }

        int majorityElement = 0;
        int count = 0;

        // left-to-right
        for(int i = 0; i < nums.length; i++) {

            int currentElement = nums[i];

            // set new majorityElement at start of partition
            // a new partition starts when count = 0
            if(count == 0) {
                majorityElement = currentElement;
            }

            // count tracks frequency of majority and minority elements in partition
            if(majorityElement == currentElement) {
                count++;
            } else {
                count--;
            }
        }
        return majorityElement;
    }
}

class LeetCodeSort extends ChallengesLeetCodeUtil {

    // OOP constructor that initializes the class field on class object instantiation
    public LeetCodeSort() {
        // ! OOP INHERITANCE: child subclass inherits class fields + public methods from extending parent super class
        super();
    }

     /*
        ? given an array of integers, sort the elements using the merge sort algorithm.

         ! MERGE SORT (Depth-First-Search)
            merge sort divides an input array into two halves & continues to recursively divide the resulting partitions into two halves until the partitions are 1-element arrays
            then each 1-element array is merged together in sequential order left-to-right

         ! Big(O) TIME COMPLEXITY: the worst case scenario for the number of steps in an algorithm's execution

             * LOGARITHMIC TIME COMPLEXITY = O(logn) = O of log to the base 2 n
                     repeatedly dividing array in half during splitting

         ! SPACE COMPLEXITY:

             * overall: NOT in-place

             splitting phase = in-place algorithm that doesn't use extra memory
                 track splitting via indices

             merge phase = NOT in-place algorithm
                 creates temporary arrays for sorting siblings for merge

         ! STABLE ALGORITHM:

             if there are duplicate elements, the original order of these elements will be preserved

                 because only swap if element at index_i > (index_i + 1)

         ! MERGE SORT LOGIC:

             ! DEPTH FIRST SEARCH: recursively, check if the currentNode has any children (left-to-right) that has the search path for the target node

             * divide & conquer algorithm:

                 splitting base problem into several mini-problems, solving mini-problems, and then merging mini-solutions to solve base problem

             * recursive algorithm:

                 calls itself until reaching a base case and then feeds return values to itself to solve backwards

             ? PHASE 1: splitting

                 logical splitting (in-place = no new arrays)

                 1. divide the array into two sub-arrays (left & right partition)
                 2. then recursively divide each subsequent array into two arrays
                 3. UNTIL you have multiple sorted arrays of 1 length

                     split left side first, then right side last
                         each split results in 'sibling arrays'

                     EXAMPLE:

                                  [20, 35, -15, 7, 55, 1, -22]

                         [20, 35, -15]       &&            [7, 55, 1, -22]

                     [20]    &&  [35, -15]            [7, 55]    &&      [1, -22]

                                [35] && [-15]       [7] && [55]        [1] && [-22]

             ? PHASE 2: merging (not in-place)

                 MERGING = sorting elements starting from bottom-to-up with temporary array

                     not in-place: uses new temporary arrays

                 handle left side first, then right side

                     merge all sibling arrays on left & right side before proceeding to higher level to recursively merge resulting sibling arrays

                 STEPS:

                 1. create temp array that can hold all elements in the arrays we're merging

                 2. set i to 1st index of left sibling array

                 3. set j to 1st index of right sibling array

                 4. step through left & right array & get the smallest value for temp: compare left[i] to right[j] sibling arrays

                     if left[i] is smaller, copy to temp array and increment i by 1
                     if right[j] is smaller, copy to temp array and increment j by 1

                     repeat until temp array has merged all elements into temp array in sorted order

                 5. copy temp array back into original input array at the correct position (making it a STABLE algorithm)

                 6. repeat steps 4 & 5 until you have sorted original input array
     */
    public int[] mergeSort(int[] nums) {

        if(nums.length == 0) {
            return null;
        }

        int start = 0;
        int end = nums.length;

        // ! RECURSION: an algorithm calls itself & each call is placed on the call stack waiting for a return value until the algorithm can no longer call itself (the base case/breaking condition)
        recursivePartition(nums, start, end);

        return nums;
    }

    /**
     *
     * @param nums input array
     * @param start start index for partition
     * @param end end index for partition
     * @return
     */
    private static void recursivePartition(int[] nums, int start, int end){

        // ! RECURSION base case/breaking condition: the algorithm either upward propagates recursive call return for stack resolution or experiences a stack overflow
        // CANNOT be nums length given that partition lengths change via recursion
        boolean isBaseCase = (end - start) < 2;
        int partitionLength = start + end;
        int midpoint = partitionLength / 2;

        if(isBaseCase) {
            return;
        }

        /*
            * ex) [20, 35, -15, 7, 55, 1, -22]
            * midpoint = 7

            ? LEFT partition + sub-partitions

                [20, 35, -15] ->
                    [20] [35, -15] ->
                        [20] [35] [-15]
         */
        recursivePartition(nums, start,  midpoint);

        /*
            * ex) [20, 35, -15, 7, 55, 1, -22]
            * midpoint = 7

            ? RIGHT partition + sub-partitions
                [7, 55, 1, -22] ->
                    [7, 55] [1,-22] ->
                        [7] [55] [1] [-22]
         */
        recursivePartition(nums, midpoint, end);

        // merge 1-element partitions and subsequent sorted partitions
        merge(nums, start, end, midpoint);
    }

    /**
     *
     * @param nums input array
     * @param start start index for partition
     * @param end end index for partition
     * @param midpoint start or end index for left or right partition respectively
     */
    private static void merge(int[] nums, int start, int end, int midpoint) {

        int currentLeftEnd = nums[midpoint-1];
        int currentRightStart = nums[midpoint];

        boolean isAlreadySortedLeftToRight = currentLeftEnd <= currentRightStart;

        // do nothing if already sorted
        if(isAlreadySortedLeftToRight) {
            return;
        }

        // copy into temp array needed bc for inserting in sorted order for input array
        int i = start;
        int j = midpoint;
        int tempIndex = 0;
        int tempLength = end - start;

        int[] temp = new int[tempLength];

        // depthFirstSearch traversal of left & right partitions, respectively
        while(i < midpoint && j < end) {

            int currentLeftElement = nums[i];
            int currentRightElement = nums[j];

            boolean hasPreservedPartitions = currentLeftElement <= currentRightElement;

            // ? MERGE SORT: write smaller of 2 comparison elements to temp array for left-to-right sorted order
            // ! STABLE ALGORITHM: if equal, write left first to preserve original order
            if(hasPreservedPartitions) {
                temp[tempIndex++] = nums[i++];
            } else {
                temp[tempIndex++] = nums[j++];
            }
        }

        /*
            ? MERGE SORT OPTIMIZATION

                LEFT partition remaining elements, must copy to temp array

                RIGHT partition remaining elements, no copying into temp array needed bc already will be in sorted order for input array
         */

        int[] sourceArray;

        int destinationIndex = start + tempIndex;
        int remainingElementIndex = i;

        // no action, if no remainder left partition elements
        // else move to correct index
        int notCopiedTotal = midpoint - i;

        // ? MERGE SORT: copying sorted tempArray elements back into inputArray
        sourceArray = nums;
        System.arraycopy(sourceArray, remainingElementIndex, nums, destinationIndex, notCopiedTotal);

        // only copy numElements in tempArray into inputArray
        sourceArray = temp;
        System.arraycopy(sourceArray, 0, nums, start, tempIndex);
    }

     /*
         ? given an array of integers, sort the elements using the quick sort algorithm.

         ! QUICK SORT (Depth-First-Search)

            Quick Sort works by selecting a pivot element from the array

            it will partition at the pivot point into two halves
                where the smaller element on the left and the greater element on the right.

            It'll keep for doing this process recursively until the entire array is sorted.

         ! Big(O) TIME COMPLEXITY: the worst case scenario for the number of steps in an algorithm's execution

             * LOGARITHMIC TIME COMPLEXITY = O(logn) = O of log to the base 2 n
                     repeatedly dividing array in half during splitting

         ! SPACE COMPLEXITY:

             in-place algorithm that doesn't use extra memory

         ! UNSTABLE ALGORITHM:

             if there are duplicate elements, no guarantee that their original order will be preserved,
                 since quick sort is predicated on moving elements around a pivotIndex for recursive partitions

         ! QUICK SORT LOGIC:

             * divide & conquer algorithm:
                 splitting base problem into several mini-problems, solving mini-problems, and then merging mini-solutions to solve base problem

             * recursive algorithm:
                 calls itself until reaching a base case and then feeds return values to itself to solve backwards

             ? PHASE 1: partitioning step/pivotIndex splitting

                 identify pivotIndex for logical splitting (in-place = no new arrays)

                     each element and it's respective index eventually serves as the pivotIndex

                     CHECK: pivotIndex serves as boundary for 2 sibling sub-arrays that prevent crossover

                 1. divide the array into two sub-arrays (left & right partitions)
                 2. then recursively divide each subsequent array into two arrays
                 3. UNTIL you have multiple sorted arrays of 1 length (each containing the pivotIndex element at it's correct position)

                     in left sub-array, elements less than pivotIndex element are moved to the left during traversal
                     in right sub-array, elements greater than pivotIndex element are moved to the right during traversal

                     AS A RESULT, element at pivotIndex will be in the middle AND in its correct position

                     EXAMPLE:

                        right-to-left first
                        left-to-right second
                                                      [20, 35, -15, 7, 55, 1, -22]

                                     [-15, 7, 20, 35]       pivotIndex = 7            [-22, 1, 7, 55]

                     [-15, 7]    pivotIndex = 7  [7, 20, 35]            [-22, 1]    pivotIndex = 1      [1, 7, 55]

             [-15] && [7]     [7, 20] pivotIndex = 20 [20, 35]       [-22] && [1]        [1, 7] pivotIndex = 7 [7, 55]

                             [7] && [20] && [35]                                     [1] && [7] && [55]

                 STEPS:

                     STEP 1: identify pivotIndex for 2-or-more element arrays
                         pivotIndex is the correct position in the sorted array

                     STEP 2: use recursion to subsequently partition the left & right partitioned arrays into more sub-arrays using the pivotIndex
                         BREAK CASE for recursive calls: handle 1 element arrays

                         using the first element respective index in the array as the pivotIndex

                         for left partition, search/traverse from left to right
                         for right partition, search/traverse from right to left
                         stop traversal when i and j cross each other to maintain partitions

                         FOUND 1st element less than pivot during traversal of LEFT partition: so move elements at index j to index i (move to LEFT of pivotIndex)
                         FOUND 1st element greater than pivot during traversal of RIGHT partition: so move elements at index i to index j (move to RIGHT of pivotIndex)

                         after correct index for pivotIndex element has been FOUND after each traversal, re-assign pivotIndex for subsequent sub-arrays/partitions

             ? PHASE 2: merging

                 MERGING = sorting elements/pivotIndex in respective 1-element array that are starting from bottom-to-up in-place

                 handle left side first, then right side

                     merge all sibling arrays on left & right side before proceeding to higher level to recursively merge resulting sibling arrays

                     after correct index for pivotIndex element has been FOUND after each traversal, re-assign pivotIndex for subsequent sub-arrays/partitions
     */
    public int[] quickSort(int[] nums, int start, int end) {

        // ! EXCEPTION HANDLING: LOOK BEFORE YOU LEAP (LBYL) = use conditional if-else block
        if(nums.length == 0) {
            return null;
        }

        // ! RECURSION: an algorithm calls itself & each call waiting for a return value until the algorithm can no longer call itself (the base case/breaking condition)
        boolean isBaseCase = (end - start) < 2;

        // 1-element arrays are sorted and don't require a recursive call
        if(isBaseCase) {
            return nums;
        }

        /*
            * STEP 1: recursively break up array into sub-arrays to identify pivotIndex for 2-or-more element arrays

                ? use pivotIndex to move smaller elements left & larger elements right

                     EXAMPLE:

                        right-to-left first
                        left-to-right second
                                                      [20, 35, -15, 7, 55, 1, -22]

                                     [-15, 7, 20, 35]       pivotIndex = 7            [-22, 1, 7, 55]

                     [-15, 7]    pivotIndex = 7  [7, 20, 35]            [-22, 1]    pivotIndex = 1      [1, 7, 55]

             [-15] && [7]     [7, 20] pivotIndex = 20 [20, 35]       [-22] && [1]        [1, 7] pivotIndex = 7 [7, 55]

                             [7] && [20] && [35]                                     [1] && [7] && [55]

         */
        int pivotIndex = quickPartition(nums, start, end);

        /*
            * STEP 2: use recursion to subsequently shift elements left or right in relation to pivot index
            ! RECURSION + DIVIDE & CONQUER: partition LEFT side FIRST, THEN RIGHT side with midpoint via start & end sub-array
         */
        // LEFT PARTITIONS
        nums = quickSort(nums, start, pivotIndex);

        // RIGHT partition
        nums = quickSort(nums, pivotIndex + 1, end);

        return nums;
    }

    private static int quickPartition(int[] nums, int start, int end) {

        // use first element in the inputArray OR sub-array as the pivot
        int pivotIndex = nums[start];

        // ? QUICK SORT in-place: alternate between traversing right-to-left & left-to-right & shift relative to pivot
        // traverse left-to-right
        int i = start;

        // traverse right-to-left
        int j = end;

        // define partitions by ensuring no crossover between traversing index
        while(i < j) {

            // ! LEFT PARTITIONS
            // decrement j to traverse array right-to-left for an element less than the pivot
            while(i < j && (nums[--j] >= pivotIndex));

            // * stop traversal when i and j cross each other to maintain partitions
            // if i > j, the indices have crossed
            if(i < j) {
                // * FOUND 1st element less than pivot during traversal of respective partition: so move element at index j to index i (move to LEFT of pivotIndex)
                nums[i] = nums[j];
            }

            // ! RIGHT PARTITIONS
            // decrement i before execution to traverse array left-to-right for an element greater than the pivot
            while(i < j && (nums[++i] <= pivotIndex));

            if(i < j) {

                // * FOUND 1st element greater than pivot during traversal of respective partition: so move element at index i to index j (move to RIGHT of pivotIndex)
                nums[j] = nums[i];
            }
        }

        // * index j will become the new pivotIndex for subsequent sub-arrays/partitions
        nums[j] = pivotIndex;
        return j;
    }
}

class LeetCodeLinkedList extends ChallengesLeetCodeUtil {

    // OOP constructor that initializes the class fields on class object instantiation
    public LeetCodeLinkedList() {
        // ! INHERITANCE: child subclass that inherits the extending parent super class
        super();
    }

    /**
     * ? Amazon LeetCode 876:
     *
     * ?    Given a non-empty, singly linked list with a head node "head", return a middle node of the linked list
     * ?    if there are two middle nodes, return the second
     *
     * * example)
     *
     *      linkedList: 1-2-3-4-5-null
     *
     *      solution: 3-4-5-null
     *
     * * O(n) constant TIME COMPLEXITY: single pass through & dependent on input array size
     * * O(1) constant TIME COMPLEXITY: using an ordered array
     *
     * @return a linkedList
     */
    public LinkedList<Integer> getMiddleLinkedList(LinkedList linkedList) {

        if(linkedList.isEmpty()) {
            return null;
        }

        LinkedList<Integer> results = new LinkedList<>();
        ListIterator<Integer> p1 = linkedList.listIterator();
        ListIterator<Integer> p2 = linkedList.listIterator();

        p1.next();
        p2.next();

        int middle = 0;

        while(p2.hasNext()) {

            // ! UNBOXING: casting wrapper class dataType -> primitive
            middle = p1.next();

            p2.next();
            p2.next();
        }

        results.add(middle);

        while(p1.hasNext()) {
            results.add(p1.next());
        }

        return results;
    }

    /**
     * ? Design a circular linkedList that supports the methods:
     *      add()
     *      hasCycle()
     *      display()
     *
     * * example)
     *
     *      hasCycle:   1 - 2 - 3
     *                  |       |
     *                  6 - 5 - 4
     *
     *      noCycle: 3-4-5-null
     *
     * * O(n) constant TIME COMPLEXITY: single pass through & dependent on input array size
     * * O(1) constant TIME COMPLEXITY: using an ordered array
     */
    class CircularLinkedList {

        // CONSTANTS/static class variables assigned FINAL value before compilation/instantiation
        private static final String EMPTY = "List is empty";
        private static final String TITLE = "Circular LinkedList:";

        // ! INNER CLASS + package private access modifier: logically grouped components within a super class
        class Node {
            // OOP ENCAPSULATION private class fields
            private int data;
            private Node next;

            // OOP constructor that initializes the class fields on class object instantiation
            public Node(int data) {
                this.data = data;
            }

            // OOP getters & setters
            public int getData() {
                return data;
            }

            public void setData(int data) {
                this.data = data;
            }

            public Node getNext() {
                return next;
            }

            public void setNext(Node next) {
                this.next = next;
            }
        }

        // OOP ENCAPSULATION private class fields
        Node head = null;
        Node tail = null;

        public void add(int data) {
            // create a new node
            Node newNode = new Node(data);

            // check if linkList is empty
            if(head == null) {

                head = newNode;
                tail = newNode;

                newNode.setNext(newNode);

            } else {
                // tail will point to new node.
                tail.setNext(newNode);

                // New node will become new tail.
                tail = newNode;

                //Since, it is circular linked list tail will point to head.
                tail.setNext(head);
            }
        }

        public boolean hasCycle() {

            if(this.head == null || this.head.getNext() == null) {
                return false;
            }

            display();
            return this.head == this.tail.getNext();
        }

        public void display() {

            Node current = this.head;

            if(head == null) {

                System.out.println(EMPTY);

            } else {

                System.out.println(TITLE);

                do {

                    System.out.print(" " + current.getData());
                    current = current.getNext();

                } while(current != this.head);
            }

            System.out.println("\nHead: " + this.head.getData() +
                    "\nTail Next: " + this.tail.getNext().getData());
        }
    }

    /**
     * ? Design a singly linkedList of Employee objects that supports the methods:
     *      addToHead(): add Node to top
     *      getSize():
     *      getHead():
     *      pop()
     *
     * * example)
     *
     *      linkedList: null-3-4-5-null
     *
     * * O(n) constant TIME COMPLEXITY: single pass through & dependent on input array size
     * * O(1) constant TIME COMPLEXITY: using an ordered array
     */
    class SinglyLinkedList {

        // CONSTANTS/private static class fields assigned FINAL value before compilation/instantiation
        private static final String CURRENT_HEAD = "Current head: ";

        // OOP ENCAPSULATION private class fields
        private Node head;
        private Integer size;

        // OOP constructor that initializes the class fields on class/object instantiation
        public SinglyLinkedList() {

            // default values
            this.head = null;
            this.size = 0;
        }

        // ! INNER CLASS: logically grouped components within a super-class
        class Node {

            // OOP ENCAPSULATION private class fields
            private Employee employee;
            private Node next;

            // OOP constructor that initializes the class fields on class/object instantiation
            public Node(Employee employee) {
                this.employee = employee;
            }

            // ! POLYMORPHISM + INTERFACE: uniquely implement/@Override publicly-shared signature
            @Override
            public String toString() {
                return employee.toString();
            }

            // OOP ENCAPSULATION GETTERS & SETTERS
            public Employee getEmployee() {
                return employee;
            }

            public void setEmployee(Employee employee) {
                this.employee = employee;
            }

            public Node getNext() {
                return next;
            }

            public void setNext(Node next) {
                this.next = next;
            }
        }

        // NON-STATIC CLASS METHODS: unique object behavior
        public void addToHead(Employee employee) {

            // create new node with respective data
            Node node = new Node(employee);

            // the new node's next field is going to point at the current head that's shifted to the second node
            node.setNext(this.head);

            // the head will point to the new node as the first node in the list
            this.head = node;

            this.size++;
        }

        public Node pop() {

            if(!isEmpty()) {

                // save head
                Node removedNode = this.head;

                // point head at 2nd in the list
                this.head = this.head.getNext();

                // decrement length
                this.size--;

                removedNode.setNext(null);
                return removedNode;
            }

            return null;
        }

        public void printList() {
            Node current = this.head;
            System.out.println(CURRENT_HEAD);

            while(current != null) {
                System.out.println(current + " -> ");
                current = current.getNext();
            }
            System.out.println("null");
        }

        private boolean isEmpty() {
            return this.head == null;
        }

        // OOP getters & setters
        public Node getHead() {
            return head;
        }

        public int getSize() {

            if(isEmpty()) {
                return 0;
            }

            // ! UNBOXING: casting wrapper class dataType -> primitive
            return this.size;
        }
    }
}