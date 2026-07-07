package Day16;

import java.sql.Connection;
import java.sql.Date;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        try {

            Connection con = DBConnection.getConnection();
            Scanner sc = new Scanner(System.in);

            // ---------- STUDENT ----------
            System.out.println("Enter Student Name:");
            String studentName = sc.nextLine();

            System.out.println("Enter Student Email:");
            String studentEmail = sc.nextLine();

            StudentCRUD.insertStudent(con, studentName, studentEmail);

            // ---------- COURSE ----------
            System.out.println("\nEnter Course Name:");
            String courseName = sc.nextLine();

            System.out.println("Enter Course Duration:");
            String duration = sc.nextLine();

            System.out.println("Enter Course Fees:");
            double fees = sc.nextDouble();

            CourseCRUD.insertCourse(con, courseName, duration, fees);

            System.out.println("\nStudents");
            StudentCRUD.readStudents(con);

            System.out.println("\nCourses");
            CourseCRUD.readCourses(con);

            // ---------- ENROLLMENT ----------
            System.out.println("\nEnter Student ID:");
            int studentId = sc.nextInt();

            System.out.println("Enter Course ID:");
            int courseId = sc.nextInt();

            System.out.println("Enter Enrollment Date (yyyy-mm-dd):");
            String date = sc.next();

            EnrollmentCRUD.insertEnrollment(
                    con,
                    studentId,
                    courseId,
                    Date.valueOf(date)
            );

            System.out.println("\nEnrollments");
            EnrollmentCRUD.readEnrollments(con);

            // ---------- UPDATE STUDENT ----------
            System.out.println("\nEnter Student ID to Update:");
            int updateStudentId = sc.nextInt();
            sc.nextLine();

            System.out.println("Enter New Student Name:");
            String newName = sc.nextLine();

            System.out.println("Enter New Student Email:");
            String newEmail = sc.nextLine();

            StudentCRUD.updateStudent(con, updateStudentId, newName, newEmail);

            // ---------- UPDATE COURSE ----------
            System.out.println("\nEnter Course ID to Update:");
            int updateCourseId = sc.nextInt();

            System.out.println("Enter New Fees:");
            double newFees = sc.nextDouble();

            CourseCRUD.updateCourse(con, updateCourseId, newFees);

            // ---------- UPDATE ENROLLMENT ----------
            System.out.println("\nEnter Enrollment ID to Update:");
            int enrollmentId = sc.nextInt();

            System.out.println("Enter New Course ID:");
            int newCourseId = sc.nextInt();

            EnrollmentCRUD.updateEnrollment(con, enrollmentId, newCourseId);

            System.out.println("\nAfter Update");

            StudentCRUD.readStudents(con);
            CourseCRUD.readCourses(con);
            EnrollmentCRUD.readEnrollments(con);

            // ---------- DELETE ----------
            System.out.println("\nEnter Enrollment ID to Delete:");
            int deleteEnrollment = sc.nextInt();

            EnrollmentCRUD.deleteEnrollment(con, deleteEnrollment);

            System.out.println("Enter Course ID to Delete:");
            int deleteCourse = sc.nextInt();

            CourseCRUD.deleteCourse(con, deleteCourse);

            System.out.println("Enter Student ID to Delete:");
            int deleteStudent = sc.nextInt();

            StudentCRUD.deleteStudent(con, deleteStudent);

            System.out.println("\nAfter Delete");

            StudentCRUD.readStudents(con);
            CourseCRUD.readCourses(con);
            EnrollmentCRUD.readEnrollments(con);

            sc.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}