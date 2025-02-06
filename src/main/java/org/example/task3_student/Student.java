package org.example.task3_student;

/**
 * Создайте класс Student с поляями для хранения имени, номера зачетной книжки и среднего балла.
 * Реализуйте методы для получения и установки этих полей.
 * Создайте интерфейс Printable с методом print() для вывода информации о студенте
 */
public class Student implements Printable{
    String name;
    String tubNumber;
    double gpa;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTubNumber() {
        return tubNumber;
    }

    public void setTubNumber(String tubNumber) {
        this.tubNumber = tubNumber;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    @Override
    public void print() {
        System.out.println("ФИО студента " + getName());
        System.out.println("Номер зачетной книжки " + getTubNumber());
        System.out.println("Средний балл - " + getGpa());
    }
}
