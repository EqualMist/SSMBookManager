package book.manager.controller.page;

import book.manager.mapper.UserMapper;
import book.manager.service.serviceImpl.SimpleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping("/page/auth")
public class AuthPageController {

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/register")
    public String register() {
        return "register";
    }


}
