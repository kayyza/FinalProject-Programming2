package org.example;

import java.io.IOException;
import java.util.ArrayList;

public interface FileHandler {
    void saveToFile(String fileName, ArrayList<Student> students) throws IOException;
    ArrayList<Student> loadFromFile(String fileName);
}
