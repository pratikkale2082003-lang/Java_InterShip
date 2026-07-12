package Day17;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentDAO {

    // ================= INSERT STUDENT =================

    public void insertStudent(Student student) {

        String sql = "INSERT INTO students(name, email) VALUES(?, ?)";

        try (
                Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
        ) {

            ps.setString(1, student.getName());
            ps.setString(2, student.getEmail());

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Student Added Successfully.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    // ================= DISPLAY ALL STUDENTS =================

    public void displayStudents() {

        String sql = "SELECT * FROM students ORDER BY student_id";

        try (
                Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
        ) {

            System.out.println("\n---------------------------------------------");
            System.out.printf("%-5s %-20s %-30s%n", "ID", "NAME", "EMAIL");
            System.out.println("---------------------------------------------");

            while (rs.next()) {

                System.out.printf("%-5d %-20s %-30s%n",
                        rs.getInt("student_id"),
                        rs.getString("name"),
                        rs.getString("email"));

            }

            System.out.println("---------------------------------------------");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    // ================= GET ALL STUDENTS =================

    public ArrayList<Student> getAllStudents() {

        ArrayList<Student> list = new ArrayList<>();

        String sql = "SELECT * FROM students ORDER BY student_id";

        try (
                Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
        ) {

            while (rs.next()) {

                Student student = new Student();

                student.setStudentId(rs.getInt("student_id"));
                student.setName(rs.getString("name"));
                student.setEmail(rs.getString("email"));

                list.add(student);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;

    }

    // ================= SEARCH STUDENT =================

    public Student searchStudent(int id) {

        Student student = null;

        String sql = "SELECT * FROM students WHERE student_id=?";

        try (
                Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
        ) {

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                student = new Student();

                student.setStudentId(rs.getInt("student_id"));
                student.setName(rs.getString("name"));
                student.setEmail(rs.getString("email"));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return student;

    }

    // ================= UPDATE STUDENT =================

    public void updateStudent(Student student) {

        String sql = "UPDATE students SET name=?, email=? WHERE student_id=?";

        try (
                Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
        ) {

            ps.setString(1, student.getName());
            ps.setString(2, student.getEmail());
            ps.setInt(3, student.getStudentId());

            int rows = ps.executeUpdate();

            if (rows > 0) {

                System.out.println("Student Updated Successfully.");

            } else {

                System.out.println("Student Not Found.");

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    // ================= DELETE STUDENT =================

    public void deleteStudent(int id) {

        String sql = "DELETE FROM students WHERE student_id=?";

        try (
                Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
        ) {

            ps.setInt(1, id);

            int rows = ps.executeUpdate();

            if (rows > 0) {

                System.out.println("Student Deleted Successfully.");

            } else {

                System.out.println("Student Not Found.");

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}