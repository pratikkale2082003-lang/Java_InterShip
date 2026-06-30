package Day5;



	class Rectangle {

	    double length;
	    double width;

	    // Default Constructor
	    Rectangle() {
	        length = 1;
	        width = 1;
	    }

	    // Parameterized Constructor
	    Rectangle(double length, double width) {
	        this.length = length;
	        this.width = width;
	    }

	    // Method to calculate area
	    double calculateArea() {
	        return length * width;
	    }

	    // Method to calculate perimeter
	    double calculatePerimeter() {
	        return 2 * (length + width);
	    }

	    // Method to display details
	    void displayDetails() {
	        System.out.println("Length     : " + length);
	        System.out.println("Width      : " + width);
	        System.out.println("Area       : " + calculateArea());
	        System.out.println("Perimeter  : " + calculatePerimeter());
	        System.out.println();
	    }
	}
	    public class Reactangle_Program{
	    	

	    public static void main(String[] args) {

	        // Creating objects using different constructors
	        Rectangle r1 = new Rectangle();      // Default constructor
	        Rectangle r2 = new Rectangle(10, 5); // Parameterized constructor
	        Rectangle r3 = new Rectangle(7, 4);

	        // Display details
	        r1.displayDetails();
	        r2.displayDetails();
	        r3.displayDetails();
	    }
	}

