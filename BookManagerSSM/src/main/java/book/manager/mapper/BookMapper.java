package book.manager.mapper;

import book.manager.entity.Book;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BookMapper {

    @Select("SELECT * FROM book")
    List<Book> getAllBooks();

    @Delete("DELETE FROM book WHERE bid = #{bid}")
    void deleteBook(Integer bid);

    @Insert("INSERT INTO book (title, `desc`, price) VALUES (#{title}, #{desc}, #{price})")
    void addBook(@Param("title") String title, @Param("desc") String desc, @Param("price") Double price);
}
