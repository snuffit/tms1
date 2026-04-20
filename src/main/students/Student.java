package main.students;

/**
 * @author Pstyga Stas
 * @created 20.04.2026
 */
public class Student {

    private String name;
    private String group;
    private int course;
    private double averageScore;

    public Student(String name, String group, int course, double averageScore) {
        this.name = name;
        this.group = group;
        this.course = course;
        this.averageScore = averageScore;
    }

    public double getAverageScore() {
        return averageScore;
    }

    public void transferToNextCourse() {
        this.course++;
    }

    public int getCourse() {
        return course;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + ", " + group + ", " + course +
                ", " + averageScore + "; ";
    }
}
