package com.alek0m0m.aicookbookbackend.service;

import com.Alek0m0m.library.spring.web.mvc.BaseService;
import com.alek0m0m.aicookbookbackend.dto.UserToDTOMapper;
import com.alek0m0m.aicookbookbackend.dto.UserDTO;
import com.alek0m0m.aicookbookbackend.model.User;
import com.alek0m0m.aicookbookbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService extends BaseService<User, UserDTO, UserRepository> {

    @Autowired
    public UserService(UserRepository repository, UserToDTOMapper entityToDtoMapper) {
        super(repository, entityToDtoMapper);
    }

    // crud operations



}
