package com.alek0m0m.aicookbookbackend.repository;

import com.alek0m0m.aicookbookbackend.library.jpa.*;
import com.alek0m0m.aicookbookbackend.library.mvc.*;
import com.alek0m0m.aicookbookbackend.model.Recipe;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface RecipeRepository extends BaseRepository<Recipe> {



    @Modifying
    @Transactional
    @Query(value = "ALTER TABLE recipe AUTO_INCREMENT = 1", nativeQuery = true)
    void resetAutoIncrement();
}
