package crownhounds.learnjava;

import java.util.*;

/**
 * Please refer to DataStructures class
 */
public class DataStructures_Utility {

    // CONSTANTS
    public static final String DIVIDER = "\n-------------------------\n";

    // overloaded method
    public static void formatDivider() {

        System.out.println(DIVIDER);

    }

    public static void formatDivider(String title) {

        System.out.println("\n\t" + title.trim() + " notes\n");

    }

    public static void getLinkedListNotes() {
        /*
            ? LINKED LIST logic:
                while current element in linkedList is pointing to a next valid element, show current element

            * example:
                element_a --> element_b --> element_c
         */

        ArrayList<Integer> intList = new ArrayList<Integer>();
        intList.add(1);
        intList.add(3);
        intList.add(4);

        System.out.println("\nset 1:");
        for(int i = 0; i < intList.size(); i++) {
            System.out.println("\t" + i + ":" + intList.get(i));
        }

        System.out.println("\neach element would be shifted down to correctly index the value 2" +
                "\nprocessing these shifts can be computationally taxing at scale");

        System.out.println("\nset 2:");
        intList.add(1,2); // set value 2 at index 1

        for(int i = 0; i < intList.size(); i++) {
            System.out.println("\t" + i + ":" + intList.get(i));
        }

        DataStructures_Utility.formatDivider();

        LinkedList<String> placesToVisit = new LinkedList<String>();
        placesToVisit.add("LA");
        placesToVisit.add("Phoenix");
        placesToVisit.add("Austin");
        placesToVisit.add("Atlanta");
        placesToVisit.add("Jersey City");
        placesToVisit.add("Manhattan");
        placesToVisit.add("The Bronx");

        DS_LinkedLists.printLinkedList(placesToVisit);

        DataStructures_Utility.formatDivider();

        System.out.println("LinkedList.add(index, value) was called and handled shifting of pointers" +
                "\nelement Alice Springs was added\n");

        placesToVisit.add(1, "Alice Springs");

        DS_LinkedLists.printLinkedList(placesToVisit);

        DataStructures_Utility.formatDivider();

        System.out.println("LinkedList.remove(index) was called and handled shifting of pointers" +
                "\nelement Atlanta was removed\n");

        placesToVisit.remove(4);

        DS_LinkedLists.printLinkedList(placesToVisit);

        DataStructures_Utility.formatDivider();

        LinkedList<String> texasTour = new LinkedList<String>();
        DS_LinkedLists.addInAlphabeticalOrder(texasTour, "San Antonio");
        DS_LinkedLists.addInAlphabeticalOrder(texasTour, "Austin");
        DS_LinkedLists.addInAlphabeticalOrder(texasTour, "Dallas");

        DS_LinkedLists.printLinkedList(texasTour);


    }

    public static void getPrimitiveDataTypeNotes() {

        PrimitiveDataTypes.integers();

        PrimitiveDataTypes.byteShortAndLongs();

        PrimitiveDataTypes.floatingPointNumbers();

        PrimitiveDataTypes.booleansCharsAndStrings();
    }

    public static void getReferencesAndValueNotes() {

        DataStructures_Utility.formatDivider("references and values");

        ReferencesAndValues.getValues();
        ReferencesAndValues.getReferences();
    }

    public static void getArrayNotes() {

        DataStructures_Utility.formatDivider("array");

        DS_Array.createArray();

        DataStructures_Utility.formatDivider();

        DS_Array.getInputSum(5);

        DataStructures_Utility.formatDivider();

        DS_Array.getInputAverage(5);

        DS_Array.resizeArray();

        DataStructures_Utility.formatDivider();

    }

    public static void getArrayListNotes() {

        DataStructures_Utility.formatDivider("arrayList");

        DS_ArrayList.createArrayList();
    }

    public static void getCastingNotes() {

        DataStructures_Utility.formatDivider("casting");

        // CASTING is converting one datatype to another by prefacing with parenthesis with desired data type
        // JAVA uses int data type by default

        byte myMinByte = Byte.MIN_VALUE;
        short myMinShort = Short.MIN_VALUE;

        // error because defined as byte but int provided
        byte myByteTotal = (byte) (myMinByte/2);
        short myShortTotal = (short) (myMinShort / 2);
        System.out.println("CASTING myByteTotal: " + myByteTotal);
        System.out.println("CASTING myShortTotal: " + myShortTotal);
    }

    public static void overAndUnderFlow() {
         /*
        overflow & underflow = value exceeds memory allocated by computer
            Integer is used to perform operations on an int
         */

        DataStructures_Utility.formatDivider("overflow & underflow");

        int myMinInt = Integer.MIN_VALUE;
        int myMaxInt = Integer.MAX_VALUE;
        System.out.println("BUSTED UNDERFLOW MIN: " + (myMinInt - 1));
        System.out.println("BUSTED OVERFLOW MAX: " + (myMaxInt + 1));

    }

}

class ReferencesAndValues {

    public static void getValues() {

        int myIntValue = 10;
        int anotherIntValue = myIntValue;

        System.out.println("both variables have the same value,\n" +
                "but each independent variable is allocated to it's own single space in memory:\n" +
                "\tmyIntValue: " + myIntValue + "\n" +
                "\tantherIntValue: " + anotherIntValue + "\n");
    }

    public static void getReferences() {

        // ! every time the 'new' keyword is used, an object is initialized in memory & referenced
        // * both array of strings below, are referencing the same object address stored in memory

        String[] referenceStrings = new String[3]; // [null, null, null]
        String[] moreReferenceStrings = referenceStrings;

        System.out.println("a reference holds a memory address to the object, but not to the object itself\n" +
                Arrays.toString(referenceStrings) + "\n" +
                Arrays.toString(moreReferenceStrings) + "\n");

        moreReferenceStrings[0] = "test";

        System.out.println("PROOF: only updating moreReferenceStrings,\n" +
                "updates both variables because they are BOTH referencing the same space in memory\n" +
                Arrays.toString(referenceStrings) + "\n" +
                Arrays.toString(moreReferenceStrings));


        String[] stringsToModify = modifyArray(referenceStrings);

        System.out.println("PROOF: stringsToModify is a 3rd additional reference to the same address in memory like referenceString & moreReferenceStrings\n" +
                Arrays.toString(referenceStrings) + "\n" +
                Arrays.toString(moreReferenceStrings) + "\n" +
                Arrays.toString(stringsToModify));

        int[] arrayToDereference = new int[5]; // originally = [0,0,0,0,0]
        int[] originalMemorySpace = arrayToDereference;

        arrayToDereference = new int[] {10, 20, 30};

        System.out.println("\nyou can dereference an array to point to another space in memory\n" +
                Arrays.toString(arrayToDereference) + "\n" +
                Arrays.toString(originalMemorySpace) + "\n" +
                Arrays.toString(arrayToDereference));
    }

    private static String[] modifyArray(String[] stringsToModify) {

        stringsToModify[stringsToModify.length - 1] = "final";

        System.out.println("\nReferencesAndValues.modifyArray(stringsToModify) was called\n");

        return stringsToModify;
    }
}

class DS_ArrayList {

    public static void printArrayList(ArrayList<String> myArrayList) {

        for(int i = 0; i < myArrayList.size(); i++) {
            System.out.println((i + 1) + ": " + myArrayList.get(i));
        }
    }

    public static void createArrayList() {
        /*
            ArrayList inherits from AbstractList
                the List interface in java is a sequential ordered collection

            ! the ArrayList is a resizeable array
                you don't have to worry about adjusting the capacity in memory for an ArrayList object

            * to initialize an ArrayList object/class

                ArrayList<ELEMENTS_OF_DATATYPE> groceryList = new ArrayList<ELEMENTS_OF_DATATYPE>();
         */

        System.out.println("to initialize: new ArrayList<DATATYPE>()");

        ArrayList<String> myArrayList = new ArrayList<>();

        System.out.println(myArrayList.toString());

        System.out.println("ArrayList<DATATYPE>.add(item) was called");

        myArrayList.add("bread");
        myArrayList.add("cheese");
        myArrayList.add("wine");

        System.out.println("ArrayList<DATATYPE>.get(index) was called, ArrayList<DATATYPE>.size: " + myArrayList.size());

        printArrayList(myArrayList);

        DataStructures_Utility.formatDivider();

        String newItem = "diapers";
        System.out.println("ArrayList<DATATYPE>.set(index, newItem) was called" +
                "\nnewItem: " + newItem);

        myArrayList.set(1, newItem);

        System.out.println("ArrayList<DATATYPE>.get(index) was called" +
                "\nArrayList<DATATYPE>.size(): " + myArrayList.size());

        printArrayList(myArrayList);

        DataStructures_Utility.formatDivider();

        System.out.println("ArrayList<DATATYPE>.get(removingElementIndex) was called");

        String removingItem = myArrayList.get(2);

        System.out.println("ArrayList<DATATYPE>.remove(removingElementIndex) was called");

        myArrayList.remove(removingItem);

        System.out.println(removingItem + " was removed");
        printArrayList(myArrayList);

        DataStructures_Utility.formatDivider();

        ArrayList<Integer> firstArrayList = new ArrayList<Integer>();
        firstArrayList.add(1);
        firstArrayList.add(2);
        firstArrayList.add(3);
        System.out.println("firstArrayList: " + firstArrayList);

        ArrayList<Integer> secondArrayList = new ArrayList<Integer>();
        secondArrayList.add(88);
        secondArrayList.add(99);
        secondArrayList.add(77);
        System.out.println("secondArrayList: " + secondArrayList);

        ArrayList<Integer> copyArrayList = new ArrayList<Integer>();
        copyArrayList.addAll(firstArrayList);
        copyArrayList.addAll(secondArrayList);
        System.out.println("copyArrayList (firstArrayList + secondArrayList): " + copyArrayList);

        System.out.println("Copy using arrayList.addAll(arrayListToAdd)\n" +
                "\tcopyArrayList: " + copyArrayList);

        ArrayList<Integer> thirdArrayList = new ArrayList<Integer>(copyArrayList);

        System.out.println("Copy onInitialization\n" +
                "\tthirdArrayList: " + thirdArrayList);

        DataStructures_Utility.formatDivider();

        String queryItem = "beer";
        boolean hasQueryItem = myArrayList.contains(queryItem);
        System.out.println("ArrayList<DATATYPE>.contains(queryItem) was called and returned boolean: " + hasQueryItem);

        int indexOfQueryItem = myArrayList.indexOf(queryItem);
        System.out.println("ArrayList<DATATYPE>.indexOf(queryItem) was called and returned int: " + indexOfQueryItem);

        if(indexOfQueryItem >= 0) {

            String foundItem = myArrayList.get(indexOfQueryItem);
            System.out.println("ArrayList<DATATYPE>.get(indexOfQueryItem) was called because '" +
                    foundItem + "' was in myArrayList");

        } else {

            System.out.println("myArrayList.get(myArrayList.indexOf(index)) returned null");

        }

        DataStructures_Utility.formatDivider();

        ArrayList<String> myStringArrayList = new ArrayList<String>();
        myStringArrayList.add("one");
        myStringArrayList.add("two");

        String[] myStringArray = new String[myStringArrayList.size()];
        myStringArray = myStringArrayList.toArray(myStringArray);
        System.out.println("Importing values into an array from an arrayList" +
                "\nmyStringArray: " + Arrays.toString(myStringArray));
    }
}

class DS_Array {

    public static void createArray() {

        // defining an array in java
        String[] myDefinedArray = {"Steve", "Mark", "Mary"};

        System.out.println("\nuse 'Arrays' wrapper to access .toString method to print as an String array/String[] in console: \n" +
                Arrays.toString(myDefinedArray));

        // ! the 'new' keyword is used to create and initialize the array elements to their default values (0 or null)
            // Strings[3] = [null, null, null]
            // int[3] = [0, 0, 0]

        // a new array of 10 int elements
        int[] arrayOfIntegers = new int[10];

        /*
            ! all arrays start at index 0

               array.length of 5 = int[5] = [index_0, index_1, index_2, index_3, index_4]

            * to access & set an element of an array with a newValue

                array[at index] = newValue
         */

        arrayOfIntegers[0] = 50;

        System.out.println("\naccess the 1st element at index 0 in new int[10] array & set the element of arrayOfIntegers[0]: \n" +
                arrayOfIntegers[0]);

        // array works with other data types
        double[] arrayOfDoubles = new double[23];
        arrayOfDoubles[21] = 1000;

        System.out.println("\naccess new double[23] array & set an element at arrayOfDoubles[21]: \n" +
                arrayOfDoubles[21]);

        System.out.println("\n------------\n");

        float[] floatArray = new float[5];

        for(int i = 0; i < floatArray.length; i++) {
            floatArray[i] = i * 10;
            System.out.println("index " + i + " = " + floatArray[i]);
        }

        System.out.println("\nuse for loop to access each index in new float[5] array given floatArray.length & set the element: \n" +
                Arrays.toString(floatArray));

        ArrayList<String> myStringArrayList = new ArrayList<String>();
        myStringArrayList.add("one");
        myStringArrayList.add("two");

        String[] myStringArray = new String[myStringArrayList.size()];
        myStringArray = myStringArrayList.toArray(myStringArray);
        System.out.println("myStringArray: " + Arrays.toString(myStringArray));

    }

    public static int getInputSum(int numElements) {

        int inputSum = 0;

        /**
         * getUserInput() takes an int for the number of elements of an array and captures user input scanned from the console to set as the array's element values
         */
        int[] userInput = getUserInput(numElements);

        for(int i = 0; i < userInput.length; i++) {
            inputSum += userInput[i];
            System.out.println("Element value: " + userInput[i] + " at index: " + i);
        }

        System.out.println("\nuse a while loop to build an userInputArray of n elements\n" +
                "then use a for loop to getInputSum(n): " + inputSum);

        return inputSum;
    }

    public static void getInputAverage(int numElements) {

        // use a double since the average might not be a whole number/integer
        double inputAvg;

        int sum = getInputSum(numElements);

        inputAvg = (double) sum / (numElements + 1);

        System.out.println("\nuse a while loop to build an userInputArray of n elements\n" +
                "then use a for loop to getInputSum(n): " + sum +
                "\nthen use a for loop to getInputAverage(n): " + inputAvg);

    }

    private static int[] getUserInput(int numElements) {

        Scanner scanner = new Scanner(System.in);
        int index = 0;
        int[] userInputArray = new int[numElements];

        while(index < userInputArray.length) {

            System.out.println("Enter a number: ");

            if(scanner.hasNextInt()) {
                // scanner object has nextInt method that will cast automatic string number from console into int variables
                int capturedUserInput = scanner.nextInt();
                userInputArray[index] = capturedUserInput;

                // increment index for next element in array assignment
                index++;

                // use scanner.nextLine after nextInt to handle enter key (line separator) input error
                scanner.nextLine();

            }
        }

        return userInputArray;
    }

    public static void resizeArray() {

        int[] baseData = {1,2,3};
        System.out.println("baseData " + Arrays.toString(baseData) + " of length: " + baseData.length);

        int[] original = baseData;
        baseData = new int[12];

        for(int i = 0; i < original.length; i++) {
            baseData[i] = original[i];
        }

        System.out.println("baseData " + Arrays.toString(baseData) + " of RESIZED length: " + baseData.length);
    }
}

class PrimitiveDataTypes {

    public static void byteShortAndLongs() {

        DataStructures_Utility.formatDivider("byte, short, and longs");

        // a byte occupies 8 bits/ a width of 8
        byte myMinByte = Byte.MIN_VALUE;
        byte myMaxByte = Byte.MAX_VALUE;
        System.out.println("Byte min: " + myMinByte);
        System.out.println("Byte max: " + myMaxByte);

        // a short occupies 16 bits/ a width of 16
        short myMinShort = Short.MIN_VALUE;
        short myMaxShort = Short.MAX_VALUE;
        System.out.println("Short min: " + myMinShort);
        System.out.println("Short max: " + myMaxShort);

        // a long occupies 64 bits/ a width of 64
        // a long value is expressed with a capital L
        long myLongValue = 100L;
        long myMinLong = Long.MIN_VALUE;
        long myMaxLong = Long.MAX_VALUE;
        System.out.println("Long value: " + myLongValue);
        System.out.println("Long min: " + myMinLong);
        System.out.println("Long max: " + myMaxLong);
    }

    public static void booleansCharsAndStrings() {

        DataStructures_Utility.formatDivider("booleans, chars, and strings");

        // conventional to name booleans starting with verbs as a question
        boolean isCustomerOver21 = true;
        System.out.println("isCustomerOver21: " + isCustomerOver21);

        // 16-bit chars are single unicode character that uses single quotes
        // https://unicode-table.com/en/
        char myChar = 'D';
        char myUnicodeChar = '\u0044'; // 'D'
        char myUnicodeCopyright = '\u00A9';

        System.out.println("myChar: " + myChar);
        System.out.println("myUnicodeChar: " + myUnicodeChar);
        System.out.println("myUnicodeCopyright: " + myUnicodeCopyright);

        DataStructures_Utility.formatDivider();

        // Strings can store multiple characters that use double quotes
        // Strings are immutable and can only be recreated via re-assignment
        String myString = "This is an IMMUTABLE string of characters";
        System.out.println("sentence 1: ".toUpperCase() + myString);

        System.out.println("\nuse StringBuffer (mutable)," +
                "\n'appending values'/re-creating an immutable string with additional data is inefficient");

        myString += "!!!! ";
        System.out.println("sentence 2: ".toUpperCase() + myString);

        myString += (myUnicodeCopyright + "2019");
        System.out.println("sentence 3: ".toUpperCase() + myString);

        DataStructures_Utility.formatDivider();

        // String that have numbers will NOT run calculations
        // but simply be joined as a single string with a plus operator
        String numString = "250.55";
        numString += numString + "49.95";
        System.out.println("numString error: " + numString);

        String lastString = "10";
        int myInt = 50;
        double myDouble = 120.45d;
        lastString += myInt;
        lastString += myDouble;
        System.out.println("lastString error: " + lastString);
    }

    public static void floatingPointNumbers() {

        DataStructures_Utility.formatDivider("floating point numbers");

        // FLOATING POINT NUMBERS are numbers with a fraction for precision that express a decimal point
        // precision = format & amount of spaced occupied by the space
        // 32 bits floats & 64 bits doubles

        // JAVA assumes all floating point numbers are DOUBLES
        // it's best practice specify by adding an 'f' or a 'd' to a floating point number for a float or double

        float myMinFloat = Float.MIN_VALUE; // 32 bit single precision number with a decimal
        float myMaxFloat = Float.MAX_VALUE; // 32 bit single precision number with a decimal
        System.out.println("myMinFloat: " + myMinFloat);
        System.out.println("myMaxFloat: " + myMaxFloat);

        DataStructures_Utility.formatDivider();

        double myMinDouble = Double.MIN_VALUE; // 64 bit single precision number with a decimal
        double myMaxDouble = Double.MAX_VALUE; // 64 bit single precision number with a decimal
        System.out.println("myMinDouble: " + myMinDouble);
        System.out.println("myMaxDouble: " + myMaxDouble);

        DataStructures_Utility.formatDivider();

        // ints don't handle remainders
        int myIntValue = 5/3;
        float myFloatValue = 5f/ 3f;

        // doubles can be specified with a 'd' or with a decimal point in java
//        double myDoubleValue = 5d / 3d;
        double myDoubleValue = 5.00 / 3.00;

        System.out.println("myIntValue " + myIntValue);
        System.out.println("myFloatValue " + myFloatValue);
        System.out.println("myDoubleValue " + myDoubleValue);
    }

    public static void integers() {

        DataStructures_Utility.formatDivider("integers");

        // an int occupies 32 bits/ a width of 32

        // ints can have underscores in them to denote size
        int myIntTest = 2_155_200;

        int myMinInt = Integer.MIN_VALUE;
        int myMaxInt = Integer.MAX_VALUE;
        System.out.println("INT MIN: " + myMinInt);
        System.out.println("INT MAX: " + myMaxInt);

        int myIntTotal = (myMinInt / 2);

    }
}

class IntWrapperClass {
    /*
        Object WRAPPER:
            ! a class that 'wraps' functionality for a private value
     */

    private int privateIntValue;

    public IntWrapperClass(int privateIntValue) {
        this.privateIntValue = privateIntValue;
    }

    public int getPrivateIntValue() {
        return privateIntValue;
    }

    public void setPrivateIntValue(int privateIntValue) {
        this.privateIntValue = privateIntValue;
    }
}

class UnboxingAndAutoboxing {

    public static void getUnboxingNotes() {

        ArrayList<Integer> integerArrayList = new ArrayList<Integer>();

        for(int i = 0; i <= 10; i++) {
            /*

                ! UNBOXING = more functional Object-Wrapper datatype -> primitive datatype

                ? integerArrayList.get(i).intValue()

                    use Integer wrapper class to convert Integer object back into a primitive int value
             */

            System.out.println(integerArrayList.get(i).intValue());
        }

        // Shortcut Compilation
        /*
            Integer myIntegerValue = 56;
            Integer myIntegerValue = Integer.valueOf(56)
         */

        Integer myIntegerValue = 56;


    }

    public static void getBoxingNotes() {

        ArrayList<Integer> integerArrayList = new ArrayList<Integer>();

        for(int i = 0; i <= 10; i++) {
            /*
                ! AUTOBOXING = primitive datatype -> to more functional Object-Wrapper datatype

                ? Integer.valueOf(x)

                    use Integer wrapper class to convert primitive int i into an Integer class object
             */

            System.out.println(integerArrayList.add(Integer.valueOf(i)));
        }
    }
}

class DS_LinkedLists {

    // class fields/object instance members

    // constructor that initializes the fields on class instantiation

    // unique behaviors
    public static void printLinkedList(LinkedList<String> linkedList) {
        /*
            use an Iterator to access each element in a list-type data structure
            ! equivalent of a for loop
         */
        Iterator<String> iterator = linkedList.iterator();

        System.out.println("LINKED LIST LOGIC:" +
                "\n\twhile element in linkedList is pointing to a next valid element, show current element\n");

        // iterator.hasNext() = validates pointer to next element
        while(iterator.hasNext()) {
            // iterator.next() = returns current value & moves to next valid element
            System.out.println("Now visiting: " + iterator.next());
        }

    }

    public static boolean addInAlphabeticalOrder(LinkedList<String> linkedList, String newCity) {
        /*
            use an ListIterator to move forward and backward in a list-type data structure
            ! equivalent of a for loop
         */
        ListIterator<String> listIterator = linkedList.listIterator();

        System.out.println("addInAlphabeticalOrder() was called");

        // listIterator.hasNext validates currentElement pointer is pointing to a valid nextElement
        while(listIterator.hasNext()) {

            int comparison = listIterator.next().compareTo(newCity);
            if(comparison == 0) {

            } else if() {

            } else {
                
            }


        }


        listIterator.add(newCity);
        return true;
    }


}