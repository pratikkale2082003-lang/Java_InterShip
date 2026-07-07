package Day15;

import java.sql.*;

public class CollegeDAO {

    private Connection con;

    public CollegeDAO(Connection con) {
        this.con = con;
    }

    // ==========================
    // Phone Validation
    // ==========================

    public boolean isValidPhone(String phone) {
        return phone.matches("\\d{10}");
    }

    // ==========================
    // Check Duplicate Email
    // ==========================

    public boolean emailExists(String email) {

        String sql = "SELECT * FROM students WHERE email=?";

        try {

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, email);

            ResultSet rs = ps.executeQuery();

            return rs.next();

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return false;
    }

    // ==========================
    // Insert Student
    // ==========================

    public void insertStudent(Student s) {

        if (!isValidPhone(s.getPhone())) {
            System.out.println("Invalid Phone Number");
            return;
        }

        if (emailExists(s.getEmail())) {
            System.out.println("Duplicate Email : " + s.getEmail());
            return;
        }

        String sql = "INSERT INTO students VALUES(?,?,?,?)";

        try {

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, s.getId());
            ps.setString(2, s.getName());
            ps.setString(3, s.getEmail());
            ps.setString(4, s.getPhone());

            ps.executeUpdate();

            System.out.println("Student Inserted Successfully.");

        } catch (SQLException e) {

            e.printStackTrace();
        }

    }

    // ==========================
    // Insert Course
    // ==========================

    public void insertCourse(Course c) {

        String sql = "INSERT INTO courses VALUES(?,?,?,?)";

        try {

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, c.getId());
            ps.setString(2, c.getCourseName());
            ps.setString(3, c.getDuration());
            ps.setDouble(4, c.getFee());

            ps.executeUpdate();

            System.out.println("Course Inserted Successfully.");

        } catch (SQLException e) {

            e.printStackTrace();
        }

    }

    // ==========================
    // Insert Enrollment
    // ==========================

    public void insertEnrollment(Enrollment e) {

        String sql = "INSERT INTO enrollments VALUES(?,?,?,?)";

        try {

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, e.getId());
            ps.setInt(2, e.getStudentId());
            ps.setInt(3, e.getCourseId());
            ps.setDate(4, e.getDate());

            ps.executeUpdate();

            System.out.println("Enrollment Inserted Successfully.");

        } catch (SQLException ex) {

            ex.printStackTrace();
        }

    }

    // ==========================
    // Display Students
    // ==========================

    public void displayStudents() {

        String sql = "SELECT * FROM students";

        try {

            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);

            System.out.println("\n----- STUDENTS -----");

            while (rs.next()) {

                System.out.println(
                        rs.getInt("id") + " | " +
                        rs.getString("name") + " | " +
                        rs.getString("email") + " | " +
                        rs.getString("phone"));

            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

    }

    // ==========================
    // Display Courses
    // ==========================

    public void displayCourses() {

        String sql = "SELECT * FROM courses";

        try {

            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);

            System.out.println("\n----- COURSES -----");

            while (rs.next()) {

                System.out.println(
                        rs.getInt("id") + " | " +
                        rs.getString("course_name") + " | " +
                        rs.getString("duration") + " | " +
                        rs.getDouble("fee"));

            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

    }

    // ==========================
    // Display Enrollments
    // ==========================

    public void displayEnrollments() {

        String sql = "SELECT * FROM enrollments";

        try {

            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);

            System.out.println("\n----- ENROLLMENTS -----");

            while (rs.next()) {

                System.out.println(
                        rs.getInt("id") + " | " +
                        rs.getInt("student_id") + " | " +
                        rs.getInt("course_id") + " | " +
                        rs.getDate("enrollment_date"));

            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

    }

    // ==========================
    // Update Student
    // ==========================

    public void updateStudent(int id, String phone) {

        if (!isValidPhone(phone)) {

            System.out.println("Invalid Phone Number");

            return;
        }

        String sql = "UPDATE students SET phone=? WHERE id=?";

        try {

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, phone);
            ps.setInt(2, id);

            if (ps.executeUpdate() > 0)
                System.out.println("Student Updated Successfully.");
            else
                System.out.println("Student Not Found.");

        } catch (SQLException e) {

            e.printStackTrace();
        }

    }

    // ==========================
    // Delete Student
    // ==========================

    public void deleteStudent(int id) {

        String sql = "DELETE FROM students WHERE id=?";

        try {

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, id);

            if (ps.executeUpdate() > 0)
                System.out.println("Student Deleted Successfully.");
            else
                System.out.println("Student Not Found.");

        } catch (SQLException e) {

            e.printStackTrace();
        }

    }

}