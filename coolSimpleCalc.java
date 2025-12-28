package Blake;


import java.util.Scanner;

public class coolSimpleCalc {
    public static void main(String[] args) {

        double num1 = 0; //initializing variables
        String operator;
        double num2 = 0;
        double result = 0;
        String newOperation;

        Scanner input = new Scanner(System.in); //Initalization of scanner must be outside while loop or it could cause
        while (true) {
            boolean trueOperation = true; //resets to true each time

            System.out.println("What is your first number in the operation?");
            if (input.hasNextFloat()) {
                num1 = input.nextFloat();
            } else {
                System.out.println("Please Enter a Valid Number.");
                input.nextLine();
                continue;
            }
            System.out.println("What is your second number in the operation?");  //These methods are used to provide a value to the variables and provide error correction in case inputs are false
            if (input.hasNextFloat()) {
                num2 = input.nextFloat();
            } else {
                System.out.println("Please Enter a Valid Number.");
                input.nextLine();
                continue;
            }
            System.out.println("Would you like to Add, Subtract, Multiply, or Divide?");
            operator = input.next().toLowerCase();
            input.nextLine();

            result = calculate(num1, num2, operator);

            if (trueOperation) { //I have trueOperation set to true by default so unless it hits default it will stay true and output the result. The result only changes by the operator so I didn't need to output this exit logic each time.
                System.out.println("Your result is " + String.format("%.2f", result)); //the string format is used to round up from xx.xxxxxxxxx to xx.xx

                System.out.println("Would you like to calculate another operation? (Yes/No)");  //Restarts operation if users wishes or breaks in case they enter no or something other than yes/no
                newOperation = input.nextLine().toLowerCase();
                if (newOperation.equals("yes")) {
                    continue;
                } else if (newOperation.equals("no")) {
                    break;
                }  else {
                    System.out.println("Well I'm gonna take that as a no");
                    break;
                }
            }
        }
        input.close(); //close scanner to prevent memory leaks
    }


    public static double calculate(double num1, double num2, String operator) {
        return switch (operator) {
            case "add", "+" -> num1 + num2;
            case "subtract", "-" -> num1 - num2;
            case "multiply", "*", "x" -> num1 * num2;
            case "divide", "/" -> {
                if (num2 == 0) {
                    System.out.println("Cannot Divide by Zero.");
                    yield 0;
                } else {
                    yield num1 / num2;
                }
            }
            default -> {
                System.out.println("Operator " + operator + " Undefined.");
                yield 0;
            }
        };
    }
}