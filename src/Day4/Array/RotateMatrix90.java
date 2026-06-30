package Day4.Array;



	import java.util.Scanner;

	public class RotateMatrix90 {

	    public static void main(String[] args) {

	        Scanner sc = new Scanner(System.in);

	        System.out.print("Enter number of rows: ");
	        int rows = sc.nextInt();

	        System.out.print("Enter number of columns: ");
	        int cols = sc.nextInt();

	        int matrix[][] = new int[rows][cols];

	        // Input matrix elements
	        System.out.println("Enter matrix elements:");
	        for (int i = 0; i < rows; i++) {
	            for (int j = 0; j < cols; j++) {
	                matrix[i][j] = sc.nextInt();
	            }
	        }

	        // Display original matrix
	        System.out.println("\nOriginal Matrix:");
	        for (int i = 0; i < rows; i++) {
	            for (int j = 0; j < cols; j++) {
	                System.out.print(matrix[i][j] + " ");
	            }
	            System.out.println();
	        }

	        // Rotate matrix by 90 degrees clockwise
	        System.out.println("\nMatrix after 90-degree rotation:");

	        for (int j = 0; j < cols; j++) {
	            for (int i = rows - 1; i >= 0; i--) {
	                System.out.print(matrix[i][j] + " ");
	            }
	            System.out.println();
	        }

	        sc.close();
	    }
	
}
