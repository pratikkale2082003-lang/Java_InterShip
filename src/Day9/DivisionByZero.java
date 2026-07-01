package Day9;
//Demonstrate the use of finally block by opening and closing a resource.
public class DivisionByZero{

	 public static void main(String[] args) {
		
		  int a = 10;
		  int b = 0;
		  
		   try {
			   
			    int result = a/ b;
			    
			    System.out.println("Result = " +  result);
			    
		   }
		    catch (ArithmeticException e) {
		    	
		    	 System.out.println("error:  Cannot divide  by zero. " );
		    	 
		    }
		   
		   System.out.println("Program continoues after exception handling");
	}
}
