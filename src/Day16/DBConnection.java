package Day16;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    private static final String URL = "jdbc:postgresql://localhost:5432/College";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "7733";

    public static Connection getConnection() {

        try {

            Class.forName("org.postgresql.Driver");

            return DriverManager.getConnection(URL, USERNAME, PASSWORD);

        } catch (Exception e) {

            e.printStackTrace();
        }

        return null;
    }
}