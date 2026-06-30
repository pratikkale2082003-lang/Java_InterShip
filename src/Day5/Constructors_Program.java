package Day5;



	class Student {

	    int id;
	    String name;
	    double marks;

	    // Default Constructor
	    Student() {
	        id = 0;
	        name = "Unknown";
	        marks = 0.0;
	    }

	    // Constructor with two parameters
	    Student(int id, String name) {
	        this.id = id;
	        this.name = name;
	        marks = 0.0;
	    }

	    // Constructor with three parameters
	    Student(int id, String name, double marks) {
	        this.id = id;
	        this.name = name;
	        this.marks = marks;
	    }

	    // Method to display details
	    void display() {
	        System.out.println("ID    : " + id);
	        System.out.println("Name  : " + name);
	        System.out.println("Marks : " + marks);
	        System.out.println();
	    }
	}
	public class Constructors_Program {
		
	    public static void main(String[] args) {

	        // Creating objects using different constructors
	        Student s1 = new Student();                    // Default constructor
	        Student s2 = new Student(101, "Pratik");      // Two-parameter constructor
	        Student s3 = new Student(102, "Rahul", 85.5); // Three-parameter constructor

	        // Display details
	        s1.display();
	        s2.display();
	        s3.display();
	    }
	
}
