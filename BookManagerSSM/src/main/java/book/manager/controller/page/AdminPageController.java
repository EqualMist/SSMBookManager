package book.manager.controller.page;

import book.manager.service.AuthService;
import book.manager.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/page/admin")
public class AdminPageController {

    @Resource
    AuthService authService;
    @Resource
    BookService bookService;

    @RequestMapping("/index")
    public String index(HttpSession session, Model model) {
        model.addAttribute("user", authService.findUser(session));
        return "/admin/index";
    }

    @RequestMapping("/book")
    public String book(HttpSession session, Model model) {
        model.addAttribute("user", authService.findUser(session));
        model.addAttribute("bookList", bookService.getAllBooks());
        return "/admin/book";
    }

    @RequestMapping("/add-book")
    public String addBook(HttpSession session, Model model) {
        model.addAttribute("user", authService.findUser(session));
        return "/admin/add-book";
    }
}
