package book.manager.service.serviceImpl;

import book.manager.entity.GlobalStat;
import book.manager.mapper.BookMapper;
import book.manager.mapper.UserMapper;
import book.manager.service.BookService;
import book.manager.service.StatService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class StatServiceImpl implements StatService {

    @Resource
    private BookMapper bookMapper;
    @Resource
    private UserMapper userMapper;

    @Override
    public GlobalStat getGlobalStat() {
        GlobalStat globalStat = new GlobalStat();
        globalStat.setUserCount(userMapper.getUserCount());
        globalStat.setBookCount(bookMapper.getBookCount());
        globalStat.setBorrowCount(bookMapper.getBorrowCount());
        return globalStat;
    }
}
