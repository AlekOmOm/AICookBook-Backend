package com.alek0m0m.aicookbookbackend.repository;

import com.alek0m0m.aicookbookbackend.library.jpa.*;
import com.alek0m0m.aicookbookbackend.library.mvc.*;

import com.alek0m0m.aicookbookbackend.model.User;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends BaseRepository<User> {



}