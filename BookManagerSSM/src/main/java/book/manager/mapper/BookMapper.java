package book.manager.mapper;

import book.manager.entity.Book;
import book.manager.entity.Borrow;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BookMapper {

    @Select("SELECT * FROM book")
    List<Book> getAllBooks();

    @Select("SELECT * FROM book WHERE bid = #{bid}")
    Book getBookByBid(@Param("bid") Integer bid);

    @Delete("DELETE FROM book WHERE bid = #{bid}")
    void deleteBook(Integer bid);

    @Insert("INSERT INTO book (title, `desc`, price) VALUES (#{title}, #{desc}, #{price})")
    void addBook(@Param("title") String title, @Param("desc") String desc, @Param("price") Double price);

    @Insert("INSERT INTO borrow (bid, sid, time) values (#{bid}, #{sid}, now())")
    void borrowBook(@Param("bid") Integer bid, @Param("sid") Integer sid);

    @Select("SELECT * FROM borrow")
    List<Borrow> getBorrowList();

    @Select("SELECT * FROM borrow WHERE sid = #{sid}")
    List<Borrow> getBorrowListBySid(Integer sid);

    @Delete("DELETE FROM borrow WHERE bid = #{bid} AND sid = #{sid}")
    void returnBook(@Param("bid") Integer bid, @Param("sid") Integer sid);
}
