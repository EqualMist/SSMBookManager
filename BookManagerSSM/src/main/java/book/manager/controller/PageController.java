package book.manager.controller;

import book.manager.service.serviceImpl.SimpleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

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
//        SecurityContext context = SecurityContextHolder.getContext();
//        Authentication authentication = context.getAuthentication();
//        User user = (User) authentication.getPrincipal();
//        System.out.println(user.getUsername());
//        System.out.println(user.getAuthorities());
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
