package book.manager.service.serviceImpl;

import book.manager.entity.AuthUser;
import book.manager.mapper.UserMapper;
import book.manager.service.AuthService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Service
public class AuthServiceImpl implements AuthService {

    @Resource
    private UserMapper userMapper;

    @Transactional
    @Override
    public void register(String username, String sex, String grade, String password) {
        // 密码加密
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        AuthUser user = new AuthUser(0, username, encoder.encode(password),"user");
        if (userMapper.registerUser(user) <= 0) {
            throw new RuntimeException("用户基本信息添加失败！");
        }
        if (userMapper.addStudent(user.getUid(), username, grade, sex) <= 0) {
            throw new RuntimeException("学生基本信息添加失败！");
        }
    }

    @Override
    public AuthUser findUser(HttpSession session) {
        AuthUser user = (AuthUser) session.getAttribute("user");
        if (user == null) {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            user = userMapper.getUserByUsername(authentication.getName());
            session.setAttribute("user", user);
        }
        return user;
    }

    @Override
    public Integer getSidByUid(Integer uid) {
        return userMapper.getSidByUid(uid);
    }
}
