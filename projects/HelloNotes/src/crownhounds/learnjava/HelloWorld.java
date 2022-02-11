package crownhounds.learnjava;

// public = access modifier
// class = datatype object
public class HelloWorld {

    // method = function on an object that serves as a collection of statements that performs an operation
    // void = method won't return anything
    // code block = a function's defined block of code
    public static void main(String[] args) {

        /*
            8 primitive dataTypes
                boolean, byte, char, short, int, long, float, double
         */

        // dataType varName = value;
        int myExpression = (2 * 10);
        int mySecondExpression = (5 + 10) + myExpression;
        int myThirdExpression = 2;
        int myTotal = mySecondExpression * myThirdExpression;
        int myLastExpression = myTotal - 1000;

        String name = "World!";

        System.out.println("Hello " + name);
        System.out.println(myTotal);
        System.out.println(myLastExpression);

    }
}


