package Day4.Array;


import java.util.Scanner;

public class RowColumnSum {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input rows and columns
        System.out.print("Enter number of rows: ");
        int rows = sc.nextInt();

        System.out.print("Enter number of columns: ");
        int cols = sc.nextInt();

        int arr[][] = new int[rows][cols];

        // Input array elements
        System.out.println("Enter array elements:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        // Sum of each row
        System.out.println("\nSum of each row:");
        for (int i = 0; i < rows; i++) {
            int rowSum = 0;

            for (int j = 0; j < cols; j++) {
                rowSum += arr[i][j];
            }

            System.out.println("Row " + (i + 1) + " Sum = " + rowSum);
        }

        // Sum of each column
        System.out.println("\nSum of each column:");
        for (int j = 0; j < cols; j++) {
            int colSum = 0;

            for (int i = 0; i < rows; i++) {
                colSum += arr[i][j];
            }

            System.out.println("Column " + (j + 1) + " Sum = " + colSum);
        }

        sc.close();
    }
}