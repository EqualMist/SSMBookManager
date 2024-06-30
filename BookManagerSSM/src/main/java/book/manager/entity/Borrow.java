package book.manager.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Borrow {

    Integer id;
    Integer bid;
    Integer sid;
    Date time;
}
