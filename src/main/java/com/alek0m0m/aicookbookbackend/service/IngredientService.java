package com.alek0m0m.aicookbookbackend.service;

import com.alek0m0m.aicookbookbackend.dto.IngredientDTO;
import com.alek0m0m.aicookbookbackend.library.jpa.*;
import com.alek0m0m.aicookbookbackend.library.mvc.*;

import com.alek0m0m.aicookbookbackend.dto.RecipeDTO;
import com.alek0m0m.aicookbookbackend.model.Ingredient;
import com.alek0m0m.aicookbookbackend.model.Recipe;
import com.alek0m0m.aicookbookbackend.repository.IngredientRepository;
import com.alek0m0m.aicookbookbackend.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IngredientService extends BaseService<Ingredient, IngredientDTO, IngredientRepository> {

    protected IngredientService(IngredientRepository repository, EntityToDTOMapper<Ingredient, IngredientDTO> entityToDtoMapper) {
        super(repository, entityToDtoMapper);
    }
}
