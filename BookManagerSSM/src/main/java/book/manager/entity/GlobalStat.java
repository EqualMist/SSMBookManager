package book.manager.entity;

import lombok.Data;

@Data
public class GlobalStat {

    private Integer userCount;
    private Integer bookCount;
    private Integer borrowCount;
}
