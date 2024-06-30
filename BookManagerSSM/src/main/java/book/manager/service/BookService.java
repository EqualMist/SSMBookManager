package book.manager.service;

import book.manager.entity.Book;

import java.util.List;

public interface BookService {

    List<Book> getAllBooks();

    List<Book> getAllBooksWithoutBorrrow();

    List<Book> getBorrowedBooksById(int id);

    void deleteBook(Integer bid);

    void addBook(String title, String desc, Double price);

    void borrowBook(Integer bid, Integer uid);

    void returnBook(Integer bid, Integer uid);
}
