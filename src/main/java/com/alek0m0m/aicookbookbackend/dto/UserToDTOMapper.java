package com.alek0m0m.aicookbookbackend.dto;

import com.Alek0m0m.library.jpa.EntityToDTOMapper;
import com.alek0m0m.aicookbookbackend.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserToDTOMapper implements EntityToDTOMapper<User, UserDTO> {

    @Override
    public UserDTO apply(User entity) {
        UserDTO dto = new UserDTO();
        dto.setId(entity.getId());
        dto.setUsername(entity.getUsername());
        dto.setEmail(entity.getEmail());
        dto.setPassword(entity.getPassword());
        dto.setRole(entity.getRole());
        return dto;
    }

    @Override
    public UserDTO map(User entity) {
        return apply(entity);
    }

}
