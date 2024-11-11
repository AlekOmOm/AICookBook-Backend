package com.alek0m0m.aicookbookbackend.service;

import com.alek0m0m.aicookbookbackend.library.mvc.*;
import com.alek0m0m.aicookbookbackend.dto.UserDTOMapper;
import com.alek0m0m.aicookbookbackend.dto.UserDTO;
import com.alek0m0m.aicookbookbackend.model.User;
import com.alek0m0m.aicookbookbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService extends BaseService<User, UserDTO, UserRepository> {

    @Autowired
    public UserService(UserRepository repository, UserDTOMapper entityToDtoMapper) {
        super(repository, entityToDtoMapper);
    }

    // crud operations

}
