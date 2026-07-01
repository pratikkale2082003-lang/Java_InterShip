package Day3;

import java.util.Scanner;

public class LargestNumber {

	 public static void main(String[] args) {
		
		  Scanner sc = new Scanner(System.in);
		  
		   System.out.print("Enter First number : ");
		    int a = sc.nextInt();
		    
		    
		    System.out.print("Enter Scecond number : ");
		     int b = sc.nextInt();
		      
		    System.out.print("Enter Third Number : ");
		      int c = sc.nextInt();
		      
		      
		       if (a >= b && a >= c) {
		    	    System.out.println("Largest Number is : " + a);
		       }
		       else if (b >= c && b >=a) {
		    	   System.out.println("Largest Number is : " + b);
		       }
		       else {
		    	   System.out.println("Largest Number is : " + b);
		       }
		       sc.close();
	}
	 
}
