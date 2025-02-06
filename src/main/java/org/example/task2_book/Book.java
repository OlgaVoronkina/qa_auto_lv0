package org.example.task2_book;

/**
 * Создайте класс Book с полями для хранения названия, автора и года издания.
 * Реализуйте методы для получения и установки этих полей.
 * Создайте интерфейс Displayable с методом display(), который реализуется в классе Book для отображения информации о книге
 */
public class Book implements Displayable{
    String name;
    String author;
    int year;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public void display() {
        System.out.println("Название книги - " + getName());
        System.out.println("Автор книги - " + getAuthor());
        System.out.println("Год издания " + getYear());
    }
}
