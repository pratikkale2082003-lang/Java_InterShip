package Day10;

import java.io.FileWriter;
import java.io.IOException;

//File handling allows Java programs to read and write data to files.
public class FileWriterExample {

	 public static void main(String [] args) {
		 
		  try {
			  
			   FileWriter writer = new FileWriter("sample.txt");
		  writer.write("Hello,  Java File Handling !");
		  
		  writer.close();
		  System.out.println("Data written sucessFully..");
		  } catch (IOException e) {
			  
			   System.out.println("An error occured.");
		  }
	 }
}
