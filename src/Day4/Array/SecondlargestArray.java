package Day4.Array;

import java.util.Scanner;

public class SecondlargestArray {

	 public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
		System.out.print("Enter Size of Array : ");
		int n = sc.nextInt();
		
		
		   int arr [] = new int[n];
		   
		    System.out.println("Enter Elements :  ");
		     for (int i = 0; i < arr.length; i++) {
		    	arr[i] = sc.nextInt();
		    	 
		     }
		     
		    int largest = arr[0];
		    
		     for (int i = 0; i < arr.length; i++) {
		    	 
		    	  if (arr[i] > largest) {
		    		   largest = arr[i];
		    		   
		    	  }
		     }
		      System.out.println("Largest Array : " + largest);
	
	 
		       int second = arr[0];
		       
		        for (int i = 0; i < arr.length; i++) {
		        	
		        	 if (arr[i] > second && arr[i] != largest) {
		        		 second = arr[i];
		        		 
		        	 }
		        
		        }
		         System.out.println("Second Largest Array : " + second);
		         sc.close();
	 }
}
