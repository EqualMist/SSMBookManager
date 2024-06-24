package book.manager.controller;

import book.manager.service.SimpleService;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Controller
public class PageController {

    @Resource
    private SimpleService simpleService;

//    @PreAuthorize("hasRole('admin')")
    @RequestMapping("/admin")
    public String admin() {
        return "index";
    }

//    @PreAuthorize("hasAnyRole('user', 'admin')")
//    @PostAuthorize("hasRole('admin')")
    @RequestMapping("/index")
    public String index() {

        List<String> list = simpleService.test();
        System.out.println(list.toString());
        return "index";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }
}
