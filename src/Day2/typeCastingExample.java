package Day2;

import java.util.Scanner;

public class typeCastingExample {

	 public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter a double value : ");
		 double doublevalue = sc.nextDouble();
		 
		  int intvalue =  (int) doublevalue;
		  
		  System.out.println("Double value : " + doublevalue);
		   System.out.println("Integer value : " + intvalue);
		    sc.close();
	}
}
