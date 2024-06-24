package book.manager.controller;

import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.stereotype.Controller
public class Controller {

    @RequestMapping("/index")
    public String index() {
        System.out.println("index");
        return "index";
    }
}
