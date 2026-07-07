package Day14;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class MemberCRUD {

    // Insert Member
    public static void insertMember(Connection con,
                                    String name,
                                    String email,
                                    String phone,
                                    String address) {

        String sql = "INSERT INTO Members(name,email,phone,address) VALUES(?,?,?,?)";

        try {

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, phone);
            ps.setString(4, address);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Member Added Successfully.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Read Members
    public static void readMembers(Connection con) {

        String sql = "SELECT * FROM Members";

        try {

            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);

            System.out.println("\n----------- Members -----------");

            while (rs.next()) {

                System.out.println(
                        rs.getInt("member_id") + " | " +
                        rs.getString("name") + " | " +
                        rs.getString("email") + " | " +
                        rs.getString("phone") + " | " +
                        rs.getString("address") + " | " +
                        rs.getDate("join_date")
                );
            }

            System.out.println("-------------------------------");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Update Member
    public static void updateMember(Connection con,
                                    int memberId,
                                    String phone,
                                    String address) {

        String sql =
                "UPDATE Members SET phone=?, address=? WHERE member_id=?";

        try {

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, phone);
            ps.setString(2, address);
            ps.setInt(3, memberId);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Member Updated Successfully.");
            } else {
                System.out.println("Member Not Found.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Delete Member
    public static void deleteMember(Connection con,
                                    int memberId) {

        String sql =
                "DELETE FROM Members WHERE member_id=?";

        try {

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, memberId);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Member Deleted Successfully.");
            } else {
                System.out.println("Member Not Found.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Search Member by ID
    public static void searchMember(Connection con,
                                    int memberId) {

        String sql =
                "SELECT * FROM Members WHERE member_id=?";

        try {

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, memberId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                System.out.println("\nMember Details");

                System.out.println("ID       : " + rs.getInt("member_id"));
                System.out.println("Name     : " + rs.getString("name"));
                System.out.println("Email    : " + rs.getString("email"));
                System.out.println("Phone    : " + rs.getString("phone"));
                System.out.println("Address  : " + rs.getString("address"));
                System.out.println("Join Date: " + rs.getDate("join_date"));

            } else {

                System.out.println("Member Not Found.");

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}