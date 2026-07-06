package Day13;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Day13 {



    static String url = "jdbc:postgresql://localhost:5432/Shopdb";
    static String username = "postgres";
    static String password = "7733";

    public static void main(String[] args) {

        try {

            Class.forName("org.postgresql.Driver");

            Connection con = DriverManager.getConnection(url, username, password);

            System.out.println("Database Connected Successfully!");

            createTable(con);

            insertBook(con, 1, "Java Programming", "James Gosling", 550.0);
            insertBook(con, 2, "Spring Boot", "Rod Johnson", 650.0);
            insertBook(con, 3, "Database Systems", "Elmasri", 700.0);

            System.out.println("\nAll Books:");
            displayBooks(con);

            updateBook(con, 2, 750.0);

            System.out.println("\nAfter Update:");
            displayBooks(con);

            deleteBook(con, 3);

            System.out.println("\nAfter Delete:");
            displayBooks(con);

            con.close();
            System.out.println("Connection Closed.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Create Table
    public static void createTable(Connection con) {

        String sql = "CREATE TABLE IF NOT EXISTS books ("
                + "id INT PRIMARY KEY,"
                + "title VARCHAR(100),"
                + "author VARCHAR(100),"
                + "price DOUBLE PRECISION)";

        try {
            Statement st = con.createStatement();
            st.execute(sql);
            System.out.println("Books Table Created Successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // Insert
    public static void insertBook(Connection con, int id, String title, String author, double price) {

        String sql = "INSERT INTO books VALUES(?,?,?,?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, id);
            ps.setString(2, title);
            ps.setString(3, author);
            ps.setDouble(4, price);

            if (ps.executeUpdate() > 0)
                System.out.println("Book Inserted Successfully.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // Read
    public static void displayBooks(Connection con) {

        String sql = "SELECT * FROM books";

        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                System.out.println(
                        rs.getInt("id") + " | " +
                        rs.getString("title") + " | " +
                        rs.getString("author") + " | " +
                        rs.getDouble("price"));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // Update
    public static void updateBook(Connection con, int id, double price) {

        String sql = "UPDATE books SET price=? WHERE id=?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setDouble(1, price);
            ps.setInt(2, id);

            if (ps.executeUpdate() > 0)
                System.out.println("Book Updated Successfully.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // Delete
    public static void deleteBook(Connection con, int id) {

        String sql = "DELETE FROM books WHERE id=?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, id);

            if (ps.executeUpdate() > 0)
                System.out.println("Book Deleted Successfully.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}