package Day16;

import java.sql.*;

public class CourseCRUD {

    public static void insertCourse(Connection con,String name,String duration,double fees)throws Exception{

        String sql="INSERT INTO courses(course_name,duration,fees) VALUES(?,?,?)";

        PreparedStatement ps=con.prepareStatement(sql);

        ps.setString(1,name);
        ps.setString(2,duration);
        ps.setDouble(3,fees);

        ps.executeUpdate();

        System.out.println("Course Inserted");
    }

    public static void readCourses(Connection con)throws Exception{

        Statement st=con.createStatement();

        ResultSet rs=st.executeQuery("SELECT * FROM courses");

        while(rs.next()){

            System.out.println(

                    rs.getInt("id")+" "
                    +rs.getString("course_name")+" "
                    +rs.getString("duration")+" "
                    +rs.getDouble("fees")
            );
        }

    }

    public static void updateCourse(Connection con,int id,double fees)throws Exception{

        String sql="UPDATE courses SET fees=? WHERE id=?";

        PreparedStatement ps=con.prepareStatement(sql);

        ps.setDouble(1,fees);
        ps.setInt(2,id);

        ps.executeUpdate();

        System.out.println("Course Updated");
    }

    public static void deleteCourse(Connection con,int id)throws Exception{

        String sql="DELETE FROM courses WHERE id=?";

        PreparedStatement ps=con.prepareStatement(sql);

        ps.setInt(1,id);

        ps.executeUpdate();

        System.out.println("Course Deleted");
    }

}