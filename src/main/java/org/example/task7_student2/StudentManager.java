package org.example.task7_student2;

import java.util.ArrayList;

public class StudentManager {
    private ArrayList<Student2> students;

    public StudentManager() {
        this.students = new ArrayList<>();
    }

    public StudentManager(ArrayList<Student2> students) {
        this.students = students;
    }


    public void addStudent(Student2 student){
        students.add(student);
    }

    public ArrayList<Student2> getStudentsList(){
        return students;
    }

    public void removeStudent(Student2 student){
        students.remove(student);
    }

    public void removeStudent(String id){
        //вариант 1 - найти студента по id - удалить
        Student2 targetStudent = null;
        for (Student2 student:students){
            if(student.getId().equals(id)){
                targetStudent = student;
            }
        }
        if(targetStudent!=null){
            students.remove(targetStudent);
        }else {
            System.out.println("student with id "+id+ "not found");
        }
    }
}
