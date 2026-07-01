package Day9;

//Write a program to catch multiple exceptions: ArithmeticException and ArrayIndexOutOfBoundsException.
public class MultipleExceptionExample {

    public static void main(String[] args) {

        int[] arr = {10, 20, 30};

        try {
            // Uncomment one at a time to test

            // ArithmeticException
            int result = 10 / 0;

            // ArrayIndexOutOfBoundsException
            // System.out.println(arr[5]);

        } catch (ArithmeticException e) {
            System.out.println("Error: Cannot divide by zero.");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Array index is out of bounds.");
        }

        System.out.println("Program continues after exception handling.");
    }
}