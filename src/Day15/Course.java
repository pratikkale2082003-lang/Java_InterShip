package Day15;

public class Course {

    private int id;
    private String courseName;
    private String duration;
    private double fee;

    public Course(int id, String courseName, String duration, double fee) {

        this.id = id;
        this.courseName = courseName;
        this.duration = duration;
        this.fee = fee;
    }

    public int getId() {
        return id;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getDuration() {
        return duration;
    }

    public double getFee() {
        return fee;
    }
}