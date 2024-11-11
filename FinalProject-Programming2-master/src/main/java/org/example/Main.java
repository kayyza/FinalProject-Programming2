package org.example;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        StudentManager manager = new StudentManager();

        Student student1 = new Student("Rachel", 1, 3.9);
        Student student2 = new Student("Kayleigh", 2, 4.0);

        // adding students to list
        manager.addStudent(student1);
        manager.addStudent(student2);

        // user input for saving text files
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a save file name. Extension must be .txt");
        String fileName = scanner.nextLine();


        manager.saveToFile(fileName, manager.getStudents());
        System.out.println("Number of students before save: " + manager.getStudents().size());

        // user input for loading text file
        System.out.println("Please enter a load file name.");
        String loadFileName = scanner.nextLine();

        // adding students to list
        ArrayList<Student> loadData = manager.loadFromFile(loadFileName);
        for (Student loadedStudent : loadData) {
            manager.addStudent(loadedStudent);
        }

        // printing students from StudentManager
        System.out.println("Number of students after save: " + manager.getStudents().size());

        for (Student student : manager.getStudents()) {
            System.out.println(student.toString());
        }
    }
}
