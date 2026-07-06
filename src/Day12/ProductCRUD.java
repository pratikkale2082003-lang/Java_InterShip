package Day12;

import java.sql.*;

public class ProductCRUD {

    static String url = "jdbc:postgresql://localhost:5432/cravita";
    static String username = "postgres";
    static String password = "7733";

    public static void main(String[] args) {

        try {
            // Load Driver
            Class.forName("org.postgresql.Driver");

            // Connect
            Connection con = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to PostgreSQL Successfully!");

            // Create Table
            createTable(con);

            // Insert Products
            insertProduct(con, 1, "Laptop", 55000);
            insertProduct(con, 2, "Mobile", 25000);
            insertProduct(con, 3, "Headphone", 2000);

            // Display
            displayProducts(con);

            // Update
            updateProduct(con, 2, 28000);

            // Display Again
            displayProducts(con);

            // Delete
            deleteProduct(con, 3);

            // Final Display
            displayProducts(con);

            con.close();
            System.out.println("Connection Closed.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Create Table
    public static void createTable(Connection con) {

        String sql = """
                CREATE TABLE IF NOT EXISTS products(
                    id INT PRIMARY KEY,
                    name VARCHAR(100),
                    price DOUBLE PRECISION
                )
                """;

        try {
            Statement st = con.createStatement();
            st.execute(sql);
            System.out.println("Products Table Created Successfully.");
        } catch (SQLException e) {
            System.out.println("Table Creation Failed!");
        }
    }

    // Insert
    public static void insertProduct(Connection con, int id, String name, double price) {

        String sql = "INSERT INTO products(id,name,price) VALUES(?,?,?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setDouble(3, price);

            int rows = ps.executeUpdate();

            if (rows > 0)
                System.out.println("Product Inserted Successfully.");
            else
                System.out.println("Insert Failed.");

        } catch (SQLException e) {
            System.out.println("Insert Error : " + e.getMessage());
        }
    }

    // Display
    public static void displayProducts(Connection con) {

        String sql = "SELECT * FROM products";

        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            System.out.println("\n------ Products ------");

            while (rs.next()) {

                System.out.println(
                        rs.getInt("id") + " | " +
                        rs.getString("name") + " | " +
                        rs.getDouble("price"));
            }

            System.out.println("----------------------");

        } catch (SQLException e) {
            System.out.println("Display Failed!");
        }
    }

    // Update
    public static void updateProduct(Connection con, int id, double newPrice) {

        String sql = "UPDATE products SET price=? WHERE id=?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setDouble(1, newPrice);
            ps.setInt(2, id);

            int rows = ps.executeUpdate();

            if (rows > 0)
                System.out.println("Product Updated Successfully.");
            else
                System.out.println("Update Failed.");

        } catch (SQLException e) {
            System.out.println("Update Error!");
        }
    }

    // Delete
    public static void deleteProduct(Connection con, int id) {

        String sql = "DELETE FROM products WHERE id=?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, id);

            int rows = ps.executeUpdate();

            if (rows > 0)
                System.out.println("Product Deleted Successfully.");
            else
                System.out.println("Delete Failed.");

        } catch (SQLException e) {
            System.out.println("Delete Error!");
        }
    }
}