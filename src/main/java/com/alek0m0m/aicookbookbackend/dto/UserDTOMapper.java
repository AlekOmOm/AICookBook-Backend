package com.alek0m0m.aicookbookbackend.dto;

import com.alek0m0m.aicookbookbackend.library.jpa.*;
import com.alek0m0m.aicookbookbackend.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserDTOMapper extends EntityToDTOMapperImpl<UserDTOInput, UserDTO, User> {
    
    @Override
    public UserDTO toDTO(UserDTOInput dtoInput) {
        UserDTO userDTO = new UserDTO();
        userDTO.setUsername(dtoInput.getUsername());
        userDTO.setPassword(dtoInput.getPassword());
        return userDTO;
    }

    @Override
    public User toEntity(UserDTO userDTO) {
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        return user;
    }

    @Override
    public UserDTO entityToDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setUsername(user.getUsername());
        userDTO.setPassword(user.getPassword());
        return userDTO;
    }
}
