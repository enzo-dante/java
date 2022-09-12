package crownhounds.learnjava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

/**
 * Please refer to Challenges class
 */
public class Challenges_Utility {

    public static final String DIFFERENT_MESSAGE = "All numbers are different";
    public static final String DIVIDER = "\n------------\n";
    public static final String EXIT = "exit";
    public static final String EQUAL_MESSAGE = "All numbers are equal";
    public static final String INVALID_VALUE = "Invalid Value";
    public static final String INVALID_INPUT = "Invalid Input";
    public static final String NEITHER_MESSAGE = "Neither all are equal or different";
    public static final int NEGATIVE_ONE = -1;
    public static final String USER_PROMPT = "\nPlease select an option:\n";
    public static final String USER_NAME_PROMPT = "\nPlease enter a name:\n";
    public static final String USER_NUMBER_PROMPT = "\nPlease enter a number:\n";

    public static void printMethodName(String className, String methodName) {

        System.out.println(className + "." + methodName + "() was called\n");

    }
}

class BarkingDog {

    public static boolean shouldWakeUp(boolean barking, int hourOfDay) {

        boolean isAwake = false;

        if(hourOfDay < 0 || hourOfDay > 23) {
            isAwake = false;
        } else if((barking && hourOfDay < 8) ||
                (barking && hourOfDay > 22)) {
            isAwake = true;
        }

        return isAwake;
    }
}

class DecimalComparator {

    public static boolean areEqualByThreeDecimalPlaces(double num1, double num2) {

        // multiply both params by 1000 to move comparison numbers for int casting
        int int1 = (int) (num1 * 1000);
        int int2 = (int) (num2 * 1000);

        return int1 == int2;
    }
}

class DigitalSum {

    public static int sumDigits(int number) {

        int sum = 0;
        int numberLength = Integer.toString(number).length();

        if(number <= 10) {
            return -1;
        }

        // for loop solution
//        for(int i = 0; i < numberLength; i++) {
//            sum += number % 10;
//            number /= 10;
//        }

        // while loop solution
        while(number > 0) {
            // extract the least significant digit
            int digit = number % 10;
            sum += digit;

            // drop least significant digit
            number /= 10;
        }

        return sum;
    }
}

class EqualSumChecker {

    public static boolean hasEqualSum(int num1, int num2, int num3) {

        return (num1 + num2) == num3;
    }
}

class EvenDigitSum {

    public static int getEvenDigitSum(int number) {

        int sum = 0;
        int remainder = 0;
        int numLastIndex = Integer.toString(number).length() -1;

        if (number < 0) {
            return -1;
        }

        for(int i = numLastIndex; i >= 0; i--) {

            remainder = number % 10;
            number /= 10;

            if(remainder % 2 == 0) {
                sum += remainder;
            }
        }

        return sum;

    }
}

class FactorPrinter {

    public static void printFactors(int number) {

        if(number < 1) {
            System.out.println(Challenges_Utility.INVALID_VALUE);
        } else {
            for(int f = 1; f <= number; f++) {
                if(number % f == 0) {
                    System.out.println(f);
                }
            }
        }
    }
}

class FirstLastDigitSum {

    public static int sumFirstAndLastDigit(int number) {

        String numStr = Integer.toString(number);
        int firstDigit = 0;
        int lastDigit = 0;

        if(number < 0) {
            return -1;
        } else if(numStr.length() == 1) {
            firstDigit = number;
            lastDigit = number;
        } else {
            for(int i = numStr.length() - 1; i >= 0; i--) {

                if(i == numStr.length() - 1) {
                    lastDigit = number % 10;
                } else if(i == 0) {
                    firstDigit = number % 10;
                }

                // pop off smallest digit
                number /= 10;
            }
        }

        return firstDigit + lastDigit;
    }
}

class FlourPacker {

    public static boolean canPack(int bigCount, int smallCount, int goal) {

        boolean hasFullBag = false;
        int convertedBigCount = bigCount * 5;
        int convertedBigRemainder = convertedBigCount % 5;

        if(bigCount < 0 || smallCount < 0 || goal < 0) {
            return false;
        }

        // bigCount doesn't apply
        if(goal < 5) {

            hasFullBag = smallCount >= goal;

            // evenly divBy5 convertedBigCount
        } else if(convertedBigCount % 5 == 0) {

            if(convertedBigCount > goal) {

                convertedBigCount = (goal / 5) * 5;

            }

            hasFullBag = convertedBigCount + smallCount >= goal;

        } else {

            // divBy5 convertedBigCount with remainder
            hasFullBag = (convertedBigCount - convertedBigRemainder) + smallCount >= goal;

        }

        return hasFullBag;
    }
}

class IntEqualityPrinter {

    public static void printEqual(int num1, int num2, int num3) {

        if(num1 < 0 || num2 < 0 || num3 < 0) {
            System.out.println(Challenges_Utility.INVALID_VALUE);
            return;
        }

        if(num1 == num2 && num1 == num3) {
            System.out.println(Challenges_Utility.EQUAL_MESSAGE);
        } else if((num1 != num2 && num1 != num3) &&
                (num2 != num3)) {
            System.out.println(Challenges_Utility.DIFFERENT_MESSAGE);
        } else {
            System.out.println(Challenges_Utility.NEITHER_MESSAGE);
        }
    }
}

class LargestPrime {

    public static int getLargestPrime(int number) {

        int largestPrimeFactor = 2;
        boolean isDivisibleFactor;

        if(number <= 1) {
            return -1;
        }

        // continue loop until you get to largestPrimeFactor
        while(largestPrimeFactor < number) {

            isDivisibleFactor = number % largestPrimeFactor == 0;

            if(isDivisibleFactor) {

                // decrement number by factor to get to prime factors
                number /= largestPrimeFactor;

            } else {
                largestPrimeFactor++;
            }
        }

        return number;
    }
}

class LastDigitChecker {

    public static boolean hasSameLastDigit(int num1, int num2, int num3) {

        boolean hasSameLastFor2 = false;

        if(isValid(num1) && isValid(num2) && isValid(num3)) {

            if(getLastDigit(num1) == getLastDigit(num2) ||
                    getLastDigit(num1) == getLastDigit(num3) ||
                    getLastDigit(num2) == getLastDigit(num3)) {

                hasSameLastFor2 = true;
            }
        }

        return hasSameLastFor2;
    }

    private static boolean isValid(int number) {

        return number >= 10 && number <= 1000;

    }

    private static int getLastDigit(int number) {

        return number % 10;

    }
}

class LeapYearCalculator {

    public static boolean isLeapYear(int year) {

        boolean isYearLeaped = false;
        boolean isDivBy4 = year % 4 == 0;
        boolean isDivBy100 = year % 100 == 0;
        boolean isDivBy400 = year % 400 == 0;
        boolean isRange1To10000 = (year >= 1) && (year < 10000);

        if(isRange1To10000 && isDivBy4) {

            if(!isDivBy100) {
                isYearLeaped = true;

            } else if(isDivBy400) {
                isYearLeaped = true;
            }
        }

        return isYearLeaped;
    }
}

class MegaBytesConverter {

    public static void printMegaBytesAndKiloBytes(int kiloBytes) {
        double kiloToMegaRatio = 1024D; // 1024 KB = 1 MB
        long megaBytes = (long) Math.floor(kiloBytes / kiloToMegaRatio); // how many times does 1 megaByte (1024 kiloBytes) go into x kiloBytes
        long remainder = Math.round(kiloBytes % kiloToMegaRatio);

        if(kiloBytes < 0) {
            System.out.println(Challenges_Utility.INVALID_VALUE);
        } else {
            System.out.println(kiloBytes + " KB = " + megaBytes + " MB and " +  remainder + " KB");
        }
    }
}

class MinutesToYearsDaysCalculator {

    public static void printYearsAndDays(long minutes) {

        String formattedMessage = "XX min = YY y and ZZ d";
        long totalHours = minutes / 60L;
        long totalDays = totalHours / 24L;
        long totalYears = totalDays / 365L;
        long remainingDays = totalDays % 365L;

//        System.out.println(minutes);
//        System.out.println(totalHours);
//        System.out.println("totalDays: " + totalDays);
//        System.out.println("remainingDays: " + remainingDays);
//        System.out.println(totalYears);

        if(minutes < 0) {
            System.out.println(Challenges_Utility.INVALID_VALUE);
        } else {
            formattedMessage = formattedMessage.replace("XX", Long.toString(minutes))
                    .replace("YY", Long.toString(totalYears))
                    .replace("ZZ", Long.toString(remainingDays));

            System.out.println(formattedMessage);
        }
    }
}

class NumberInWord {

    public static void printNumberInWord(int num) {

        // enhanced switch statement
//        switch (num) {
//            case 0 -> System.out.println("ZERO");
//            case 1 -> System.out.println("ONE");
//            case 2 -> System.out.println("TWO");
//            case 3 -> System.out.println("THREE");
//            case 4 -> System.out.println("FOUR");
//            case 5 -> System.out.println("FIVE");
//            case 6 -> System.out.println("SIX");
//            case 7 -> System.out.println("SEVEN");
//            case 8 -> System.out.println("EIGHT");
//            case 9 -> System.out.println("NINE");
//            default -> System.out.println("OTHER");
//        }

        // basic switch statement
        switch(num) {
            case 0:
                System.out.println("ZERO");
                break;
            case 1:
                System.out.println("ONE");
                break;
            case 2:
                System.out.println("TWO");
                break;
            case 3:
                System.out.println("THREE");
                break;
            case 4:
                System.out.println("FOUR");
                break;
            case 5:
                System.out.println("FIVE");
                break;
            case 6:
                System.out.println("SIX");
                break;
            case 7:
                System.out.println("SEVEN");
                break;
            case 8:
                System.out.println("EIGHT");
                break;
            case 9:
                System.out.println("NINE");
                break;
            default:
                System.out.println("OTHER");
                break;
        }
    }

    public static void printNumberInWord(int num, ArrayList<String> numList) {
        if(num == 0) {
            System.out.println(numList.get(num));
        } else if(num == 1) {
            System.out.println(numList.get(num));
        } else if(num == 2) {
            System.out.println(numList.get(num));
        } else if(num == 3) {
            System.out.println(numList.get(num));
        } else if(num == 4) {
            System.out.println(numList.get(num));
        } else if(num == 5) {
            System.out.println(numList.get(num));
        } else if(num == 6) {
            System.out.println(numList.get(num));
        } else if(num == 7) {
            System.out.println(numList.get(num));
        } else if(num == 8) {
            System.out.println(numList.get(num));
        } else if(num == 9) {
            System.out.println(numList.get(num));
        } else {
            System.out.println("OTHER");
        }
    }

}

class NumberOfDaysInMonth {

    public static boolean isLeapYear(int year) {

        if(year < 1 || year > 9999) {
            return false;
        }

        boolean isLeap = false;

        if(year % 4 == 0 &&
                year % 100 == 0 &&
                year % 400 == 0) {
            isLeap = true;
        } else if(year % 4 == 0 && year % 100 != 0) {
            isLeap = true;
        }

        return isLeap;
    }

    public static int getDaysInMonth(int month, int year) {

        if((month < 1 || month > 12) ||
                (year < 1 || year > 9999)) {
            return -1;
        }

        int numMonthDays = 0;

        switch(month) {
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                numMonthDays = 31;
                break;
            case 4: case 6: case 9: case 11:
                numMonthDays = 30;
                break;
            case 2:
                numMonthDays = isLeapYear(year) ? 29 : 28;
                break;
            default:
                numMonthDays = -1;
                break;
        }

        return numMonthDays;
    }
}

class PlayingCat {

    public static boolean isCatPlaying(boolean summer, int temperature) {

        boolean isPlaying = false;

        if(!summer &&
                ((temperature >= 25) && (temperature <= 35))) {
            isPlaying = true;
        } else if(summer &&
                ((temperature >= 25) && (temperature <= 45))) {
            isPlaying = true;
        }

        return isPlaying;
    }
}

class SharedDigit {

    public static boolean hasSharedDigit(int num1, int num2) {

        boolean hasShared = true;
        int digit0 = 0;
        int digit1 = 0;
        int digit2 = 0;
        int digit3 = 0;

        if((num1 < 10 || num1 > 99) ||
                (num2 < 10 || num2 > 99)) {

            hasShared = false;

        } else {

            digit0 = num1 % 10;
            digit1 = num1 / 10;
            digit2 = num2 % 10;
            digit3 = num2 / 10;

            if(digit0 != digit2 &&
                    digit0 != digit3 &&
                    digit1 != digit2 &&
                    digit1 != digit3) {

                hasShared = false;

            }
        }

        return hasShared;
    }
}

class SumOddRange {

    private static boolean isOdd(int number) {

        if(number < 0 || number % 2 == 0) {
            return false;
        }

        return true;
    }

    public static int sumOdd(int start, int end) {

        int sum = 0;

        if(start < 0 || end < start) {
            System.out.println(Challenges_Utility.NEGATIVE_ONE);
            return -1;
        }

        for(int i = start; i <= end; i++) {

            if(isOdd(i)) {
                sum += i;
            }
        }

        System.out.println("sum: " + sum);
        return sum;
    }
}

class TeenNumberChecker {

    public static boolean hasTeen(int num1, int num2, int num3) {

        // ! if one of params is "teen" (range 13 -19 (inclusive)), return true
        int minRange = 13;
        int maxRange = 19;
        boolean inRange = (num1 >= minRange && num1 <= maxRange) ||
                (num2 >= minRange && num2 <= maxRange) ||
                (num3 >= minRange && num3 <= maxRange);

        return inRange;
    }

    public static boolean isTeen(int num) {
        return (num >= 13) && (num <= 19);
    }
}

class MinElement {

    Scanner scanner = new Scanner(System.in);

    public int[] readIntegers(int count) {

        int[] userIntegers = new int[count];
        int i = 0;
        int userNum;

        while(i < userIntegers.length) {

            System.out.println(Challenges_Utility.USER_PROMPT);

            // only capture valid int values
            if(scanner.hasNextInt()) {

                // capture integer user input
                userNum = scanner.nextInt();

                // handle 'enter' key down to continue capturing user input
                scanner.nextLine();

                userIntegers[i] = userNum;
                i++;

            } else {
                System.out.println(Challenges_Utility.INVALID_INPUT);
                scanner = new Scanner(System.in);
            }
        }

        // release resource in memory
        scanner.close();

        return userIntegers;
    }

    public int findMin(int[] userIntegers) {

        return selectionSort(userIntegers)[0] > Integer.MIN_VALUE ? selectionSort(userIntegers)[0] : -1;

    }

    private int[] selectionSort(int[] userIntegers) {

        // last index in the given iteration of the unsorted partition (array starts as unsorted)
        // ! [[unsortedPartition][]] -> [[unsortedPartition][sortedPartition]]
        int lastUnsortedIndex = userIntegers.length - 1;

        // track the largest value in the unsorted partition
        int currentLargestIndex = 0;

        // unsortedPartition
        for(int i = 0; i <= lastUnsortedIndex; i++) {

            if(i == lastUnsortedIndex) {

                // if you reach the end of the unsortedPartition and the last element in unsortedPartition is the largest, id as currentLargestIndex
                if(userIntegers[currentLargestIndex] < userIntegers[lastUnsortedIndex]) {
                    currentLargestIndex = lastUnsortedIndex;
                }

                // swap largest element with element at the end of the unsortedPartition
                swapValues(userIntegers, currentLargestIndex, lastUnsortedIndex);

                // decrement unsortedPartition length/ increment sortedPartition length
                // reset largest element traversal in unsortedPartition
                i = 0;
                currentLargestIndex = 0;
                lastUnsortedIndex--;

            } else {

                // traverse array and track index with the largest element
                if(userIntegers[currentLargestIndex] < userIntegers[i]) {
                    currentLargestIndex = i;
                }
            }
        }

        return userIntegers;
    }

    /**
     * swap the element values at index i and index j in the given array
     */
    private static void swapValues(int[] selectionSortArray, int i, int j) {

        // do nothing if indices are the same to maintain stable algorithm
        if(i == j) {
            return;
        }

        int savedElement = selectionSortArray[i];
        selectionSortArray[i] = selectionSortArray[j];
        selectionSortArray[j] = savedElement;
    }
}

class GroceryList {

    // CONSTANTS
    public static final String PLEASE_ENTER_VALID_CHOICE = "\nPlease enter valid choice:\n" +
            "\t0 - instructions\n" +
            "\nchoice:";
    public static final String PLEASE_ENTER_ITEM_NUMBER = "\nPlease enter item number:\n";
    public static final String PLEASE_ENTER_ITEM_NAME = "\nPlease enter item name:\n";
    public static final String EMPTY_GROCERY_LIST = "Grocery list is empty";
    public static final String QUITING_APP = "\nQuiting grocery list app\n";
    public static final String QUIT_UPDATE = "\nQuiting update";
    public static final String QUIT_DELETE = "\nQuiting delete";

    // class fields/instance members
    ArrayList<String> itemList;
    Scanner scanner = new Scanner(System.in);

    // constructor to initialize the fields on class instantiation
    public GroceryList() {
        this.itemList = new ArrayList<String>();
    }

    // non-static class methods/unique behaviors
    public boolean validateGroceryListSize() {

        if(this.itemList.size() > 0) {
            return true;
        }

        System.out.println(EMPTY_GROCERY_LIST);
        return false;
    }

    // overloaded method
    public boolean validateGroceryListSize(int providedUserIndex, boolean isRemove) {

        if(this.itemList.size() > providedUserIndex) {
            System.out.println(Challenges_Utility.INVALID_INPUT + ": item number");
            readGroceryList();
            return false;
        }
        return true;
    }

    // overloaded method
    public boolean validateGroceryListSize(int providedUserIndex) {

        if(this.itemList.size() < providedUserIndex) {
            System.out.println(Challenges_Utility.INVALID_INPUT + ": item number");
            readGroceryList();
            return false;
        }
        return true;
    }

    public void readGroceryList() {
        System.out.println(getClass().getSimpleName() + ".readGroceryList() was called\n");

        if(validateGroceryListSize()) {
            for(int i = 0; i < this.itemList.size(); i++) {
                System.out.println((i + 1) + ": " + this.itemList.get(i));
            }

            System.out.println(Challenges_Utility.DIVIDER);
        }
    }

    public void addItemToGroceryList(String item) {

        this.itemList.add(item);
        System.out.println(getClass().getSimpleName() + ".addItemToGroceryList() was called\n" +
                item + " was added to the grocery list");
    }

    public void updateItemInGroceryList(int updateIndex, String newItem) {
        this.itemList.set(updateIndex, newItem);
        System.out.println(getClass().getSimpleName() + ".updateItemInGroceryList() was called\n" +
                "index " + updateIndex + " was updated to have " + newItem);
    }

    public void removeItemFromGroceryList(int removeIndex) {
        System.out.println(getClass().getSimpleName() + ".removeItemFromGroceryList() was called");
        String removeItem = this.itemList.get(removeIndex);

        if(removeItem != null) {
            this.itemList.remove(removeItem);
            System.out.println(removeItem + " was removed from the grocery list");
        } else {
            System.out.println("item to remove was not found in the grocery list");
        }
    }

    public String queryGroceryList(String queryItem) {
        System.out.println(getClass().getSimpleName() + ".queryGroceryList() was called");
        boolean hasQueryItem = this.itemList.contains(queryItem);

        if(hasQueryItem) {
            int queryIndex = this.itemList.indexOf(queryItem);
            if(queryIndex >= 0) {
                return this.itemList.get(queryIndex);
            }
        }

        return null;
    }

    public boolean quitGroceryListApp() {
        System.out.println(getClass().getSimpleName() + ".quitGroceryListApp() was called\n" + QUITING_APP);
        return true;
    }

    public void printGroceryListInstructions() {
        System.out.println("GroceryList.printInstructions() was called");

        System.out.println("\n\tINSTRUCTIONS:\n" +
                "0 - print grocery list instructions\n" +
                "1 - read grocery list\n" +
                "2 - add item to grocery list\n" +
                "3 - update item to grocery list\n" +
                "4 - remove item to grocery list\n" +
                "5 - query item to grocery list\n" +
                "6 - quit grocery list app\n"
        );
    }

    public void copyGroceryList(ArrayList<String> arrayList) {
        ArrayList<String> copyArrayList = new ArrayList<String>(getItemList());
        arrayList.addAll(getItemList());
    }

    // getters & setters
    public ArrayList<String> getItemList() {
        return this.itemList;
    }

    public void setItemList(ArrayList<String> itemList) {
        this.itemList = itemList;
    }
}

class Phone {

    // class fields
    String myPhoneNumber;
    boolean powerOn;

    // constructor to initialize the fields on class/object instantiation
    public Phone(String myPhoneNumber) {
        this.myPhoneNumber = myPhoneNumber;
        this.powerOn = false;
    }

    // unique class methods/behaviors

    // getters & setters
    public String getMyPhoneNumber() {
        return myPhoneNumber;
    }

    public void setMyPhoneNumber(String myPhoneNumber) {
        this.myPhoneNumber = myPhoneNumber;
    }
}


class Bank {

    // CONSTANTS
    private final String CLASS_NAME = getClass().getSimpleName();

    // private class fields/object instance members
    private String name;
    private ArrayList<Branch> branches;

    // constructor that initializes the fields on class/object instantiation
    public Bank(String name) {
        this.name = name;
        this.branches = new ArrayList<Branch>();
    }

    // unique non-static behaviors

    public boolean addBranch(String branchName) {

        Challenges_Utility.printMethodName(CLASS_NAME, "addBranch");

        if(findBranch(branchName) == null) {
            this.branches.add(new Branch(branchName));
            System.out.println(branchName + " branch was added");
            return true;
        }

        System.out.println(branchName + " already exists");
        return false;
    }

    public boolean addCustomer(String branchName, String customerName, double initialTransaction) {

        Challenges_Utility.printMethodName(CLASS_NAME, "addCustomer");

        Branch queryBranch = findBranch(branchName);

        if(queryBranch != null) {

            System.out.println("SUCCESS: addCustomer()");
            return queryBranch.newCustomer(customerName, initialTransaction);

        }

        System.out.println("FAILED: addCustomer()");

        return false;
    }

    /*
        ! POLYMORPHISM is the mechanism in OOP that enables methods
            to function differently based on the type of object that is executing the method
    */
    public boolean addCustomerTransaction(String branchName, String customerName, double transaction) {
        Challenges_Utility.printMethodName(CLASS_NAME, "addCustomerTransaction");

        Branch queryBranch = findBranch(branchName);

        if(queryBranch != null) {

            System.out.println("SUCCESS: addCustomerTransaction()");
            return queryBranch.addCustomerTransaction(customerName, transaction);
        }

        System.out.println("FAILED: addCustomerTransaction()");
        return false;
    }

    // ! ENCAPSULATION enables restricting access to certain components
    private Branch findBranch(String branchName) {
        Challenges_Utility.printMethodName(CLASS_NAME, "findBranch");

        int totalBranches = this.branches.size();

        if(totalBranches > 0) {

            for(int i = 0; i < totalBranches; i++) {

                Branch queryBranch = this.branches.get(i);

                if(Objects.equals(queryBranch.getName(), branchName)) {

                    return queryBranch;
                }
            }
        }
        return null;
    }

    /**
     * This method prints out a list of customers.
     * @param branchName
     * @param printTransactions
     * @return boolean if branch exists
     */
    public boolean listCustomers(String branchName, boolean printTransactions) {
        Challenges_Utility.printMethodName(CLASS_NAME, "listCustomers");

        Branch queryBranch = findBranch(branchName);

        if(queryBranch != null) {

            ArrayList<Customer> customers = queryBranch.getCustomers();
            for(int i = 0; i < customers.size(); i++) {

                Customer customer = customers.get(i);
                System.out.println("Customer Name:\n" + customer.getName() + "\n");

                ArrayList<Double> transactions = customer.getTransactions();
                if(printTransactions && (transactions.size() > 0)) {

                    for(int j = 0; j < transactions.size(); j++) {
                        System.out.println("transaction: " + transactions.get(j));
                    }
                }
            }

            return true;
        }

        System.out.println(branchName + " was not found");
        return false;
    }

    // getters & setters
}

class Branch {

    // CONSTANTS
    private final String CLASS_NAME = getClass().getSimpleName();

    // private class fields/object instance members
    private String name;
    private ArrayList<Customer> customers;

    // constructor that initializes the fields on class/object instantiation
    public Branch(String name) {
        this.name = name;
        this.customers = new ArrayList<Customer>();
    }

    // unique non-static behaviors
    public boolean addCustomerTransaction(String customerName, double transaction) {

        Challenges_Utility.printMethodName(CLASS_NAME, "addCustomerTransaction");

        Customer queryCustomer = findCustomer(customerName);

        if(queryCustomer != null) {

            System.out.println("SUCCESS: addCustomerTransaction()");
            queryCustomer.addTransaction(transaction);
            return true;
        }

        System.out.println("FAILED: addCustomerTransaction()");
        return false;
    }

    public boolean newCustomer(String customerName, double initialTransaction) {

        Challenges_Utility.printMethodName(CLASS_NAME, "newCustomer");

        if(findCustomer(customerName) == null) {
            System.out.println(customerName + " was added");
            this.customers.add(new Customer(customerName, initialTransaction));
            return true;
        }

        System.out.println(customerName + " already exists");
        return false;
    }

    // ! ENCAPSULATION enables restricting access to certain components
    private Customer findCustomer(String customerName) {

        Challenges_Utility.printMethodName(CLASS_NAME, "findCustomer");

        int totalCustomers = this.customers.size();

        if(totalCustomers > 0) {

            for(int i = 0; i < totalCustomers; i++) {

                Customer queryCustomer = this.customers.get(i);

                if(Objects.equals(queryCustomer.getName(), customerName)) {
                    return queryCustomer;
                }
            }
        }

        return null;
    }

    // getters & setters
    public String getName() {
        return this.name;
    }

    public ArrayList<Customer> getCustomers() {
        return this.customers;
    }
}

class Customer {

    // CONSTANTS
    private final String CLASS_NAME = getClass().getSimpleName();

    // private class fields/object instance members
    private String name;
    private ArrayList<Double> transactions;

    // constructor that initializes the fields on class/object instantiation
    public Customer(String name, double transaction) {
        this.name = name;
        this.transactions = new ArrayList<Double>();

        /*
            ! AUTOBOXING = converting primitive value to Object Wrapper class
                via WrapperClass.valueOf()
        */
        this.transactions.add(Double.valueOf(transaction));
    }

    // unique non-static behaviors
    public void addTransaction(double transaction) {
        /*
            ! AUTOBOXING = converting primitive value to an Object Wrapper class

            ? Shortcut Compilation

                Integer myIntegerValue = 56;
                Integer myIntegerValue = Integer.valueOf(56)
         */

        Double autoboxingTransaction = transaction;
        this.transactions.add(autoboxingTransaction);
    }

    // getters & setters
    public String getName(){
        return this.name;
    }

    public ArrayList<Double> getTransactions() {
        return this.transactions;
    }

}