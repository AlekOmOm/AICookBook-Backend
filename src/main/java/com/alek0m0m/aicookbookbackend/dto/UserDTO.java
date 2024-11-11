package com.alek0m0m.aicookbookbackend.dto;

import com.alek0m0m.aicookbookbackend.library.jpa.*;
import com.alek0m0m.aicookbookbackend.library.mvc.*;
import com.alek0m0m.aicookbookbackend.model.User;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class UserDTO extends BaseEntityDTO<User> {

    private String username;
    private String password;

    @Override
    public User toEntity() {
        User user = new User();
        user.setId(getId());
        user.setUsername(getUsername());
        user.setPassword(getPassword());
        return user;
    }


}
