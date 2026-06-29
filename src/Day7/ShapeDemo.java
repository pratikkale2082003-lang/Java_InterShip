package Day7;


 interface shape {
	 
	  double area();
	  
	   double parimeter();
	   
	  
 }
 
  class Circle  implements shape{

	  
	   double radius;
	   
	   
	   Circle (double radius){
		   
		    this.radius = radius;
		    
	   }
	   
	@Override
	public double area() {
	
		return Math.PI * radius * radius;
	}

	@Override
	public double parimeter() {
		// TODO Auto-generated method stub
		return 2 * Math.PI * radius;
	}
	  
  }
  
   class Rectangle  implements shape{

	   
	    double length , width;
	    
	    
	    
	     Rectangle (double length, double width ){
	    	 
	    	  this.length = length;
	    	   this.width =width;
	    	   
	     }
	@Override
	public double area() {
		return length * width;
	}

	@Override
	public double parimeter() {
		
		return 2 * (length + width);
	}
	   
   }
public class ShapeDemo {

	
	 public static void main(String [] args) {
		 
		  shape  circle = new Circle(5);
		  
		   shape rectangle =new Rectangle(4,6);
		   
		    System.out.println("Circle Area : " + circle.area());
				  
		    System.out.println("Circle Parameter : " + circle.parimeter());
	
	 System.out.println("Rectangle Area : " + rectangle.area());
	  
	  System.out.println("Rectangle Perimeter : " + rectangle.parimeter());
	 
	 }
}
