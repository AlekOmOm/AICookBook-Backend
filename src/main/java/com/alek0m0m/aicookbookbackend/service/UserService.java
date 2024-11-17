package com.alek0m0m.aicookbookbackend.service;

import com.alek0m0m.aicookbookbackend.dto.UserDTOInput;
import com.alek0m0m.aicookbookbackend.library.jpa.BaseEntityDTO;
import com.alek0m0m.aicookbookbackend.library.mvc.*;
import com.alek0m0m.aicookbookbackend.dto.UserDTOMapper;
import com.alek0m0m.aicookbookbackend.dto.UserDTO;
import com.alek0m0m.aicookbookbackend.model.User;
import com.alek0m0m.aicookbookbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService extends BaseService<UserDTOInput, UserDTO, User, UserDTOMapper, UserRepository> {

    @Autowired
    public UserService(UserRepository repository, UserDTOMapper mapper) {
        super(repository, mapper);
    }

    @Override
    protected void setSubEntities(BaseEntityDTO<User> entityDTO) {
        System.out.println(" user no sub entities");
    }


}
