package org.example.task8_book2;

import java.util.HashSet;

public class BookCollection {
    public HashSet<Book2> books=new HashSet<>();

    public void addBook(Book2 book){
        if(books.contains(book)){
            System.out.println("Книга " + book + " уже существует");
        }
        else {
            this.books.add(book);
        }
    }

    public   void  removeBook (Book2 book){
        books.remove(book);
    }

    public void checkBooks(Book2 book){
        if(this.books.contains(book)){
            System.out.println("Книга " +book+ "  есть в коллекции");
        }
        else{
            System.out.println("Книги " +book+ " НЕТ в коллекции");
        }
    }

    public HashSet<Book2> getBooks(){
        return books;
    }

}
