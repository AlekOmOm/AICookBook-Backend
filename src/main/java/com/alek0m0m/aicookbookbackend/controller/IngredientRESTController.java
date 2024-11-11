package com.alek0m0m.aicookbookbackend.controller;

import com.alek0m0m.aicookbookbackend.dto.IngredientDTO;
import com.alek0m0m.aicookbookbackend.library.mvc.*;
import com.alek0m0m.aicookbookbackend.library.jpa.*;
import com.alek0m0m.aicookbookbackend.model.Ingredient;
import com.alek0m0m.aicookbookbackend.repository.IngredientRepository;
import com.alek0m0m.aicookbookbackend.service.IngredientService;

public class IngredientRESTController extends BaseRESTController<Ingredient, IngredientDTO, IngredientService, IngredientRepository> {

    protected IngredientRESTController(IngredientService service) {
        super(service);
    }

}
