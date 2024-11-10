package com.alek0m0m.aicookbookbackend.controller;

import com.Alek0m0m.library.jpa.BaseEntityDTO;
import com.Alek0m0m.library.spring.web.mvc.BaseRESTController;
import com.alek0m0m.aicookbookbackend.dto.UserDTO;
import com.alek0m0m.aicookbookbackend.model.User;
import com.alek0m0m.aicookbookbackend.repository.UserRepository;
import com.alek0m0m.aicookbookbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserRESTController extends BaseRESTController<User, UserDTO, UserService, UserRepository> {

    @Autowired
    protected UserRESTController(UserService service) {
        super(service);
    }


    @Override
    public ResponseEntity<UserDTO> create(BaseEntityDTO baseEntityDTO) {
        return null;
    }
}
