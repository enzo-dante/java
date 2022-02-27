package crownhounds.learnjava;

import java.util.ArrayList;

public class NumberInWord {

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
