package Week1_Day2;

import java.util.Scanner;

public class BooleanInput {
public static void main(String[] args) {
	 Scanner sc = new Scanner (System.in);
	 
	  System.out.print("Are you a student? (true/false): ");
	  boolean isStudent = sc.nextBoolean();
	  
	   if (isStudent) {
		   System.out.println("You are a Student");
	   }
	   else {
		   System.out.println("You are not a Student");
	   }
	    sc.close();
	    
}
	
}
