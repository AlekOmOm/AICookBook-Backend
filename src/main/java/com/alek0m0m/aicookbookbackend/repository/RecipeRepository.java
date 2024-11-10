package com.alek0m0m.aicookbookbackend.repository;

import com.Alek0m0m.library.spring.web.mvc.BaseRepository;
import com.alek0m0m.aicookbookbackend.model.Recipe;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepository extends BaseRepository<Recipe> {
}
