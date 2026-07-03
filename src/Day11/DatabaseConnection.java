package Day11;
import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {

    public static void main(String[] args) {

        // Database Details
        String url = "jdbc:postgresql://localhost:5432/JavaIntership";
        String username = "postgres";
        String password = "7733";

        try {
            // Load PostgreSQL Driver
            Class.forName("org.postgresql.Driver");

            // Create Connection
            Connection con = DriverManager.getConnection(url, username, password);

            if (con != null) {
                System.out.println("Database Connected Successfully!");
            }

            // Close Connection
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}