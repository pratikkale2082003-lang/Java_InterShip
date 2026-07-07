package Day16;

import java.sql.*;

public class EnrollmentCRUD {

    public static void insertEnrollment(Connection con,
                                        int studentId,
                                        int courseId,
                                        Date date)throws Exception{

        String sql="""
                INSERT INTO enrollments
                (student_id,course_id,enrollment_date)
                VALUES(?,?,?)
                """;

        PreparedStatement ps=con.prepareStatement(sql);

        ps.setInt(1,studentId);
        ps.setInt(2,courseId);
        ps.setDate(3,date);

        ps.executeUpdate();

        System.out.println("Enrollment Inserted");

    }

    public static void readEnrollments(Connection con)throws Exception{

        String sql="""
                SELECT
                e.id,
                s.student_name,
                c.course_name,
                e.enrollment_date

                FROM enrollments e

                JOIN students s
                ON e.student_id=s.id

                JOIN courses c
                ON e.course_id=c.id
                """;

        Statement st=con.createStatement();

        ResultSet rs=st.executeQuery(sql);

        while(rs.next()){

            System.out.println(

                    rs.getInt(1)+" "
                    +rs.getString(2)+" "
                    +rs.getString(3)+" "
                    +rs.getDate(4)

            );

        }

    }

    public static void updateEnrollment(Connection con,
                                        int id,
                                        int newCourseId)throws Exception{

        String sql="""
                UPDATE enrollments
                SET course_id=?
                WHERE id=?
                """;

        PreparedStatement ps=con.prepareStatement(sql);

        ps.setInt(1,newCourseId);
        ps.setInt(2,id);

        ps.executeUpdate();

        System.out.println("Enrollment Updated");

    }

    public static void deleteEnrollment(Connection con,int id)throws Exception{

        String sql="DELETE FROM enrollments WHERE id=?";

        PreparedStatement ps=con.prepareStatement(sql);

        ps.setInt(1,id);

        ps.executeUpdate();

        System.out.println("Enrollment Deleted");

    }

}