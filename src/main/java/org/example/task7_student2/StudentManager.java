package org.example.task7_student2;

import java.util.ArrayList;

public class StudentManager {
    ArrayList<Student2> students = new ArrayList<>();

    public void addStudent(Student2 student){
        students.add(student);
    }

    public ArrayList<Student2> getStudentsList(){
        return students;
    }

    public void removeStudent(Student2 student){
        students.remove(student);
    }
}
