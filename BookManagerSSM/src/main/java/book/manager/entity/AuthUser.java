package book.manager.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthUser {

    private int uid;
    private String name;
    private String password;
    private String role;
}
