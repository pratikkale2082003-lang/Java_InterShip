package Day4.String;

import java.util.Scanner;

public class CapitalizeWords {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String str = sc.nextLine();

        // Split the string into words
        String words[] = str.split(" ");

        String result = "";

        
        for (String word : words) {

            if (!word.isEmpty()) {
                result += Character.toUpperCase(word.charAt(0))
                        + word.substring(1) + " ";
            }
        }

        System.out.println("Modified String: " + result.trim());

        sc.close();
    }
}
