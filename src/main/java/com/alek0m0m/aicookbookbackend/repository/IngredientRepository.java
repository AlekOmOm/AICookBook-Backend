package com.alek0m0m.aicookbookbackend.repository;

import com.alek0m0m.aicookbookbackend.library.mvc.BaseRepository;
import com.alek0m0m.aicookbookbackend.model.Ingredient;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface IngredientRepository extends BaseRepository<Ingredient> {
    // Additional query methods if needed


}
