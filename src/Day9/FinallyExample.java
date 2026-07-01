package Day9;


//Demonstrate the use of finally block by opening and closing a resource.
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FinallyExample {

    public static void main(String[] args) {

        BufferedReader br = null;

        try {
            br = new BufferedReader(new FileReader("sample.txt"));
            System.out.println("File opened successfully.");

            String line = br.readLine();
            System.out.println("First Line: " + line);

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());

        } finally {
            try {
                if (br != null) {
                    br.close();
                    System.out.println("File closed successfully.");
                }
            } catch (IOException e) {
                System.out.println("Error while closing file.");
            }
        }

        System.out.println("Program ended.");
    }
}