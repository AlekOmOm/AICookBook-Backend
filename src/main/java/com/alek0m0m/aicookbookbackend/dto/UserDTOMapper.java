package com.alek0m0m.aicookbookbackend.dto;

import com.alek0m0m.aicookbookbackend.library.jpa.*;
import com.alek0m0m.aicookbookbackend.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserDTOMapper implements EntityToDTOMapper<User, UserDTO> {

    @Override
    public UserDTO apply(User entity) {
        UserDTO dto = new UserDTO();
        dto.setId(entity.getId());
        dto.setUsername(entity.getUsername());
        dto.setPassword(entity.getPassword());
        return dto;
    }

    @Override
    public UserDTO map(User entity) {
        return apply(entity);
    }

}
