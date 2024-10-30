package org.example;

public class Student extends Person{
    private int ID;
    private static int currentID = 1;
    private double GPA;


    public String getDescription() {
        return "Name: " + getName() + ", Student ID: " + ID + ", GPA: " + GPA;
    }
    // constructors
    public Student() {
        super(null);
        ID = 0;
        GPA = 0.0;
    }

    public Student(String getName, double GPA) {
        super(getName);
        this.ID = nextID();
        this.GPA = GPA;
    }

    private static int nextID() {
        return currentID++;
    }

    // getters
    public int getID() {
        return ID;
    }
    public double getGPA() {
        return GPA;
    }

    // setters
    public void setID(int ID) {
        this.ID = ID;
    }

    public void setGPA(double GPA) {
        this.GPA = GPA;
    }

    // equals method
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Student student = (Student) o;
        return ID == student.ID && Double.compare(GPA, student.GPA) == 0;
    }
}
