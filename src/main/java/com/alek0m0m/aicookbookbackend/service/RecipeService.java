package com.alek0m0m.aicookbookbackend.service;

import com.Alek0m0m.library.jpa.EntityToDTOMapper;
import com.Alek0m0m.library.spring.web.mvc.BaseService;
import com.alek0m0m.aicookbookbackend.dto.RecipeDTO;
import com.alek0m0m.aicookbookbackend.model.Recipe;
import com.alek0m0m.aicookbookbackend.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecipeService extends BaseService<Recipe, RecipeDTO, RecipeRepository> {

    @Autowired
    protected RecipeService(RecipeRepository repository, EntityToDTOMapper<Recipe, RecipeDTO> entityToDtoMapper) {
        super(repository, entityToDtoMapper);
    }
}
