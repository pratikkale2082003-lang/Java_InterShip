package Day7;


 interface Playable {
	 
	  void play();
	  
 }
 
  class Guiter implements Playable {

	@Override
	public void play() {
		// TODO Auto-generated method stub
		
		 System.out.println("Playing Guitar");
	}
	  
  }
  
   class Piano implements Playable{

	@Override
	public void play() {
	System.out.println("Playing Piano");
		
	}
	   
   }
public class PlayableDemo {

	 public static void main(String[] args) {
		
		 Playable instr1 = new Guiter();
		 
		  Playable instr2 = new  Piano();
		  
		   instr1.play();
		   instr2.play();
		    
	}
}
