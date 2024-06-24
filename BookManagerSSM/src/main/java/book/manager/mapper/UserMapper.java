package book.manager.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Select("SELECT password FROM user WHERE username = #{username}")
    String getPasswordByUsername(String username);
}
