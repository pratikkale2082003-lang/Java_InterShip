package Day3;

import java.util.Scanner;

public class Weekday {
public static void main(String[] args) {
	
	 Scanner sc = new Scanner(System.in);
	 
	  System.out.print("Enter a Number (1-7)");
	  int day = sc.nextInt();
	  
	   switch(day) {
	   
	   case 1 :
		    System.out.println("Monday");
		     break;
		     
		     
	   case 2 :
		   System.out.println("Tuesday");
		   break;
		   
	   case 3 : 
		   System.out.println("Wednesday");
		    break;
		  
	   case 4:
		   System.out.println("ThursDay");
		   break;
		   
	   case 5 : 
		   System.out.println("Friday");
		    break;
		    
	   case 6 :
		   System.out.println("Saturday");
		   break;
		   
	   case 7 :
		   System.out.println("Sunday");
	   
	   
	   default:
		   System.out.println("Number N0t Found");
	   }
	   sc.close();
}
}
