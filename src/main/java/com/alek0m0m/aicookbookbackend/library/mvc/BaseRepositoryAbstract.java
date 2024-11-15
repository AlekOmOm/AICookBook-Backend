package com.alek0m0m.aicookbookbackend.library.mvc;

import com.alek0m0m.aicookbookbackend.library.jpa.*;
import com.alek0m0m.aicookbookbackend.library.mvc.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public abstract class BaseRepositoryAbstract<T extends BaseEntity> implements BaseRepository<T> {

    // Utilizing the BaseRepositoryInterface
    // gives us access to the custom methods defined in the interface
    // and the default methods defined in JpaRepository
    // without having to implement them in the repository class
    private final BaseRepository<T> repository;

    @Autowired
    public BaseRepositoryAbstract(BaseRepository<T> repository) {
        this.repository = repository;
    }

    // can call JPA methods directly on the repository
    protected BaseRepository<T> getRepository() {
        return repository;
    }

}
