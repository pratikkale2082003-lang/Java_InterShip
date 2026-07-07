package Day15;

import java.sql.Date;

public class Enrollment {

    private int id;
    private int studentId;
    private int courseId;
    private Date date;

    public Enrollment(int id, int studentId, int courseId, Date date) {

        this.id = id;
        this.studentId = studentId;
        this.courseId = courseId;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public int getStudentId() {
        return studentId;
    }

    public int getCourseId() {
        return courseId;
    }

    public Date getDate() {
        return date;
    }
}