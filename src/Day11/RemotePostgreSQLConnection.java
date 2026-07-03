package Day11;


	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.SQLException;

	public class RemotePostgreSQLConnection {

	    public static void main(String[] args) {

	        // Remote PostgreSQL Database Details
	    	 String url = "jdbc:postgresql://localhost:5432/cravita";
	         String username = "postgres";
	         String password = "7733"; 

	        try {
	            // Load PostgreSQL JDBC Driver
	            Class.forName("org.postgresql.Driver");
	            System.out.println("PostgreSQL Driver Loaded Successfully.");

	            // Create Connection
	            Connection con = DriverManager.getConnection(url, username, password);

	            System.out.println("Connected to Remote PostgreSQL Database Successfully!");

	            // Close Connection
	            con.close();
	            System.out.println("Connection Closed.");

	        } catch (ClassNotFoundException e) {
	            System.out.println("PostgreSQL JDBC Driver Not Found.");
	        } catch (SQLException e) {
	            System.out.println("Connection Failed!");
	            System.out.println("Reason: " + e.getMessage());
	        }
	    }
	
}
