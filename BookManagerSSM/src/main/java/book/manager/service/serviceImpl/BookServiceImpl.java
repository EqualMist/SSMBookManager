package book.manager.service.serviceImpl;

import book.manager.entity.Book;
import book.manager.mapper.BookMapper;
import book.manager.service.BookService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Resource
    private BookMapper bookMapper;

    @Override
    public List<Book> getAllBooks() {
        return bookMapper.getAllBooks();
    }

    @Override
    public void deleteBook(Integer bid) {
        bookMapper.deleteBook(bid);
    }

    @Override
    public void addBook(String title, String desc, Double price) {
        bookMapper.addBook(title, desc, price);
    }
}
