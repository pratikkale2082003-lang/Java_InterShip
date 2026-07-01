package Day9;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


//Create a method that reads a file and declares throws IOException. Call it from main and handle the exception.
public class FileReadExample {

    // Method that declares throws IOException
    static void readFile(String fileName) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileName));

        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }

        br.close();
    }

    public static void main(String[] args) {

        try {
            readFile("sample.txt");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("Program ended successfully.");
    }
}