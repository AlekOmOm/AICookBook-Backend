package com.alek0m0m.aicookbookbackend.controller;

import com.alek0m0m.aicookbookbackend.dto.UserDTOInput;
import com.alek0m0m.aicookbookbackend.dto.UserDTOMapper;
import com.alek0m0m.aicookbookbackend.library.mvc.*;

import com.alek0m0m.aicookbookbackend.dto.UserDTO;
import com.alek0m0m.aicookbookbackend.model.User;
import com.alek0m0m.aicookbookbackend.repository.UserRepository;
import com.alek0m0m.aicookbookbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/users")
public class UserRESTController extends BaseRESTController< UserDTOInput, UserDTO, User, UserDTOMapper, UserService, UserRepository> {

    @Autowired
    protected UserRESTController(UserService service) {
        super(service);
    }

}
