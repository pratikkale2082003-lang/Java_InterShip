package Day14;


import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    private static final String URL =
            "jdbc:postgresql://localhost:5432/LibrarySystem";

    private static final String USER = "postgres";

    private static final String PASSWORD = "7733";

    public static Connection getConnection() {

        Connection con = null;

        try {

            Class.forName("org.postgresql.Driver");

            con = DriverManager.getConnection(URL, USER, PASSWORD);

            System.out.println("Database Connected Successfully.");

        } catch (Exception e) {
            e.printStackTrace();
        }

        return con;
    }
}