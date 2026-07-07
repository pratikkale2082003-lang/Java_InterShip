package Day14;

import java.sql.Connection;
import java.sql.Date;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Connection con = DBConnection.getConnection();

        Scanner sc = new Scanner(System.in);

        int choice;

        do {

            System.out.println("\n=======================================");
            System.out.println(" LIBRARY MANAGEMENT SYSTEM ");
            System.out.println("=======================================");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Update Book Quantity");
            System.out.println("4. Delete Book");

            System.out.println("5. Add Member");
            System.out.println("6. View Members");
            System.out.println("7. Update Member");
            System.out.println("8. Delete Member");
            System.out.println("9. Search Member");

            System.out.println("10. Issue Book");
            System.out.println("11. View Loans");
            System.out.println("12. Return Book");
            System.out.println("13. Delete Loan");
            System.out.println("14. Search Loan");

            System.out.println("0. Exit");

            System.out.print("\nEnter Choice : ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:

                    System.out.print("Book Title : ");
                    String title = sc.nextLine();

                    System.out.print("Author : ");
                    String author = sc.nextLine();

                    System.out.print("ISBN : ");
                    String isbn = sc.nextLine();

                    System.out.print("Category : ");
                    String category = sc.nextLine();

                    System.out.print("Quantity : ");
                    int quantity = sc.nextInt();

                    BookCRUD.insertBook(con, title, author, isbn, category, quantity);
                    break;

                case 2:

                    BookCRUD.readBooks(con);
                    break;

                case 3:

                    System.out.print("Book ID : ");
                    int bid = sc.nextInt();

                    System.out.print("New Quantity : ");
                    int qty = sc.nextInt();

                    BookCRUD.updateBook(con, bid, qty);
                    break;

                case 4:

                    System.out.print("Book ID : ");
                    bid = sc.nextInt();

                    BookCRUD.deleteBook(con, bid);
                    break;

                case 5:

                    sc.nextLine();

                    System.out.print("Member Name : ");
                    String name = sc.nextLine();

                    System.out.print("Email : ");
                    String email = sc.nextLine();

                    System.out.print("Phone : ");
                    String phone = sc.nextLine();

                    System.out.print("Address : ");
                    String address = sc.nextLine();

                    MemberCRUD.insertMember(con, name, email, phone, address);
                    break;

                case 6:

                    MemberCRUD.readMembers(con);
                    break;

                case 7:

                    System.out.print("Member ID : ");
                    int memberId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("New Phone : ");
                    phone = sc.nextLine();

                    System.out.print("New Address : ");
                    address = sc.nextLine();

                    MemberCRUD.updateMember(con, memberId, phone, address);
                    break;

                case 8:

                    System.out.print("Member ID : ");
                    memberId = sc.nextInt();

                    MemberCRUD.deleteMember(con, memberId);
                    break;

                case 9:

                    System.out.print("Member ID : ");
                    memberId = sc.nextInt();

                    MemberCRUD.searchMember(con, memberId);
                    break;

                case 10:

                    System.out.print("Member ID : ");
                    memberId = sc.nextInt();

                    System.out.print("Book ID : ");
                    int bookId = sc.nextInt();

                    sc.nextLine();

                    System.out.print("Due Date (yyyy-mm-dd): ");
                    String date = sc.nextLine();

                    Date dueDate = Date.valueOf(date);

                    LoanCRUD.issueBook(con, memberId, bookId, dueDate);
                    break;

                case 11:

                    LoanCRUD.readLoans(con);
                    break;

                case 12:

                    System.out.print("Loan ID : ");
                    int loanId = sc.nextInt();

                    LoanCRUD.returnBook(con, loanId);
                    break;

                case 13:

                    System.out.print("Loan ID : ");
                    loanId = sc.nextInt();

                    LoanCRUD.deleteLoan(con, loanId);
                    break;

                case 14:

                    System.out.print("Loan ID : ");
                    loanId = sc.nextInt();

                    LoanCRUD.searchLoan(con, loanId);
                    break;

                case 0:

                    System.out.println("\nThank You for Using Library Management System.");
                    break;

                default:

                    System.out.println("Invalid Choice.");

            }

        } while (choice != 0);

        try {
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        sc.close();
    }
}