package Day4.String;



	import java.util.Arrays;
	import java.util.Scanner;

	public class AnagramCheck {

	    public static void main(String[] args) {

	        Scanner sc = new Scanner(System.in);

	        // Input two strings
	        System.out.print("Enter First String: ");
	        String str1 = sc.nextLine();

	        System.out.print("Enter Second String: ");
	        String str2 = sc.nextLine();

	       

	            // Convert strings to character arrays
	            char[] arr1 = str1.toCharArray();
	            char[] arr2 = str2.toCharArray();

	            // Sort the arrays
	            Arrays.sort(arr1);
	            Arrays.sort(arr2);

	            // Compare arrays
	            if (Arrays.equals(arr1, arr2)) {
	                System.out.println("The Strings are Anagrams.");
	            } else {
	                System.out.println("The Strings are not Anagrams.");
	            }
	        

	        sc.close();
	    }
	
	}
