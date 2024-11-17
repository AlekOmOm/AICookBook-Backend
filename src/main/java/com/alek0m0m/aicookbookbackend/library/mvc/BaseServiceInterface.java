package com.alek0m0m.aicookbookbackend.library.mvc;

import com.alek0m0m.aicookbookbackend.library.jpa.*;
import com.alek0m0m.aicookbookbackend.library.mvc.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BaseServiceInterface< R extends BaseEntityDTO<T>, T extends BaseEntity> {

    BaseRepository<T> getRepository();

    R save(BaseEntityDTO<T> entityDTO);

    List<R> findAll();
    R findById(long id);

    void deleteById(long id);
}