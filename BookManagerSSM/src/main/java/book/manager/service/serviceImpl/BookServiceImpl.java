package book.manager.service.serviceImpl;

import book.manager.entity.Book;
import book.manager.entity.Borrow;
import book.manager.entity.BorrowDetails;
import book.manager.mapper.BookMapper;
import book.manager.mapper.UserMapper;
import book.manager.service.BookService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    @Resource
    private BookMapper bookMapper;
    @Resource
    private UserMapper userMapper;

    @Override
    public List<Book> getAllBooks() {
        return bookMapper.getAllBooks();
    }

    @Override
    public List<Book> getAllBooksWithoutBorrrow() {
        List<Book> books = bookMapper.getAllBooks();
        List<Integer> borrowIds = bookMapper.getBorrowList().stream().map(Borrow::getBid).collect(Collectors.toList());
        return books.stream().filter(book ->!borrowIds.contains(book.getBid())).collect(Collectors.toList());
    }

    @Override
    public List<Book> getBorrowedBooksById(int id) {
        Integer sid = userMapper.getSidByUid(id);
        if (sid == null) {
            return Collections.EMPTY_LIST;
        }
        return bookMapper.getBorrowListBySid(sid)
                .stream()
                .map(borrow -> {
                    return bookMapper.getBookByBid(borrow.getBid());
                }).collect(Collectors.toList());
    }

    @Override
    public void deleteBook(Integer bid) {
        bookMapper.deleteBook(bid);
    }

    @Override
    public void addBook(String title, String desc, Double price) {
        bookMapper.addBook(title, desc, price);
    }

    @Override
    public void borrowBook(Integer bid, Integer uid) {
        Integer sid = userMapper.getSidByUid(uid);
        if (sid == null) {
            return;
        }
        bookMapper.borrowBook(bid, sid);
    }

    @Override
    public void returnBook(Integer bid, Integer uid) {
        Integer sid = userMapper.getSidByUid(uid);
        if (sid == null) {
            return;
        }
        bookMapper.returnBook(bid, sid);
    }

    @Override
    public List<BorrowDetails> getBorrowDetails() {
        return bookMapper.getBorrowDetails();
    }
}
