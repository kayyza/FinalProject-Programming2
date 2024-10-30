package org.example;

public class Main {
    public static void main(String[] args) {
        Student student1 = new Student("Rachel", 3.9);
        Student student2 = new Student("Kayleigh", 4.0);

        System.out.println(student1.getDescription());
        System.out.println(student2.getDescription());
    }
}