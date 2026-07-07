package Day16;

import java.sql.*;

public class StudentCRUD {

    public static void insertStudent(Connection con, String name, String email) throws Exception {

        String sql = "INSERT INTO students(student_name,email) VALUES(?,?)";

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, name);
        ps.setString(2, email);

        ps.executeUpdate();

        System.out.println("Student Inserted");
    }

    public static void readStudents(Connection con) throws Exception {

        Statement st = con.createStatement();

        ResultSet rs = st.executeQuery("SELECT * FROM students");

        while (rs.next()) {

            System.out.println(

                    rs.getInt("id") + " "
                            + rs.getString("student_name") + " "
                            + rs.getString("email")
            );
        }

    }

    public static void updateStudent(Connection con, int id, String name, String email) throws Exception {

        String sql = "UPDATE students SET student_name=?, email=? WHERE id=?";

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, name);
        ps.setString(2, email);
        ps.setInt(3, id);

        ps.executeUpdate();

        System.out.println("Student Updated");
    }

    public static void deleteStudent(Connection con, int id) throws Exception {

        String sql = "DELETE FROM students WHERE id=?";

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, id);

        ps.executeUpdate();

        System.out.println("Student Deleted");
    }

}