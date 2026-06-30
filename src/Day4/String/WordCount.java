package Day4.String;


import java.util.Scanner;

public class WordCount {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a sentence: ");
        String sentence = sc.nextLine();

        
        sentence = sentence.trim();

      
        if (sentence.isEmpty()) {
            System.out.println("Number of words: 0");
        } else {
            // Split the sentence using one or more spaces
            String words[] = sentence.split("\\s+");

            System.out.println("Number of words: " + words.length);
        }

        sc.close();
    }
}