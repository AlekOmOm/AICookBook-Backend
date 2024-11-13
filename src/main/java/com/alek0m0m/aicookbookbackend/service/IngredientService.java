package com.alek0m0m.aicookbookbackend.service;

import com.alek0m0m.aicookbookbackend.dto.*;
import com.alek0m0m.aicookbookbackend.library.jpa.*;
import com.alek0m0m.aicookbookbackend.library.mvc.*;
import com.alek0m0m.aicookbookbackend.model.Ingredient;
import com.alek0m0m.aicookbookbackend.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IngredientService extends BaseService<IngredientDTOInput, IngredientDTO, Ingredient, IngredientDTOMapper, IngredientRepository> {

    @Autowired
    protected IngredientService(IngredientRepository repository, IngredientDTOMapper ingredientDTOMapper) {
        super(repository, ingredientDTOMapper);
    }

}
