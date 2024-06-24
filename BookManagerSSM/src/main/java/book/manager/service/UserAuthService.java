package book.manager.service;

import book.manager.mapper.UserMapper;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserAuthService implements UserDetailsService {

    @Resource
    UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        String password = userMapper.getPasswordByUsername(s); // 从数据库根据用户名获取密码
        if (password == null) {
            throw new UsernameNotFoundException("用户名或密码错误");
        }
        return User //这里需要返回UserDetails，SpringSecurity会根据给定的信息进行比对
                .withUsername(s)
                .password(password) //直接从数据库取的密码
                .roles("user") //用户角色
                .build();
    }
}
