package Blake;


import java.util.Scanner;

public class coolSimpleCalc {
    public static void main(String[] args) {
        double num1 = 0; //initializing variables
        String operator;
        double num2 = 0;
        double result = 0;
        String newOperation;

        Scanner input = new Scanner(System.in); //Initialization of scanner must be outside while loop or it could cause minor performance issues
        while (true) {
            num1 = readNumber(input, "What is your first number in the operation?"); //I realized I can use method(input, "string") to save space and move error logic to method

            num2 = readNumber(input, "What is your second number in the operation?");

            System.out.println("Would you like to Add, Subtract, Multiply, or Divide?");
            operator = input.next().toLowerCase();
            input.nextLine();

            result = calculate(num1, num2, operator);

            System.out.println("Your result is " + String.format("%.2f", result));

            System.out.println("Would you like to calculate another operation? (Yes/No)");
            newOperation = input.nextLine().toLowerCase();

            if (newOperation.equals("yes")) { //Exit Logic
                continue;
            }  else {
                System.out.println("Alright seeya");
                break;
            }
        }
        input.close(); //close scanner to prevent memory leaks
    }

    public static double readNumber(Scanner input, String prompt) {
        while (true) {
            System.out.println(prompt);
            if (input.hasNextDouble()) {
                return input.nextDouble();
            } else {
                System.out.println("Please Enter a Valid Number.");
                input.nextLine();
                continue;
            }
        }
    } //Checks for Double otherwise continues loop
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
    } //Calculator Logic
}