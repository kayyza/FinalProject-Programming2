package org.example;

import java.util.ArrayList;
import java.util.Objects;

public class StudentManager {
    private ArrayList<Student> students;

    // constructors
    public StudentManager() {
        students = new ArrayList<>();
    }

    public StudentManager(ArrayList<Student> students) {
        this.students = students;
    }

    // adds a student to the list
    public void addStudent(Student student) {
        students.add(student);
    }

    // removes student from the list based on their ID
    public void removeStudent(int id) {
        for (Student student : students) {
            if (student.getID() == id) {
                students.remove(student);
                break;
            }
        }
    }

    public Student searchStudentByID(int id) {
        for (Student student : students) {
            if (student.getID() == id) {
                return student;
            }
        }
        return searchStudentByID(id);
    }

    // getter
    public ArrayList<Student> getStudents() {
        return students;
    }

    // setter
    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    // equals method
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentManager that = (StudentManager) o;
        return Objects.equals(students, that.students);
    }
}
