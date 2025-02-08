package org.example.task8_book2;
/**
 * Создайте класс Book с полями для названия и автора.
 * В классе BookCollection используйте HashSet<Book> для хранения коллекции книг без дубликатов.
 * Реализуйте методы для добавления книги в коллекцию, удаление книги из коллекции и проверки, содержится ли книга в коллекции
 */
public class Book2 {
    private String bookName;
    private String bookAuthor;

    public Book2(String bookName, String bookAuthor) {
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
    }

    @Override
    public String toString() {
        return "Book2{" +
                "bookName='" + bookName + '\'' +
                ", bookAuthor='" + bookAuthor + '\'' +
                '}';
    }
}
