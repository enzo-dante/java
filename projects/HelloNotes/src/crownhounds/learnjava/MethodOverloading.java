package crownhounds.learnjava;

public class MethodOverloading {

    /*
        Method Overloading is when you use the same method name but with different parameters
            the overloaded method needs to be unique which is set by number of params

            NOTE: not java specific concept
     */

    public static void main(String[] args) {

        int newScore = calculateScore("Tim", 500);
        System.out.println("calculateScore(2 params) : " + newScore);

        int noPlayerScore = calculateScore(75);
        System.out.println("calculateScore(1 params): " + noPlayerScore);

        int invalidScore = calculateScore();
        System.out.println("calculateScore(0 params): " + invalidScore);
    }

    public static int calculateScore(String playerName, int score) {

        int arbitraryNum = 1000;

        System.out.println("\nPlayer " + playerName + " scored " + score + " points");
        return score * arbitraryNum;
    }

    public static int calculateScore(int score) {
        System.out.println("\nUnnamed player scored " + score + " points");
        return score * 1000;
    }

    public static int calculateScore() {
        System.out.println("\nno player name, no player score.".toUpperCase());
        return 0;
    }


}
