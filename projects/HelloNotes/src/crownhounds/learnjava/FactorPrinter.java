package crownhounds.learnjava;

public class FactorPrinter {

    private static final String INVALID_VALUE = "Invalid Value";

    public static void printFactors(int number) {

        if(number < 1) {
            System.out.println(INVALID_VALUE);
        } else {
            for(int f = 1; f <= number; f++) {
                if(number % f == 0) {
                    System.out.println(f);
                }
            }
        }
    }
}
