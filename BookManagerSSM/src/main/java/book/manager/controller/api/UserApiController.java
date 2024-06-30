package book.manager.controller.api;

import book.manager.entity.AuthUser;
import book.manager.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.annotation.Resource;

@Controller
@RequestMapping("/api/user")
public class UserApiController {

    @Resource
    private BookService bookService;

    @RequestMapping(value = "/borrow-book", method = RequestMethod.GET)
    public String borrowBook(@RequestParam("bid") Integer bid, @SessionAttribute("user") AuthUser user) {
        bookService.borrowBook(bid, user.getUid());
        return "redirect:/page/user/book";
    }

    @RequestMapping(value = "/return-book", method = RequestMethod.GET)
    public String returnBook(@RequestParam("bid") Integer bid, @SessionAttribute("user") AuthUser user) {
        bookService.returnBook(bid, user.getUid());
        return "redirect:/page/user/book";
    }
}
