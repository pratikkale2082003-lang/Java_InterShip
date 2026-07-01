package Day2;

import java.util.Scanner;

public class ArithmeticOperations {
public static void main(String[] args) {
	
	 Scanner sc = new  Scanner(System.in);
	 System.out.print("Enter first Number : ");
	  double  num1 = sc.nextDouble();
	  
	   System.out.print("Enter second number : ");
	   double num2 = sc.nextDouble();
	   
	   
	   System.out.println("Sum = " + (num1 + num2));
       System.out.println("Difference = " + (num1 - num2));
       System.out.println("Product = " + (num1 * num2));
       System.out.println("Quotient = " + (num1 / num2));
       System.out.println("Remainder = " + (num1 % num2));
	 
       sc.close();
}
}
