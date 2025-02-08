package org.example.task7_student2;

/**
 * Создайте класс Student с полями  для хранения имени и ID студента.
 * В классе StudentManager используйте ArrayList<Student> для хранения списка студентов.
 * Реализуйте методы для добавления нового студента в список, удаление студента по ID  и получение списка всех студентов
 */
public class Student2 {
    private String studentName;
    private String id;

    public Student2(String studentName, String id) {
        this.studentName = studentName;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Student2{" +
                "studentName='" + studentName + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
