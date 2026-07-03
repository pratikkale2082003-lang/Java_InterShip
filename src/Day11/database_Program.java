package Day11;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class database_Program {

    public static void main(String[] args) {

        // Database Details
        String url = "jdbc:postgresql://localhost:5432/cravita";
        String username = "postgres";
        String password = "7733";   // Change this to test exceptions

        Connection con = null;

        try {
            // Load PostgreSQL JDBC Driver
            Class.forName("org.postgresql.Driver");
            System.out.println("Driver Loaded Successfully.");

            // Create Database Connection
            con = DriverManager.getConnection(url, username, password);

            System.out.println("Database Connected Successfully!");

        } catch (ClassNotFoundException e) {
            System.out.println("JDBC Driver Not Found!");
            e.printStackTrace();

        } catch (SQLException e) {
            System.out.println("Database Connection Failed!");
            System.out.println("Reason: " + e.getMessage());

        } finally {
            // Close Connection
            if (con != null) {
                try {
                    con.close();
                    System.out.println("Database Connection Closed.");
                } catch (SQLException e) {
                    System.out.println("Error while closing connection.");
                    e.printStackTrace();
                }
            }
        }
    }
}