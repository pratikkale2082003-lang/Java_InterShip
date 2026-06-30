package Day5;


class Book {

    String title;
    String author;
    double price;

    // Default Constructor
    Book() {
        title = "Unknown";
        author = "Unknown";
        price = 0.0;
    }

    // Parameterized Constructor
    Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    // Method to display book details
    void displayDetails() {
        System.out.println("Title  : " + title);
        System.out.println("Author : " + author);
        System.out.println("Price  : ₹" + price);
        System.out.println();
    }
}
     public class Bookprogram{
    	 
     
    public static void main(String[] args) {

       
        Book b1 = new Book(); 
        Book b2 = new Book("Java Programming", "James Gosling", 599);
        Book b3 = new Book("Effective Java", "Joshua Bloch", 750);

        // Display details
        b1.displayDetails();
        b2.displayDetails();
        b3.displayDetails();
    }
}