package Day7;


 class Animal {
	 
	  void sound () {
		  
		   System.out.println("Animal makes a sound ");
	  }
 }

  class Dog  extends Animal {
	 
	   void sound() {
		   
		    System.out.println("Dog barks");
	   }
  }
  
  class Cat extends Animal {

	    @Override
	    void sound() {
	        System.out.println("Cat meows");
	    }
	}
public class AnimalDemo {
public static void main(String[] args) {
	
	 Animal [] animals =  { new Dog(),new Cat() };
	 
	   for (Animal animal : animals) {
		   
		    animal.sound();
		    
	   }
	 
}
}
