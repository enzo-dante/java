package com.crownhounds.learnjava;

public class RegularExpressions {
    /*
        ! REGULAR EXPRESSIONS: case-sensitive search Strings for a specific pattern or validate user input matches a specific pattern

            entire REGULAR EXPRESSION match quick check = selecting REGULAR EXPRESSION string literal will enable a "yellow bulb" pop-up that has a "check RegExp" option
     */

    public static void main(String[] args) {
        CharacterClassBoundaryMatchers characterClassBoundaryMatchers = new CharacterClassBoundaryMatchers();

    }
}

// ! OOP INHERITANCE + ACCESS-MODIFIER package-private: child subclass inherits class fields + public methods from extending parent super-class
class CharacterClassBoundaryMatchers extends Notes {

    // CONSTANTS/static class variables assigned FINAL value before compilation/instantiation
    private static final String ORIGINAL_TITLE = "ORIGINAL: ";

    // OOP constructor that initializes the class fields on class object instantiation
    public CharacterClassBoundaryMatchers() {
        super("REGULAR EXPRESSIONS Character Classes");
        getNotes();
    }

    // ! INTERFACE + OOP POLYMORPHISM: must uniquely implement/@Override all publicly-shared signatures for designated classes
    @Override
    public void getNotes() {
        String regEx;
        String result;
        String unmodifiedString;
        boolean isMatch;

        String original = "abcDeeeF12Ghhiiiijkl99z";

        // ? STRING LITERAL
        String i = "I am a String. Yes, I am.";
        System.out.println(i);

        Util.printSeparator();

        // ? REGULAR EXPRESSION str.replaceAll(patternReplaced, replacementString) = replace a given pattern in a String
        String u = i.replaceAll("I am", "You are");
        System.out.println(u);

        Util.printSeparator();

        // ? CHARACTER CLASSES = wildcard that represent a set of characters
        // ? REG_EX "." = wildcard for any character class
        String dotAnyMatchReplaced = original.replaceAll(".", "Y");
        System.out.println(dotAnyMatchReplaced);

        Util.printSeparator();

        // ? BOUNDARY MATCHES = query for boundaries like start/end of a string or word
        // ? REG_EX "^" = beginning of string is matched by given regular expression BOUNDARY MATCH
        //              ! length of replacementString doesn't have to match length of regular expression
        String beginningReplaced = original.replaceAll("^abcDeee", "ZZZ");
        System.out.println("BEGINNING MATCH .replaceAll(): " + beginningReplaced);

        unmodifiedString = original.replaceAll("^F12", "ZZZ");
        System.out.println("NO BEGINNING MATCH .replaceAll(): " + unmodifiedString);

        Util.printSeparator();

        // ? REGULAR EXPRESSION str.matches("regEx") = boolean match validation for ENTIRE regEx
        isMatch = original.matches("^Hello");
        System.out.println(isMatch);

        isMatch = original.matches("^abcDeee");
        System.out.println(isMatch);

        isMatch = original.matches("^abcDeeeF12Ghhiiiijkl99z");
        System.out.println(isMatch);

        Util.printSeparator();

        // ? REG_EX "$" = end of string is matched by given regular expression BOUNDARY MATCH
        //              ! length of replacementString doesn't have to match length of regular expression
        String endReplaced = original.replaceAll("99z$", "_THE_END");
        System.out.println(ORIGINAL_TITLE + original);
        System.out.println("END MATCH .replaceAll(): " + endReplaced);

        Util.printSeparator();

        // ? REG_EX "[characterClass]" = each individual character in the provided regEx character class set is validated in given string
        //              ! length of replacementString doesn't have to match length of regular expression
        String noVowels = original.replaceAll("[aeiou]", "__");
        System.out.println(ORIGINAL_TITLE + original);
        System.out.println("CHARACTER CLASS SET MATCH .replaceAll(): " + noVowels);

        Util.printSeparator();

        // ? REG_EX "[setA][setB]" = only valid regEx match IF setA is followed by setB
        //              ! length of replacementString doesn't have to match length of regular expression
        String no12 = original.replaceAll("[1][2]", "_____");
        System.out.println(ORIGINAL_TITLE + original);
        System.out.println("Multi-CHARACTER CLASS SET MATCH .replaceAll(): " + no12);

        Util.printSeparator();

        // ? REG_EX "[characterClass]" for UPPER & LOWER  = characterClass set + remaining string match & replaced with case-sensitive string
        String uppercase = "harry".replaceAll("[Hh]arry", "Harry");
        System.out.println(uppercase);

        String lowercase = "HARRY".replaceAll("[Hh]ARRY", "hARRY");
        System.out.println(lowercase);

        Util.printSeparator();

        // ? REG_EX "[^characterClass]" for UPPER & LOWER  = match all occurrences NOT in characterClass set
        String onlyEJ = original.replaceAll("[^ej]", ".");
        System.out.println(ORIGINAL_TITLE + original);
        System.out.println(onlyEJ);

        Util.printSeparator();

        // ? REG_EX "[a-zA-Z0-9]" = case-sensitive inclusive match all occurrences with IN RANGE dash of provided characterClass set
        //      "[abcdef345678]" = "[a-f3-8]"
        //      "[abcDEF789]" = "[a-cD-F7-9]"

        result = original.replaceAll("[a-f3-8]", ".");
        System.out.println(ORIGINAL_TITLE + original);
        System.out.println("case-sensitive: " + result);

        Util.printSeparator();

        // ? REG_EX "(?i)[a-z0-9]" = case-INSENSITIVE inclusive match all occurrences with IN RANGE dash of provided characterClass set
        result = original.replaceAll("(?i)[a-f3-8]", ".");
        System.out.println(ORIGINAL_TITLE + original);
        System.out.println("case-INSENSITIVE: " + result);

        Util.printSeparator();

        // ? REG_EX "[0-9]" = match all occurrences with IN RANGE dash of provided NUMBERS characterClass set
        regEx = "[0-9]";
        result = original.replaceAll(regEx, ".");
        System.out.println(ORIGINAL_TITLE + original);
        System.out.println("replace all numbers: " + result);

        Util.printSeparator();

        // ? REG_EX "\\d" = match all NUMBER occurrences with provided characterClass set
        //      "\\d" = "[0-9]"
        regEx = "\\d";
        result = original.replaceAll(regEx, ".");
        System.out.println(ORIGINAL_TITLE + original);
        System.out.println("replace all numbers: " + result);

        Util.printSeparator();

        // ? REG_EX "\\D" = match all NON-NUMBER occurrences with provided characterClass set
        regEx = "\\D";
        result = original.replaceAll(regEx, ".");
        System.out.println(ORIGINAL_TITLE + original);
        System.out.println("replace all non-numbers: " + result);

        Util.printSeparator();

        // ? REG_EX "\\s" = match all whitespace occurrences with provided characterClass set
        regEx = "\\s";
        String hasWhiteSpace = "This is \t a \t\t regex test for whitespace";
        result = hasWhiteSpace.replaceAll(regEx, "");
        System.out.println(ORIGINAL_TITLE + hasWhiteSpace);
        System.out.println("remove whitespace: " + result);

        Util.printSeparator();

        // ? REG_EX "\\s" = TARGETED match of whitespace occurrences with provided characterClass set
        regEx = "\t";
        hasWhiteSpace = "This is \t a \t\t regex test for whitespace";
        result = hasWhiteSpace.replaceAll(regEx, ".");
        System.out.println(ORIGINAL_TITLE + hasWhiteSpace);
        System.out.println("TARGETED whitespace removal: " + result);
        Util.printSeparator();

        // ? REG_EX "\\S" = match all NON-whitespace occurrences with provided characterClass set
        //      only tabs, spaces, & new line characters remain
        regEx = "\\S";
        hasWhiteSpace = "This is \t a \t\t regex test for whitespace";
        result = hasWhiteSpace.replaceAll(regEx, "");
        System.out.println(ORIGINAL_TITLE + hasWhiteSpace);
        System.out.println("remove NON-whitespace: " + result);

        Util.printSeparator();

        // ? REG_EX "\\w" = match all a-z, A-Z, 0-9, and underscore occurrences with provided characterClass set
        regEx = "\\w";
        result = hasWhiteSpace.replaceAll(regEx, ".");
        System.out.println(ORIGINAL_TITLE + hasWhiteSpace);
        System.out.println("replace a-z, A-Z, 0-9, and underscore: " + result);

        Util.printSeparator();

        // ? REG_EX "\\W" = match everything BUT a-z, A-Z, 0-9, and underscore occurrences with provided characterClass set
        regEx = "\\W";
        result = hasWhiteSpace.replaceAll(regEx, ".");
        System.out.println(ORIGINAL_TITLE + hasWhiteSpace);
        System.out.println("replace everything BUT a-z, A-Z, 0-9, and underscore: " + result);

        Util.printSeparator();

        // ? REG_EX "\\b" = match boundary for all a-z, A-Z, 0-9, and underscore occurrences with provided characterClass set
        //      useful with adding html tags
        regEx = "\\b";
        result = hasWhiteSpace.replaceAll(regEx, "_");
        System.out.println(ORIGINAL_TITLE + hasWhiteSpace);
        System.out.println("replace boundary for all a-z, A-Z, 0-9, and underscore: " + result);

        Util.printSeparator();

        // ? REG_EX "\\B" = match NON-boundary for all a-z, A-Z, 0-9, and underscore occurrences with provided characterClass set
        regEx = "\\B";
        result = hasWhiteSpace.replaceAll(regEx, "_");
        System.out.println(ORIGINAL_TITLE + hasWhiteSpace);
        System.out.println("replace NON-boundary for all a-z, A-Z, 0-9, and underscore: " + result);
    }
}