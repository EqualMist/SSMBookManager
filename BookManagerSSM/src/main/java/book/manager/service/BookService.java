package book.manager.service;

import book.manager.entity.Book;

import java.util.List;

public interface BookService {

    List<Book> getAllBooks();

    void deleteBook(Integer bid);

    void addBook(String title, String desc, Double price);
}