package book.manager.controller;

import book.manager.entity.AuthUser;
import book.manager.mapper.UserMapper;
import book.manager.service.serviceImpl.SimpleService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
public class PageController {

    @Resource
    private SimpleService simpleService;

    @Resource
    private UserMapper userMapper;

    @RequestMapping("/admin")
    public String admin() {
        return "index";
    }

    @RequestMapping("/index")
    public String index(HttpSession session, Model model) {
        AuthUser user = (AuthUser) session.getAttribute("user");
        if (user == null) {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            AuthUser authUser = userMapper.getUserByUsername(authentication.getName());
            session.setAttribute("user", authUser);
        }
        model.addAttribute("user", user);
        return "index";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/register")
    public String register() {
        return "register";
    }


//    @RequestMapping("/auth")
//    @ResponseBody
//    public String auth(){
//        SecurityContext context = SecurityContextHolder.getContext();  //获取SecurityContext对象（当前会话肯定是没有登陆的）
//        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken("Test", null,
//                AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_user"));  //手动创建一个UsernamePasswordAuthenticationToken对象，也就是用户的认证信息，角色需要添加ROLE_前缀，权限直接写
//        context.setAuthentication(token);  //手动为SecurityContext设定认证信息
//        return "Login success！";
//    }

}
