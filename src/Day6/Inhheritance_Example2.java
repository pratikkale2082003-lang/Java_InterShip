package Day6;
//Implement a class Employee with fields and constructors.
//Create a subclass Manager that overrides a method to 
//display role-specific information and uses super to call
//the parent constructor.


 class Employee {
	 
	  String name;
	  int empId;
	  double salary;
	  
//	  Constructors
	  Employee (String name , int empId, double salary){

		   this.name = name;
		   this.empId = empId;
		   this.salary = salary;
		   
		   
	  }
	  
	   void displayInfo() {
		   
		    System.out.println("Employee Name : " + name);
		    System.out.println("Employee ID : " + empId);
		    System.out.println("Salary : " + salary);
	   }
 }
 
 class Manager extends Employee{
	 
	  String department;
	  Manager(String name , int empId, double salary, String department){
		  super(name , empId, salary);
		   this.department = department;
		   
	  }
 
 void displayInfo() {
	 
	  super.displayInfo();
	   System.out.println("Role :  Manager");
	   System.out.println("Department : " +  department);
	   
	   
 }
 }
 
 
 
public class Inhheritance_Example2 {

	 public static void main(String[] args) {
		Manager m = new Manager("Pratik Kale" , 101,75000, "Computer Science");
		
		 m.displayInfo();
	}
}
