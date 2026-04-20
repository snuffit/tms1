package main.students;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Pstyga Stas
 * @created 20.04.2026
 */
public class University {

    private List<Student> students = new ArrayList<>();

    public void addStudent(Student student) {
        this.students.add(student);
    }

    public void transferToNextCourse() {
        for (int i = 0; i < this.students.size(); i++) {
            if(students.get(i).getAverageScore() >= 3) {
                students.get(i).transferToNextCourse();
            }else {
                students.remove(i);
            }
        }
    }

    public void getStudentsFromCourse(int course) {
        System.out.printf("На %d курсе обучаются: ", course);
        for (Student student : this.students) {
            if(student.getCourse() == course) {
                System.out.print(student.getName() + " ");
            }
        }
        System.out.println();
    }

    public void getStudentsInfo() {

        System.out.println(this.students);
    }
}
