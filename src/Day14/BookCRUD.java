package Day14;

import java.sql.*;

public class BookCRUD {

    // Insert Book
    public static void insertBook(Connection con,
                                  String title,
                                  String author,
                                  String isbn,
                                  String category,
                                  int quantity) {

        String sql = "INSERT INTO Books(title,author,isbn,category,quantity) VALUES(?,?,?,?,?)";

        try {

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, title);
            ps.setString(2, author);
            ps.setString(3, isbn);
            ps.setString(4, category);
            ps.setInt(5, quantity);

            ps.executeUpdate();

            System.out.println("Book Inserted Successfully.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Read Books
    public static void readBooks(Connection con) {

        String sql = "SELECT * FROM Books";

        try {

            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);

            System.out.println("--------------------------------------------");

            while (rs.next()) {

                System.out.println(
                        rs.getInt("book_id") + " | " +
                        rs.getString("title") + " | " +
                        rs.getString("author") + " | " +
                        rs.getString("category") + " | Qty : " +
                        rs.getInt("quantity"));

            }

            System.out.println("--------------------------------------------");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Update Quantity
    public static void updateBook(Connection con,
                                  int id,
                                  int quantity) {

        String sql =
                "UPDATE Books SET quantity=? WHERE book_id=?";

        try {

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, quantity);

            ps.setInt(2, id);

            ps.executeUpdate();

            System.out.println("Book Updated.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Delete Book
    public static void deleteBook(Connection con,
                                  int id) {

        String sql =
                "DELETE FROM Books WHERE book_id=?";

        try {

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, id);

            ps.executeUpdate();

            System.out.println("Book Deleted.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}