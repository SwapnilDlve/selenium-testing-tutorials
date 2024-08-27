package main;

import java.util.Scanner;

public class CommandLineCalculator {

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Simple Calculator");
            System.out.println("Select operation:");
            System.out.println("1. Add");
            System.out.println("2. Subtract");
            System.out.println("3. Multiply");
            System.out.println("4. Divide");

            System.out.print("Enter choice (1/2/3/4): ");
            int choice = Integer.parseInt(scanner.nextLine());

            if (choice < 1 || choice > 4) {
                throw new IllegalArgumentException("Invalid operation choice");
            }

            System.out.print("Enter first number: ");
            double num1 = getValidNumber(scanner.nextLine());

            System.out.print("Enter second number: ");
            double num2 = getValidNumber(scanner.nextLine());

            double result = performOperation(choice, num1, num2);

            System.out.println("Result: " + result);

        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid input. Please enter numeric values.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static double getValidNumber(String input) {
        try {
            return Double.parseDouble(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid input. Please enter a numeric value.");
        }
    }

    private static double performOperation(int choice, double num1, double num2) {
        switch (choice) {
            case 1:
                return add(num1, num2);
            case 2:
                return subtract(num1, num2);
            case 3:
                return multiply(num1, num2);
            case 4:
                return divide(num1, num2);
            default:
                throw new IllegalArgumentException("Invalid operation choice");
        }
    }

    private static double add(double x, double y) {
        checkForOverflow(x, y);
        return x + y;
    }

    private static double subtract(double x, double y) {
        checkForOverflow(x, y);
        return x - y;
    }

    private static double multiply(double x, double y) {
        checkForOverflow(x, y);
        return x * y;
    }

    private static double divide(double x, double y) {
        if (y != 0) {
            return x / y;
        } else {
            throw new ArithmeticException("Cannot divide by zero");
        }
    }

    private static void checkForOverflow(double x, double y) {
        double result = x + y;
        if (Double.isInfinite(result)) {
            throw new ArithmeticException("Data overflow");
        }
    }
}
