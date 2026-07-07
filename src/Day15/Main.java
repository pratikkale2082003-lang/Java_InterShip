package Day15;

import java.sql.Connection;
import java.sql.Date;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Connection con = DBConnection.getConnection();

        if (con == null) {
            System.out.println("Connection Failed!");
            return;
        }

        CollegeDAO dao = new CollegeDAO(con);

        Scanner sc = new Scanner(System.in);

        // ==========================
        // Student Input
        // ==========================

        System.out.println("Enter Student ID:");
        int sid = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter Student Name:");
        String name = sc.nextLine();

        System.out.println("Enter Student Email:");
        String email = sc.nextLine();

        System.out.println("Enter Student Phone:");
        String phone = sc.nextLine();

        dao.insertStudent(new Student(sid, name, email, phone));

        // ==========================
        // Course Input
        // ==========================

        System.out.println("\nEnter Course ID:");
        int cid = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter Course Name:");
        String cname = sc.nextLine();

        System.out.println("Enter Duration:");
        String duration = sc.nextLine();

        System.out.println("Enter Fee:");
        double fee = sc.nextDouble();

        dao.insertCourse(new Course(cid, cname, duration, fee));

        // ==========================
        // Enrollment Input
        // ==========================

        System.out.println("\nEnter Enrollment ID:");
        int eid = sc.nextInt();

        System.out.println("Enter Student ID:");
        int studentId = sc.nextInt();

        System.out.println("Enter Course ID:");
        int courseId = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter Enrollment Date (yyyy-mm-dd):");
        String date = sc.nextLine();

        dao.insertEnrollment(
                new Enrollment(
                        eid,
                        studentId,
                        courseId,
                        Date.valueOf(date)
                )
        );

        // Display Data
        dao.displayStudents();
        dao.displayCourses();
        dao.displayEnrollments();

        sc.close();
    }
}