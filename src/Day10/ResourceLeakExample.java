package Day10;

//Always handle exceptions and close streams to avoid resource leaks. code
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ResourceLeakExample {
    public static void main(String[] args) {

        try (BufferedReader br = new BufferedReader(new FileReader("sample.txt"))) {

            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}