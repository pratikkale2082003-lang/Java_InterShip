package Day6;

class Student {
    String name;
    int age;
    String course;

    // Constructor 1
    Student() {
        this("Unknown"); // Calls Constructor 2
        System.out.println("Default Constructor Called");
    }

    // Constructor 2
    Student(String name) {
        this(name, 0); // Calls Constructor 3
        System.out.println("Constructor with Name Called");
    }

    // Constructor 3
    Student(String name, int age) {
        this(name, age, "Not Assigned"); // Calls Constructor 4
        System.out.println("Constructor with Name and Age Called");
    }

    // Constructor 4
    Student(String name, int age, String course) {
        this.name = name;
        this.age = age;
        this.course = course;
        System.out.println("Constructor with All Parameters Called");
    }

    // Method to display details
    void display() {
        System.out.println("\nStudent Details:");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Course: " + course);
    }
}
     public class  Constructor_Program {
    	 
     
     
    public   static void main(String[] args) {
        Student s1 = new Student();
        s1.display();
        
        
    }
}