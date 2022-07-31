package com.crownhounds.masterjava;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressions {
    /*
        ! REGULAR EXPRESSIONS: case-sensitive search Strings for a specific pattern or validate user input matches a specific pattern

            entire REGULAR EXPRESSION match quick check = selecting REGULAR EXPRESSION string literal will enable a "yellow bulb" pop-up that has a "check RegExp" option

            * REGEX potential use cases

                1. email validation

                2. credit card number validation

                3. phone number validation

                4. advanced find/replace in text

                5. formatting text/output

                6. syntax highlighting

            * ex) US phone number REGEX

                "^[\(]{1}[0-9]{3}[\)]{1}[ ]{1}[0-9]{3}[0-9][\-]{1}[0-9]{4})$"

            * ex) email REGEX

                general email pattern sequence:

                    starts with 1 or more letter, number, plus sign, dash, underscore, or period

                    a single @ sign

                    1 or more letter, number, or dash

                    a single dot

                    ends with 1 or more letter, number, dash or period

                "(^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+$)"

                * pattern explanation:

                    ^ = search string has to start with any of the defined characters in the bracket

                    [a-zA-Z0-9_.+-] = allow lower case a-z, upper case a-z, 0-9, underscore, period, plus sign, or dash

                    + = allow one or more of the specified characters in the defined bracket

                    @ = a single 'commercial at' sign

                    [a-zA-Z0-9-] = allow lower case a-z, upper case a-z, 0-9 or dash

                    + = allow one or more of the specified characters in the defined bracket

                    \. = a single dot that (must use escape backslash to specify)

                    [a-zA-Z0-9-.] = allow lower case a-z, upper case a-z, 0-9, underscore, dash or period

                    + = allow one or more of the specified characters in the defined bracket

                    $ = search string has to end with any of the defined characters in the bracket

        ? REGEX character class
        character classes allow us to specify characters to filter in a pattern

            \ = escape special meaning of a character

            . = matches everything

            \. = string value of a period

            \d = digit 0-9

            \w = letter, digit, or underscore

            \s = whitespace character

            \D = not a digit

            \W = not a word character

            \S = not a whitespace character

        ? REGEX boundary matcher
        character classes allow us to specify characters in a GROUP/RANGE to filter in a pattern

            [] = character classes allow us to specify groups/ranges of characters

            [^] = anything that is NOT the specified characters in the brackets with the carrot symbol

                [^k] = anything but the lowercase letter k

            ^ = carrot anchor species the search string has to start with defined regular expression

                ^\d{3}

            '$' = dollar sign boundary denotes the end of string or line

            \b = word boundary

                ex: \b\w+\b = select only and every word

                    'hello world I am typing'

            | = the pipe character in regex denotes logical or

                "Mr|Mrs|Ms"

            () = parenthesis represent whole group

                (\(\d{3}\)|\d{3}) \d{3} \d{4}

        ? REGEX quantifiers
        specify how many times a specific character should occur in a pattern

            + = one or more

            {x} = exactly x times.

                {3} = 3 times

            {3,5} = 3 to 5 times

            {4,} = four or more times

            * = zero or more times

            ? = once or none (optional)

     */

    public static void main(String[] args) {
        logicalOperators();
        CharacterClassBoundaryMatchers regexCharacterClasses = new CharacterClassBoundaryMatchers();
        Quantifier regexQuantifier = new Quantifier();
    }

    public static void logicalOperators() {

        // ? REG_EX OR operator "[H|h]arry" = if character is a OR b than a match
        System.out.println("harry".replaceAll("[H|h]arry", "Larry"));

        // ? REG_EX NOT operator "[^abc]" = match all character that are NOT carrot bracket characters
        String tvTest = "tstvtkt";
        String tNotV_regExp = "t[^v]";
        Pattern tNotV_pattern = Pattern.compile(tNotV_regExp);
        Matcher tNotV_matcher = tNotV_pattern.matcher(tvTest);

        int count = 0;
        while(tNotV_matcher.find()) {
            count++;
            System.out.println("Occurence: " + count + " : " +
                    tNotV_matcher.start() + " index - " + tNotV_matcher.end() + " index"
            );
        }

        tNotV_matcher.reset();

        // ? REG_EX NOT operator "characterClass(?!characterClass)" = look ahead, and match any character not followed by specified characterClass

        // ? REG_EX NEGATIVE LOOK AHEAD "characterClass(?!characterClass)" do NOT include the character they match in the matched text
        // ? REG_EX POSITIVE LOOK AHEAD "characterClass(?=characterClass)" include the character they match in the matched text
        tvTest = "tstvtkt";
        tNotV_regExp = "t(?!v)";
        tNotV_pattern = Pattern.compile(tNotV_regExp);
        tNotV_matcher = tNotV_pattern.matcher(tvTest);

        count = 0;
        while(tNotV_matcher.find()) {
            count++;
            System.out.println("Occurence: " + count + " : " +
                    tNotV_matcher.start() + " index - " + tNotV_matcher.end() + " index"
            );
        }
    }
}

// ! OOP INHERITANCE + ACCESS-MODIFIER package-private: child subclass inherits class fields + public methods from extending parent super-class
class CharacterClassBoundaryMatchers extends Notes {

    // CONSTANTS/static class variables assigned FINAL value before compilation/instantiation
    private static final String ORIGINAL_TITLE = "ORIGINAL: ";

    // OOP constructor that initializes the class fields on class object instantiation
    public CharacterClassBoundaryMatchers() {
        super("REGULAR EXPRESSION Character Classes");
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

// ! OOP INHERITANCE: child subclass that inherits class fields & public method from extending parent super class
class Quantifier extends Notes{
    /*
        ! REGEX QUANTIFIER: how often specific element in a regex can occur
     */

    // CONSTANTS/static class variables assigned FINAL value before compilation/instantiation
    private static final String ORIGINAL_TITLE = "ORIGINAL: ";

    // OOP constructor that initializes class fields on class/object instantiation
    public Quantifier() {
        // ! OOP INHERITANCE: child subclass that inherits class fields & public method from extending parent super class
        super("REGULAR EXPRESSION Quantifiers");
        getNotes();

    }

    // ! INTERFACE + OOP POLYMORPHISM: must uniquely implement/@Override all publicly-shared signatures for a set of classes
    @Override
    public void getNotes() {
        String regEx;
        String result;
        String unmodifiedString;
        boolean isMatch;

        String original = "abcDeeeF12Ghhiiiijkl99z";

        // ? REG_EX QUANTIFIER "characterClass{n}" = characterClass must occur n times in the pattern to match
        regEx = "e{3}";
        result = original.replaceAll(regEx, ".....");
        System.out.println(ORIGINAL_TITLE + original);
        System.out.println("replace successive characterClasses if occur n times: " + result);

        Util.printSeparator();

        // ? REG_EX QUANTIFIER "characterClass+" = characterClass occurs 1 or more times is a pattern match
        regEx = "i+";
        result = original.replaceAll(regEx, ".....");
        System.out.println(ORIGINAL_TITLE + original);
        System.out.println("replace successive characterClasses if occur n times: " + result);

        Util.printSeparator();

        // ? REG_EX QUANTIFIER "characterClasscharacterClass*" = a characterClass that is followed by another characterClass that occurs 0 or more times is a pattern match
        regEx = "i*";
        result = original.replaceAll(regEx, ".....");
        System.out.println(ORIGINAL_TITLE + original);
        System.out.println("replace successive characterClasses if occur 0 or more times: " + result);

        Util.printSeparator();

        // ? REG_EX QUANTIFIER "characterClass{a,b}" = characterClass must occur in range a to b times in the pattern to match
        regEx = "i{1,4}";
        result = original.replaceAll(regEx, "_");
        System.out.println(ORIGINAL_TITLE + original);
        System.out.println("replace successive characterClasses if occur in range(a,b): " + result);

        Util.printSeparator();

        // ? REG_EX PATTERN MATCHER = Pattern compile(regex) & match for ENTIRE multiple occurrences or use the same pattern for multiple sequences
        // ? REG_EX MATCHERS can only be used once before requiring a reset
        StringBuilder htmlText = new StringBuilder("<h1>My Heading </h1>");
        htmlText.append("<h2>Sub Heading</h2>");
        htmlText.append("<p>content 1</p>");
        htmlText.append("<p>content 2</p>");
        htmlText.append("<h2>Summary</h2>");
        htmlText.append("<p>Here is a summary.</p>");

        String h2RegEx = "<h2>";
        Pattern pattern = Pattern.compile(h2RegEx, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(htmlText);
        System.out.println("matcher: " + matcher.matches());

        // ? REG_EX PATTERN MATCHER ".*characterClass.*" = anything before AND anything after characterClass regular expression in pattern match
        h2RegEx = ".*<h2>.*";
        pattern = Pattern.compile(h2RegEx, Pattern.CASE_INSENSITIVE);
        matcher = pattern.matcher(htmlText);
        System.out.println("matcher: " + matcher.matches());

        Util.printSeparator();

        // ? REG_EX PATTERN MATCHER = matchers can only be used ONCE before requiring a RESET
        // ? REG_EX PATTERN MATCHER .start() & .end() = start_index & end_index respectively
        matcher.reset();

        h2RegEx = "<h2>";
        pattern = Pattern.compile(h2RegEx, Pattern.CASE_INSENSITIVE);
        matcher = pattern.matcher(htmlText);

        int count = 0;
        while(matcher.find()) {
            count++;
            System.out.println("Occurrence " + count + " : " +
                    matcher.start() + " index to " + matcher.end() + " index"
            );
        }

        Util.printSeparator();

        // ? REG_EX PATTERN MATCHER group "(characterClass)" + matcher.group(n) = use "()" to label groups and get group by occurrence
        // ? REG_EX PATTERN MATCHER ".*characterClass.*" = anything before AND anything after characterClass regular expression in pattern match

        // ? REG_EX GREEDY QUANTIFIER: * quantifier is matches as much as possible
        // ? REG_EX LAZY QUANTIFIER: ? quantifier matches 0-1 minimum number of characters required for a match
        String h2GroupPattern = "(<h2>.*?</h2>)";
        Pattern groupPattern = Pattern.compile(h2GroupPattern, Pattern.CASE_INSENSITIVE);
        Matcher groupMatcher = groupPattern.matcher(htmlText);
        System.out.println(groupMatcher.matches());

        groupMatcher.reset();

        while(groupMatcher.find()) {
            count++;
            System.out.println("Occurrence: " + groupMatcher.group(1));
        }

        Util.printSeparator();

        // group1 = (<h2>)
        // group2 = (.+?)
        // group3 = (</h2>)
        String h2MultiGroups = "(<h2>)(.+?)(</h2>)";
        Pattern h2MultiGroupsPattern = Pattern.compile(h2MultiGroups);
        Matcher h2MultiGroupsMatcher = h2MultiGroupsPattern.matcher(htmlText);

        while(h2MultiGroupsMatcher.find()) {
            String text = h2MultiGroupsMatcher.group(2);
            System.out.println("Occurrence: " + text);
        }
    }
}