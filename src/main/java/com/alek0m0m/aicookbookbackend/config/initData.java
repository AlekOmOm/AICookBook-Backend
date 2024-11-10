package com.alek0m0m.aicookbookbackend.config;

import com.alek0m0m.aicookbookbackend.model.User;
import com.alek0m0m.aicookbookbackend.service.UserService;
import com.alek0m0m.aicookbookbackend.dto.UserToDTOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class initData implements CommandLineRunner {
    private final UserService userService;
    private final UserToDTOMapper userToDTOMapper;

    @Autowired
    public initData(UserService userService, UserToDTOMapper userToDTOMapper) {
        this.userService = userService;
        this.userToDTOMapper = userToDTOMapper;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Init data");

        User user = new User();
        user.setUsername("admin");
        user.setEmail("admin@mail.com");
        user.setPassword("admin");
        user.setRole("ADMIN");

        userService.save(userToDTOMapper.apply(user));

    }
}
