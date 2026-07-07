package Day14;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class LoanCRUD {

    // Issue Book
    public static void issueBook(Connection con,
                                 int memberId,
                                 int bookId,
                                 Date dueDate) {

        try {

            // Check book quantity
            String checkBook =
                    "SELECT quantity FROM Books WHERE book_id=?";

            PreparedStatement ps1 =
                    con.prepareStatement(checkBook);

            ps1.setInt(1, bookId);

            ResultSet rs = ps1.executeQuery();

            if (!rs.next()) {
                System.out.println("Book Not Found.");
                return;
            }

            int quantity = rs.getInt("quantity");

            if (quantity <= 0) {
                System.out.println("Book Out of Stock.");
                return;
            }

            // Check member exists
            String checkMember =
                    "SELECT * FROM Members WHERE member_id=?";

            PreparedStatement ps2 =
                    con.prepareStatement(checkMember);

            ps2.setInt(1, memberId);

            ResultSet rs2 = ps2.executeQuery();

            if (!rs2.next()) {
                System.out.println("Member Not Found.");
                return;
            }

            // Insert Loan
            String insertLoan =
                    "INSERT INTO Loans(member_id,book_id,due_date) VALUES(?,?,?)";

            PreparedStatement ps3 =
                    con.prepareStatement(insertLoan);

            ps3.setInt(1, memberId);
            ps3.setInt(2, bookId);
            ps3.setDate(3, dueDate);

            ps3.executeUpdate();

            // Reduce Quantity
            String updateBook =
                    "UPDATE Books SET quantity=quantity-1 WHERE book_id=?";

            PreparedStatement ps4 =
                    con.prepareStatement(updateBook);

            ps4.setInt(1, bookId);

            ps4.executeUpdate();

            System.out.println("Book Issued Successfully.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // View All Loans
    public static void readLoans(Connection con) {

        String sql =
                "SELECT l.loan_id, " +
                "m.name, " +
                "b.title, " +
                "l.issue_date, " +
                "l.due_date, " +
                "l.return_date " +
                "FROM Loans l " +
                "JOIN Members m ON l.member_id=m.member_id " +
                "JOIN Books b ON l.book_id=b.book_id";

        try {

            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);

            System.out.println("\n----------- Loan Records -----------");

            while (rs.next()) {

                System.out.println(

                        rs.getInt("loan_id") + " | " +

                        rs.getString("name") + " | " +

                        rs.getString("title") + " | " +

                        rs.getDate("issue_date") + " | " +

                        rs.getDate("due_date") + " | " +

                        rs.getDate("return_date"));

            }

            System.out.println("------------------------------------");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Return Book
    public static void returnBook(Connection con,
                                  int loanId) {

        try {

            // Get Book ID
            String findLoan =
                    "SELECT book_id FROM Loans WHERE loan_id=?";

            PreparedStatement ps =
                    con.prepareStatement(findLoan);

            ps.setInt(1, loanId);

            ResultSet rs = ps.executeQuery();

            if (!rs.next()) {

                System.out.println("Loan Not Found.");

                return;
            }

            int bookId = rs.getInt("book_id");

            // Update Return Date
            String updateLoan =
                    "UPDATE Loans SET return_date=CURRENT_DATE WHERE loan_id=?";

            PreparedStatement ps2 =
                    con.prepareStatement(updateLoan);

            ps2.setInt(1, loanId);

            ps2.executeUpdate();

            // Increase Quantity
            String updateBook =
                    "UPDATE Books SET quantity=quantity+1 WHERE book_id=?";

            PreparedStatement ps3 =
                    con.prepareStatement(updateBook);

            ps3.setInt(1, bookId);

            ps3.executeUpdate();

            System.out.println("Book Returned Successfully.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Delete Loan
    public static void deleteLoan(Connection con,
                                  int loanId) {

        String sql =
                "DELETE FROM Loans WHERE loan_id=?";

        try {

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setInt(1, loanId);

            int rows = ps.executeUpdate();

            if (rows > 0)
                System.out.println("Loan Deleted Successfully.");
            else
                System.out.println("Loan Not Found.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Search Loan
    public static void searchLoan(Connection con,
                                  int loanId) {

        String sql =
                "SELECT l.loan_id, m.name, b.title, l.issue_date, l.due_date, l.return_date " +
                "FROM Loans l " +
                "JOIN Members m ON l.member_id=m.member_id " +
                "JOIN Books b ON l.book_id=b.book_id " +
                "WHERE l.loan_id=?";

        try {

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setInt(1, loanId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                System.out.println("\nLoan Details");

                System.out.println("Loan ID     : " + rs.getInt("loan_id"));
                System.out.println("Member Name : " + rs.getString("name"));
                System.out.println("Book Title  : " + rs.getString("title"));
                System.out.println("Issue Date  : " + rs.getDate("issue_date"));
                System.out.println("Due Date    : " + rs.getDate("due_date"));
                System.out.println("Return Date : " + rs.getDate("return_date"));

            } else {

                System.out.println("Loan Not Found.");

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}