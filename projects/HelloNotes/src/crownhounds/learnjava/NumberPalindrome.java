package crownhounds.learnjava;

public class NumberPalindrome {

    private static final String INVALID_INPUT = "invalid input".toUpperCase();

    public static boolean isPalindrome(int number) {

        boolean isPal = false;
        int updatedNum = number;
        String reverseNumStr = "";
        String numStr = Integer.toString(number);
        char c = ' ';

        // if negative number cannot be palindrome
        for(int i = 0; i < numStr.length(); i++) {
            if(updatedNum < 0) {
                updatedNum *= -1;
                numStr = Integer.toString(updatedNum);
            }
            c = numStr.charAt(i);
            reverseNumStr = c + reverseNumStr;
        }

        if(numStr.equals(reverseNumStr)) {
            isPal = true;
            System.out.println(number + " is a pal");
        } else {
            System.out.println(number + " is NOT a pal");
        }
        return isPal;
    }
}
