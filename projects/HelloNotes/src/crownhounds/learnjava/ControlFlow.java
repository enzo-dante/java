package crownhounds.learnjava;

public class ControlFlow {

    public static void main(String[] args) {

//        operatorsAndExpressions();
//        ifThenConditionalLogic();
        ternaryOperator();
    }

    private static void ifThenConditionalLogic() {

        /*
            if-then statements tell the program to execute a certain section of code only
                if expression evaluates true

              if(expression) {
                codeBlockA
              } else {
                codeBlockB
              }
         */

        // in Java, no semicolon for an if statement
        // expressions use double equal signs to evaluate
        int newValue = 50;
        if (newValue == 50) {
            System.out.println("this is true!");
        } else {
            System.out.println("this is an error!".toUpperCase());
        }

        // common practice: the variable by itself is also an expression that can be evaluated
        boolean isCar = false;
        if (isCar) {
            System.out.println("this isn't suppose to happen!".toUpperCase());
        }

        // check that the expression should evaluate false
            // !isAlien = (isAlien == false)
        boolean isAlien = false;
        if (!isAlien) {
            System.out.println("it is not an alien!".toLowerCase());
        }

        int topScore = 80;
        if (topScore <= 100) {
            System.out.println("you have the high score!".toUpperCase());
        }

        // handling multiple expressions with && requires the left AND right operands to be true
            // clarify expressions with parenthesis
        int secondTopScore = 60;
        if ((topScore > secondTopScore) && (topScore < 100)) {
            System.out.println("greater than top score and less than 100.");
        }

        // handling multiple expressions with || (or) where either one or both are operands are true
        // clarify expressions with parenthesis
        if ((topScore > 90) || (secondTopScore <= 90)) {
            System.out.println("Either or both of the conditions are true.");
        }
    }

    private static void operatorsAndExpressions() {

        System.out.println("\noperators and expressions\n".toUpperCase());

        /*

        Java Operator Precedence Table
            https://www.cs.bilkent.edu.tr/~guvenir/courses/CS101/op_precedence.html

        operators are special symbols that perform specific operations on 1 or multiple operands (manipulated obj)
            = equals
            + addition
            - subtraction
            * multiplication
            / division
            % remainder of 2 operands

            ++ add 1
            -- subtract 1
            ** power of

        expressions are the combination of values and operators
            == evaluates
            != does not evaluate
            > greater than
            < less than
            >= greater than or equal to
            <= less than or equal to
            && and
            || or

         */

        // 15 & 12 operands
        // + and = symbols are operators
        // 15 + 12 is the expression
        int result = 15 + 12; // 15 & 12 operands; + symbol is the operator
        System.out.println("15 + 12 = " + result);

        int previousResult = result;
        result -= 3;
        System.out.println("previousResult: " + previousResult);
        System.out.println("Result: " + result);

        result *= 10;
        System.out.println("24 * 10 = " + result);

        result /= 5;
        System.out.println("240/5 = " + result);

        result %= 5;
        System.out.println("48 % 5 has a remainder of " + result);

        int myNum = 1;
        myNum++;
        System.out.println("1 + 1 = " + myNum);

        myNum--;
        System.out.println("2 - 1 = " + myNum);
    }

    private static void ternaryOperator() {

        /*
            ternary operator is a single line if-else statement

                if condition evaluates true (?) than return true else (:) return false;
         */
        boolean isCar = false;
        isCar = true;

        boolean wasCar = isCar ? true : false;

        if (wasCar) {
            System.out.println("wasCar is true");
        }
    }


}
