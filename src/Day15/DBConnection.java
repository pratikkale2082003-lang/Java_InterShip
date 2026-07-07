package Day15;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    private static final String URL =
            "jdbc:postgresql://localhost:5432/Shopdb";

    private static final String USER = "postgres";
    private static final String PASSWORD = "7733";

    public static Connection getConnection() {

        try {

            Class.forName("org.postgresql.Driver");

            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);

            System.out.println("Database Connected Successfully!");

            return con;

        } catch (Exception e) {

            e.printStackTrace();
        }

        return null;
    }

}