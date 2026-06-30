package Day4.String;

import java.util.Scanner;

public class FindAndReplaceSubstring {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input the original string
        System.out.print("Enter the original string: ");
        String str = sc.nextLine();

        // Input the substring to find
        System.out.print("Enter the substring to find: ");
        String oldSub = sc.nextLine();

        // Input the replacement substring
        System.out.print("Enter the replacement substring: ");
        String newSub = sc.nextLine();

        // Replace the substring
        String modifiedString = str.replace(oldSub, newSub);

        // Display the result
        System.out.println("Modified String: " + modifiedString);

        sc.close();
    }
}