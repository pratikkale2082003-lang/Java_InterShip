package Day6;
//Create a class Vehicle with fields like brand and year, and a method displayInfo().
//Create a subclass Car that inherits from Vehicle and overrides the displayInfo() method to add more details.

 class  vehicle {
	 
	  String brand;
	  
	   int year;
	   
	    // Constructors 
	    vehicle(String brand , int year){
	    	
	    	 this.brand = brand;
	    	  this.year = year;
	    	  
	    }
	    
	     void displayInfo() {
	    	 
	    	  System.out.println("Brand : " + brand);
	    	   System.out.println("Year : " + year);
	    	   
	    	   
	     }
 }
 
 
  class Car  extends  vehicle {

	  
	  
	   String  model;
	   
	Car(String brand, int year, String model) {
		super(brand, year);
		this.model = model;
		
	}
	  
	
	
	 void  displayInfo() {
		 
		  super.displayInfo();
		   System.out.println("Model : " + model);
	 }
  }
public class Inheritance_Example1 {

	 public static void main(String [] args) {
		 
		  Car c = new Car("Toyato", 2024, "Camary");
		  
		   c.displayInfo();
	 }
}
