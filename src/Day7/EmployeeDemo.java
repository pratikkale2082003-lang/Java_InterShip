package Day7;


 abstract class Employee {
	 
	   String name;
	   Employee(String name){
		   this.name = name;
		   
	   }
	   
	    abstract double calculatesalary();
	    
 }
 
  class FullTimeEmployee extends Employee{
	  
	   double monthlysalary;
	   
	   FullTimeEmployee(String name , double monthlysalary){
		   super(name);
		   
		    this.monthlysalary=monthlysalary;
		    
	   }

	   @Override
	   double calculatesalary() {
		
		return monthlysalary;
	   }
  }
  
  // Part Time Employee
   class PartTimeEmployee extends Employee{

	   
	   
	   int  hourWorked;
	    double hourlyRate;
	   
	    PartTimeEmployee(String name , int hourWorked, double hourlyRate){
	    	 
	    	   super(name);
	    	   this.hourWorked=hourWorked;
	    	   this.hourlyRate=hourlyRate;
	    	   
	     }
	    
	@Override
	double calculatesalary() {
		// TODO Auto-generated method stub
		return  hourWorked * hourlyRate;
	}
	   
   }
   
public class EmployeeDemo {

	 public static void main(String[] args) {
		
		  Employee emp1 = new FullTimeEmployee("Pratik", 50000);
		  
		   Employee emp2 = new  PartTimeEmployee("Rahul", 40,300);
		   
		    System.out.println(emp1.name + "Salary : " + emp1.calculatesalary());
	System.out.println(emp2.name + "Salary : " + emp2.calculatesalary());
	 
	 }
	 
}
