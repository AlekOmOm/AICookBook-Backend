package com.alek0m0m.aicookbookbackend.repository;

import com.Alek0m0m.library.spring.web.mvc.BaseRepository;
import com.alek0m0m.aicookbookbackend.model.User;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends BaseRepository<User> {

}