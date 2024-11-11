package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class StudentManager implements FileHandler{
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

    // searches for a student based off the recursive method below
    public Student searchStudentByID(int id) {
        return searchStudentByID(id, 0);
    }

    // recursive method to search for a student based off their ID
    public Student searchStudentByID(int id, int index) {
        if (students.get(index).getID() == id) {
            return students.get(index);
        }
        return searchStudentByID(id, index + 1);
    }

    // displays all students
    public ArrayList<Student> displayStudents() {
        return students;
    }

    // saves the list of students to a text file
    public void saveToFile(String fileName, ArrayList<Student> students) throws IOException {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));

            // iterating through the list of students and writing them to a file
            for (Student student : students) {
                writer.write(student.getID() + ", " + student.getName() + ", " + student.getGPA());
                writer.newLine();
            }
            writer.close();
            System.out.println("Student data has been saved.");
        } catch (IOException e) {
            System.out.println("Error: Could not save student data." + e.getMessage());
        }
    }


    // loads data from a text file
    public ArrayList<Student> loadFromFile(String fileName) {
        ArrayList<Student> loadedList = new ArrayList<>();
            try {
                BufferedReader reader = new BufferedReader(new FileReader(fileName));
                String line;

                // while loop to separate each part of the line into a string
                // the strings will be added to a String array
                // creating a new Student with the loaded values
                // adding new students to list
                while ((line = reader.readLine()) != null) {

                    String [] listParts = line.split(", ");
                    int id = Integer.parseInt(listParts[0]);
                    String name = listParts[1];
                    double gpa = Double.parseDouble(listParts[2]);
                    Student tempStudent = new Student(name, id, gpa);
                    loadedList.add(tempStudent);
                }
                reader.close();
                System.out.println("Student data has been loaded.");

            } catch (NumberFormatException | IOException e) {
                System.out.println("Error: Could not load student data: " + e.getMessage());
            }

            return loadedList;
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
