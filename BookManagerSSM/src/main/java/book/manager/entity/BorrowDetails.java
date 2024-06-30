package book.manager.entity;

import lombok.Data;

import java.util.Date;

@Data
public class BorrowDetails {

    private Integer id;
    String bookTitle;
    String username;
    Date time;
}
