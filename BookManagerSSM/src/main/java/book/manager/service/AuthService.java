package book.manager.service;

import book.manager.entity.AuthUser;

import javax.servlet.http.HttpSession;

public interface AuthService {

    void register(String username, String sex, String grade, String password);

    AuthUser findUser (HttpSession session);

    Integer getSidByUid(Integer uid);
}
