package book.manager.mapper;

import book.manager.entity.AuthUser;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {

    @Select("SELECT * FROM users WHERE name = #{username}")
    AuthUser getUserByUsername(String username);

    @Options(useGeneratedKeys = true, keyProperty = "uid", keyColumn = "id") // 添加后自动返回id信息
    @Insert("INSERT INTO users(name, role, password) VALUES (#{name}, #{role}, #{password})")
     int registerUser(AuthUser user);

    @Insert("INSERT INTO student(uid, name, grade, sex) VALUES (#{uid}, #{name}, #{grade}, #{sex})")
     int addStudent(@Param("uid") int uid, @Param("name") String name, @Param("grade") String grade, @Param("sex") String sex);

}
