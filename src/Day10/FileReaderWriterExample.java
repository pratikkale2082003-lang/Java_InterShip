package Day10;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReaderWriterExample {
	
//	FileReader and FileWriter handle character streams.
    public static void main(String[] args) {
        try {
            // Writing to a file
            FileWriter writer = new FileWriter("sample.txt");
            writer.write("Hello Java");
            writer.close();

            // Reading from a file
            FileReader reader = new FileReader("sample.txt");
            int ch;
            while ((ch = reader.read()) != -1) {
                System.out.print((char) ch);
            }
            reader.close();

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}