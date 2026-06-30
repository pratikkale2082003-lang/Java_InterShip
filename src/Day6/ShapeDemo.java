package Day6;


//Parent class
class Shape {

 // Method to calculate area
 double area() {
     System.out.println("Calculating area of Shape");
     return 0;
 }
}

//Child class Rectangle
class Rectangle extends Shape {
 double length;
 double width;

 // Constructor using this keyword
 Rectangle(double length, double width) {
     this.length = length;
     this.width = width;
 }

 // Overriding area() method
 @Override
    double area() {
     super.area(); // Calling parent class method
     return this.length * this.width;
 }
}

//Child class Circle
class Circle extends Shape {
 double radius;

 // Constructor using this keyword
 Circle(double radius) {
     this.radius = radius;
 }

 // Overriding area() method
 @Override
 double area() {
     super.area(); // Calling parent class method
     return Math.PI * this.radius * this.radius;
 }
}

//Main class
public class ShapeDemo {
 public static void main(String[] args) {

     Rectangle rect = new Rectangle(10, 5);
     Circle circle = new Circle(7);

     System.out.println("Rectangle Area: " + rect.area());
     System.out.println("Circle Area: " + circle.area());
 }
}