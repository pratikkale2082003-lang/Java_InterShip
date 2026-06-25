package Assignment;

import java.util.Scanner;

public class Calculator {
	

	    // Function for addition
	    static double add(double a, double b) {
	        return a + b;
	    }

	    // Function for subtraction
	    static double subtract(double a, double b) {
	        return a - b;
	    }

	    // Function for multiplication
	    static double multiply(double a, double b) {
	        return a * b;
	    }

	    // Function for division
	    static double divide(double a, double b) {
	        if (b == 0) {
	            System.out.println("Error: Cannot divide by zero.");
	            return Double.NaN;
	        }
	        return a / b;
	    }

	    public static void main(String[] args) {

	        Scanner sc = new Scanner(System.in);
	        char choice;

	        do {
	            System.out.print("Enter first number: ");
	            double num1 = sc.nextDouble();

	            System.out.print("Enter second number: ");
	            double num2 = sc.nextDouble();

	            System.out.print("Choose operation (+, -, *, /): ");
	            char operator = sc.next().charAt(0);

	            double result;

	            switch (operator) {
	                case '+':
	                    result = add(num1, num2);
	                    System.out.println("\nResult: " + result);
	                    break;

	                case '-':
	                    result = subtract(num1, num2);
	                    System.out.println("\nResult: " + result);
	                    break;

	                case '*':
	                    result = multiply(num1, num2);
	                    System.out.println("\nResult: " + result);
	                    break;

	                case '/':
	                    result = divide(num1, num2);
	                    if (!Double.isNaN(result)) {
	                        System.out.println("\nResult: " + result);
	                    }
	                    break;

	                default:
	                    System.out.println("Invalid operator!");
	            }

	            System.out.print("\nDo you want to perform another calculation? (y/n): ");
	            choice = sc.next().charAt(0);
	            System.out.println();

	        } while (choice == 'y' || choice == 'Y');

	        System.out.println("Thank you for using the calculator!");
	        sc.close();
	    }
	
}


/*Enter first number: 10
Enter second number: 5
Choose operation (+, -, *, /): +

Result: 15.0

Do you want to perform another calculation? (y/n): y

Enter first number: 45
Enter second number: 25
Choose operation (+, -, *, /): -

Result: 20.0

Do you want to perform another calculation? (y/n): n

Thank you for using the calculator!  */